/*****************************************************************************
 * AboutFragment.kt
 *
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
 */

package com.shera.internexttv.gui

import android.annotation.SuppressLint
import android.content.res.Configuration
import android.os.Bundle
import android.util.Base64
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.ScrollView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import kotlinx.coroutines.*
import org.videolan.tools.coroutineScope
import com.shera.internexttv.BuildConfig
import com.shera.internexttv.gui.audio.AudioPagerAdapter
import com.shera.internexttv.gui.helpers.UiTools
import com.shera.internexttv.util.Util

private const val TAG = "VLC/AboutFragment"
private const val MODE_TOTAL = 2 // Number of audio browser modes

@ObsoleteCoroutinesApi
@ExperimentalCoroutinesApi
class AboutFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater.inflate(com.shera.internexttv.R.layout.about, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (activity as? AppCompatActivity)?.supportActionBar?.title = "VLC ${BuildConfig.VERSION_NAME}"

        val aboutMain = view.findViewById<ScrollView>(com.shera.internexttv.R.id.about_main)
        val webView = view.findViewById<WebView>(com.shera.internexttv.R.id.webview)
        ///val revision = getString(com.shera.internexttv.R.string.build_revision)

        val lists = arrayOf(aboutMain, webView)
        val titles = arrayOf(getString(com.shera.internexttv.R.string.about), getString(com.shera.internexttv.R.string.licence))
        val viewPager = view.findViewById<ViewPager>(com.shera.internexttv.R.id.pager).apply {
            offscreenPageLimit = MODE_TOTAL - 1
            adapter = AudioPagerAdapter(lists as Array<View>, titles)
        }
        requireActivity().findViewById<TabLayout>(com.shera.internexttv.R.id.sliding_tabs).apply {
            visibility = View.VISIBLE
            setupWithViewPager(viewPager)
        }
//        coroutineScope.launch {
//            val asset = withContext(Dispatchers.IO) {
//                Util.readAsset("licence.htm", "").replace("!COMMITID!", revision)
//            }
//            UiTools.fillAboutView(view)
//            webView.loadData(asset, "text/html", "UTF8")
//
//            webView.webViewClient = object : WebViewClient() {
//
//                override fun onPageFinished(view: WebView, url: String) {
//
//                    // Inject CSS when page is done loading
//                    injectCSS(webView, when (context?.resources?.configuration?.uiMode?.and(Configuration.UI_MODE_NIGHT_MASK)) {
//                        Configuration.UI_MODE_NIGHT_YES -> {
//                            "licence_dark.css"
//                        }
//                        Configuration.UI_MODE_NIGHT_NO -> {
//                            "licence_light.css"
//                        }
//                        else -> {
//                            "licence_light.css"
//                        }
//                    })
//                    super.onPageFinished(view, url)
//                }
//            }
//
//
//        }
    }

    @SuppressLint("SetJavaScriptEnabled")
    private fun injectCSS(webView: WebView, cssAsset: String) {
        try {
            webView.settings.javaScriptEnabled = true
            val inputStream = requireActivity().assets.open(cssAsset)
            val buffer = ByteArray(inputStream.available())
            inputStream.read(buffer)
            inputStream.close()
            val encoded = Base64.encodeToString(buffer, Base64.NO_WRAP)
            webView.loadUrl("javascript:(function() {" +
                    "var parent = document.getElementsByTagName('head').item(0);" +
                    "var style = document.createElement('style');" +
                    "style.type = 'text/css';" +
                    // Tell the browser to BASE64-decode the string into your script !!!
                    "style.innerHTML = window.atob('" + encoded + "');" +
                    "parent.appendChild(style)" +
                    "})()")
            webView.settings.javaScriptEnabled = false
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}
