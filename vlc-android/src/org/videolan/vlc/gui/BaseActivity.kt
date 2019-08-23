package com.shera.internexttv.gui

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.KeyEvent
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.cancel
import org.videolan.tools.KeyHelper
import com.shera.internexttv.gui.helpers.applyTheme
import com.shera.internexttv.util.Settings
import com.shera.internexttv.util.getContextWithLocale

open class BaseActivity : AppCompatActivity(), CoroutineScope by MainScope() {

    lateinit var settings: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        settings = Settings.getInstance(this)
        /* Theme must be applied before super.onCreate */
        applyTheme()
        super.onCreate(savedInstanceState)
    }

    override fun attachBaseContext(newBase: Context?) {
        super.attachBaseContext(newBase?.getContextWithLocale())
    }

    override fun getApplicationContext(): Context {
        return super.getApplicationContext().getContextWithLocale()
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent): Boolean {
        KeyHelper.manageModifiers(event)
        return super.onKeyDown(keyCode, event)
    }

    override fun onKeyUp(keyCode: Int, event: KeyEvent): Boolean {
        KeyHelper.manageModifiers(event)
        return super.onKeyUp(keyCode, event)
    }

    override fun onDestroy() {
        cancel()
        super.onDestroy()
    }
}
