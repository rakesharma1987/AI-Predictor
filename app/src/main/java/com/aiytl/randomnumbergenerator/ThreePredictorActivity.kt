package com.aiytl.randomnumbergenerator

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
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
    private var intSpinner1 : Int? = 0
    private var intSpinner2 : Int? = 0
    private var intSpinner3 : Int? = 0
    private var intSpinner4 : Int? = 0
    private var intSpinner5 : Int? = 0
    private var intSpinner6 : Int? = 0
    private var sumOfSpinner14 : Int = 0
    private var sumOfSpinner25 : Int = 0
    private var sumOfSpinner36 : Int = 0


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

        binding.spinner1.onItemSelectedListener = object :
            AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>,
                                        view: View, position: Int, id: Long) {
                intSpinner1 = parent.getItemAtPosition(position).toString().toInt()
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                // write code to perform some action
            }
        }

        binding.spinner2.onItemSelectedListener = object :
            AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>,
                                        view: View, position: Int, id: Long) {
                intSpinner2 = parent.getItemAtPosition(position).toString().toInt()
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                // write code to perform some action
            }
        }

        binding.spinner3.onItemSelectedListener = object :
            AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>,
                                        view: View, position: Int, id: Long) {
                intSpinner3 = parent.getItemAtPosition(position).toString().toInt()
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                // write code to perform some action
            }
        }

        binding.spinner4.onItemSelectedListener = object :
            AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>,
                                        view: View, position: Int, id: Long) {
                intSpinner4 = parent.getItemAtPosition(position).toString().toInt()
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                // write code to perform some action
            }
        }

        binding.spinner5.onItemSelectedListener = object :
            AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>,
                                        view: View, position: Int, id: Long) {
                intSpinner5 = parent.getItemAtPosition(position).toString().toInt()
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                // write code to perform some action
            }
        }

        binding.spinner6.onItemSelectedListener = object :
            AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>,
                                        view: View, position: Int, id: Long) {
                intSpinner6 = parent.getItemAtPosition(position).toString().toInt()
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                // write code to perform some action
            }
        }

        binding.btnGen2nos.setOnClickListener {
            sumOfSpinner14 = intSpinner1?.plus(intSpinner4!!)!!
            sumOfSpinner25 = intSpinner2?.plus(intSpinner5!!)!!
            sumOfSpinner36 = intSpinner3?.plus(intSpinner6!!)!!

            Log.d("SUM", "$sumOfSpinner14 $sumOfSpinner25 $sumOfSpinner36")
            for (i in 1..2){
                if (i == 1) {
                    var cube14 = sumOfSpinner14*sumOfSpinner14*sumOfSpinner14
                    var cube25 = sumOfSpinner25*sumOfSpinner25*sumOfSpinner25
                    var cube36 = sumOfSpinner36*sumOfSpinner36*sumOfSpinner36
                    Log.d("SUM", "$cube14 $cube25 $cube36")
                }
                if (i == 1) {
                    var four14 = sumOfSpinner14*sumOfSpinner14*sumOfSpinner14*sumOfSpinner14
                    var four25 = sumOfSpinner25*sumOfSpinner25*sumOfSpinner25*sumOfSpinner25
                    var four36 = sumOfSpinner36*sumOfSpinner36*sumOfSpinner36*sumOfSpinner36
                    Log.d("SUM", "$four14 $four25 $four36")
                }
            }
        }

    }
}