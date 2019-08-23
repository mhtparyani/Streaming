package com.shera.internexttv.viewmodels.tv

import org.videolan.medialibrary.media.MediaLibraryItem
import com.shera.internexttv.providers.HeaderProvider

interface TvBrowserModel {

    var currentItem: MediaLibraryItem?
    var nbColumns: Int
    val provider: HeaderProvider
}