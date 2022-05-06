package com.aiytl.randomnumbergenerator.activity

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.aiytl.randomnumbergenerator.R
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
        binding.btnOtherApp.setOnClickListener(this)

    }

    override fun onClick(view: View?) {
        when (view!!.id) {
            R.id.btn_pick3 -> {
                startActivity(Intent(MainActivity@this, ThreePredictorActivity::class.java))
            }

            R.id.btn_pick4 -> {
                startActivity(Intent(MainActivity@this, FourpredictorActivity::class.java))
            }

            R.id.btn_other_app -> {
                startActivity(Intent(MainActivity@this, OtherAppsActivity::class.java))
            }

        }
    }
}