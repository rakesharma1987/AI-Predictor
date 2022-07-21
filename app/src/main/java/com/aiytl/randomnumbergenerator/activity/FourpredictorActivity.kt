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
import com.aiytl.randomnumbergenerator.addapter.FourPredictorAdapter
import com.aiytl.randomnumbergenerator.databinding.ActivityFourpredictorBinding
import com.aiytl.randomnumbergenerator.model.FourNumbers
import com.android.billingclient.api.*
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.MobileAds
import java.math.BigInteger

class FourpredictorActivity : AppCompatActivity() {
    private lateinit var binding : ActivityFourpredictorBinding
    private lateinit var context: Context
    private var numberList = arrayOf("0", "1", "2", "3", "4", "5", "6", "7", "8", "9")
    private lateinit var arrayAdapter: ArrayAdapter<String>
    private var intSpinner1: Int? = 0
    private var intSpinner2: Int? = 0
    private var intSpinner3: Int? = 0
    private var intSpinner4: Int? = 0
    private var intSpinner5: Int? = 0
    private var intSpinner6: Int? = 0
    private var intSpinner7: Int? = 0
    private var intSpinner8: Int? = 0
    private var sumOfSpinner15: Int? = 0
    private var sumOfSpinner26: Int? = 0
    private var sumOfSpinner37: Int? = 0
    private var sumOfSpinner48: Int? = 0
    private lateinit var billingClient : BillingClient

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFourpredictorBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar!!.title = getString(R.string.msg_title_bar_4_predictor_activity)

        context = this
        binding.recyclerview4column.layoutManager = LinearLayoutManager(context)

        MobileAds.initialize(context)
        binding.bannerAdview.loadAd(AdRequest.Builder().build())

        val purchasesUpdatedListener =
            PurchasesUpdatedListener { billingResult, purchases ->
                // To be implemented in a later section.
            }

        billingClient = BillingClient.newBuilder(context)
            .setListener(purchasesUpdatedListener)
            .enablePendingPurchases()
            .build()

        val skulList = ArrayList<String>()
        skulList.add("android.test.purchased")

        billingClient.startConnection(object : BillingClientStateListener {
            override fun onBillingSetupFinished(billingResult: BillingResult) {
                if (billingResult.responseCode ==  BillingClient.BillingResponseCode.OK) {
                    // The BillingClient is ready. You can query purchases here.
                }
            }
            override fun onBillingServiceDisconnected() {
                // Try to restart the connection on the next request to
                // Google Play by calling the startConnection() method.
            }
        })

        arrayAdapter =
            ArrayAdapter(context, android.R.layout.simple_dropdown_item_1line, numberList)

        binding.spinner1.adapter = arrayAdapter
        binding.spinner2.adapter = arrayAdapter
        binding.spinner3.adapter = arrayAdapter
        binding.spinner4.adapter = arrayAdapter
        binding.spinner5.adapter = arrayAdapter
        binding.spinner6.adapter = arrayAdapter
        binding.spinner7.adapter = arrayAdapter
        binding.spinner8.adapter = arrayAdapter

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

        binding.spinner7.onItemSelectedListener = object :
            AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View, position: Int, id: Long
            ) {
                intSpinner7 = parent.getItemAtPosition(position).toString().toInt()
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                // write code to perform some action
            }
        }

        binding.spinner8.onItemSelectedListener = object :
            AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View, position: Int, id: Long
            ) {
                intSpinner8 = parent.getItemAtPosition(position).toString().toInt()
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                // write code to perform some action
            }
        }

        binding.btnGen2nos.setOnClickListener(View.OnClickListener {
            sumOfSpinner15 = intSpinner1?.plus(intSpinner5!!)!!
            sumOfSpinner26 = intSpinner2?.plus(intSpinner6!!)!!
            sumOfSpinner37 = intSpinner3?.plus(intSpinner7!!)!!
            sumOfSpinner48 = intSpinner4?.plus(intSpinner8!!)!!

            if (sumOfSpinner15 == 0) sumOfSpinner15 = 7
            if (sumOfSpinner15 == 1) sumOfSpinner15 = 9
            if (sumOfSpinner26 == 0) sumOfSpinner26 = 7
            if (sumOfSpinner26 == 1) sumOfSpinner26 = 9
            if (sumOfSpinner37 == 0) sumOfSpinner37 = 7
            if (sumOfSpinner37 == 1) sumOfSpinner37 = 9
            if (sumOfSpinner48 == 0) sumOfSpinner48 = 7
            if (sumOfSpinner48 == 1) sumOfSpinner48 = 9

            Log.d("RESULT", "sumOfSpinner15 $sumOfSpinner15")
            Log.d("RESULT", "sumOfSpinner26 $sumOfSpinner26")
            Log.d("RESULT", "sumOfSpinner37 $sumOfSpinner37")
            Log.d("RESULT", "sumOfSpinner48 $sumOfSpinner48")
            
            var fourNumberList = ArrayList<FourNumbers>()

            var resultantNum15 : BigInteger = BigInteger("0")
            var resultantNum26 : BigInteger = BigInteger("0")
            var resultantNum37 : BigInteger = BigInteger("0")
            var resultantNum48 : BigInteger = BigInteger("0")

            var resultInBigInteger15 : BigInteger = BigInteger("0")
            var resultInBigInteger26 : BigInteger = BigInteger("0")
            var resultInBigInteger37 : BigInteger = BigInteger("0")
            var resultInBigInteger48 : BigInteger = BigInteger("0")

            if (sumOfSpinner15 in 2..3){
                resultantNum15 = BigInteger(sumOfSpinner15.toString())
                resultInBigInteger15 = resultantNum15.pow(80)
            }else{
                resultantNum15 = BigInteger(sumOfSpinner15.toString())
                resultInBigInteger15 = resultantNum15.pow(40)
            }

            if (sumOfSpinner26 in 2..3){
                resultantNum26 = BigInteger(sumOfSpinner26.toString())
                resultInBigInteger26 = resultantNum26.pow(80)
            }else{
                resultantNum26 = BigInteger(sumOfSpinner26.toString())
                resultInBigInteger26 = resultantNum26.pow(40)
            }

            if (sumOfSpinner37 in 2..3){
                resultantNum37 = BigInteger(sumOfSpinner37.toString())
                resultInBigInteger37 = resultantNum37.pow(80)
            }else{
                resultantNum37 = BigInteger(sumOfSpinner37.toString())
                resultInBigInteger37 = resultantNum37.pow(40)
            }

            if (sumOfSpinner48 in 2..3){
                resultantNum48 = BigInteger(sumOfSpinner48.toString())
                resultInBigInteger48 = resultantNum48.pow(80)
            }else{
                resultantNum48 = BigInteger(sumOfSpinner48.toString())
                resultInBigInteger48 = resultantNum48.pow(40)
            }

            var result15 = "$resultInBigInteger15".toCharArray()
            var result26 = "$resultInBigInteger26".toCharArray()
            var result37  = "$resultInBigInteger37".toCharArray()
            var result48 = "$resultInBigInteger48".toCharArray()

            for (i in 1..2) {
                if (i == 1) {

                    var fourNumbers = FourNumbers(result15[0], result26[0], result37[0], result48[0])
                    fourNumberList.add(fourNumbers)
                }
                if (i == 2) {
                    var fourNumbers = FourNumbers(result15[1], result26[1], result37[1], result48[1])
                    fourNumberList.add(fourNumbers)
                }
            }
            var fourPredictorAdapter: FourPredictorAdapter =
                FourPredictorAdapter(fourNumberList)
            binding.recyclerview4column.adapter = fourPredictorAdapter
        })

        binding.btnGen40nos.setOnClickListener {
            billingClient.startConnection(object : BillingClientStateListener {
                override fun onBillingSetupFinished(billingResult: BillingResult) {
                    if (billingResult.responseCode ==  BillingClient.BillingResponseCode.OK) {
                        val params = SkuDetailsParams.newBuilder()
                        params.setSkusList(skulList)
                            .setType(BillingClient.SkuType.INAPP)

                        billingClient.querySkuDetailsAsync(params.build()){
                                billingResult, skuDetailList ->

                            for (skuDetail in skuDetailList!!){
                                val flowPurchase = BillingFlowParams.newBuilder()
                                    .setSkuDetails(skuDetail)
                                    .build()

                                val responseCode = billingClient.launchBillingFlow(this@FourpredictorActivity, flowPurchase).responseCode
                                if (responseCode == 0){
                                    generate40sRows()
                                }
                            }
                        }
                    }
                }
                override fun onBillingServiceDisconnected() {
                    // Try to restart the connection on the next request to
                    // Google Play by calling the startConnection() method.
                }
            })
        }
    }

    private fun generate40sRows() {
        sumOfSpinner15 = intSpinner1?.plus(intSpinner5!!)!!
        sumOfSpinner26 = intSpinner2?.plus(intSpinner6!!)!!
        sumOfSpinner37 = intSpinner3?.plus(intSpinner7!!)!!
        sumOfSpinner48 = intSpinner4?.plus(intSpinner8!!)!!

        if (sumOfSpinner15 == 0) sumOfSpinner15 = 7
        if (sumOfSpinner15 == 1) sumOfSpinner15 = 9
        if (sumOfSpinner26 == 0) sumOfSpinner26 = 7
        if (sumOfSpinner26 == 1) sumOfSpinner26 = 9
        if (sumOfSpinner37 == 0) sumOfSpinner37 = 7
        if (sumOfSpinner37 == 1) sumOfSpinner37 = 9
        if (sumOfSpinner48 == 0) sumOfSpinner48 = 7
        if (sumOfSpinner48 == 1) sumOfSpinner48 = 9

        Log.d("RESULT", "sumOfSpinner15 $sumOfSpinner15")
        Log.d("RESULT", "sumOfSpinner26 $sumOfSpinner26")
        Log.d("RESULT", "sumOfSpinner37 $sumOfSpinner37")
        Log.d("RESULT", "sumOfSpinner48 $sumOfSpinner48")

        var fourNumberList = ArrayList<FourNumbers>()

        var resultantNum15 : BigInteger = BigInteger("0")
        var resultantNum26 : BigInteger = BigInteger("0")
        var resultantNum37 : BigInteger = BigInteger("0")
        var resultantNum48 : BigInteger = BigInteger("0")

        var resultInBigInteger15 : BigInteger = BigInteger("0")
        var resultInBigInteger26 : BigInteger = BigInteger("0")
        var resultInBigInteger37 : BigInteger = BigInteger("0")
        var resultInBigInteger48 : BigInteger = BigInteger("0")

        if (sumOfSpinner15 in 2..3){
            resultantNum15 = BigInteger(sumOfSpinner15.toString())
            resultInBigInteger15 = resultantNum15.pow(80)
        }else{
            resultantNum15 = BigInteger(sumOfSpinner15.toString())
            resultInBigInteger15 = resultantNum15.pow(40)
        }

        if (sumOfSpinner26 in 2..3){
            resultantNum26 = BigInteger(sumOfSpinner26.toString())
            resultInBigInteger26 = resultantNum26.pow(80)
        }else{
            resultantNum26 = BigInteger(sumOfSpinner26.toString())
            resultInBigInteger26 = resultantNum26.pow(40)
        }

        if (sumOfSpinner37 in 2..3){
            resultantNum37 = BigInteger(sumOfSpinner37.toString())
            resultInBigInteger37 = resultantNum37.pow(80)
        }else{
            resultantNum37 = BigInteger(sumOfSpinner37.toString())
            resultInBigInteger37 = resultantNum37.pow(80)
        }

        if (sumOfSpinner48 in 2..3){
            resultantNum48 = BigInteger(sumOfSpinner48.toString())
            resultInBigInteger48 = resultantNum48.pow(80)
        }else{
            resultantNum48 = BigInteger(sumOfSpinner48.toString())
            resultInBigInteger48 = resultantNum48.pow(40)
        }

        var result15 = "$resultInBigInteger15".toCharArray()
        var result26 = "$resultInBigInteger26".toCharArray()
        var result37  = "$resultInBigInteger37".toCharArray()
        var result48 = "$resultInBigInteger48".toCharArray()

        for (i in 1..40) {
            if (i == 1) {
                var fourNumbers = FourNumbers(result15[0], result26[0], result37[0], result48[0])
                fourNumberList.add(fourNumbers)
            }
            if (i == 2) {

                var fourNumbers = FourNumbers(result15[1], result26[1], result37[1], result48[1])
                fourNumberList.add(fourNumbers)
            }
            if (i == 3) {

                var fourNumbers = FourNumbers(result15[2], result26[2], result37[2], result48[2])
                fourNumberList.add(fourNumbers)
            }
            if (i == 4) {

                var fourNumbers = FourNumbers(result15[3], result26[3], result37[3], result48[3])
                fourNumberList.add(fourNumbers)
            }
            if (i == 5) {

                var fourNumbers = FourNumbers(result15[4], result26[4], result37[4], result48[4])
                fourNumberList.add(fourNumbers)
            }
            if (i == 6) {

                var fourNumbers = FourNumbers(result15[5], result26[5], result37[5], result48[5])
                fourNumberList.add(fourNumbers)
            }
            if (i == 7) {

                var fourNumbers = FourNumbers(result15[6], result26[6], result37[6], result48[6])
                fourNumberList.add(fourNumbers)
            }
            if (i == 8) {
                var fourNumbers = FourNumbers(result15[7], result26[7], result37[7], result48[7])
                fourNumberList.add(fourNumbers)
            }
            if (i == 9) {
                var fourNumbers = FourNumbers(result15[8], result26[8], result37[8], result48[8])
                fourNumberList.add(fourNumbers)
            }
            if (i == 10) {
                var fourNumbers = FourNumbers(result15[9], result26[9], result37[9], result48[9])
                fourNumberList.add(fourNumbers)
            }
            if (i == 11) {
                var fourNumbers = FourNumbers(result15[10], result26[10], result37[10], result48[10])
                fourNumberList.add(fourNumbers)
            }
            if (i == 12) {
                var fourNumbers = FourNumbers(result15[11], result26[11], result37[11], result48[11])
                fourNumberList.add(fourNumbers)
            }
            if (i == 13) {
                var fourNumbers = FourNumbers(result15[12], result26[12], result37[12], result48[12])
                fourNumberList.add(fourNumbers)
            }
            if (i == 14) {
                var fourNumbers = FourNumbers(result15[13], result26[13], result37[13], result48[13])
                fourNumberList.add(fourNumbers)
            }
            if (i == 15) {
                var fourNumbers = FourNumbers(result15[14], result26[14], result37[14], result48[14])
                fourNumberList.add(fourNumbers)
            }
            if (i == 16) {
                var fourNumbers = FourNumbers(result15[15], result26[15], result37[15], result48[15])
                fourNumberList.add(fourNumbers)
            }
            if (i == 17) {
                var fourNumbers = FourNumbers(result15[16], result26[16], result37[16], result48[16])
                fourNumberList.add(fourNumbers)
            }
            if (i == 18) {
                var fourNumbers = FourNumbers(result15[17], result26[17], result37[17], result48[17])
                fourNumberList.add(fourNumbers)
            }
            if (i == 19) {
                var fourNumbers = FourNumbers(result15[18], result26[18], result37[18], result48[18])
                fourNumberList.add(fourNumbers)
            }
            if (i == 20) {
                var fourNumbers = FourNumbers(result15[19], result26[19], result37[19], result48[19])
                fourNumberList.add(fourNumbers)
            }
            if (i == 21) {
                var fourNumbers = FourNumbers(result15[20], result26[20], result37[20], result48[20])
                fourNumberList.add(fourNumbers)
            }
            if (i == 22) {
                var fourNumbers = FourNumbers(result15[21], result26[21], result37[21], result48[21])
                fourNumberList.add(fourNumbers)
            }
            if (i == 23) {
                var fourNumbers = FourNumbers(result15[22], result26[22], result37[22], result48[22])
                fourNumberList.add(fourNumbers)
            }
            if (i == 24) {
                var fourNumbers = FourNumbers(result15[23], result26[23], result37[23], result48[23])
                fourNumberList.add(fourNumbers)
            }
            if (i == 25) {
                var fourNumbers = FourNumbers(result15[24], result26[24], result37[24], result48[24])
                fourNumberList.add(fourNumbers)
            }
            if (i == 26) {
                var fourNumbers = FourNumbers(result15[24], result26[12], result37[0], result48[2])
                fourNumberList.add(fourNumbers)
            }
            if (i == 27) {
                var fourNumbers = FourNumbers(result15[20], result26[24], result37[23], result48[22])
                fourNumberList.add(fourNumbers)
            }
            if (i == 28) {
                var fourNumbers = FourNumbers(result15[21], result26[20], result37[19], result48[18])
                fourNumberList.add(fourNumbers)
            }
            if (i == 29) {
                var fourNumbers = FourNumbers(result15[17], result26[16], result37[15], result48[14])
                fourNumberList.add(fourNumbers)
            }
            if (i == 30) {
                var fourNumbers = FourNumbers(result15[13], result26[12], result37[11], result48[10])
                fourNumberList.add(fourNumbers)
            }
            if (i == 31) {
                var fourNumbers = FourNumbers(result15[9], result26[8], result37[7], result48[6])
                fourNumberList.add(fourNumbers)
            }
            if (i == 32) {
                var fourNumbers = FourNumbers(result15[5], result26[4], result37[3], result48[2])
                fourNumberList.add(fourNumbers)
            }
            if (i == 33) {
                var fourNumbers = FourNumbers(result15[1], result26[2], result37[3], result48[4])
                fourNumberList.add(fourNumbers)
            }
            if (i == 34) {
                var fourNumbers = FourNumbers(result15[5], result26[6], result37[7], result48[8])
                fourNumberList.add(fourNumbers)
            }
            if (i == 35) {
                var fourNumbers = FourNumbers(result15[9], result26[10], result37[11], result48[12])
                fourNumberList.add(fourNumbers)
            }
            if (i == 36) {
                var fourNumbers = FourNumbers(result15[13], result26[14], result37[15], result48[16])
                fourNumberList.add(fourNumbers)
            }
            if (i == 37) {
                var fourNumbers = FourNumbers(result15[17], result26[18], result37[19], result48[20])
                fourNumberList.add(fourNumbers)
            }
            if (i == 38) {
                var fourNumbers = FourNumbers(result15[21], result26[22], result37[23], result48[24])
                fourNumberList.add(fourNumbers)
            }
            if (i == 39) {
                var fourNumbers = FourNumbers(result15[5], result26[7], result37[9], result48[11])
                fourNumberList.add(fourNumbers)
            }
            if (i == 40) {
                var fourNumbers = FourNumbers(result15[13], result26[15], result37[17], result48[19])
                fourNumberList.add(fourNumbers)
            }
        }
        var fourPredictorAdapter: FourPredictorAdapter = FourPredictorAdapter(fourNumberList)
        binding.recyclerview4column.adapter = fourPredictorAdapter
    }
}