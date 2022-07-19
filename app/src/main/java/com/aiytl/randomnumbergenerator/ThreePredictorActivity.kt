package com.aiytl.randomnumbergenerator

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.recyclerview.widget.LinearLayoutManager
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
    private var intSpinner1: Long? = 0L
    private var intSpinner2: Long? = 0L
    private var intSpinner3: Long? = 0L
    private var intSpinner4: Long? = 0L
    private var intSpinner5: Long? = 0L
    private var intSpinner6: Long? = 0L
    private var sumOfSpinner14: Long? = 0L
    private var sumOfSpinner25: Long? = 0L
    private var sumOfSpinner36: Long? = 0L
    private var sumOfSpinner16: Long? = 0L
    private var sumOfSpinner24: Long? = 0L
    private var sumOfSpinner31: Long? = 0L
    private var sumOfSpinner12: Long? = 0L
    private var sumOfSpinner23: Long? = 0L
    private var sumOfSpinner65: Long? = 0L


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
                intSpinner1 = parent.getItemAtPosition(position).toString().toLong()
                if (intSpinner1!! == 0L){
                    intSpinner1 = 7L
                }
                if (intSpinner1!! == 1L) {
                    intSpinner1 = 9L
                }
                Log.d("Result:", ""+intSpinner1)
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
                intSpinner2 = parent.getItemAtPosition(position).toString().toLong()
                if (intSpinner2!! == 0L) intSpinner2 = 7L
                if (intSpinner2!! == 1L) intSpinner2 = 9L
                Log.d("Result:", ""+intSpinner2)
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
                intSpinner3 = parent.getItemAtPosition(position).toString().toLong()
                if (intSpinner3!! == 0L) intSpinner3 = 7
                if (intSpinner3!! == 1L) intSpinner3 = 9
                Log.d("Result:", ""+intSpinner3)
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
                intSpinner4 = parent.getItemAtPosition(position).toString().toLong()
                if (intSpinner4!! == 0L) intSpinner4 = 7
                if (intSpinner4!! == 1L) intSpinner4 = 9
                Log.d("Result:", ""+intSpinner4)
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
                intSpinner5 = parent.getItemAtPosition(position).toString().toLong()
                if (intSpinner5!! == 0L) intSpinner5 = 7
                if (intSpinner5!! == 1L) intSpinner5 = 9
                Log.d("Result:", ""+intSpinner5)
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
                intSpinner6 = parent.getItemAtPosition(position).toString().toLong()
                if (intSpinner6!! == 0L) intSpinner6 = 7
                if (intSpinner6!! == 1L) intSpinner6 = 9
                Log.d("Result:", ""+intSpinner6)
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                // write code to perform some action
            }
        }

        binding.btnGen2nos.setOnClickListener(View.OnClickListener {
            sumOfSpinner14 = intSpinner1?.plus(intSpinner4!!)!!
            sumOfSpinner25 = intSpinner2?.plus(intSpinner5!!)!!
            sumOfSpinner36 = intSpinner3?.plus(intSpinner6!!)!!

            sumOfSpinner16 = intSpinner1?.plus(intSpinner6!!)!!
            sumOfSpinner24 = intSpinner2?.plus(intSpinner4!!)!!
            sumOfSpinner31 = intSpinner3?.plus(intSpinner1!!)!!

            sumOfSpinner12 = intSpinner1?.plus(intSpinner2!!)!!
            sumOfSpinner23 = intSpinner2?.plus(intSpinner3!!)!!
            sumOfSpinner65 = intSpinner6?.plus(intSpinner5!!)!!

            Log.d("SUM", "$sumOfSpinner14 $sumOfSpinner25 $sumOfSpinner36")
            var threeNumberList = ArrayList<ThreeNumbers>()

            var resultantNum14 : Long
            var resultantNum25 : Long
            var resultantNum36: Long

            if (sumOfSpinner14!! == 16L || sumOfSpinner14!! == 9L){
                var newNum = sumOfSpinner14!! + 1L
                resultantNum14 =(newNum * newNum * newNum * newNum * newNum * newNum * newNum * newNum * newNum * newNum * newNum * newNum).toLong()
            } else{
                resultantNum14 = (sumOfSpinner14!! * sumOfSpinner14!! * sumOfSpinner14!! * sumOfSpinner14!! * sumOfSpinner14!! * sumOfSpinner14!! * sumOfSpinner14!! * sumOfSpinner14!! * sumOfSpinner14!! * sumOfSpinner14!! * sumOfSpinner14!! * sumOfSpinner14!!).toLong()
            }

            if (sumOfSpinner25!! == 16L || sumOfSpinner25!! == 9L){
                var newNum = sumOfSpinner25!! + 1L
                resultantNum25 = (newNum * newNum * newNum * newNum * newNum * newNum * newNum * newNum * newNum * newNum * newNum * newNum).toLong()
            } else{
                resultantNum25 = (sumOfSpinner25!! * sumOfSpinner25!! * sumOfSpinner25!! * sumOfSpinner25!! * sumOfSpinner25!! * sumOfSpinner25!! * sumOfSpinner25!! * sumOfSpinner25!! * sumOfSpinner25!! * sumOfSpinner25!! * sumOfSpinner25!! * sumOfSpinner25!!).toLong()
            }

            if (sumOfSpinner36!! == 16L || sumOfSpinner36!! == 9L){
                var newNum = sumOfSpinner36!! + 1L
                resultantNum36 = (newNum * newNum * newNum * newNum * newNum * newNum * newNum * newNum * newNum * newNum * newNum * newNum).toLong()
            }else {
                resultantNum36= (sumOfSpinner36!! * sumOfSpinner36!! * sumOfSpinner36!! * sumOfSpinner36!! * sumOfSpinner36!! * sumOfSpinner36!! * sumOfSpinner36!! * sumOfSpinner36!! * sumOfSpinner36!! * sumOfSpinner36!! * sumOfSpinner36!! * sumOfSpinner36!!).toLong()
            }

            var result14 = resultantNum14.toString().toCharArray()
            var result25 = resultantNum25.toString().toCharArray()
            var result36  = resultantNum36.toString().toCharArray()

            Log.d("Result:", ""+result14)
            Log.d("Result:", ""+result25)
            Log.d("Result:", ""+result36)

            for (i in 1..2) {
                if (i == 1) {

                    var threeNumbers = ThreeNumbers(result14[0], result25[0], result36[0])
                    threeNumberList.add(threeNumbers)
                }
                if (i == 2) {
                    var threeNumbers = ThreeNumbers(result14[1], result25[1], result36[1])
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

            sumOfSpinner16 = intSpinner1?.plus(intSpinner6!!)!!
            sumOfSpinner24 = intSpinner2?.plus(intSpinner4!!)!!
            sumOfSpinner31 = intSpinner3?.plus(intSpinner1!!)!!

            sumOfSpinner12 = intSpinner1?.plus(intSpinner2!!)!!
            sumOfSpinner23 = intSpinner2?.plus(intSpinner3!!)!!
            sumOfSpinner65 = intSpinner6?.plus(intSpinner5!!)!!

            Log.d("SUM", "$sumOfSpinner14 $sumOfSpinner25 $sumOfSpinner36")
            var threeNumberList = ArrayList<ThreeNumbers>()

            var resultantNum14 : Long
            var resultantNum25 : Long
            var resultantNum36: Long

            if (sumOfSpinner14!!.equals(16) || sumOfSpinner14!!.equals(9)){
                var newNum = sumOfSpinner14!! + 1
                resultantNum14 =(newNum * newNum * newNum * newNum * newNum * newNum * newNum * newNum * newNum * newNum * newNum * newNum).toLong()
            } else{
                resultantNum14 = (sumOfSpinner14!! * sumOfSpinner14!! * sumOfSpinner14!! * sumOfSpinner14!! * sumOfSpinner14!! * sumOfSpinner14!! * sumOfSpinner14!! * sumOfSpinner14!! * sumOfSpinner14!! * sumOfSpinner14!! * sumOfSpinner14!! * sumOfSpinner14!!).toLong()
            }

            if (sumOfSpinner25!!.equals(16) || sumOfSpinner25!!.equals(9)){
                var newNum = sumOfSpinner25!! + 1
                resultantNum25 = (newNum * newNum * newNum * newNum * newNum * newNum * newNum * newNum * newNum * newNum * newNum * newNum).toLong()
            } else{
                resultantNum25 = (sumOfSpinner25!! * sumOfSpinner25!! * sumOfSpinner25!! * sumOfSpinner25!! * sumOfSpinner25!! * sumOfSpinner25!! * sumOfSpinner25!! * sumOfSpinner25!! * sumOfSpinner25!! * sumOfSpinner25!! * sumOfSpinner25!! * sumOfSpinner25!!).toLong()
            }

            if (sumOfSpinner36!!.equals(16) || sumOfSpinner36!!.equals(9)){
                var newNum = sumOfSpinner36!! + 1
                resultantNum36 = (newNum * newNum * newNum * newNum * newNum * newNum * newNum * newNum * newNum * newNum * newNum * newNum).toLong()
            }else {
                resultantNum36= (sumOfSpinner36!! * sumOfSpinner36!! * sumOfSpinner36!! * sumOfSpinner36!! * sumOfSpinner36!! * sumOfSpinner36!! * sumOfSpinner36!! * sumOfSpinner36!! * sumOfSpinner36!! * sumOfSpinner36!! * sumOfSpinner36!! * sumOfSpinner36!!).toLong()
            }

            var result14 = resultantNum14.toString().toCharArray()
            var result25 = resultantNum25.toString().toCharArray()
            var result36 = resultantNum36.toString().toCharArray()

            Log.d("SUM", "$sumOfSpinner14 $sumOfSpinner25 $sumOfSpinner36")
            for (i in 1..40) {
                if (i == 1) {

                    var threeNumbers = ThreeNumbers(result14[0], result25[0], result36[0])
                    threeNumberList.add(threeNumbers)
                }
                if (i == 2) {

                    var threeNumbers = ThreeNumbers(result14[1], result25[1], result36[1])
                    threeNumberList.add(threeNumbers)
                }
                if (i == 3) {

                    var threeNumbers = ThreeNumbers(result14[2], result25[2], result36[2])
                    threeNumberList.add(threeNumbers)
                }
                if (i == 4) {

                    var threeNumbers = ThreeNumbers(result14[3], result25[3], result36[3])
                    threeNumberList.add(threeNumbers)
                }
                if (i == 5) {

                    var threeNumbers = ThreeNumbers(result14[4], result25[4], result36[4])
                    threeNumberList.add(threeNumbers)
                }
                if (i == 6) {

                    var threeNumbers = ThreeNumbers(result14[5], result25[5], result36[5])
                    threeNumberList.add(threeNumbers)
                }
                if (i == 7) {

                    var threeNumbers = ThreeNumbers(result14[6], result25[6], result36[6])
                    threeNumberList.add(threeNumbers)
                }
                if (i == 8) {

                    var threeNumbers = ThreeNumbers(result14[8], result25[0], result36[0])
                    threeNumberList.add(threeNumbers)
                }
                if (i == 9) {
                    var threeNumbers = ThreeNumbers(result14[7], result25[7], result36[7])
                    threeNumberList.add(threeNumbers)
                }
                if (i == 10) {
                    var threeNumbers = ThreeNumbers(result14[8], result25[8], result36[8])
                    threeNumberList.add(threeNumbers)
                }
                if (i == 11) {
                    var threeNumbers = ThreeNumbers(result14[1], result25[2], result36[3])
                    threeNumberList.add(threeNumbers)
                }
                if (i == 12) {
                    var threeNumbers = ThreeNumbers(result14[1], result25[4], result36[5])
                    threeNumberList.add(threeNumbers)
                }
                if (i == 13) {
                    var threeNumbers = ThreeNumbers(result14[1], result25[6], result36[7])
                    threeNumberList.add(threeNumbers)
                }
                if (i == 14) {
                    var threeNumbers = ThreeNumbers(result14[1], result25[8], result36[0])
                    threeNumberList.add(threeNumbers)
                }
                if (i == 15) {
                    var threeNumbers = ThreeNumbers(result14[2], result25[3], result36[4])
                    threeNumberList.add(threeNumbers)
                }
                if (i == 16) {
                    var threeNumbers = ThreeNumbers(result14[2], result25[5], result36[6])
                    threeNumberList.add(threeNumbers)
                }
                if (i == 17) {
                    var threeNumbers = ThreeNumbers(result14[2], result25[7], result36[8])
                    threeNumberList.add(threeNumbers)
                }
                if (i == 18) {
                    var threeNumbers = ThreeNumbers(result14[3], result25[1], result36[2])
                    threeNumberList.add(threeNumbers)
                }
                if (i == 19) {
                    var threeNumbers = ThreeNumbers(result14[3], result25[3], result36[4])
                    threeNumberList.add(threeNumbers)
                }
                if (i == 20) {
                    var threeNumbers = ThreeNumbers(result14[3], result25[5], result36[6])
                    threeNumberList.add(threeNumbers)
                }
                if (i == 21) {
                    var threeNumbers = ThreeNumbers(result14[3], result25[7], result36[8])
                    threeNumberList.add(threeNumbers)
                }
                if (i == 22) {
                    var threeNumbers = ThreeNumbers(result14[4], result25[1], result36[2])
                    threeNumberList.add(threeNumbers)
                }
                if (i == 23) {
                    var threeNumbers = ThreeNumbers(result14[4], result25[3], result36[4])
                    threeNumberList.add(threeNumbers)
                }
                if (i == 24) {
                    var threeNumbers = ThreeNumbers(result14[4], result25[5], result36[6])
                    threeNumberList.add(threeNumbers)
                }
                if (i == 25) {
                    var threeNumbers = ThreeNumbers(result14[4], result25[7], result36[8])
                    threeNumberList.add(threeNumbers)
                }
                if (i == 26) {
                    var threeNumbers = ThreeNumbers(result14[5], result25[1], result36[2])
                    threeNumberList.add(threeNumbers)
                }
                if (i == 27) {
                    var threeNumbers = ThreeNumbers(result14[5], result25[2], result36[3])
                    threeNumberList.add(threeNumbers)
                }
                if (i == 28) {
                    var threeNumbers = ThreeNumbers(result14[5], result25[4], result36[5])
                    threeNumberList.add(threeNumbers)
                }
                if (i == 29) {
                    var threeNumbers = ThreeNumbers(result14[5], result25[6], result36[7])
                    threeNumberList.add(threeNumbers)
                }
                if (i == 30) {
                    var threeNumbers = ThreeNumbers(result14[6], result25[0], result36[0])
                    threeNumberList.add(threeNumbers)
                }
                if (i == 31) {
                    var threeNumbers = ThreeNumbers(result14[5], result25[8], result36[0])
                    threeNumberList.add(threeNumbers)
                }
                if (i == 32) {
                    var threeNumbers = ThreeNumbers(result14[6], result25[1], result36[2])
                    threeNumberList.add(threeNumbers)
                }
                if (i == 33) {
                    var threeNumbers = ThreeNumbers(result14[6], result25[2], result36[3])
                    threeNumberList.add(threeNumbers)
                }
                if (i == 34) {
                    var threeNumbers = ThreeNumbers(result14[6], result25[4], result36[5])
                    threeNumberList.add(threeNumbers)
                }
                if (i == 35) {
                    var threeNumbers = ThreeNumbers(result14[6], result25[6], result36[7])
                    threeNumberList.add(threeNumbers)
                }
                if (i == 36) {
                    var threeNumbers = ThreeNumbers(result14[6], result25[8], result36[0])
                    threeNumberList.add(threeNumbers)
                }
                if (i == 37) {
                    var threeNumbers = ThreeNumbers(result14[7], result25[0], result36[0])
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
                    var threeNumbers = ThreeNumbers(result14[7], result25[3], result36[3])
                    threeNumberList.add(threeNumbers)
                }
            }
            var threePredictorAdapter: ThreePredictorAdapter = ThreePredictorAdapter(threeNumberList)
            binding.recyclerview3column.adapter = threePredictorAdapter
        }

    }

    fun getSumOfDigits(number: Long): Long {
        var number = number
        var sum = 0L
        while (number > 0) {
            val r = number % 10
            sum += r
            number /= 10
        }
        return sum
    }

    fun countDigits(str: String): Long = (str.filter { Character.isDigit(it) }.count()).toLong()

    fun convertStringToArray(str: String): Array<String> {
        return str.toCharArray().map { it.toString() }.toTypedArray()
    }

    fun stringToIntList(data: String): List<Int> =
        data.split(",").filter { it.toIntOrNull() != null }
            .map { it.toInt() }

}