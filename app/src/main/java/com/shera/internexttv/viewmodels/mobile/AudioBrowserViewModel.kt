/*****************************************************************************
 * AudioBrowserViewModel.kt
 *****************************************************************************
 * Copyright © 2019 VLC authors and VideoLAN
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
 *****************************************************************************/

package com.shera.internexttv.viewmodels.mobile

import android.content.Context
import androidx.annotation.MainThread
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.ObsoleteCoroutinesApi
import com.shera.internexttv.gui.audio.AudioBrowserFragment
import com.shera.internexttv.providers.medialibrary.AlbumsProvider
import com.shera.internexttv.providers.medialibrary.ArtistsProvider
import com.shera.internexttv.providers.medialibrary.GenresProvider
import com.shera.internexttv.providers.medialibrary.TracksProvider
import com.shera.internexttv.util.KEY_ARTISTS_SHOW_ALL
import com.shera.internexttv.util.Settings
import com.shera.internexttv.viewmodels.MedialibraryViewModel


@ExperimentalCoroutinesApi
class AudioBrowserViewModel(context: Context) : MedialibraryViewModel(context) {

    val artistsProvider = ArtistsProvider(context, this,
            Settings.getInstance(context).getBoolean(KEY_ARTISTS_SHOW_ALL, false))
    val albumsProvider = AlbumsProvider(null, context, this)
    val tracksProvider = TracksProvider(null, context, this)
    val genresProvider = GenresProvider(context, this)
    override val providers = arrayOf(artistsProvider, albumsProvider, tracksProvider, genresProvider)
    private val settings = Settings.getInstance(context)
    val providersInCard = arrayOf(true, true, false, false)

    var showResumeCard = settings.getBoolean("audio_resume_card", true)
    val displayModeKeys = arrayOf("display_mode_audio_browser_artists", "display_mode_audio_browser_albums", "display_mode_audio_browser_track")


    init {
        watchAlbums()
        watchArtists()
        watchGenres()
        watchMedia()
        //Initial state coming from preferences and falling back to [providersInCard] hardcoded values
        for (i in 0 until displayModeKeys.size) {
            providersInCard[i] = settings.getBoolean(displayModeKeys[i], providersInCard[i])
        }

    }

    override fun refresh() {
        artistsProvider.showAll = settings.getBoolean(KEY_ARTISTS_SHOW_ALL, false)
        super.refresh()
    }

    @MainThread
    internal fun setLoading() {
        providers.forEach { it.loading.value = true }
    }

    class Factory(val context: Context): ViewModelProvider.NewInstanceFactory() {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            @Suppress("UNCHECKED_CAST")
            return AudioBrowserViewModel(context.applicationContext) as T
        }
    }
}

@ExperimentalCoroutinesApi
@ObsoleteCoroutinesApi
internal fun AudioBrowserFragment.getViewModel() = ViewModelProviders.of(requireActivity(), AudioBrowserViewModel.Factory(requireContext())).get(AudioBrowserViewModel::class.java)