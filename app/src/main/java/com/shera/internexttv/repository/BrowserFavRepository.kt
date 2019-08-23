/*******************************************************************************
 *  BrowserFavRepository.kt
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
 ******************************************************************************/

package com.shera.internexttv.repository

import androidx.lifecycle.MediatorLiveData
import android.content.Context
import android.net.Uri
import androidx.annotation.WorkerThread
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.videolan.medialibrary.interfaces.media.AbstractMediaWrapper
import org.videolan.tools.IOScopedObject
import org.videolan.tools.SingletonHolder
import com.shera.internexttv.ExternalMonitor
import com.shera.internexttv.database.BrowserFavDao
import com.shera.internexttv.database.MediaDatabase
import com.shera.internexttv.database.models.BrowserFav
import com.shera.internexttv.util.TYPE_LOCAL_FAV
import com.shera.internexttv.util.TYPE_NETWORK_FAV
import com.shera.internexttv.util.convertFavorites
import java.util.*


class BrowserFavRepository(private val browserFavDao: BrowserFavDao) : IOScopedObject() {

    private val networkFavs by lazy { browserFavDao.getAllNetwrokFavs() }

    val browserFavorites by lazy { browserFavDao.getAll() }

    val localFavorites by lazy { browserFavDao.getAllLocalFavs() }

    fun addNetworkFavItem(uri: Uri, title: String, iconUrl: String?) = launch {
        browserFavDao.insert(BrowserFav(uri, TYPE_NETWORK_FAV, title, iconUrl))
    }

    fun addLocalFavItem(uri: Uri, title: String, iconUrl: String? = null) = launch {
        browserFavDao.insert(BrowserFav(uri, TYPE_LOCAL_FAV, title, iconUrl))
    }

    val networkFavorites by lazy {
        MediatorLiveData<List<AbstractMediaWrapper>>().apply {
            addSource(networkFavs) { value = convertFavorites(it).filterNetworkFavs() }
            addSource(ExternalMonitor.connected) {
                launch(Dispatchers.Main.immediate) {
                    val favList = convertFavorites(networkFavs.value)
                    if (favList.isNotEmpty()) value = if (it == true) favList.filterNetworkFavs() else emptyList()
                }
            }
        }
    }

    @WorkerThread
    fun browserFavExists(uri: Uri): Boolean = browserFavDao.get(uri).isNotEmpty()

    fun deleteBrowserFav(uri: Uri) = launch { browserFavDao.delete(uri) }

    private fun List<AbstractMediaWrapper>.filterNetworkFavs() : List<AbstractMediaWrapper> {
        return when {
            isEmpty() -> this
            !ExternalMonitor.isConnected -> emptyList()
            !ExternalMonitor.allowLan() -> {
                val schemes = Arrays.asList("ftp", "sftp", "ftps", "http", "https")
                mutableListOf<AbstractMediaWrapper>().apply { this@filterNetworkFavs.filterTo(this) { schemes.contains(it.uri.scheme) } }
            }
            else -> this
        }
    }

    companion object : SingletonHolder<BrowserFavRepository, Context>({ BrowserFavRepository(MediaDatabase.getInstance(it).browserFavDao()) })
}
