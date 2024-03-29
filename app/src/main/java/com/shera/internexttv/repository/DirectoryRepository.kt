package com.shera.internexttv.repository

import android.content.Context
import android.text.TextUtils
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.videolan.libvlc.util.AndroidUtil
import org.videolan.medialibrary.MLServiceLocator
import org.videolan.medialibrary.interfaces.media.AbstractMediaWrapper
import org.videolan.tools.IOScopedObject
import org.videolan.tools.SingletonHolder
import com.shera.internexttv.R
import com.shera.internexttv.database.CustomDirectoryDao
import com.shera.internexttv.database.MediaDatabase
import com.shera.internexttv.database.models.CustomDirectory
import com.shera.internexttv.util.AndroidDevices
import com.shera.internexttv.util.AndroidDevices.EXTERNAL_PUBLIC_DIRECTORY
import com.shera.internexttv.util.FileUtils
import java.io.File

class DirectoryRepository (private val customDirectoryDao: CustomDirectoryDao) : IOScopedObject() {

    fun addCustomDirectory(path: String): Job = launch {
            customDirectoryDao.insert(CustomDirectory(path))
    }

    suspend fun getCustomDirectories() = withContext(coroutineContext) {
        try {
            customDirectoryDao.getAll()
        } catch (e: Exception) {
            emptyList<CustomDirectory>()
        }
    }

    fun deleteCustomDirectory(path: String) = launch { customDirectoryDao.delete(CustomDirectory(path)) }

    suspend fun customDirectoryExists(path: String) = withContext(coroutineContext) { customDirectoryDao.get(path).isNotEmpty() }

    suspend fun getMediaDirectoriesList(context: Context) = getMediaDirectories().filter {
        File(it).exists()
    }.map { createDirectory(it, context) }

    suspend fun getMediaDirectories() = mutableListOf<String>().apply {
        add(EXTERNAL_PUBLIC_DIRECTORY)
        addAll(AndroidDevices.externalStorageDirectories)
        addAll(getCustomDirectories().map { it.path })
    }

    companion object : SingletonHolder<DirectoryRepository, Context>({ DirectoryRepository(MediaDatabase.getInstance(it).customDirectoryDao()) })
}

fun createDirectory(it: String, context: Context): AbstractMediaWrapper {
    val directory = MLServiceLocator.getAbstractMediaWrapper(AndroidUtil.PathToUri(it))
    directory.type = AbstractMediaWrapper.TYPE_DIR
    if (TextUtils.equals(EXTERNAL_PUBLIC_DIRECTORY, it)) {
        directory.setDisplayTitle(context.resources.getString(R.string.internal_memory))
    } else {
        val deviceName = FileUtils.getStorageTag(directory.title)
        if (deviceName != null) directory.setDisplayTitle(deviceName)
    }
    return directory
}