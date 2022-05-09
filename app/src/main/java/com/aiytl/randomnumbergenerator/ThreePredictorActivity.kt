package com.aiytl.randomnumbergenerator

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import com.aiytl.randomnumbergenerator.R
import com.aiytl.randomnumbergenerator.databinding.ActivityThreePredictorBinding
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.MobileAds

class ThreePredictorActivity : AppCompatActivity() {
    private lateinit var context: Context
    private lateinit var binding : ActivityThreePredictorBinding
    private var numberList = arrayOf("0", "1", "2", "3", "4", "5", "6", "7", "8", "9")
    private lateinit var arrayAdapter : ArrayAdapter<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityThreePredictorBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar!!.title = getString(R.string.msg_title_bar_3_predictor_activity)

        context = this

        MobileAds.initialize(context)
        binding.bannerAdview.loadAd(AdRequest.Builder().build())

        arrayAdapter = ArrayAdapter(context, android.R.layout.simple_dropdown_item_1line, numberList)

        binding.spinner1.adapter = arrayAdapter
        binding.spinner2.adapter = arrayAdapter
        binding.spinner3.adapter = arrayAdapter
        binding.spinner4.adapter = arrayAdapter
        binding.spinner5.adapter = arrayAdapter
        binding.spinner6.adapter = arrayAdapter

//        binding.spinner1.onItemSelectedListener = object :
//            AdapterView.OnItemSelectedListener {
//            override fun onItemSelected(parent: AdapterView<*>,
//                                        view: View, position: Int, id: Long) {
//                Toast.makeText(context, "" + numberList[position], Toast.LENGTH_SHORT).show()
//            }
//
//            override fun onNothingSelected(parent: AdapterView<*>) {
//                // write code to perform some action
//            }
//        }

    }
}