package com.shera.internexttv.gui.tv.browser

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.shera.internexttv.R
import com.shera.internexttv.gui.network.MRLPanelFragment
import com.shera.internexttv.gui.tv.MainTvActivity
import com.shera.internexttv.util.HEADER_STREAM

class TVActivity : AppCompatActivity() {

    private lateinit var fragment: Fragment

    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.tv_vertical_grid)
        if (savedInstanceState == null) {
            val type = intent.getLongExtra(MainTvActivity.BROWSER_TYPE, -1)
            if (type == HEADER_STREAM) {
                fragment = MRLPanelFragment()
            } else {
                finish()
                return
            }
            supportFragmentManager.beginTransaction()
                    .add(R.id.tv_fragment_placeholder, fragment)
                    .commit()
        }
    }
}