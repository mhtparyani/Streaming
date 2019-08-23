/*
 * *************************************************************************
 *  FilePickerActivity.java
 * **************************************************************************
 *  Copyright © 2015 VLC authors and VideoLAN
 *  Author: Geoffrey Métais
 *
 *  This program is free software; you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation; either version 2 of the License, or
 *  (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program; if not, write to the Free Software
 *  Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston MA 02110-1301, USA.
 *  ***************************************************************************
 */

package com.shera.internexttv.gui

import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.text.Html
import android.text.format.DateFormat
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.FileProvider
import androidx.core.text.HtmlCompat
import androidx.databinding.DataBindingUtil
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.ObsoleteCoroutinesApi
import org.videolan.libvlc.util.AndroidUtil
import org.videolan.medialibrary.interfaces.AbstractMedialibrary
import com.shera.internexttv.DebugLogService
import com.shera.internexttv.R
import com.shera.internexttv.VLCApplication
import com.shera.internexttv.databinding.SendCrashActivityBinding
import com.shera.internexttv.util.*
import java.io.File

@ObsoleteCoroutinesApi
@ExperimentalCoroutinesApi
class SendCrashActivity : AppCompatActivity(), DebugLogService.Client.Callback {
    private var logMessage = ""
    override fun onStarted(lostList: List<String>) {
        logMessage = "Starting collecting logs at ${System.currentTimeMillis()}"
        //initiate a log to wait for
        Log.d("SendCrashActivity", logMessage)
    }

    override fun onStopped() {
    }

    override fun onLog(msg: String) {
        //Wait for the log to initiate a save to avoid ANR
        if (msg.contains(logMessage)) {
            if (AndroidUtil.isOOrLater && !Permissions.canWriteStorage())
                Permissions.askWriteStoragePermission(this, false, Runnable { client.save() })
            else
                client.save()
        }
    }

    override fun onSaved(success: Boolean, path: String) {
        if (!success) {
            Snackbar.make(window.decorView, R.string.dump_logcat_failure, Snackbar.LENGTH_LONG).show()
            client.stop()
            return
        }
        runIO(Runnable {
            client.stop()
            FileUtils.zip(arrayOf(path), logcatZipPath)

            val emailIntent = Intent(Intent.ACTION_SEND)
            emailIntent.type = "message/rfc822"
            //get medialib db if needed
            if (binding.includeMedialibSwitch.isChecked) {
                if (Permissions.canWriteStorage()) {
                    val db = File(getDir("db", Context.MODE_PRIVATE).toString() + AbstractMedialibrary.VLC_MEDIA_DB_NAME)

                    val dbFile = File(dbPath)
                    FileUtils.copyFile(db, dbFile)
                    FileUtils.zip(arrayOf(dbPath), dbZipPath)
                    FileUtils.deleteFile(dbFile)

                    val dbUri = FileProvider.getUriForFile(this, applicationContext.packageName + ".provider", File(dbZipPath))
                    emailIntent.putExtra(Intent.EXTRA_STREAM, dbUri)
                    emailIntent.type = "application/zip"
                }
            }
            val appData = StringBuilder()
            try {
                appData.append("App version: ${AppUtils.getVersionName(VLCApplication.appContext)}<br/>App version code: ${AppUtils.getVersionCode(VLCApplication.appContext)}<br/>")
            } catch (e: PackageManager.NameNotFoundException) {

            }
            appData.append("Time: " + DateFormat.format("MM/dd/yyyy kk:mm:ss", System.currentTimeMillis()) + "<br/>")
            appData.append("Device model: ${Build.MANUFACTURER} ${Build.MODEL}<br/>")
            appData.append("Android version: ${Build.VERSION.SDK_INT}<br/>")
            appData.append("System name: ${Build.DISPLAY}<br/>")
            appData.append("Memory free: ${AppUtils.freeMemory().readableFileSize()} on ${AppUtils.totalMemory().readableFileSize()}")

            val logcatUri = FileProvider.getUriForFile(this, applicationContext.packageName + ".provider", File(logcatZipPath))
            emailIntent.putExtra(Intent.EXTRA_STREAM, logcatUri)
            emailIntent.type = "application/zip"

            val describeCrash = getString(R.string.describe_crash)
            val body = "<p>Here are my crash logs for VLC</strong></p><p style=3D\"color:#16171A;\"> [$describeCrash]</p><p>$appData</p>"
            val htmlBody = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) Html.fromHtml(body, HtmlCompat.FROM_HTML_MODE_LEGACY) else Html.fromHtml(body)

            emailIntent.putExtra(Intent.EXTRA_EMAIL, arrayOf("vlc.crashreport+androidcrash@gmail.com"))
            emailIntent.putExtra(Intent.EXTRA_SUBJECT, "[${AppUtils.getVersionName(VLCApplication.appContext)}] Crash logs for VLC")
            emailIntent.putExtra(Intent.EXTRA_TEXT, htmlBody)
            emailIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(emailIntent)
            runOnUiThread {
                finish()
            }

        })
    }

    private lateinit var client: DebugLogService.Client
    private lateinit var binding: SendCrashActivityBinding
    private val dbPath = VLCApplication.appContext.getExternalFilesDir(null)!!.absolutePath + "/" + AbstractMedialibrary.VLC_MEDIA_DB_NAME
    private val dbZipPath = VLCApplication.appContext.getExternalFilesDir(null)!!.absolutePath + "/" + "db.zip"
    private val logcatZipPath = VLCApplication.appContext.getExternalFilesDir(null)!!.absolutePath + "/" + "logcat.zip"

    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.send_crash_activity)

        binding.reportBugButton.setOnClickListener {
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://forum.videolan.org/viewforum.php?f=35")))
            finish()
        }
        binding.reportCrashButton.setOnClickListener {
            binding.crashFirstStepContainer.visibility = View.GONE
            binding.crashSecondStepContainer.visibility = View.VISIBLE
            client = DebugLogService.Client(this, this)
        }

        binding.sendCrashButton.setOnClickListener {
            client.start()
            binding.sendCrashButton.visibility = View.GONE
            binding.sendCrashProgress.visibility = View.VISIBLE
        }
    }

    override fun onDestroy() {
        if (::client.isInitialized) client.release()
        super.onDestroy()
    }

}
