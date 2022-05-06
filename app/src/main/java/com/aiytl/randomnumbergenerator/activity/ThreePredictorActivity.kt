package com.aiytl.randomnumbergenerator.activity

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.aiytl.randomnumbergenerator.R
import com.aiytl.randomnumbergenerator.databinding.ActivityThreePredictorBinding
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.MobileAds

class ThreePredictorActivity : AppCompatActivity() {
    private lateinit var context: Context
    private lateinit var binding : ActivityThreePredictorBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityThreePredictorBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar!!.title = getString(R.string.msg_title_bar_3_predictor_activity)

        context = this

        MobileAds.initialize(context)
        binding.bannerAdview.loadAd(AdRequest.Builder().build())

    }
}