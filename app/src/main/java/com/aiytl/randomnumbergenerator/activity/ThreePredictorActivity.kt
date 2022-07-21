package com.aiytl.randomnumbergenerator.activity

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import com.aiytl.randomnumbergenerator.R
import com.aiytl.randomnumbergenerator.addapter.ThreePredictorAdapter
import com.aiytl.randomnumbergenerator.databinding.ActivityThreePredictorBinding
import com.aiytl.randomnumbergenerator.model.ThreeNumbers
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.MobileAds
import java.math.BigInteger

class ThreePredictorActivity : AppCompatActivity() {
    private lateinit var context: Context
    private lateinit var binding: ActivityThreePredictorBinding
    private var numberList = arrayOf("0", "1", "2", "3", "4", "5", "6", "7", "8", "9")
    private lateinit var arrayAdapter: ArrayAdapter<String>
    private var intSpinner1: Int? = 0
    private var intSpinner2: Int? = 0
    private var intSpinner3: Int? = 0
    private var intSpinner4: Int? = 0
    private var intSpinner5: Int? = 0
    private var intSpinner6: Int? = 0
    private var sumOfSpinner14: Int? = 0
    private var sumOfSpinner25: Int? = 0
    private var sumOfSpinner36: Int? = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityThreePredictorBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar!!.title = getString(R.string.msg_title_bar_3_predictor_activity)

        context = this
        binding.recyclerview3column.layoutManager = LinearLayoutManager(context)

        MobileAds.initialize(context)
        binding.bannerAdview.loadAd(AdRequest.Builder().build())

        arrayAdapter =
            ArrayAdapter(context, android.R.layout.simple_dropdown_item_1line, numberList)

        binding.spinner1.adapter = arrayAdapter
        binding.spinner2.adapter = arrayAdapter
        binding.spinner3.adapter = arrayAdapter
        binding.spinner4.adapter = arrayAdapter
        binding.spinner5.adapter = arrayAdapter
        binding.spinner6.adapter = arrayAdapter

        binding.spinner1.onItemSelectedListener = object :
            AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View, position: Int, id: Long
            ) {
                intSpinner1 = parent.getItemAtPosition(position).toString().toInt()
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                // write code to perform some action
            }
        }

        binding.spinner2.onItemSelectedListener = object :
            AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View, position: Int, id: Long
            ) {
                intSpinner2 = parent.getItemAtPosition(position).toString().toInt()
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                // write code to perform some action
            }
        }

        binding.spinner3.onItemSelectedListener = object :
            AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View, position: Int, id: Long
            ) {
                intSpinner3 = parent.getItemAtPosition(position).toString().toInt()
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                // write code to perform some action
            }
        }

        binding.spinner4.onItemSelectedListener = object :
            AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View, position: Int, id: Long
            ) {
                intSpinner4 = parent.getItemAtPosition(position).toString().toInt()
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                // write code to perform some action
            }
        }

        binding.spinner5.onItemSelectedListener = object :
            AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View, position: Int, id: Long
            ) {
                intSpinner5 = parent.getItemAtPosition(position).toString().toInt()
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                // write code to perform some action
            }
        }

        binding.spinner6.onItemSelectedListener = object :
            AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View, position: Int, id: Long
            ) {
                intSpinner6 = parent.getItemAtPosition(position).toString().toInt()
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                // write code to perform some action
            }
        }

        binding.btnGen2nos.setOnClickListener(View.OnClickListener {
            sumOfSpinner14 = intSpinner1?.plus(intSpinner4!!)!!
            sumOfSpinner25 = intSpinner2?.plus(intSpinner5!!)!!
            sumOfSpinner36 = intSpinner3?.plus(intSpinner6!!)!!

            if (sumOfSpinner14 == 0) sumOfSpinner14 = 7
            if (sumOfSpinner14 == 1) sumOfSpinner14 = 9
            if (sumOfSpinner25 == 0) sumOfSpinner25 = 7
            if (sumOfSpinner25 == 1) sumOfSpinner25 = 9
            if (sumOfSpinner36 == 0) sumOfSpinner36 = 7
            if (sumOfSpinner36 == 1) sumOfSpinner36 = 9

            Log.d("SUM", "$sumOfSpinner14 $sumOfSpinner25 $sumOfSpinner36")
            var threeNumberList = ArrayList<ThreeNumbers>()

            var resultantNum14 : BigInteger = BigInteger("0")
            var resultantNum25 : BigInteger = BigInteger("0")
            var resultantNum36: BigInteger = BigInteger("0")

            var resultInBigInteger14 : BigInteger
            var resultInBigInteger25 : BigInteger
            var resultInBigInteger36 : BigInteger

            if (sumOfSpinner14 in 2..3){
                resultantNum14 = BigInteger(sumOfSpinner14.toString())
                resultInBigInteger14 = resultantNum14.pow(80)
            }else{
                resultantNum14 = BigInteger(sumOfSpinner14.toString())
                resultInBigInteger14 = resultantNum14.pow(40)
            }

            if (sumOfSpinner25 in 2..3){
                resultantNum25 = BigInteger(sumOfSpinner25.toString())
                resultInBigInteger25 = resultantNum25.pow(80)
            }else{
                resultantNum25 = BigInteger(sumOfSpinner25.toString())
                resultInBigInteger25 = resultantNum25.pow(40)
            }

            if (sumOfSpinner36 in 2..3){
                resultantNum36 = BigInteger(sumOfSpinner36.toString())
                resultInBigInteger36 = resultantNum36.pow(80)
            }else{
                resultantNum36 = BigInteger(sumOfSpinner36.toString())
                resultInBigInteger36 = resultantNum36.pow(40)
            }

            var result14 = resultInBigInteger14.toString().toCharArray()
            var result25 = resultInBigInteger25.toString().toCharArray()
            var result36  = resultInBigInteger36.toString().toCharArray()

            Log.d("Result:", ""+result14)
            Log.d("Result:", ""+result25)
            Log.d("Result:", ""+result36)

            for (i in 1..2) {
                if (i == 1) {

                    var threeNumbers = ThreeNumbers(result14[1], result25[2], result36[3])
                    threeNumberList.add(threeNumbers)
                }
                if (i == 2) {
                    var threeNumbers = ThreeNumbers(result14[4], result25[5], result36[6])
                    threeNumberList.add(threeNumbers)
                }
            }
            var threePredictorAdapter: ThreePredictorAdapter =
                ThreePredictorAdapter(threeNumberList)
            binding.recyclerview3column.adapter = threePredictorAdapter
        })

        binding.btnGen40nos.setOnClickListener {
            sumOfSpinner14 = intSpinner1?.plus(intSpinner4!!)!!
            sumOfSpinner25 = intSpinner2?.plus(intSpinner5!!)!!
            sumOfSpinner36 = intSpinner3?.plus(intSpinner6!!)!!

            if (sumOfSpinner14 == 0) sumOfSpinner14 = 7
            if (sumOfSpinner14 == 1) sumOfSpinner14 = 9
            if (sumOfSpinner25 == 0) sumOfSpinner25 = 7
            if (sumOfSpinner25 == 1) sumOfSpinner25 = 9
            if (sumOfSpinner36 == 0) sumOfSpinner36 = 7
            if (sumOfSpinner36 == 1) sumOfSpinner36 = 9

            Log.d("SUM", "$sumOfSpinner14 $sumOfSpinner25 $sumOfSpinner36")
            var threeNumberList = ArrayList<ThreeNumbers>()

            var resultantNum14 : BigInteger = BigInteger("0")
            var resultantNum25 : BigInteger = BigInteger("0")
            var resultantNum36: BigInteger = BigInteger("0")

            var resultInBigInteger14 : BigInteger
            var resultInBigInteger25 : BigInteger
            var resultInBigInteger36 : BigInteger

            if (sumOfSpinner14 in 2..3){
                resultantNum14 = BigInteger(sumOfSpinner14.toString())
                resultInBigInteger14 = resultantNum14.pow(80)
            }else{
                resultantNum14 = BigInteger(sumOfSpinner14.toString())
                resultInBigInteger14 = resultantNum14.pow(40)
            }

            if (sumOfSpinner25 in 2..3){
                resultantNum25 = BigInteger(sumOfSpinner25.toString())
                resultInBigInteger25 = resultantNum25.pow(80)
            }else{
                resultantNum25 = BigInteger(sumOfSpinner25.toString())
                resultInBigInteger25 = resultantNum25.pow(40)
            }

            if (sumOfSpinner36 in 2..3){
                resultantNum36 = BigInteger(sumOfSpinner36.toString())
                resultInBigInteger36 = resultantNum36.pow(80)
            }else{
                resultantNum36 = BigInteger(sumOfSpinner36.toString())
                resultInBigInteger36 = resultantNum36.pow(40)
            }

            var result14 = resultInBigInteger14.toString().toCharArray()
            var result25 = resultInBigInteger25.toString().toCharArray()
            var result36  = resultInBigInteger36.toString().toCharArray()

            Log.d("Result:", ""+result14)
            Log.d("Result:", ""+result25)
            Log.d("Result:", ""+result36)

            Log.d("SUM", "$sumOfSpinner14 $sumOfSpinner25 $sumOfSpinner36")
            for (i in 1..40) {
                if (i == 1) {

                    var threeNumbers = ThreeNumbers(result14[1], result25[2], result36[3])
                    threeNumberList.add(threeNumbers)
                }
                if (i == 2) {

                    var threeNumbers = ThreeNumbers(result14[4], result25[5], result36[6])
                    threeNumberList.add(threeNumbers)
                }
                if (i == 3) {

                    var threeNumbers = ThreeNumbers(result14[7], result25[8], result36[9])
                    threeNumberList.add(threeNumbers)
                }
                if (i == 4) {

                    var threeNumbers = ThreeNumbers(result14[10], result25[11], result36[12])
                    threeNumberList.add(threeNumbers)
                }
                if (i == 5) {

                    var threeNumbers = ThreeNumbers(result14[13], result25[14], result36[15])
                    threeNumberList.add(threeNumbers)
                }
                if (i == 6) {

                    var threeNumbers = ThreeNumbers(result14[16], result25[17], result36[18])
                    threeNumberList.add(threeNumbers)
                }
                if (i == 7) {

                    var threeNumbers = ThreeNumbers(result14[19], result25[20], result36[21])
                    threeNumberList.add(threeNumbers)
                }
                if (i == 8) {
                    var threeNumbers = ThreeNumbers(result14[22], result25[23], result36[24])
                    threeNumberList.add(threeNumbers)
                }
                if (i == 9) {
                    var threeNumbers = ThreeNumbers(result14[24], result25[23], result36[22])
                    threeNumberList.add(threeNumbers)
                }
                if (i == 10) {
                    var threeNumbers = ThreeNumbers(result14[22], result25[21], result36[20])
                    threeNumberList.add(threeNumbers)
                }
                if (i == 11) {
                    var threeNumbers = ThreeNumbers(result14[20], result25[19], result36[18])
                    threeNumberList.add(threeNumbers)
                }
                if (i == 12) {
                    var threeNumbers = ThreeNumbers(result14[18], result25[17], result36[16])
                    threeNumberList.add(threeNumbers)
                }
                if (i == 13) {
                    var threeNumbers = ThreeNumbers(result14[16], result25[15], result36[14])
                    threeNumberList.add(threeNumbers)
                }
                if (i == 14) {
                    var threeNumbers = ThreeNumbers(result14[14], result25[13], result36[12])
                    threeNumberList.add(threeNumbers)
                }
                if (i == 15) {
                    var threeNumbers = ThreeNumbers(result14[12], result25[11], result36[10])
                    threeNumberList.add(threeNumbers)
                }
                if (i == 16) {
                    var threeNumbers = ThreeNumbers(result14[10], result25[9], result36[8])
                    threeNumberList.add(threeNumbers)
                }
                if (i == 17) {
                    var threeNumbers = ThreeNumbers(result14[8], result25[7], result36[6])
                    threeNumberList.add(threeNumbers)
                }
                if (i == 18) {
                    var threeNumbers = ThreeNumbers(result14[6], result25[5], result36[4])
                    threeNumberList.add(threeNumbers)
                }
                if (i == 19) {
                    var threeNumbers = ThreeNumbers(result14[4], result25[3], result36[2])
                    threeNumberList.add(threeNumbers)
                }
                if (i == 20) {
                    var threeNumbers = ThreeNumbers(result14[2], result25[1], result36[0])
                    threeNumberList.add(threeNumbers)
                }
                if (i == 21) {
                    var threeNumbers = ThreeNumbers(result14[0], result25[1], result36[2])
                    threeNumberList.add(threeNumbers)
                }
                if (i == 22) {
                    var threeNumbers = ThreeNumbers(result14[0], result25[2], result36[1])
                    threeNumberList.add(threeNumbers)
                }
                if (i == 23) {
                    var threeNumbers = ThreeNumbers(result14[1], result25[0], result36[2])
                    threeNumberList.add(threeNumbers)
                }
                if (i == 24) {
                    var threeNumbers = ThreeNumbers(result14[2], result25[0], result36[1])
                    threeNumberList.add(threeNumbers)
                }
                if (i == 25) {
                    var threeNumbers = ThreeNumbers(result14[2], result25[3], result36[4])
                    threeNumberList.add(threeNumbers)
                }
                if (i == 26) {
                    var threeNumbers = ThreeNumbers(result14[4], result25[3], result36[0])
                    threeNumberList.add(threeNumbers)
                }
                if (i == 27) {
                    var threeNumbers = ThreeNumbers(result14[23], result25[3], result36[4])
                    threeNumberList.add(threeNumbers)
                }
                if (i == 28) {
                    var threeNumbers = ThreeNumbers(result14[3], result25[4], result36[23])
                    threeNumberList.add(threeNumbers)
                }
                if (i == 29) {
                    var threeNumbers = ThreeNumbers(result14[4], result25[4], result36[24])
                    threeNumberList.add(threeNumbers)
                }
                if (i == 30) {
                    var threeNumbers = ThreeNumbers(result14[1], result25[17], result36[16])
                    threeNumberList.add(threeNumbers)
                }
                if (i == 31) {
                    var threeNumbers = ThreeNumbers(result14[16], result25[17], result36[15])
                    threeNumberList.add(threeNumbers)
                }
                if (i == 32) {
                    var threeNumbers = ThreeNumbers(result14[15], result25[17], result36[19])
                    threeNumberList.add(threeNumbers)
                }
                if (i == 33) {
                    var threeNumbers = ThreeNumbers(result14[19], result25[15], result36[14])
                    threeNumberList.add(threeNumbers)
                }
                if (i == 34) {
                    var threeNumbers = ThreeNumbers(result14[14], result25[15], result36[13])
                    threeNumberList.add(threeNumbers)
                }
                if (i == 35) {
                    var threeNumbers = ThreeNumbers(result14[13], result25[12], result36[11])
                    threeNumberList.add(threeNumbers)
                }
                if (i == 36) {
                    var threeNumbers = ThreeNumbers(result14[11], result25[10], result36[9])
                    threeNumberList.add(threeNumbers)
                }
                if (i == 37) {
                    var threeNumbers = ThreeNumbers(result14[9], result25[8], result36[7])
                    threeNumberList.add(threeNumbers)
                }
                if (i == 38) {
                    var threeNumbers = ThreeNumbers(result14[7], result25[1], result36[1])
                    threeNumberList.add(threeNumbers)
                }
                if (i == 39) {
                    var threeNumbers = ThreeNumbers(result14[7], result25[2], result36[2])
                    threeNumberList.add(threeNumbers)
                }
                if (i == 40) {
                    var threeNumbers = ThreeNumbers(result14[7], result25[13], result36[3])
                    threeNumberList.add(threeNumbers)
                }
            }
            var threePredictorAdapter: ThreePredictorAdapter = ThreePredictorAdapter(threeNumberList)
            binding.recyclerview3column.adapter = threePredictorAdapter
        }

    }

}