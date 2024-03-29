package com.shera.internexttv.viewmodels.tv

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.videolan.medialibrary.media.MediaLibraryItem
import com.shera.internexttv.providers.medialibrary.*
import com.shera.internexttv.util.CATEGORY_ALBUMS
import com.shera.internexttv.util.CATEGORY_ARTISTS
import com.shera.internexttv.util.CATEGORY_GENRES
import com.shera.internexttv.util.CATEGORY_VIDEOS
import com.shera.internexttv.viewmodels.MedialibraryViewModel


@ExperimentalCoroutinesApi
class MediaBrowserViewModel(context: Context, val category: Long) : MedialibraryViewModel(context), TvBrowserModel {


    override var nbColumns = 0
    override var currentItem: MediaLibraryItem? = null

    override val provider = when (category) {
        CATEGORY_ALBUMS -> AlbumsProvider(null, context, this)
        CATEGORY_ARTISTS -> ArtistsProvider(context, this, true)
        CATEGORY_GENRES -> GenresProvider(context, this)
        CATEGORY_VIDEOS -> VideosProvider(null, context, this)
        else -> TracksProvider(null, context, this)
    }
    override val providers = arrayOf(provider)

    init {
        when(category){
            CATEGORY_ALBUMS -> watchAlbums()
            CATEGORY_ARTISTS -> watchArtists()
            CATEGORY_GENRES -> watchGenres()
            else -> watchMedia()
        }
    }

    class Factory(private val context: Context, private val category: Long) : ViewModelProvider.NewInstanceFactory() {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            @Suppress("UNCHECKED_CAST")
            return MediaBrowserViewModel(context.applicationContext, category) as T
        }
    }
}

@ExperimentalCoroutinesApi
fun Fragment.getMediaBrowserModel(category: Long) = ViewModelProviders.of(requireActivity(), MediaBrowserViewModel.Factory(requireContext(), category)).get(MediaBrowserViewModel::class.java)
