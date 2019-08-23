package com.shera.internexttv.gui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.shera.internexttv.R
import com.shera.internexttv.databinding.ActivityBetaWelcomeBinding

class BetaWelcomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityBetaWelcomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_beta_welcome)
        binding.betaOkButton.setOnClickListener {
            finish()
        }
    }
}
