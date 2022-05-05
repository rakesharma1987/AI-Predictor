package com.aiytl.randomnumbergenerator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.aiytl.randomnumbergenerator.R

class ThreePredictorActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_three_predictor)
        supportActionBar!!.title = getString(R.string.msg_title_bar_3_predictor_activity)
    }
}