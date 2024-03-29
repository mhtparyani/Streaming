/*****************************************************************************
 * PlaylistsProvider.kt
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

package com.shera.internexttv.providers.medialibrary

import android.content.Context
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.videolan.medialibrary.interfaces.media.AbstractPlaylist
import com.shera.internexttv.viewmodels.SortableModel


@ExperimentalCoroutinesApi
class PlaylistsProvider(context: Context, scope: SortableModel) : MedialibraryProvider<AbstractPlaylist>(context, scope) {

    override fun getAll() : Array<AbstractPlaylist> = medialibrary.getPlaylists(sort, desc)

    override fun getPage(loadSize: Int, startposition: Int)  : Array<AbstractPlaylist> {
        val list = if (scope.filterQuery == null) medialibrary.getPagedPlaylists(sort, desc, loadSize, startposition)
        else medialibrary.searchPlaylist(scope.filterQuery, sort, desc, loadSize, startposition)
        return list.also { completeHeaders(it, startposition) }
    }

    override fun getTotalCount() = if (scope.filterQuery == null) medialibrary.playlistsCount else medialibrary.getPlaylistsCount(scope.filterQuery)
}