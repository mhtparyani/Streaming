package com.shera.internexttv.gui.tv.browser

import android.os.Bundle
import android.os.Parcelable
import android.util.Log
import android.view.View
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.song_browser.*
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.ObsoleteCoroutinesApi
import org.videolan.medialibrary.interfaces.AbstractMedialibrary
import org.videolan.medialibrary.interfaces.media.AbstractMediaWrapper
import org.videolan.medialibrary.media.MediaLibraryItem
import com.shera.internexttv.BuildConfig
import com.shera.internexttv.R
import com.shera.internexttv.gui.tv.FileTvItemAdapter
import com.shera.internexttv.gui.tv.TvItemAdapter
import com.shera.internexttv.gui.tv.TvUtil
import com.shera.internexttv.interfaces.IEventsHandler
import com.shera.internexttv.providers.BrowserProvider
import com.shera.internexttv.util.CATEGORY
import com.shera.internexttv.util.ITEM
import com.shera.internexttv.viewmodels.browser.BrowserModel
import com.shera.internexttv.viewmodels.browser.TYPE_FILE
import com.shera.internexttv.viewmodels.browser.TYPE_NETWORK
import com.shera.internexttv.viewmodels.browser.getBrowserModel
import java.util.*

@UseExperimental(ObsoleteCoroutinesApi::class)
@ExperimentalCoroutinesApi
class FileBrowserTvFragment : BaseBrowserTvFragment() {
    private var item: MediaLibraryItem? = null
    override lateinit var adapter: TvItemAdapter

    override fun getTitle() = when (getCategory()) {
        TYPE_FILE -> getString(R.string.directories)
        TYPE_NETWORK -> getString(R.string.network_browsing)
        else -> getString(R.string.video)
    }

    override fun getColumnNumber() = resources.getInteger(R.integer.tv_songs_col_count)

    companion object {
        fun newInstance(type: Int, item: MediaLibraryItem?) =
                FileBrowserTvFragment().apply {
                    arguments = Bundle().apply {
                        this.putInt(CATEGORY, type)
                        this.putParcelable(ITEM, item)
                    }
                }
    }

    override fun provideAdapter(eventsHandler: IEventsHandler, itemSize: Int): TvItemAdapter {
        return FileTvItemAdapter(getCategory(), this, itemSize)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        item = if (savedInstanceState != null) savedInstanceState.getParcelable<Parcelable>(ITEM) as? MediaLibraryItem
        else arguments?.getParcelable(ITEM) as? MediaLibraryItem
        viewModel = getBrowserModel(getCategory(), (item as? AbstractMediaWrapper)?.location, true, false)

        viewModel.currentItem = item

        (viewModel.provider as BrowserProvider).dataset.observe(this, Observer { items ->
            submitList(items)
            if (BuildConfig.DEBUG) Log.d("FileBrowserTvFragment", "Submit lis of ${items.size} items")
            if (BuildConfig.DEBUG) Log.d("FileBrowserTvFragment", "header size: ${viewModel.provider.headers.size()}")

            //headers
            val nbColumns = if ((viewModel as BrowserModel).sort == AbstractMedialibrary.SORT_ALPHA || (viewModel as BrowserModel).sort == AbstractMedialibrary.SORT_DEFAULT) 9 else 1

            headerList.layoutManager = GridLayoutManager(requireActivity(), nbColumns)
            headerAdapter.sortType = (viewModel as BrowserModel).sort
            val headerItems = ArrayList<String>()
            viewModel.provider.headers.run {
                for (i in 0 until size()) {
                    headerItems.add(valueAt(i))
                }
            }
            headerAdapter.items = headerItems
            headerAdapter.notifyDataSetChanged()
        })

        (viewModel as BrowserModel).provider.liveHeaders.observe(this, Observer {
            headerAdapter.notifyDataSetChanged()
            if (BuildConfig.DEBUG) Log.d("FileBrowserTvFragment", "header size (observe): ${viewModel.provider.headers.size()}")
        })

        (viewModel as BrowserModel).getDescriptionUpdate().observe(this, Observer { pair ->
            if (BuildConfig.DEBUG) Log.d("FileBrowserTvFragment", "Description update: ${pair.first} ${pair.second}")
            if (BuildConfig.DEBUG) Log.d("FileBrowserTvFragment", "header size (desc): ${viewModel.provider.headers.size()}")
            if (pair != null) (adapter as RecyclerView.Adapter<*>).notifyItemChanged(pair.first)
        })

        (viewModel as BrowserModel).loading.observe(this, Observer {
            binding.loading = it
            animationDelegate.setVisibility(binding.loadingBar, if (it) View.VISIBLE else View.GONE)
        })
    }

    override fun onResume() {
        super.onResume()

        if (item == null) (viewModel.provider as BrowserProvider).browseRoot()
        else refresh()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putParcelable(ITEM, item)
        outState.putInt(CATEGORY, getCategory())
        super.onSaveInstanceState(outState)
    }


    override fun onStop() {
        super.onStop()
        (viewModel as BrowserModel).stop()
    }

    private fun getCategory() = arguments?.getInt(CATEGORY, TYPE_FILE) ?: TYPE_FILE

    override fun onClick(v: View, position: Int, item: MediaLibraryItem) {
        val mediaWrapper = item as AbstractMediaWrapper

        mediaWrapper.removeFlags(AbstractMediaWrapper.MEDIA_FORCE_AUDIO)
        if (mediaWrapper.type == AbstractMediaWrapper.TYPE_DIR) browse(mediaWrapper, true)
        else TvUtil.openMedia(requireActivity(), item, viewModel as BrowserModel)
    }

    fun browse(media: AbstractMediaWrapper, save: Boolean) {
        val ctx = activity
        if (ctx == null || !isResumed || isRemoving) return
        val ft = ctx.supportFragmentManager.beginTransaction()
        val next = newInstance(getCategory(), media)
        (viewModel as BrowserModel).saveList(media)
        if (save) ft.addToBackStack(media.title)
        ft.replace(R.id.tv_fragment_placeholder, next, media.title)
        ft.commit()
    }
}
