/*******************************************************************************
 *  ExternalSubRepository.kt
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

import android.content.Context
import android.net.Uri
import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import org.videolan.tools.SingletonHolder
import com.shera.internexttv.database.ExternalSubDao
import com.shera.internexttv.database.MediaDatabase
import com.shera.internexttv.database.models.ExternalSub
import com.shera.internexttv.gui.dialogs.State
import com.shera.internexttv.gui.dialogs.SubtitleItem
import com.shera.internexttv.util.LiveDataMap
import java.io.File

class ExternalSubRepository(private val externalSubDao: ExternalSubDao ) {

    private var _downloadingSubtitles = LiveDataMap<Long, SubtitleItem>()

    val downloadingSubtitles: LiveData<Map<Long, SubtitleItem>>
        get() = _downloadingSubtitles as LiveData<Map<Long, SubtitleItem>>

    fun saveDownloadedSubtitle(idSubtitle: String, subtitlePath: String, mediaPath: String, language: String, movieReleaseName: String): Job {
        return GlobalScope.launch(Dispatchers.IO) { externalSubDao.insert(ExternalSub(idSubtitle, subtitlePath, mediaPath, language, movieReleaseName)) }
    }

    fun getDownloadedSubtitles(mediaUri: Uri): LiveData<List<ExternalSub>> {
        val externalSubs = externalSubDao.get(mediaUri.path)
        return Transformations.map(externalSubs) { list ->
            val existExternalSubs: MutableList<ExternalSub> = mutableListOf()
            list.forEach {
                if (File(Uri.decode(it.subtitlePath)).exists())
                    existExternalSubs.add(it)
                else
                    deleteSubtitle(it.mediaPath, it.idSubtitle)
            }
            existExternalSubs
        }
    }

    fun deleteSubtitle(mediaPath: String, idSubtitle: String) {
        GlobalScope.launch { externalSubDao.delete(mediaPath, idSubtitle) }
    }

    fun addDownloadingItem(key: Long, item: SubtitleItem) {
        _downloadingSubtitles.add(key, item.copy(state = State.Downloading))
    }

    fun removeDownloadingItem(key: Long) {
        _downloadingSubtitles.remove(key)
    }

    fun getDownloadingSubtitle(key: Long) = _downloadingSubtitles.get(key)

    companion object : SingletonHolder<ExternalSubRepository, Context>({ ExternalSubRepository(MediaDatabase.getInstance(it).externalSubDao()) })
}