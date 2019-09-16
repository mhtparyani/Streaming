package com.shera.internexttv.view.live

import androidx.appcompat.app.AppCompatActivity

import android.content.res.Configuration
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.SurfaceHolder
import android.view.SurfaceView
import android.view.ViewGroup
import android.widget.Toast

import com.shera.internexttv.R
import org.videolan.medialibrary.MLServiceLocator
import org.videolan.medialibrary.interfaces.media.AbstractMediaWrapper
import com.shera.internexttv.media.MediaUtils
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.ObsoleteCoroutinesApi
//import com.shera.internexttv.media.MediaUtils;
//import com.shera.internexttv.media.MediaUtilsKt;

import java.lang.ref.WeakReference
import java.util.ArrayList

class LiveActivity : AppCompatActivity() {
    private var mFilePath: String? = null
    private val mSurface: SurfaceView? = null
    private val holder: SurfaceHolder? = null
    internal var streamId: String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_live)
//        val b = intent.extras
//        if (b != null) {
//            streamId = b.getString("id")
//        }
        mFilePath = "http://server.internext.tv:8080/wasim/GvxkEFmjv6/23192"
        val mw = MLServiceLocator.getAbstractMediaWrapper(Uri.parse(mFilePath))
        playMedia(mw)
    }

    @ObsoleteCoroutinesApi
    @ExperimentalCoroutinesApi
    private fun playMedia(mw: AbstractMediaWrapper) {
        mw.type = AbstractMediaWrapper.TYPE_STREAM
        MediaUtils.openMedia(this, mw)
    }

    companion object {
        val TAG = "LiveActivity"
    }
}
