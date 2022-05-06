package com.aiytl.randomnumbergenerator.activity

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.aiytl.randomnumbergenerator.R
import com.aiytl.randomnumbergenerator.databinding.ActivityFourpredictorBinding
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.MobileAds

class FourpredictorActivity : AppCompatActivity() {
    private lateinit var binding : ActivityFourpredictorBinding
    private lateinit var context: Context

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFourpredictorBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar!!.title = getString(R.string.msg_title_bar_4_predictor_activity)

        context = this

        MobileAds.initialize(context)
        binding.bannerAdview.loadAd(AdRequest.Builder().build())
    }
}