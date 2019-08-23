package com.shera.internexttv.gui.helpers


import android.content.Context
import android.content.Intent
import androidx.core.content.ContextCompat
import org.videolan.medialibrary.interfaces.AbstractMedialibrary
import com.shera.internexttv.MediaParsingService
import com.shera.internexttv.VLCApplication
import com.shera.internexttv.util.ACTION_DISCOVER
import com.shera.internexttv.util.ACTION_DISCOVER_DEVICE
import com.shera.internexttv.util.EXTRA_PATH
import com.shera.internexttv.util.runIO

object MedialibraryUtils {

    fun removeDir(path: String) {
        runIO(Runnable { AbstractMedialibrary.getInstance().removeFolder(path) })
    }

    @JvmOverloads
    fun addDir(path: String, context: Context = VLCApplication.appContext) {
        val intent = Intent(ACTION_DISCOVER, null, context, MediaParsingService::class.java)
        intent.putExtra(EXTRA_PATH, path)
        ContextCompat.startForegroundService(context, intent)
    }

    fun addDevice(path: String, context: Context) {
        val intent = Intent(ACTION_DISCOVER_DEVICE, null, context, MediaParsingService::class.java)
        intent.putExtra(EXTRA_PATH, path)
        ContextCompat.startForegroundService(context, intent)
    }
}
