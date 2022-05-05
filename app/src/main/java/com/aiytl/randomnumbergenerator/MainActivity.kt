package com.aiytl.randomnumbergenerator

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.aiytl.randomnumbergenerator.databinding.ActivityMainBinding
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.MobileAds

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var context: Context
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar!!.title = getString(R.string.msg_title_bar)

        context = this

        MobileAds.initialize(context)
        binding.bannerAdview.loadAd(AdRequest.Builder().build())

        binding.btnPick3.setOnClickListener(this)
        binding.btnPick4.setOnClickListener(this)
        binding.bannerAdview.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        when (view!!.id) {
            R.id.btn_pick3 -> {
                startActivity(Intent(MainActivity@this, ThreePredictorActivity::class.java))
            }

            R.id.btn_pick4 -> {

            }

            else -> {
//                val playConsoleAppList = "https://play.google.com/store/apps/developer?id="
//                startActivity(Intent(Intent.ACTION_VIEW, playConsoleAppList))
            }

        }
    }
}