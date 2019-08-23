package com.shera.internexttv


import android.annotation.TargetApi
import android.content.Context
import android.media.tv.TvInputManager
import android.media.tv.TvInputManager.VIDEO_UNAVAILABLE_REASON_TUNING
import android.media.tv.TvInputService
import android.net.Uri
import android.os.Build
import android.util.Log
import android.view.Surface
import kotlinx.coroutines.*
import org.videolan.libvlc.Media
import org.videolan.libvlc.MediaPlayer
import com.shera.internexttv.media.MediaPlayerEventListener
import com.shera.internexttv.media.PlayerController
import com.shera.internexttv.util.VLCInstance
import com.shera.internexttv.util.getContextWithLocale
import com.shera.internexttv.util.getFromMl
import com.shera.internexttv.util.random
import java.io.IOException

private const val TAG = "PreviewInputService"

@ObsoleteCoroutinesApi
@ExperimentalCoroutinesApi
@TargetApi(Build.VERSION_CODES.LOLLIPOP)
class PreviewVideoInputService : TvInputService(), CoroutineScope {
    override val coroutineContext = Dispatchers.Main.immediate

    override fun onCreateSession(inputId: String): TvInputService.Session? {
        return PreviewSession(this)
    }

    override fun attachBaseContext(newBase: Context?) {
        super.attachBaseContext(newBase?.getContextWithLocale())
    }

    override fun getApplicationContext(): Context {
        return super.getApplicationContext().getContextWithLocale()
    }

    private inner class PreviewSession(context: Context
    ) : TvInputService.Session(context), MediaPlayerEventListener {

        val player by lazy(LazyThreadSafetyMode.NONE) { PlayerController(applicationContext) }

        override fun onRelease() {
            player.release()
        }

        override fun onTune(uri: Uri): Boolean {
            notifyVideoUnavailable(VIDEO_UNAVAILABLE_REASON_TUNING)
            val id = uri.lastPathSegment?.toLong() ?: return false
            launch {
                val mw = getFromMl { getMedia(id) }
                if (mw == null) {
                    Log.w(TAG, "Could not find video $id")
                    notifyVideoUnavailable(TvInputManager.VIDEO_UNAVAILABLE_REASON_UNKNOWN)
                    return@launch
                }
                try {
                    val media = Media(VLCInstance.get(this@PreviewVideoInputService), mw.uri)
                    val start = if (mw.length <= 0L) 0L else mw.length.random()
                    media.addOption(":start-time=${start/1000L}")
                    awaitSurface()
                    player.getVout()?.apply {
                        setVideoSurface(surface, null)
                        attachViews(null)
                        setWindowSize(width, height)
                    }
                    player.setVideoAspectRatio(null)
                    player.setVideoScale(0f)
                    player.startPlayback(media, this@PreviewSession, start)
                    notifyVideoAvailable()
                } catch (e: IOException) {
                    Log.e(TAG, "Could not prepare media player", e)
                    notifyVideoUnavailable(TvInputManager.VIDEO_UNAVAILABLE_REASON_UNKNOWN)
                } catch (e: IllegalStateException) {
                    Log.e(TAG, "Could not prepare media player", e)
                    notifyVideoUnavailable(TvInputManager.VIDEO_UNAVAILABLE_REASON_UNKNOWN)
                }
            }
            return true
        }

        private var width = 0
        private var height = 0
        private lateinit var surface: Surface
        private var surfaceReady : CompletableDeferred<Unit>? = null
        override fun onSetSurface(surface: Surface?): Boolean {
            if (surface == null) return false
            this.surface = surface
            surfaceReady?.complete(Unit)
            return true
        }

        override fun onSurfaceChanged(format: Int, width: Int, height: Int) {
            this.width = width
            this.height = height
        }

        override fun onSetStreamVolume(volume: Float) {}

        override fun onSetCaptionEnabled(enabled: Boolean) {}

        override suspend fun onEvent(event: MediaPlayer.Event) {
            when(event.type) {
                MediaPlayer.Event.EndReached -> player.release()
            }
        }

        private suspend fun awaitSurface() {
            if (!::surface.isInitialized) {
                surfaceReady = CompletableDeferred(Unit)
                surfaceReady?.await()
                surfaceReady = null
            }
        }
    }
}