/**
 * **************************************************************************
 * PlaylistFragment.kt
 * ****************************************************************************
 * Copyright © 2018 VLC authors and VideoLAN
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston MA 02110-1301, USA.
 * ***************************************************************************
 */
package com.shera.internexttv.gui

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.view.ActionMode
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.google.android.material.appbar.AppBarLayout
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.ObsoleteCoroutinesApi
import kotlinx.coroutines.launch
import org.videolan.medialibrary.interfaces.media.AbstractMediaWrapper
import org.videolan.medialibrary.media.MediaLibraryItem
import com.shera.internexttv.R
import com.shera.internexttv.databinding.PlaylistsFragmentBinding
import com.shera.internexttv.gui.audio.AudioBrowserAdapter
import com.shera.internexttv.gui.audio.AudioBrowserFragment
import com.shera.internexttv.gui.audio.BaseAudioBrowser
import com.shera.internexttv.gui.view.FastScroller
import com.shera.internexttv.gui.view.RecyclerSectionItemGridDecoration
import com.shera.internexttv.media.MediaUtils
import com.shera.internexttv.providers.medialibrary.MedialibraryProvider
import com.shera.internexttv.reloadLibrary
import com.shera.internexttv.util.CTX_PLAY_ALL
import com.shera.internexttv.util.getScreenWidth
import com.shera.internexttv.viewmodels.mobile.PlaylistsViewModel
import com.shera.internexttv.viewmodels.mobile.getViewModel
import kotlin.math.min

@ObsoleteCoroutinesApi
@ExperimentalCoroutinesApi
class PlaylistFragment : BaseAudioBrowser<PlaylistsViewModel>(), SwipeRefreshLayout.OnRefreshListener {

    private lateinit var binding: PlaylistsFragmentBinding
    private lateinit var playlists: RecyclerView
    private lateinit var playlistAdapter: AudioBrowserAdapter
    private lateinit var fastScroller: FastScroller

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = getViewModel()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = PlaylistsFragmentBinding.inflate(inflater, container, false)
        playlists = binding.swipeLayout.findViewById(R.id.audio_list)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.swipeLayout.setOnRefreshListener(this)


        //size of an item
        val spacing = resources.getDimension(R.dimen.kl_half).toInt()

        val dimension = resources.getDimension(R.dimen.default_content_width)
        val totalWidth = if (dimension > 0) min(requireActivity().getScreenWidth(), dimension.toInt()) else requireActivity().getScreenWidth()

        val itemSize = RecyclerSectionItemGridDecoration.getItemSize(totalWidth - spacing * 2, nbColumns, spacing)

        playlistAdapter = AudioBrowserAdapter(MediaLibraryItem.TYPE_PLAYLIST, this, cardSize = itemSize)
        adapter = playlistAdapter

        displayListInGrid(playlists, adapter!!, viewModel.provider as MedialibraryProvider<MediaLibraryItem>, spacing)

        playlists.adapter = playlistAdapter
        fastScroller = view.rootView.findViewById(R.id.songs_fast_scroller) as FastScroller
        fastScroller.attachToCoordinator(view.rootView.findViewById(R.id.appbar) as AppBarLayout, view.rootView.findViewById(R.id.coordinator) as CoordinatorLayout, view.rootView.findViewById(R.id.fab) as FloatingActionButton)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel.provider.pagedList.observe(requireActivity(), Observer {
            playlistAdapter.submitList(it as PagedList<MediaLibraryItem>)
            binding.empty.visibility = if (it.isNullOrEmpty()) View.VISIBLE else View.GONE
        })
        viewModel.provider.loading.observe(this, Observer<Boolean> { loading ->
            launch {
                binding.swipeLayout.isRefreshing = loading == true
                (activity as? MainActivity)?.refreshing = loading
            }
        })

        fastScroller.setRecyclerView(getCurrentRV(), viewModel.provider)

    }

    override fun onCreateActionMode(mode: ActionMode, menu: Menu): Boolean {
        mode.menuInflater.inflate(R.menu.action_mode_audio_browser, menu)
        menu.findItem(R.id.action_mode_audio_add_playlist).isVisible = false
        return true
    }

    override fun onClick(v: View, position: Int, item: MediaLibraryItem) {
        if (actionMode == null) {
            val i = Intent(activity, PlaylistActivity::class.java)
            i.putExtra(AudioBrowserFragment.TAG_ITEM, item)
            startActivity(i)
        } else super.onClick(v, position, item)
    }

    override fun onCtxAction(position: Int, option: Int) {
        if (option == CTX_PLAY_ALL) MediaUtils.playAll(requireContext(), viewModel.provider as MedialibraryProvider<AbstractMediaWrapper>, position, false)
        else super.onCtxAction(position, option)
    }

    override fun onRefresh() {
        activity?.reloadLibrary()
    }

    override fun getTitle(): String = getString(R.string.playlists)

    override fun getCurrentRV(): RecyclerView = playlists

    override fun hasFAB() = false
}
