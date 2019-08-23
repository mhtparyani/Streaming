package com.shera.internexttv.gui.tv

import android.os.Bundle
import androidx.fragment.app.FragmentActivity

import com.shera.internexttv.R
import com.shera.internexttv.gui.helpers.UiTools

class AboutActivity : FragmentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.about_main)
        UiTools.fillAboutView(window.decorView.rootView)
        TvUtil.applyOverscanMargin(this)
        this.registerTimeView(findViewById(R.id.tv_time))
    }
}
