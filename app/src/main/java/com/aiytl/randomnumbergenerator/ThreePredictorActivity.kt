package com.aiytl.randomnumbergenerator

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.LinearLayout
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.aiytl.randomnumbergenerator.R
import com.aiytl.randomnumbergenerator.addapter.ThreePredictorAdapter
import com.aiytl.randomnumbergenerator.databinding.ActivityThreePredictorBinding
import com.aiytl.randomnumbergenerator.model.ThreeNumbers
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.MobileAds
import java.util.ArrayList

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
    private var sumOfSpinner14: Int = 0
    private var sumOfSpinner25: Int = 0
    private var sumOfSpinner36: Int = 0


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

        binding.btnGen2nos.setOnClickListener {
            sumOfSpinner14 = intSpinner1?.plus(intSpinner4!!)!!
            sumOfSpinner25 = intSpinner2?.plus(intSpinner5!!)!!
            sumOfSpinner36 = intSpinner3?.plus(intSpinner6!!)!!

            Log.d("SUM", "$sumOfSpinner14 $sumOfSpinner25 $sumOfSpinner36")
            var threeNumberList = ArrayList<ThreeNumbers>()
            for (i in 1..2) {
                if (i == 1) {
                    var cube14 = sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14
                    var cube25 = sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25
                    var cube36 = sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36

                    val sumOfCube14 = getSumOfDigits(cube14)
                    val sumOfCube25 = getSumOfDigits(cube25)
                    val sumOfCube36 = getSumOfDigits(cube36)

                    var cubeResult14: String? = null
                    var cubeResult25: String? = null
                    var cubeResult36: String? = null


                    if (countDigits(sumOfCube14.toString()) in 1..5) {
                        var strArray = convertStringToArray(sumOfCube14.toString())
                        Log.d("Result", "$strArray")
                        if (strArray.size == 1) cubeResult14 = strArray[0]
                        if (strArray.size == 2) cubeResult14 = strArray[1]
                        if (strArray.size == 3) cubeResult14 = strArray[2]
                        if (strArray.size == 4) cubeResult14 = strArray[3]
                        if (strArray.size == 5) cubeResult14 = strArray[4]

                    } else if (countDigits(sumOfCube14.toString()) > 5) {
                        var strArray = convertStringToArray(sumOfCube14.toString())
                        cubeResult14 = strArray[5]
                    }

                    if (countDigits(sumOfCube25.toString()) in 1..5) {
                        var strArray = convertStringToArray(sumOfCube25.toString())
                        Log.d("Result", "$strArray")
                        if (strArray.size == 1) cubeResult25 = strArray[0]
                        if (strArray.size == 2) cubeResult25 = strArray[1]
                        if (strArray.size == 3) cubeResult25 = strArray[2]
                        if (strArray.size == 4) cubeResult25 = strArray[3]
                        if (strArray.size == 5) cubeResult25 = strArray[4]

                    } else if (countDigits(sumOfCube25.toString()) > 5) {
                        var strArray = convertStringToArray(sumOfCube14.toString())
                        cubeResult25 = strArray[5]
                    }

                    if (countDigits(sumOfCube36.toString()) in 1..5) {
                        var strArray = convertStringToArray(sumOfCube36.toString())
                        Log.d("Result", "$strArray")
                        if (strArray.size == 1) cubeResult36 = strArray[0]
                        if (strArray.size == 2) cubeResult36 = strArray[1]
                        if (strArray.size == 3) cubeResult36 = strArray[2]
                        if (strArray.size == 4) cubeResult36 = strArray[3]
                        if (strArray.size == 5) cubeResult36 = strArray[4]

                    } else if (countDigits(sumOfCube36.toString()) > 5) {
                        var strArray = convertStringToArray(sumOfCube14.toString())
                        cubeResult36 = strArray[5]
                    }


                    var threeNumbers = ThreeNumbers(
                        cubeResult14!!.toInt(),
                        cubeResult25!!.toInt(),
                        cubeResult36!!.toInt()
                    )
                    threeNumberList.add(threeNumbers)
                    Log.d("SUM", "$cube14 $cube25 $cube36")
                }
                if (i == 2) {
                    var four14 = sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14
                    var four25 = sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25
                    var four36 = sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36

                    val sumOfFour14 = getSumOfDigits(four14)
                    val sumOfFour25 = getSumOfDigits(four25)
                    val sumOfFour36 = getSumOfDigits(four36)

                    var fourResult14: String? = null
                    var fourResult25: String? = null
                    var fourResult36: String? = null

                    if (countDigits(sumOfFour14.toString()) in 1..5) {
                        var strArray = convertStringToArray(sumOfFour14.toString())
                        Log.d("Result", "$strArray")
                        if (strArray.size == 1) fourResult14 = strArray[0]
                        if (strArray.size == 2) fourResult14 = strArray[1]
                        if (strArray.size == 3) fourResult14 = strArray[2]
                        if (strArray.size == 4) fourResult14 = strArray[3]
                        if (strArray.size == 5) fourResult14 = strArray[4]

                    } else if (countDigits(sumOfFour14.toString()) > 5) {
                        var strArray = convertStringToArray(sumOfFour14.toString())
                        fourResult14 = strArray[5]
                    }

                    if (countDigits(sumOfFour25.toString()) in 1..5) {
                        var strArray = convertStringToArray(sumOfFour25.toString())
                        Log.d("Result", "$strArray")
                        if (strArray.size == 1) fourResult25 = strArray[0]
                        if (strArray.size == 2) fourResult25 = strArray[1]
                        if (strArray.size == 3) fourResult25 = strArray[2]
                        if (strArray.size == 4) fourResult25 = strArray[3]
                        if (strArray.size == 5) fourResult25 = strArray[4]

                    } else if (countDigits(sumOfFour25.toString()) > 5) {
                        var strArray = convertStringToArray(sumOfFour25.toString())
                        fourResult25 = strArray[5]
                    }

                    if (countDigits(sumOfFour36.toString()) in 1..5) {
                        var strArray = convertStringToArray(sumOfFour36.toString())
                        Log.d("Result", "$strArray")
                        if (strArray.size == 1) fourResult36 = strArray[0]
                        if (strArray.size == 2) fourResult36 = strArray[1]
                        if (strArray.size == 3) fourResult36 = strArray[2]
                        if (strArray.size == 4) fourResult36 = strArray[3]
                        if (strArray.size == 5) fourResult36 = strArray[4]

                    } else if (countDigits(sumOfFour36.toString()) > 5) {
                        var strArray = convertStringToArray(sumOfFour36.toString())
                        fourResult36 = strArray[5]
                    }

                    var threeNumbers = ThreeNumbers(
                        fourResult14!!.toInt(),
                        fourResult25!!.toInt(),
                        fourResult36!!.toInt()
                    )
                    threeNumberList.add(threeNumbers)
                    Log.d("SUM", "$four14 $four25 $four36")
                }
            }
            var threePredictorAdapter: ThreePredictorAdapter =
                ThreePredictorAdapter(threeNumberList)
            binding.recyclerview3column.adapter = threePredictorAdapter
        }

        binding.btnGen40nos.setOnClickListener {
            sumOfSpinner14 = intSpinner1?.plus(intSpinner4!!)!!
            sumOfSpinner25 = intSpinner2?.plus(intSpinner5!!)!!
            sumOfSpinner36 = intSpinner3?.plus(intSpinner6!!)!!

            Log.d("SUM", "$sumOfSpinner14 $sumOfSpinner25 $sumOfSpinner36")
            var threeNumberList = ArrayList<ThreeNumbers>()
            for (i in 1..40) {
                if (i == 1) {
                    var cube14 = sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14
                    var cube25 = sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25
                    var cube36 = sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36

                    val sumOfCube14 = getSumOfDigits(cube14)
                    val sumOfCube25 = getSumOfDigits(cube25)
                    val sumOfCube36 = getSumOfDigits(cube36)

                    var cubeResult14: String? = null
                    var cubeResult25: String? = null
                    var cubeResult36: String? = null


                    if (countDigits(sumOfCube14.toString()) in 1..5) {
                        var strArray = convertStringToArray(sumOfCube14.toString())
                        Log.d("Result", "$strArray")
                        if (strArray.size == 1) cubeResult14 = strArray[0]
                        if (strArray.size == 2) cubeResult14 = strArray[1]
                        if (strArray.size == 3) cubeResult14 = strArray[2]
                        if (strArray.size == 4) cubeResult14 = strArray[3]
                        if (strArray.size == 5) cubeResult14 = strArray[4]

                    } else if (countDigits(sumOfCube14.toString()) > 5) {
                        var strArray = convertStringToArray(sumOfCube14.toString())
                        cubeResult14 = strArray[5]
                    }

                    if (countDigits(sumOfCube25.toString()) in 1..5) {
                        var strArray = convertStringToArray(sumOfCube25.toString())
                        Log.d("Result", "$strArray")
                        if (strArray.size == 1) cubeResult25 = strArray[0]
                        if (strArray.size == 2) cubeResult25 = strArray[1]
                        if (strArray.size == 3) cubeResult25 = strArray[2]
                        if (strArray.size == 4) cubeResult25 = strArray[3]
                        if (strArray.size == 5) cubeResult25 = strArray[4]

                    } else if (countDigits(sumOfCube25.toString()) > 5) {
                        var strArray = convertStringToArray(sumOfCube14.toString())
                        cubeResult25 = strArray[5]
                    }

                    if (countDigits(sumOfCube36.toString()) in 1..5) {
                        var strArray = convertStringToArray(sumOfCube36.toString())
                        Log.d("Result", "$strArray")
                        if (strArray.size == 1) cubeResult36 = strArray[0]
                        if (strArray.size == 2) cubeResult36 = strArray[1]
                        if (strArray.size == 3) cubeResult36 = strArray[2]
                        if (strArray.size == 4) cubeResult36 = strArray[3]
                        if (strArray.size == 5) cubeResult36 = strArray[4]

                    } else if (countDigits(sumOfCube36.toString()) > 5) {
                        var strArray = convertStringToArray(sumOfCube14.toString())
                        cubeResult36 = strArray[5]
                    }


                    var threeNumbers = ThreeNumbers(
                        cubeResult14!!.toInt(),
                        cubeResult25!!.toInt(),
                        cubeResult36!!.toInt()
                    )
                    threeNumberList.add(threeNumbers)
                    Log.d("SUM", "$cube14 $cube25 $cube36")
                }
                if (i == 2) {
                    var four14 = sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14
                    var four25 = sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25
                    var four36 = sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36

                    val sumOfFour14 = getSumOfDigits(four14)
                    val sumOfFour25 = getSumOfDigits(four25)
                    val sumOfFour36 = getSumOfDigits(four36)

                    var fourResult14: String? = null
                    var fourResult25: String? = null
                    var fourResult36: String? = null

                    if (countDigits(sumOfFour14.toString()) in 1..5) {
                        var strArray = convertStringToArray(sumOfFour14.toString())
                        Log.d("Result", "$strArray")
                        if (strArray.size == 1) fourResult14 = strArray[0]
                        if (strArray.size == 2) fourResult14 = strArray[1]
                        if (strArray.size == 3) fourResult14 = strArray[2]
                        if (strArray.size == 4) fourResult14 = strArray[3]
                        if (strArray.size == 5) fourResult14 = strArray[4]

                    } else if (countDigits(sumOfFour14.toString()) > 5) {
                        var strArray = convertStringToArray(sumOfFour14.toString())
                        fourResult14 = strArray[5]
                    }

                    if (countDigits(sumOfFour25.toString()) in 1..5) {
                        var strArray = convertStringToArray(sumOfFour25.toString())
                        Log.d("Result", "$strArray")
                        if (strArray.size == 1) fourResult25 = strArray[0]
                        if (strArray.size == 2) fourResult25 = strArray[1]
                        if (strArray.size == 3) fourResult25 = strArray[2]
                        if (strArray.size == 4) fourResult25 = strArray[3]
                        if (strArray.size == 5) fourResult25 = strArray[4]

                    } else if (countDigits(sumOfFour25.toString()) > 5) {
                        var strArray = convertStringToArray(sumOfFour25.toString())
                        fourResult25 = strArray[5]
                    }

                    if (countDigits(sumOfFour36.toString()) in 1..5) {
                        var strArray = convertStringToArray(sumOfFour36.toString())
                        Log.d("Result", "$strArray")
                        if (strArray.size == 1) fourResult36 = strArray[0]
                        if (strArray.size == 2) fourResult36 = strArray[1]
                        if (strArray.size == 3) fourResult36 = strArray[2]
                        if (strArray.size == 4) fourResult36 = strArray[3]
                        if (strArray.size == 5) fourResult36 = strArray[4]

                    } else if (countDigits(sumOfFour36.toString()) > 5) {
                        var strArray = convertStringToArray(sumOfFour36.toString())
                        fourResult36 = strArray[5]
                    }

                    var threeNumbers = ThreeNumbers(
                        fourResult14!!.toInt(),
                        fourResult25!!.toInt(),
                        fourResult36!!.toInt()
                    )
                    threeNumberList.add(threeNumbers)
                    Log.d("SUM", "$four14 $four25 $four36")
                }
                if (i == 3) {
                    var six14 = sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14
                    var six25 = sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25
                    var six36 = sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36

                    val sumOfFour14 = getSumOfDigits(six14)
                    val sumOfFour25 = getSumOfDigits(six25)
                    val sumOfFour36 = getSumOfDigits(six36)

                    var fourResult14: String? = null
                    var fourResult25: String? = null
                    var fourResult36: String? = null

                    if (countDigits(sumOfFour14.toString()) in 1..5) {
                        var strArray = convertStringToArray(sumOfFour14.toString())
                        Log.d("Result", "$strArray")
                        if (strArray.size == 1) fourResult14 = strArray[0]
                        if (strArray.size == 2) fourResult14 = strArray[1]
                        if (strArray.size == 3) fourResult14 = strArray[2]
                        if (strArray.size == 4) fourResult14 = strArray[3]
                        if (strArray.size == 5) fourResult14 = strArray[4]

                    } else if (countDigits(sumOfFour14.toString()) > 5) {
                        var strArray = convertStringToArray(sumOfFour14.toString())
                        fourResult14 = strArray[5]
                    }

                    if (countDigits(sumOfFour25.toString()) in 1..5) {
                        var strArray = convertStringToArray(sumOfFour25.toString())
                        Log.d("Result", "$strArray")
                        if (strArray.size == 1) fourResult25 = strArray[0]
                        if (strArray.size == 2) fourResult25 = strArray[1]
                        if (strArray.size == 3) fourResult25 = strArray[2]
                        if (strArray.size == 4) fourResult25 = strArray[3]
                        if (strArray.size == 5) fourResult25 = strArray[4]

                    } else if (countDigits(sumOfFour25.toString()) > 5) {
                        var strArray = convertStringToArray(sumOfFour25.toString())
                        fourResult25 = strArray[5]
                    }

                    if (countDigits(sumOfFour36.toString()) in 1..5) {
                        var strArray = convertStringToArray(sumOfFour36.toString())
                        Log.d("Result", "$strArray")
                        if (strArray.size == 1) fourResult36 = strArray[0]
                        if (strArray.size == 2) fourResult36 = strArray[1]
                        if (strArray.size == 3) fourResult36 = strArray[2]
                        if (strArray.size == 4) fourResult36 = strArray[3]
                        if (strArray.size == 5) fourResult36 = strArray[4]

                    } else if (countDigits(sumOfFour36.toString()) > 5) {
                        var strArray = convertStringToArray(sumOfFour36.toString())
                        fourResult36 = strArray[5]
                    }

                    var threeNumbers = ThreeNumbers(
                        fourResult14!!.toInt(),
                        fourResult25!!.toInt(),
                        fourResult36!!.toInt()
                    )
                    threeNumberList.add(threeNumbers)
                }
                if (i == 4) {
                    var seven14 = sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14
                    var seven25 = sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25
                    var seven36 = sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36

                    val sumOfFour14 = getSumOfDigits(seven14)
                    val sumOfFour25 = getSumOfDigits(seven25)
                    val sumOfFour36 = getSumOfDigits(seven36)

                    var fourResult14: String? = null
                    var fourResult25: String? = null
                    var fourResult36: String? = null

                    if (countDigits(sumOfFour14.toString()) in 1..5) {
                        var strArray = convertStringToArray(sumOfFour14.toString())
                        Log.d("Result", "$strArray")
                        if (strArray.size == 1) fourResult14 = strArray[0]
                        if (strArray.size == 2) fourResult14 = strArray[1]
                        if (strArray.size == 3) fourResult14 = strArray[2]
                        if (strArray.size == 4) fourResult14 = strArray[3]
                        if (strArray.size == 5) fourResult14 = strArray[4]

                    } else if (countDigits(sumOfFour14.toString()) > 5) {
                        var strArray = convertStringToArray(sumOfFour14.toString())
                        fourResult14 = strArray[5]
                    }

                    if (countDigits(sumOfFour25.toString()) in 1..5) {
                        var strArray = convertStringToArray(sumOfFour25.toString())
                        Log.d("Result", "$strArray")
                        if (strArray.size == 1) fourResult25 = strArray[0]
                        if (strArray.size == 2) fourResult25 = strArray[1]
                        if (strArray.size == 3) fourResult25 = strArray[2]
                        if (strArray.size == 4) fourResult25 = strArray[3]
                        if (strArray.size == 5) fourResult25 = strArray[4]

                    } else if (countDigits(sumOfFour25.toString()) > 5) {
                        var strArray = convertStringToArray(sumOfFour25.toString())
                        fourResult25 = strArray[5]
                    }

                    if (countDigits(sumOfFour36.toString()) in 1..5) {
                        var strArray = convertStringToArray(sumOfFour36.toString())
                        Log.d("Result", "$strArray")
                        if (strArray.size == 1) fourResult36 = strArray[0]
                        if (strArray.size == 2) fourResult36 = strArray[1]
                        if (strArray.size == 3) fourResult36 = strArray[2]
                        if (strArray.size == 4) fourResult36 = strArray[3]
                        if (strArray.size == 5) fourResult36 = strArray[4]

                    } else if (countDigits(sumOfFour36.toString()) > 5) {
                        var strArray = convertStringToArray(sumOfFour36.toString())
                        fourResult36 = strArray[5]
                    }

                    var threeNumbers = ThreeNumbers(
                        fourResult14!!.toInt(),
                        fourResult25!!.toInt(),
                        fourResult36!!.toInt()
                    )
                    threeNumberList.add(threeNumbers)
                }
                if (i == 5) {
                    var seven14 = sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14
                    var seven25 = sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25
                    var seven36 = sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36

                    val sumOfFour14 = getSumOfDigits(seven14)
                    val sumOfFour25 = getSumOfDigits(seven25)
                    val sumOfFour36 = getSumOfDigits(seven36)

                    var fourResult14: String? = null
                    var fourResult25: String? = null
                    var fourResult36: String? = null

                    if (countDigits(sumOfFour14.toString()) in 1..5) {
                        var strArray = convertStringToArray(sumOfFour14.toString())
                        Log.d("Result", "$strArray")
                        if (strArray.size == 1) fourResult14 = strArray[0]
                        if (strArray.size == 2) fourResult14 = strArray[1]
                        if (strArray.size == 3) fourResult14 = strArray[2]
                        if (strArray.size == 4) fourResult14 = strArray[3]
                        if (strArray.size == 5) fourResult14 = strArray[4]

                    } else if (countDigits(sumOfFour14.toString()) > 5) {
                        var strArray = convertStringToArray(sumOfFour14.toString())
                        fourResult14 = strArray[5]
                    }

                    if (countDigits(sumOfFour25.toString()) in 1..5) {
                        var strArray = convertStringToArray(sumOfFour25.toString())
                        Log.d("Result", "$strArray")
                        if (strArray.size == 1) fourResult25 = strArray[0]
                        if (strArray.size == 2) fourResult25 = strArray[1]
                        if (strArray.size == 3) fourResult25 = strArray[2]
                        if (strArray.size == 4) fourResult25 = strArray[3]
                        if (strArray.size == 5) fourResult25 = strArray[4]

                    } else if (countDigits(sumOfFour25.toString()) > 5) {
                        var strArray = convertStringToArray(sumOfFour25.toString())
                        fourResult25 = strArray[5]
                    }

                    if (countDigits(sumOfFour36.toString()) in 1..5) {
                        var strArray = convertStringToArray(sumOfFour36.toString())
                        Log.d("Result", "$strArray")
                        if (strArray.size == 1) fourResult36 = strArray[0]
                        if (strArray.size == 2) fourResult36 = strArray[1]
                        if (strArray.size == 3) fourResult36 = strArray[2]
                        if (strArray.size == 4) fourResult36 = strArray[3]
                        if (strArray.size == 5) fourResult36 = strArray[4]

                    } else if (countDigits(sumOfFour36.toString()) > 5) {
                        var strArray = convertStringToArray(sumOfFour36.toString())
                        fourResult36 = strArray[5]
                    }

                    var threeNumbers = ThreeNumbers(
                        fourResult14!!.toInt(),
                        fourResult25!!.toInt(),
                        fourResult36!!.toInt()
                    )
                    threeNumberList.add(threeNumbers)
                }
                if (i == 6) {
                    var seven14 = sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14
                    var seven25 = sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25
                    var seven36 = sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36

                    val sumOfFour14 = getSumOfDigits(seven14)
                    val sumOfFour25 = getSumOfDigits(seven25)
                    val sumOfFour36 = getSumOfDigits(seven36)

                    var fourResult14: String? = null
                    var fourResult25: String? = null
                    var fourResult36: String? = null

                    if (countDigits(sumOfFour14.toString()) in 1..5) {
                        var strArray = convertStringToArray(sumOfFour14.toString())
                        Log.d("Result", "$strArray")
                        if (strArray.size == 1) fourResult14 = strArray[0]
                        if (strArray.size == 2) fourResult14 = strArray[1]
                        if (strArray.size == 3) fourResult14 = strArray[2]
                        if (strArray.size == 4) fourResult14 = strArray[3]
                        if (strArray.size == 5) fourResult14 = strArray[4]

                    } else if (countDigits(sumOfFour14.toString()) > 5) {
                        var strArray = convertStringToArray(sumOfFour14.toString())
                        fourResult14 = strArray[5]
                    }

                    if (countDigits(sumOfFour25.toString()) in 1..5) {
                        var strArray = convertStringToArray(sumOfFour25.toString())
                        Log.d("Result", "$strArray")
                        if (strArray.size == 1) fourResult25 = strArray[0]
                        if (strArray.size == 2) fourResult25 = strArray[1]
                        if (strArray.size == 3) fourResult25 = strArray[2]
                        if (strArray.size == 4) fourResult25 = strArray[3]
                        if (strArray.size == 5) fourResult25 = strArray[4]

                    } else if (countDigits(sumOfFour25.toString()) > 5) {
                        var strArray = convertStringToArray(sumOfFour25.toString())
                        fourResult25 = strArray[5]
                    }

                    if (countDigits(sumOfFour36.toString()) in 1..5) {
                        var strArray = convertStringToArray(sumOfFour36.toString())
                        Log.d("Result", "$strArray")
                        if (strArray.size == 1) fourResult36 = strArray[0]
                        if (strArray.size == 2) fourResult36 = strArray[1]
                        if (strArray.size == 3) fourResult36 = strArray[2]
                        if (strArray.size == 4) fourResult36 = strArray[3]
                        if (strArray.size == 5) fourResult36 = strArray[4]

                    } else if (countDigits(sumOfFour36.toString()) > 5) {
                        var strArray = convertStringToArray(sumOfFour36.toString())
                        fourResult36 = strArray[5]
                    }

                    var threeNumbers = ThreeNumbers(
                        fourResult14!!.toInt(),
                        fourResult25!!.toInt(),
                        fourResult36!!.toInt()
                    )
                    threeNumberList.add(threeNumbers)
                }
                if (i == 7) {
                    var seven14 = sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14
                    var seven25 = sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25
                    var seven36 = sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36

                    val sumOfFour14 = getSumOfDigits(seven14)
                    val sumOfFour25 = getSumOfDigits(seven25)
                    val sumOfFour36 = getSumOfDigits(seven36)

                    var fourResult14: String? = null
                    var fourResult25: String? = null
                    var fourResult36: String? = null

                    if (countDigits(sumOfFour14.toString()) in 1..5) {
                        var strArray = convertStringToArray(sumOfFour14.toString())
                        Log.d("Result", "$strArray")
                        if (strArray.size == 1) fourResult14 = strArray[0]
                        if (strArray.size == 2) fourResult14 = strArray[1]
                        if (strArray.size == 3) fourResult14 = strArray[2]
                        if (strArray.size == 4) fourResult14 = strArray[3]
                        if (strArray.size == 5) fourResult14 = strArray[4]

                    } else if (countDigits(sumOfFour14.toString()) > 5) {
                        var strArray = convertStringToArray(sumOfFour14.toString())
                        fourResult14 = strArray[5]
                    }

                    if (countDigits(sumOfFour25.toString()) in 1..5) {
                        var strArray = convertStringToArray(sumOfFour25.toString())
                        Log.d("Result", "$strArray")
                        if (strArray.size == 1) fourResult25 = strArray[0]
                        if (strArray.size == 2) fourResult25 = strArray[1]
                        if (strArray.size == 3) fourResult25 = strArray[2]
                        if (strArray.size == 4) fourResult25 = strArray[3]
                        if (strArray.size == 5) fourResult25 = strArray[4]

                    } else if (countDigits(sumOfFour25.toString()) > 5) {
                        var strArray = convertStringToArray(sumOfFour25.toString())
                        fourResult25 = strArray[5]
                    }

                    if (countDigits(sumOfFour36.toString()) in 1..5) {
                        var strArray = convertStringToArray(sumOfFour36.toString())
                        Log.d("Result", "$strArray")
                        if (strArray.size == 1) fourResult36 = strArray[0]
                        if (strArray.size == 2) fourResult36 = strArray[1]
                        if (strArray.size == 3) fourResult36 = strArray[2]
                        if (strArray.size == 4) fourResult36 = strArray[3]
                        if (strArray.size == 5) fourResult36 = strArray[4]

                    } else if (countDigits(sumOfFour36.toString()) > 5) {
                        var strArray = convertStringToArray(sumOfFour36.toString())
                        fourResult36 = strArray[5]
                    }

                    var threeNumbers = ThreeNumbers(
                        fourResult14!!.toInt(),
                        fourResult25!!.toInt(),
                        fourResult36!!.toInt()
                    )
                    threeNumberList.add(threeNumbers)
                }
                if (i == 8) {
                    var seven14 = sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14
                    var seven25 = sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25
                    var seven36 = sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36

                    val sumOfFour14 = getSumOfDigits(seven14)
                    val sumOfFour25 = getSumOfDigits(seven25)
                    val sumOfFour36 = getSumOfDigits(seven36)

                    var fourResult14: String? = null
                    var fourResult25: String? = null
                    var fourResult36: String? = null

                    if (countDigits(sumOfFour14.toString()) in 1..5) {
                        var strArray = convertStringToArray(sumOfFour14.toString())
                        Log.d("Result", "$strArray")
                        if (strArray.size == 1) fourResult14 = strArray[0]
                        if (strArray.size == 2) fourResult14 = strArray[1]
                        if (strArray.size == 3) fourResult14 = strArray[2]
                        if (strArray.size == 4) fourResult14 = strArray[3]
                        if (strArray.size == 5) fourResult14 = strArray[4]

                    } else if (countDigits(sumOfFour14.toString()) > 5) {
                        var strArray = convertStringToArray(sumOfFour14.toString())
                        fourResult14 = strArray[5]
                    }

                    if (countDigits(sumOfFour25.toString()) in 1..5) {
                        var strArray = convertStringToArray(sumOfFour25.toString())
                        Log.d("Result", "$strArray")
                        if (strArray.size == 1) fourResult25 = strArray[0]
                        if (strArray.size == 2) fourResult25 = strArray[1]
                        if (strArray.size == 3) fourResult25 = strArray[2]
                        if (strArray.size == 4) fourResult25 = strArray[3]
                        if (strArray.size == 5) fourResult25 = strArray[4]

                    } else if (countDigits(sumOfFour25.toString()) > 5) {
                        var strArray = convertStringToArray(sumOfFour25.toString())
                        fourResult25 = strArray[5]
                    }

                    if (countDigits(sumOfFour36.toString()) in 1..5) {
                        var strArray = convertStringToArray(sumOfFour36.toString())
                        Log.d("Result", "$strArray")
                        if (strArray.size == 1) fourResult36 = strArray[0]
                        if (strArray.size == 2) fourResult36 = strArray[1]
                        if (strArray.size == 3) fourResult36 = strArray[2]
                        if (strArray.size == 4) fourResult36 = strArray[3]
                        if (strArray.size == 5) fourResult36 = strArray[4]

                    } else if (countDigits(sumOfFour36.toString()) > 5) {
                        var strArray = convertStringToArray(sumOfFour36.toString())
                        fourResult36 = strArray[5]
                    }

                    var threeNumbers = ThreeNumbers(
                        fourResult14!!.toInt(),
                        fourResult25!!.toInt(),
                        fourResult36!!.toInt()
                    )
                    threeNumberList.add(threeNumbers)
                }
                if (i == 9) {
                    var seven14 = sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14
                    var seven25 = sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25
                    var seven36 = sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36

                    val sumOfFour14 = getSumOfDigits(seven14)
                    val sumOfFour25 = getSumOfDigits(seven25)
                    val sumOfFour36 = getSumOfDigits(seven36)

                    var fourResult14: String? = null
                    var fourResult25: String? = null
                    var fourResult36: String? = null

                    if (countDigits(sumOfFour14.toString()) in 1..5) {
                        var strArray = convertStringToArray(sumOfFour14.toString())
                        Log.d("Result", "$strArray")
                        if (strArray.size == 1) fourResult14 = strArray[0]
                        if (strArray.size == 2) fourResult14 = strArray[1]
                        if (strArray.size == 3) fourResult14 = strArray[2]
                        if (strArray.size == 4) fourResult14 = strArray[3]
                        if (strArray.size == 5) fourResult14 = strArray[4]

                    } else if (countDigits(sumOfFour14.toString()) > 5) {
                        var strArray = convertStringToArray(sumOfFour14.toString())
                        fourResult14 = strArray[5]
                    }

                    if (countDigits(sumOfFour25.toString()) in 1..5) {
                        var strArray = convertStringToArray(sumOfFour25.toString())
                        Log.d("Result", "$strArray")
                        if (strArray.size == 1) fourResult25 = strArray[0]
                        if (strArray.size == 2) fourResult25 = strArray[1]
                        if (strArray.size == 3) fourResult25 = strArray[2]
                        if (strArray.size == 4) fourResult25 = strArray[3]
                        if (strArray.size == 5) fourResult25 = strArray[4]

                    } else if (countDigits(sumOfFour25.toString()) > 5) {
                        var strArray = convertStringToArray(sumOfFour25.toString())
                        fourResult25 = strArray[5]
                    }

                    if (countDigits(sumOfFour36.toString()) in 1..5) {
                        var strArray = convertStringToArray(sumOfFour36.toString())
                        Log.d("Result", "$strArray")
                        if (strArray.size == 1) fourResult36 = strArray[0]
                        if (strArray.size == 2) fourResult36 = strArray[1]
                        if (strArray.size == 3) fourResult36 = strArray[2]
                        if (strArray.size == 4) fourResult36 = strArray[3]
                        if (strArray.size == 5) fourResult36 = strArray[4]

                    } else if (countDigits(sumOfFour36.toString()) > 5) {
                        var strArray = convertStringToArray(sumOfFour36.toString())
                        fourResult36 = strArray[5]
                    }

                    var threeNumbers = ThreeNumbers(
                        fourResult14!!.toInt(),
                        fourResult25!!.toInt(),
                        fourResult36!!.toInt()
                    )
                    threeNumberList.add(threeNumbers)
                }
                if (i == 10) {
                    var seven14 = sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14
                    var seven25 = sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25
                    var seven36 = sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36

                    val sumOfFour14 = getSumOfDigits(seven14)
                    val sumOfFour25 = getSumOfDigits(seven25)
                    val sumOfFour36 = getSumOfDigits(seven36)

                    var fourResult14: String? = null
                    var fourResult25: String? = null
                    var fourResult36: String? = null

                    if (countDigits(sumOfFour14.toString()) in 1..5) {
                        var strArray = convertStringToArray(sumOfFour14.toString())
                        Log.d("Result", "$strArray")
                        if (strArray.size == 1) fourResult14 = strArray[0]
                        if (strArray.size == 2) fourResult14 = strArray[1]
                        if (strArray.size == 3) fourResult14 = strArray[2]
                        if (strArray.size == 4) fourResult14 = strArray[3]
                        if (strArray.size == 5) fourResult14 = strArray[4]

                    } else if (countDigits(sumOfFour14.toString()) > 5) {
                        var strArray = convertStringToArray(sumOfFour14.toString())
                        fourResult14 = strArray[5]
                    }

                    if (countDigits(sumOfFour25.toString()) in 1..5) {
                        var strArray = convertStringToArray(sumOfFour25.toString())
                        Log.d("Result", "$strArray")
                        if (strArray.size == 1) fourResult25 = strArray[0]
                        if (strArray.size == 2) fourResult25 = strArray[1]
                        if (strArray.size == 3) fourResult25 = strArray[2]
                        if (strArray.size == 4) fourResult25 = strArray[3]
                        if (strArray.size == 5) fourResult25 = strArray[4]

                    } else if (countDigits(sumOfFour25.toString()) > 5) {
                        var strArray = convertStringToArray(sumOfFour25.toString())
                        fourResult25 = strArray[5]
                    }

                    if (countDigits(sumOfFour36.toString()) in 1..5) {
                        var strArray = convertStringToArray(sumOfFour36.toString())
                        Log.d("Result", "$strArray")
                        if (strArray.size == 1) fourResult36 = strArray[0]
                        if (strArray.size == 2) fourResult36 = strArray[1]
                        if (strArray.size == 3) fourResult36 = strArray[2]
                        if (strArray.size == 4) fourResult36 = strArray[3]
                        if (strArray.size == 5) fourResult36 = strArray[4]

                    } else if (countDigits(sumOfFour36.toString()) > 5) {
                        var strArray = convertStringToArray(sumOfFour36.toString())
                        fourResult36 = strArray[5]
                    }

                    var threeNumbers = ThreeNumbers(
                        fourResult14!!.toInt(),
                        fourResult25!!.toInt(),
                        fourResult36!!.toInt()
                    )
                    threeNumberList.add(threeNumbers)
                }
                if (i == 11) {
                    var seven14 = sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14
                    var seven25 = sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25
                    var seven36 = sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36

                    val sumOfFour14 = getSumOfDigits(seven14)
                    val sumOfFour25 = getSumOfDigits(seven25)
                    val sumOfFour36 = getSumOfDigits(seven36)

                    var fourResult14: String? = null
                    var fourResult25: String? = null
                    var fourResult36: String? = null

                    if (countDigits(sumOfFour14.toString()) in 1..5) {
                        var strArray = convertStringToArray(sumOfFour14.toString())
                        Log.d("Result", "$strArray")
                        if (strArray.size == 1) fourResult14 = strArray[0]
                        if (strArray.size == 2) fourResult14 = strArray[1]
                        if (strArray.size == 3) fourResult14 = strArray[2]
                        if (strArray.size == 4) fourResult14 = strArray[3]
                        if (strArray.size == 5) fourResult14 = strArray[4]

                    } else if (countDigits(sumOfFour14.toString()) > 5) {
                        var strArray = convertStringToArray(sumOfFour14.toString())
                        fourResult14 = strArray[5]
                    }

                    if (countDigits(sumOfFour25.toString()) in 1..5) {
                        var strArray = convertStringToArray(sumOfFour25.toString())
                        Log.d("Result", "$strArray")
                        if (strArray.size == 1) fourResult25 = strArray[0]
                        if (strArray.size == 2) fourResult25 = strArray[1]
                        if (strArray.size == 3) fourResult25 = strArray[2]
                        if (strArray.size == 4) fourResult25 = strArray[3]
                        if (strArray.size == 5) fourResult25 = strArray[4]

                    } else if (countDigits(sumOfFour25.toString()) > 5) {
                        var strArray = convertStringToArray(sumOfFour25.toString())
                        fourResult25 = strArray[5]
                    }

                    if (countDigits(sumOfFour36.toString()) in 1..5) {
                        var strArray = convertStringToArray(sumOfFour36.toString())
                        Log.d("Result", "$strArray")
                        if (strArray.size == 1) fourResult36 = strArray[0]
                        if (strArray.size == 2) fourResult36 = strArray[1]
                        if (strArray.size == 3) fourResult36 = strArray[2]
                        if (strArray.size == 4) fourResult36 = strArray[3]
                        if (strArray.size == 5) fourResult36 = strArray[4]

                    } else if (countDigits(sumOfFour36.toString()) > 5) {
                        var strArray = convertStringToArray(sumOfFour36.toString())
                        fourResult36 = strArray[5]
                    }

                    var threeNumbers = ThreeNumbers(
                        fourResult14!!.toInt(),
                        fourResult25!!.toInt(),
                        fourResult36!!.toInt()
                    )
                    threeNumberList.add(threeNumbers)
                }
                if (i == 12) {
                    var seven14 = sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14
                    var seven25 = sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25
                    var seven36 = sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36

                    val sumOfFour14 = getSumOfDigits(seven14)
                    val sumOfFour25 = getSumOfDigits(seven25)
                    val sumOfFour36 = getSumOfDigits(seven36)

                    var fourResult14: String? = null
                    var fourResult25: String? = null
                    var fourResult36: String? = null

                    if (countDigits(sumOfFour14.toString()) in 1..5) {
                        var strArray = convertStringToArray(sumOfFour14.toString())
                        Log.d("Result", "$strArray")
                        if (strArray.size == 1) fourResult14 = strArray[0]
                        if (strArray.size == 2) fourResult14 = strArray[1]
                        if (strArray.size == 3) fourResult14 = strArray[2]
                        if (strArray.size == 4) fourResult14 = strArray[3]
                        if (strArray.size == 5) fourResult14 = strArray[4]

                    } else if (countDigits(sumOfFour14.toString()) > 5) {
                        var strArray = convertStringToArray(sumOfFour14.toString())
                        fourResult14 = strArray[5]
                    }

                    if (countDigits(sumOfFour25.toString()) in 1..5) {
                        var strArray = convertStringToArray(sumOfFour25.toString())
                        Log.d("Result", "$strArray")
                        if (strArray.size == 1) fourResult25 = strArray[0]
                        if (strArray.size == 2) fourResult25 = strArray[1]
                        if (strArray.size == 3) fourResult25 = strArray[2]
                        if (strArray.size == 4) fourResult25 = strArray[3]
                        if (strArray.size == 5) fourResult25 = strArray[4]

                    } else if (countDigits(sumOfFour25.toString()) > 5) {
                        var strArray = convertStringToArray(sumOfFour25.toString())
                        fourResult25 = strArray[5]
                    }

                    if (countDigits(sumOfFour36.toString()) in 1..5) {
                        var strArray = convertStringToArray(sumOfFour36.toString())
                        Log.d("Result", "$strArray")
                        if (strArray.size == 1) fourResult36 = strArray[0]
                        if (strArray.size == 2) fourResult36 = strArray[1]
                        if (strArray.size == 3) fourResult36 = strArray[2]
                        if (strArray.size == 4) fourResult36 = strArray[3]
                        if (strArray.size == 5) fourResult36 = strArray[4]

                    } else if (countDigits(sumOfFour36.toString()) > 5) {
                        var strArray = convertStringToArray(sumOfFour36.toString())
                        fourResult36 = strArray[5]
                    }

                    var threeNumbers = ThreeNumbers(
                        fourResult14!!.toInt(),
                        fourResult25!!.toInt(),
                        fourResult36!!.toInt()
                    )
                    threeNumberList.add(threeNumbers)
                }
                if (i == 13) {
                    var seven14 = sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14
                    var seven25 = sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25
                    var seven36 = sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36

                    val sumOfFour14 = getSumOfDigits(seven14)
                    val sumOfFour25 = getSumOfDigits(seven25)
                    val sumOfFour36 = getSumOfDigits(seven36)

                    var fourResult14: String? = null
                    var fourResult25: String? = null
                    var fourResult36: String? = null

                    if (countDigits(sumOfFour14.toString()) in 1..5) {
                        var strArray = convertStringToArray(sumOfFour14.toString())
                        Log.d("Result", "$strArray")
                        if (strArray.size == 1) fourResult14 = strArray[0]
                        if (strArray.size == 2) fourResult14 = strArray[1]
                        if (strArray.size == 3) fourResult14 = strArray[2]
                        if (strArray.size == 4) fourResult14 = strArray[3]
                        if (strArray.size == 5) fourResult14 = strArray[4]

                    } else if (countDigits(sumOfFour14.toString()) > 5) {
                        var strArray = convertStringToArray(sumOfFour14.toString())
                        fourResult14 = strArray[5]
                    }

                    if (countDigits(sumOfFour25.toString()) in 1..5) {
                        var strArray = convertStringToArray(sumOfFour25.toString())
                        Log.d("Result", "$strArray")
                        if (strArray.size == 1) fourResult25 = strArray[0]
                        if (strArray.size == 2) fourResult25 = strArray[1]
                        if (strArray.size == 3) fourResult25 = strArray[2]
                        if (strArray.size == 4) fourResult25 = strArray[3]
                        if (strArray.size == 5) fourResult25 = strArray[4]

                    } else if (countDigits(sumOfFour25.toString()) > 5) {
                        var strArray = convertStringToArray(sumOfFour25.toString())
                        fourResult25 = strArray[5]
                    }

                    if (countDigits(sumOfFour36.toString()) in 1..5) {
                        var strArray = convertStringToArray(sumOfFour36.toString())
                        Log.d("Result", "$strArray")
                        if (strArray.size == 1) fourResult36 = strArray[0]
                        if (strArray.size == 2) fourResult36 = strArray[1]
                        if (strArray.size == 3) fourResult36 = strArray[2]
                        if (strArray.size == 4) fourResult36 = strArray[3]
                        if (strArray.size == 5) fourResult36 = strArray[4]

                    } else if (countDigits(sumOfFour36.toString()) > 5) {
                        var strArray = convertStringToArray(sumOfFour36.toString())
                        fourResult36 = strArray[5]
                    }

                    var threeNumbers = ThreeNumbers(
                        fourResult14!!.toInt(),
                        fourResult25!!.toInt(),
                        fourResult36!!.toInt()
                    )
                    threeNumberList.add(threeNumbers)
                }
                if (i == 14) {
                    var seven14 = sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14
                    var seven25 = sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25
                    var seven36 = sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36

                    val sumOfFour14 = getSumOfDigits(seven14)
                    val sumOfFour25 = getSumOfDigits(seven25)
                    val sumOfFour36 = getSumOfDigits(seven36)

                    var fourResult14: String? = null
                    var fourResult25: String? = null
                    var fourResult36: String? = null

                    if (countDigits(sumOfFour14.toString()) in 1..5) {
                        var strArray = convertStringToArray(sumOfFour14.toString())
                        Log.d("Result", "$strArray")
                        if (strArray.size == 1) fourResult14 = strArray[0]
                        if (strArray.size == 2) fourResult14 = strArray[1]
                        if (strArray.size == 3) fourResult14 = strArray[2]
                        if (strArray.size == 4) fourResult14 = strArray[3]
                        if (strArray.size == 5) fourResult14 = strArray[4]

                    } else if (countDigits(sumOfFour14.toString()) > 5) {
                        var strArray = convertStringToArray(sumOfFour14.toString())
                        fourResult14 = strArray[5]
                    }

                    if (countDigits(sumOfFour25.toString()) in 1..5) {
                        var strArray = convertStringToArray(sumOfFour25.toString())
                        Log.d("Result", "$strArray")
                        if (strArray.size == 1) fourResult25 = strArray[0]
                        if (strArray.size == 2) fourResult25 = strArray[1]
                        if (strArray.size == 3) fourResult25 = strArray[2]
                        if (strArray.size == 4) fourResult25 = strArray[3]
                        if (strArray.size == 5) fourResult25 = strArray[4]

                    } else if (countDigits(sumOfFour25.toString()) > 5) {
                        var strArray = convertStringToArray(sumOfFour25.toString())
                        fourResult25 = strArray[5]
                    }

                    if (countDigits(sumOfFour36.toString()) in 1..5) {
                        var strArray = convertStringToArray(sumOfFour36.toString())
                        Log.d("Result", "$strArray")
                        if (strArray.size == 1) fourResult36 = strArray[0]
                        if (strArray.size == 2) fourResult36 = strArray[1]
                        if (strArray.size == 3) fourResult36 = strArray[2]
                        if (strArray.size == 4) fourResult36 = strArray[3]
                        if (strArray.size == 5) fourResult36 = strArray[4]

                    } else if (countDigits(sumOfFour36.toString()) > 5) {
                        var strArray = convertStringToArray(sumOfFour36.toString())
                        fourResult36 = strArray[5]
                    }

                    var threeNumbers = ThreeNumbers(
                        fourResult14!!.toInt(),
                        fourResult25!!.toInt(),
                        fourResult36!!.toInt()
                    )
                    threeNumberList.add(threeNumbers)
                }
                if (i == 15) {
                    var seven14 = sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14
                    var seven25 = sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25
                    var seven36 = sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36

                    val sumOfFour14 = getSumOfDigits(seven14)
                    val sumOfFour25 = getSumOfDigits(seven25)
                    val sumOfFour36 = getSumOfDigits(seven36)

                    var fourResult14: String? = null
                    var fourResult25: String? = null
                    var fourResult36: String? = null

                    if (countDigits(sumOfFour14.toString()) in 1..5) {
                        var strArray = convertStringToArray(sumOfFour14.toString())
                        Log.d("Result", "$strArray")
                        if (strArray.size == 1) fourResult14 = strArray[0]
                        if (strArray.size == 2) fourResult14 = strArray[1]
                        if (strArray.size == 3) fourResult14 = strArray[2]
                        if (strArray.size == 4) fourResult14 = strArray[3]
                        if (strArray.size == 5) fourResult14 = strArray[4]

                    } else if (countDigits(sumOfFour14.toString()) > 5) {
                        var strArray = convertStringToArray(sumOfFour14.toString())
                        fourResult14 = strArray[5]
                    }

                    if (countDigits(sumOfFour25.toString()) in 1..5) {
                        var strArray = convertStringToArray(sumOfFour25.toString())
                        Log.d("Result", "$strArray")
                        if (strArray.size == 1) fourResult25 = strArray[0]
                        if (strArray.size == 2) fourResult25 = strArray[1]
                        if (strArray.size == 3) fourResult25 = strArray[2]
                        if (strArray.size == 4) fourResult25 = strArray[3]
                        if (strArray.size == 5) fourResult25 = strArray[4]

                    } else if (countDigits(sumOfFour25.toString()) > 5) {
                        var strArray = convertStringToArray(sumOfFour25.toString())
                        fourResult25 = strArray[5]
                    }

                    if (countDigits(sumOfFour36.toString()) in 1..5) {
                        var strArray = convertStringToArray(sumOfFour36.toString())
                        Log.d("Result", "$strArray")
                        if (strArray.size == 1) fourResult36 = strArray[0]
                        if (strArray.size == 2) fourResult36 = strArray[1]
                        if (strArray.size == 3) fourResult36 = strArray[2]
                        if (strArray.size == 4) fourResult36 = strArray[3]
                        if (strArray.size == 5) fourResult36 = strArray[4]

                    } else if (countDigits(sumOfFour36.toString()) > 5) {
                        var strArray = convertStringToArray(sumOfFour36.toString())
                        fourResult36 = strArray[5]
                    }

                    var threeNumbers = ThreeNumbers(
                        fourResult14!!.toInt(),
                        fourResult25!!.toInt(),
                        fourResult36!!.toInt()
                    )
                    threeNumberList.add(threeNumbers)
                }
                if (i == 16) {
                    var seven14 = sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14
                    var seven25 = sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25
                    var seven36 = sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36

                    val sumOfFour14 = getSumOfDigits(seven14)
                    val sumOfFour25 = getSumOfDigits(seven25)
                    val sumOfFour36 = getSumOfDigits(seven36)

                    var fourResult14: String? = null
                    var fourResult25: String? = null
                    var fourResult36: String? = null

                    if (countDigits(sumOfFour14.toString()) in 1..5) {
                        var strArray = convertStringToArray(sumOfFour14.toString())
                        Log.d("Result", "$strArray")
                        if (strArray.size == 1) fourResult14 = strArray[0]
                        if (strArray.size == 2) fourResult14 = strArray[1]
                        if (strArray.size == 3) fourResult14 = strArray[2]
                        if (strArray.size == 4) fourResult14 = strArray[3]
                        if (strArray.size == 5) fourResult14 = strArray[4]

                    } else if (countDigits(sumOfFour14.toString()) > 5) {
                        var strArray = convertStringToArray(sumOfFour14.toString())
                        fourResult14 = strArray[5]
                    }

                    if (countDigits(sumOfFour25.toString()) in 1..5) {
                        var strArray = convertStringToArray(sumOfFour25.toString())
                        Log.d("Result", "$strArray")
                        if (strArray.size == 1) fourResult25 = strArray[0]
                        if (strArray.size == 2) fourResult25 = strArray[1]
                        if (strArray.size == 3) fourResult25 = strArray[2]
                        if (strArray.size == 4) fourResult25 = strArray[3]
                        if (strArray.size == 5) fourResult25 = strArray[4]

                    } else if (countDigits(sumOfFour25.toString()) > 5) {
                        var strArray = convertStringToArray(sumOfFour25.toString())
                        fourResult25 = strArray[5]
                    }

                    if (countDigits(sumOfFour36.toString()) in 1..5) {
                        var strArray = convertStringToArray(sumOfFour36.toString())
                        Log.d("Result", "$strArray")
                        if (strArray.size == 1) fourResult36 = strArray[0]
                        if (strArray.size == 2) fourResult36 = strArray[1]
                        if (strArray.size == 3) fourResult36 = strArray[2]
                        if (strArray.size == 4) fourResult36 = strArray[3]
                        if (strArray.size == 5) fourResult36 = strArray[4]

                    } else if (countDigits(sumOfFour36.toString()) > 5) {
                        var strArray = convertStringToArray(sumOfFour36.toString())
                        fourResult36 = strArray[5]
                    }

                    var threeNumbers = ThreeNumbers(
                        fourResult14!!.toInt(),
                        fourResult25!!.toInt(),
                        fourResult36!!.toInt()
                    )
                    threeNumberList.add(threeNumbers)
                }
                if (i == 17) {
                    var seven14 = sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14
                    var seven25 = sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25
                    var seven36 = sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36

                    val sumOfFour14 = getSumOfDigits(seven14)
                    val sumOfFour25 = getSumOfDigits(seven25)
                    val sumOfFour36 = getSumOfDigits(seven36)

                    var fourResult14: String? = null
                    var fourResult25: String? = null
                    var fourResult36: String? = null

                    if (countDigits(sumOfFour14.toString()) in 1..5) {
                        var strArray = convertStringToArray(sumOfFour14.toString())
                        Log.d("Result", "$strArray")
                        if (strArray.size == 1) fourResult14 = strArray[0]
                        if (strArray.size == 2) fourResult14 = strArray[1]
                        if (strArray.size == 3) fourResult14 = strArray[2]
                        if (strArray.size == 4) fourResult14 = strArray[3]
                        if (strArray.size == 5) fourResult14 = strArray[4]

                    } else if (countDigits(sumOfFour14.toString()) > 5) {
                        var strArray = convertStringToArray(sumOfFour14.toString())
                        fourResult14 = strArray[5]
                    }

                    if (countDigits(sumOfFour25.toString()) in 1..5) {
                        var strArray = convertStringToArray(sumOfFour25.toString())
                        Log.d("Result", "$strArray")
                        if (strArray.size == 1) fourResult25 = strArray[0]
                        if (strArray.size == 2) fourResult25 = strArray[1]
                        if (strArray.size == 3) fourResult25 = strArray[2]
                        if (strArray.size == 4) fourResult25 = strArray[3]
                        if (strArray.size == 5) fourResult25 = strArray[4]

                    } else if (countDigits(sumOfFour25.toString()) > 5) {
                        var strArray = convertStringToArray(sumOfFour25.toString())
                        fourResult25 = strArray[5]
                    }

                    if (countDigits(sumOfFour36.toString()) in 1..5) {
                        var strArray = convertStringToArray(sumOfFour36.toString())
                        Log.d("Result", "$strArray")
                        if (strArray.size == 1) fourResult36 = strArray[0]
                        if (strArray.size == 2) fourResult36 = strArray[1]
                        if (strArray.size == 3) fourResult36 = strArray[2]
                        if (strArray.size == 4) fourResult36 = strArray[3]
                        if (strArray.size == 5) fourResult36 = strArray[4]

                    } else if (countDigits(sumOfFour36.toString()) > 5) {
                        var strArray = convertStringToArray(sumOfFour36.toString())
                        fourResult36 = strArray[5]
                    }

                    var threeNumbers = ThreeNumbers(
                        fourResult14!!.toInt(),
                        fourResult25!!.toInt(),
                        fourResult36!!.toInt()
                    )
                    threeNumberList.add(threeNumbers)
                }
                if (i == 18) {
                    var seven14 = sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14
                    var seven25 = sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25
                    var seven36 = sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36

                    val sumOfFour14 = getSumOfDigits(seven14)
                    val sumOfFour25 = getSumOfDigits(seven25)
                    val sumOfFour36 = getSumOfDigits(seven36)

                    var fourResult14: String? = null
                    var fourResult25: String? = null
                    var fourResult36: String? = null

                    if (countDigits(sumOfFour14.toString()) in 1..5) {
                        var strArray = convertStringToArray(sumOfFour14.toString())
                        Log.d("Result", "$strArray")
                        if (strArray.size == 1) fourResult14 = strArray[0]
                        if (strArray.size == 2) fourResult14 = strArray[1]
                        if (strArray.size == 3) fourResult14 = strArray[2]
                        if (strArray.size == 4) fourResult14 = strArray[3]
                        if (strArray.size == 5) fourResult14 = strArray[4]

                    } else if (countDigits(sumOfFour14.toString()) > 5) {
                        var strArray = convertStringToArray(sumOfFour14.toString())
                        fourResult14 = strArray[5]
                    }

                    if (countDigits(sumOfFour25.toString()) in 1..5) {
                        var strArray = convertStringToArray(sumOfFour25.toString())
                        Log.d("Result", "$strArray")
                        if (strArray.size == 1) fourResult25 = strArray[0]
                        if (strArray.size == 2) fourResult25 = strArray[1]
                        if (strArray.size == 3) fourResult25 = strArray[2]
                        if (strArray.size == 4) fourResult25 = strArray[3]
                        if (strArray.size == 5) fourResult25 = strArray[4]

                    } else if (countDigits(sumOfFour25.toString()) > 5) {
                        var strArray = convertStringToArray(sumOfFour25.toString())
                        fourResult25 = strArray[5]
                    }

                    if (countDigits(sumOfFour36.toString()) in 1..5) {
                        var strArray = convertStringToArray(sumOfFour36.toString())
                        Log.d("Result", "$strArray")
                        if (strArray.size == 1) fourResult36 = strArray[0]
                        if (strArray.size == 2) fourResult36 = strArray[1]
                        if (strArray.size == 3) fourResult36 = strArray[2]
                        if (strArray.size == 4) fourResult36 = strArray[3]
                        if (strArray.size == 5) fourResult36 = strArray[4]

                    } else if (countDigits(sumOfFour36.toString()) > 5) {
                        var strArray = convertStringToArray(sumOfFour36.toString())
                        fourResult36 = strArray[5]
                    }

                    var threeNumbers = ThreeNumbers(
                        fourResult14!!.toInt(),
                        fourResult25!!.toInt(),
                        fourResult36!!.toInt()
                    )
                    threeNumberList.add(threeNumbers)
                }
                if (i == 19) {
                    var seven14 = sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14
                    var seven25 = sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25
                    var seven36 = sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36

                    val sumOfFour14 = getSumOfDigits(seven14)
                    val sumOfFour25 = getSumOfDigits(seven25)
                    val sumOfFour36 = getSumOfDigits(seven36)

                    var fourResult14: String? = null
                    var fourResult25: String? = null
                    var fourResult36: String? = null

                    if (countDigits(sumOfFour14.toString()) in 1..5) {
                        var strArray = convertStringToArray(sumOfFour14.toString())
                        Log.d("Result", "$strArray")
                        if (strArray.size == 1) fourResult14 = strArray[0]
                        if (strArray.size == 2) fourResult14 = strArray[1]
                        if (strArray.size == 3) fourResult14 = strArray[2]
                        if (strArray.size == 4) fourResult14 = strArray[3]
                        if (strArray.size == 5) fourResult14 = strArray[4]

                    } else if (countDigits(sumOfFour14.toString()) > 5) {
                        var strArray = convertStringToArray(sumOfFour14.toString())
                        fourResult14 = strArray[5]
                    }

                    if (countDigits(sumOfFour25.toString()) in 1..5) {
                        var strArray = convertStringToArray(sumOfFour25.toString())
                        Log.d("Result", "$strArray")
                        if (strArray.size == 1) fourResult25 = strArray[0]
                        if (strArray.size == 2) fourResult25 = strArray[1]
                        if (strArray.size == 3) fourResult25 = strArray[2]
                        if (strArray.size == 4) fourResult25 = strArray[3]
                        if (strArray.size == 5) fourResult25 = strArray[4]

                    } else if (countDigits(sumOfFour25.toString()) > 5) {
                        var strArray = convertStringToArray(sumOfFour25.toString())
                        fourResult25 = strArray[5]
                    }

                    if (countDigits(sumOfFour36.toString()) in 1..5) {
                        var strArray = convertStringToArray(sumOfFour36.toString())
                        Log.d("Result", "$strArray")
                        if (strArray.size == 1) fourResult36 = strArray[0]
                        if (strArray.size == 2) fourResult36 = strArray[1]
                        if (strArray.size == 3) fourResult36 = strArray[2]
                        if (strArray.size == 4) fourResult36 = strArray[3]
                        if (strArray.size == 5) fourResult36 = strArray[4]

                    } else if (countDigits(sumOfFour36.toString()) > 5) {
                        var strArray = convertStringToArray(sumOfFour36.toString())
                        fourResult36 = strArray[5]
                    }

                    var threeNumbers = ThreeNumbers(
                        fourResult14!!.toInt(),
                        fourResult25!!.toInt(),
                        fourResult36!!.toInt()
                    )
                    threeNumberList.add(threeNumbers)
                }
                if (i == 20) {
                    var seven14 = sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14
                    var seven25 = sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25
                    var seven36 = sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36

                    val sumOfFour14 = getSumOfDigits(seven14)
                    val sumOfFour25 = getSumOfDigits(seven25)
                    val sumOfFour36 = getSumOfDigits(seven36)

                    var fourResult14: String? = null
                    var fourResult25: String? = null
                    var fourResult36: String? = null

                    if (countDigits(sumOfFour14.toString()) in 1..5) {
                        var strArray = convertStringToArray(sumOfFour14.toString())
                        Log.d("Result", "$strArray")
                        if (strArray.size == 1) fourResult14 = strArray[0]
                        if (strArray.size == 2) fourResult14 = strArray[1]
                        if (strArray.size == 3) fourResult14 = strArray[2]
                        if (strArray.size == 4) fourResult14 = strArray[3]
                        if (strArray.size == 5) fourResult14 = strArray[4]

                    } else if (countDigits(sumOfFour14.toString()) > 5) {
                        var strArray = convertStringToArray(sumOfFour14.toString())
                        fourResult14 = strArray[5]
                    }

                    if (countDigits(sumOfFour25.toString()) in 1..5) {
                        var strArray = convertStringToArray(sumOfFour25.toString())
                        Log.d("Result", "$strArray")
                        if (strArray.size == 1) fourResult25 = strArray[0]
                        if (strArray.size == 2) fourResult25 = strArray[1]
                        if (strArray.size == 3) fourResult25 = strArray[2]
                        if (strArray.size == 4) fourResult25 = strArray[3]
                        if (strArray.size == 5) fourResult25 = strArray[4]

                    } else if (countDigits(sumOfFour25.toString()) > 5) {
                        var strArray = convertStringToArray(sumOfFour25.toString())
                        fourResult25 = strArray[5]
                    }

                    if (countDigits(sumOfFour36.toString()) in 1..5) {
                        var strArray = convertStringToArray(sumOfFour36.toString())
                        Log.d("Result", "$strArray")
                        if (strArray.size == 1) fourResult36 = strArray[0]
                        if (strArray.size == 2) fourResult36 = strArray[1]
                        if (strArray.size == 3) fourResult36 = strArray[2]
                        if (strArray.size == 4) fourResult36 = strArray[3]
                        if (strArray.size == 5) fourResult36 = strArray[4]

                    } else if (countDigits(sumOfFour36.toString()) > 5) {
                        var strArray = convertStringToArray(sumOfFour36.toString())
                        fourResult36 = strArray[5]
                    }

                    var threeNumbers = ThreeNumbers(
                        fourResult14!!.toInt(),
                        fourResult25!!.toInt(),
                        fourResult36!!.toInt()
                    )
                    threeNumberList.add(threeNumbers)
                }
                if (i == 21) {
                    var seven14 = sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14
                    var seven25 = sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25
                    var seven36 = sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36

                    val sumOfFour14 = getSumOfDigits(seven14)
                    val sumOfFour25 = getSumOfDigits(seven25)
                    val sumOfFour36 = getSumOfDigits(seven36)

                    var fourResult14: String? = null
                    var fourResult25: String? = null
                    var fourResult36: String? = null

                    if (countDigits(sumOfFour14.toString()) in 1..5) {
                        var strArray = convertStringToArray(sumOfFour14.toString())
                        Log.d("Result", "$strArray")
                        if (strArray.size == 1) fourResult14 = strArray[0]
                        if (strArray.size == 2) fourResult14 = strArray[1]
                        if (strArray.size == 3) fourResult14 = strArray[2]
                        if (strArray.size == 4) fourResult14 = strArray[3]
                        if (strArray.size == 5) fourResult14 = strArray[4]

                    } else if (countDigits(sumOfFour14.toString()) > 5) {
                        var strArray = convertStringToArray(sumOfFour14.toString())
                        fourResult14 = strArray[5]
                    }

                    if (countDigits(sumOfFour25.toString()) in 1..5) {
                        var strArray = convertStringToArray(sumOfFour25.toString())
                        Log.d("Result", "$strArray")
                        if (strArray.size == 1) fourResult25 = strArray[0]
                        if (strArray.size == 2) fourResult25 = strArray[1]
                        if (strArray.size == 3) fourResult25 = strArray[2]
                        if (strArray.size == 4) fourResult25 = strArray[3]
                        if (strArray.size == 5) fourResult25 = strArray[4]

                    } else if (countDigits(sumOfFour25.toString()) > 5) {
                        var strArray = convertStringToArray(sumOfFour25.toString())
                        fourResult25 = strArray[5]
                    }

                    if (countDigits(sumOfFour36.toString()) in 1..5) {
                        var strArray = convertStringToArray(sumOfFour36.toString())
                        Log.d("Result", "$strArray")
                        if (strArray.size == 1) fourResult36 = strArray[0]
                        if (strArray.size == 2) fourResult36 = strArray[1]
                        if (strArray.size == 3) fourResult36 = strArray[2]
                        if (strArray.size == 4) fourResult36 = strArray[3]
                        if (strArray.size == 5) fourResult36 = strArray[4]

                    } else if (countDigits(sumOfFour36.toString()) > 5) {
                        var strArray = convertStringToArray(sumOfFour36.toString())
                        fourResult36 = strArray[5]
                    }

                    var threeNumbers = ThreeNumbers(
                        fourResult14!!.toInt(),
                        fourResult25!!.toInt(),
                        fourResult36!!.toInt()
                    )
                    threeNumberList.add(threeNumbers)
                }
                if (i == 22) {
                    var seven14 = sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14
                    var seven25 = sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25
                    var seven36 = sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36

                    val sumOfFour14 = getSumOfDigits(seven14)
                    val sumOfFour25 = getSumOfDigits(seven25)
                    val sumOfFour36 = getSumOfDigits(seven36)

                    var fourResult14: String? = null
                    var fourResult25: String? = null
                    var fourResult36: String? = null

                    if (countDigits(sumOfFour14.toString()) in 1..5) {
                        var strArray = convertStringToArray(sumOfFour14.toString())
                        Log.d("Result", "$strArray")
                        if (strArray.size == 1) fourResult14 = strArray[0]
                        if (strArray.size == 2) fourResult14 = strArray[1]
                        if (strArray.size == 3) fourResult14 = strArray[2]
                        if (strArray.size == 4) fourResult14 = strArray[3]
                        if (strArray.size == 5) fourResult14 = strArray[4]

                    } else if (countDigits(sumOfFour14.toString()) > 5) {
                        var strArray = convertStringToArray(sumOfFour14.toString())
                        fourResult14 = strArray[5]
                    }

                    if (countDigits(sumOfFour25.toString()) in 1..5) {
                        var strArray = convertStringToArray(sumOfFour25.toString())
                        Log.d("Result", "$strArray")
                        if (strArray.size == 1) fourResult25 = strArray[0]
                        if (strArray.size == 2) fourResult25 = strArray[1]
                        if (strArray.size == 3) fourResult25 = strArray[2]
                        if (strArray.size == 4) fourResult25 = strArray[3]
                        if (strArray.size == 5) fourResult25 = strArray[4]

                    } else if (countDigits(sumOfFour25.toString()) > 5) {
                        var strArray = convertStringToArray(sumOfFour25.toString())
                        fourResult25 = strArray[5]
                    }

                    if (countDigits(sumOfFour36.toString()) in 1..5) {
                        var strArray = convertStringToArray(sumOfFour36.toString())
                        Log.d("Result", "$strArray")
                        if (strArray.size == 1) fourResult36 = strArray[0]
                        if (strArray.size == 2) fourResult36 = strArray[1]
                        if (strArray.size == 3) fourResult36 = strArray[2]
                        if (strArray.size == 4) fourResult36 = strArray[3]
                        if (strArray.size == 5) fourResult36 = strArray[4]

                    } else if (countDigits(sumOfFour36.toString()) > 5) {
                        var strArray = convertStringToArray(sumOfFour36.toString())
                        fourResult36 = strArray[5]
                    }

                    var threeNumbers = ThreeNumbers(
                        fourResult14!!.toInt(),
                        fourResult25!!.toInt(),
                        fourResult36!!.toInt()
                    )
                    threeNumberList.add(threeNumbers)
                }
                if (i == 23) {
                    var seven14 = sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14
                    var seven25 = sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25
                    var seven36 = sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36

                    val sumOfFour14 = getSumOfDigits(seven14)
                    val sumOfFour25 = getSumOfDigits(seven25)
                    val sumOfFour36 = getSumOfDigits(seven36)

                    var fourResult14: String? = null
                    var fourResult25: String? = null
                    var fourResult36: String? = null

                    if (countDigits(sumOfFour14.toString()) in 1..5) {
                        var strArray = convertStringToArray(sumOfFour14.toString())
                        Log.d("Result", "$strArray")
                        if (strArray.size == 1) fourResult14 = strArray[0]
                        if (strArray.size == 2) fourResult14 = strArray[1]
                        if (strArray.size == 3) fourResult14 = strArray[2]
                        if (strArray.size == 4) fourResult14 = strArray[3]
                        if (strArray.size == 5) fourResult14 = strArray[4]

                    } else if (countDigits(sumOfFour14.toString()) > 5) {
                        var strArray = convertStringToArray(sumOfFour14.toString())
                        fourResult14 = strArray[5]
                    }

                    if (countDigits(sumOfFour25.toString()) in 1..5) {
                        var strArray = convertStringToArray(sumOfFour25.toString())
                        Log.d("Result", "$strArray")
                        if (strArray.size == 1) fourResult25 = strArray[0]
                        if (strArray.size == 2) fourResult25 = strArray[1]
                        if (strArray.size == 3) fourResult25 = strArray[2]
                        if (strArray.size == 4) fourResult25 = strArray[3]
                        if (strArray.size == 5) fourResult25 = strArray[4]

                    } else if (countDigits(sumOfFour25.toString()) > 5) {
                        var strArray = convertStringToArray(sumOfFour25.toString())
                        fourResult25 = strArray[5]
                    }

                    if (countDigits(sumOfFour36.toString()) in 1..5) {
                        var strArray = convertStringToArray(sumOfFour36.toString())
                        Log.d("Result", "$strArray")
                        if (strArray.size == 1) fourResult36 = strArray[0]
                        if (strArray.size == 2) fourResult36 = strArray[1]
                        if (strArray.size == 3) fourResult36 = strArray[2]
                        if (strArray.size == 4) fourResult36 = strArray[3]
                        if (strArray.size == 5) fourResult36 = strArray[4]

                    } else if (countDigits(sumOfFour36.toString()) > 5) {
                        var strArray = convertStringToArray(sumOfFour36.toString())
                        fourResult36 = strArray[5]
                    }

                    var threeNumbers = ThreeNumbers(
                        fourResult14!!.toInt(),
                        fourResult25!!.toInt(),
                        fourResult36!!.toInt()
                    )
                    threeNumberList.add(threeNumbers)
                }
                if (i == 24) {
                    var seven14 = sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14
                    var seven25 = sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25
                    var seven36 = sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36

                    val sumOfFour14 = getSumOfDigits(seven14)
                    val sumOfFour25 = getSumOfDigits(seven25)
                    val sumOfFour36 = getSumOfDigits(seven36)

                    var fourResult14: String? = null
                    var fourResult25: String? = null
                    var fourResult36: String? = null

                    if (countDigits(sumOfFour14.toString()) in 1..5) {
                        var strArray = convertStringToArray(sumOfFour14.toString())
                        Log.d("Result", "$strArray")
                        if (strArray.size == 1) fourResult14 = strArray[0]
                        if (strArray.size == 2) fourResult14 = strArray[1]
                        if (strArray.size == 3) fourResult14 = strArray[2]
                        if (strArray.size == 4) fourResult14 = strArray[3]
                        if (strArray.size == 5) fourResult14 = strArray[4]

                    } else if (countDigits(sumOfFour14.toString()) > 5) {
                        var strArray = convertStringToArray(sumOfFour14.toString())
                        fourResult14 = strArray[5]
                    }

                    if (countDigits(sumOfFour25.toString()) in 1..5) {
                        var strArray = convertStringToArray(sumOfFour25.toString())
                        Log.d("Result", "$strArray")
                        if (strArray.size == 1) fourResult25 = strArray[0]
                        if (strArray.size == 2) fourResult25 = strArray[1]
                        if (strArray.size == 3) fourResult25 = strArray[2]
                        if (strArray.size == 4) fourResult25 = strArray[3]
                        if (strArray.size == 5) fourResult25 = strArray[4]

                    } else if (countDigits(sumOfFour25.toString()) > 5) {
                        var strArray = convertStringToArray(sumOfFour25.toString())
                        fourResult25 = strArray[5]
                    }

                    if (countDigits(sumOfFour36.toString()) in 1..5) {
                        var strArray = convertStringToArray(sumOfFour36.toString())
                        Log.d("Result", "$strArray")
                        if (strArray.size == 1) fourResult36 = strArray[0]
                        if (strArray.size == 2) fourResult36 = strArray[1]
                        if (strArray.size == 3) fourResult36 = strArray[2]
                        if (strArray.size == 4) fourResult36 = strArray[3]
                        if (strArray.size == 5) fourResult36 = strArray[4]

                    } else if (countDigits(sumOfFour36.toString()) > 5) {
                        var strArray = convertStringToArray(sumOfFour36.toString())
                        fourResult36 = strArray[5]
                    }

                    var threeNumbers = ThreeNumbers(
                        fourResult14!!.toInt(),
                        fourResult25!!.toInt(),
                        fourResult36!!.toInt()
                    )
                    threeNumberList.add(threeNumbers)
                }
                if (i == 25) {
                    val seven14 = sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14
                    val seven25 = sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25
                    val seven36 = sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36

                    val sumOfFour14 = getSumOfDigits(seven14)
                    val sumOfFour25 = getSumOfDigits(seven25)
                    val sumOfFour36 = getSumOfDigits(seven36)

                    var fourResult14: String? = null
                    var fourResult25: String? = null
                    var fourResult36: String? = null

                    if (countDigits(sumOfFour14.toString()) in 1..5) {
                        var strArray = convertStringToArray(sumOfFour14.toString())
                        Log.d("Result", "$strArray")
                        if (strArray.size == 1) fourResult14 = strArray[0]
                        if (strArray.size == 2) fourResult14 = strArray[1]
                        if (strArray.size == 3) fourResult14 = strArray[2]
                        if (strArray.size == 4) fourResult14 = strArray[3]
                        if (strArray.size == 5) fourResult14 = strArray[4]

                    } else if (countDigits(sumOfFour14.toString()) > 5) {
                        var strArray = convertStringToArray(sumOfFour14.toString())
                        fourResult14 = strArray[5]
                    }

                    if (countDigits(sumOfFour25.toString()) in 1..5) {
                        var strArray = convertStringToArray(sumOfFour25.toString())
                        Log.d("Result", "$strArray")
                        if (strArray.size == 1) fourResult25 = strArray[0]
                        if (strArray.size == 2) fourResult25 = strArray[1]
                        if (strArray.size == 3) fourResult25 = strArray[2]
                        if (strArray.size == 4) fourResult25 = strArray[3]
                        if (strArray.size == 5) fourResult25 = strArray[4]

                    } else if (countDigits(sumOfFour25.toString()) > 5) {
                        var strArray = convertStringToArray(sumOfFour25.toString())
                        fourResult25 = strArray[5]
                    }

                    if (countDigits(sumOfFour36.toString()) in 1..5) {
                        var strArray = convertStringToArray(sumOfFour36.toString())
                        Log.d("Result", "$strArray")
                        if (strArray.size == 1) fourResult36 = strArray[0]
                        if (strArray.size == 2) fourResult36 = strArray[1]
                        if (strArray.size == 3) fourResult36 = strArray[2]
                        if (strArray.size == 4) fourResult36 = strArray[3]
                        if (strArray.size == 5) fourResult36 = strArray[4]

                    } else if (countDigits(sumOfFour36.toString()) > 5) {
                        var strArray = convertStringToArray(sumOfFour36.toString())
                        fourResult36 = strArray[5]
                    }

                    var threeNumbers = ThreeNumbers(
                        fourResult14!!.toInt(),
                        fourResult25!!.toInt(),
                        fourResult36!!.toInt()
                    )
                    threeNumberList.add(threeNumbers)
                }
                if (i == 26) {
                    val seven14 = sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14
                    val seven25 = sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25
                    val seven36 = sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36

                    val sumOfFour14 = getSumOfDigits(seven14)
                    val sumOfFour25 = getSumOfDigits(seven25)
                    val sumOfFour36 = getSumOfDigits(seven36)

                    var fourResult14: String? = null
                    var fourResult25: String? = null
                    var fourResult36: String? = null

                    if (countDigits(sumOfFour14.toString()) in 1..5) {
                        var strArray = convertStringToArray(sumOfFour14.toString())
                        Log.d("Result", "$strArray")
                        if (strArray.size == 1) fourResult14 = strArray[0]
                        if (strArray.size == 2) fourResult14 = strArray[1]
                        if (strArray.size == 3) fourResult14 = strArray[2]
                        if (strArray.size == 4) fourResult14 = strArray[3]
                        if (strArray.size == 5) fourResult14 = strArray[4]

                    } else if (countDigits(sumOfFour14.toString()) > 5) {
                        var strArray = convertStringToArray(sumOfFour14.toString())
                        fourResult14 = strArray[5]
                    }

                    if (countDigits(sumOfFour25.toString()) in 1..5) {
                        var strArray = convertStringToArray(sumOfFour25.toString())
                        Log.d("Result", "$strArray")
                        if (strArray.size == 1) fourResult25 = strArray[0]
                        if (strArray.size == 2) fourResult25 = strArray[1]
                        if (strArray.size == 3) fourResult25 = strArray[2]
                        if (strArray.size == 4) fourResult25 = strArray[3]
                        if (strArray.size == 5) fourResult25 = strArray[4]

                    } else if (countDigits(sumOfFour25.toString()) > 5) {
                        var strArray = convertStringToArray(sumOfFour25.toString())
                        fourResult25 = strArray[5]
                    }

                    if (countDigits(sumOfFour36.toString()) in 1..5) {
                        var strArray = convertStringToArray(sumOfFour36.toString())
                        Log.d("Result", "$strArray")
                        if (strArray.size == 1) fourResult36 = strArray[0]
                        if (strArray.size == 2) fourResult36 = strArray[1]
                        if (strArray.size == 3) fourResult36 = strArray[2]
                        if (strArray.size == 4) fourResult36 = strArray[3]
                        if (strArray.size == 5) fourResult36 = strArray[4]

                    } else if (countDigits(sumOfFour36.toString()) > 5) {
                        var strArray = convertStringToArray(sumOfFour36.toString())
                        fourResult36 = strArray[5]
                    }

                    var threeNumbers = ThreeNumbers(
                        fourResult14!!.toInt(),
                        fourResult25!!.toInt(),
                        fourResult36!!.toInt()
                    )
                    threeNumberList.add(threeNumbers)
                }
                if (i == 27) {
                    val seven14 = sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14
                    val seven25 = sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25
                    val seven36 = sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36

                    val sumOfFour14 = getSumOfDigits(seven14)
                    val sumOfFour25 = getSumOfDigits(seven25)
                    val sumOfFour36 = getSumOfDigits(seven36)

                    var fourResult14: String? = null
                    var fourResult25: String? = null
                    var fourResult36: String? = null

                    if (countDigits(sumOfFour14.toString()) in 1..5) {
                        var strArray = convertStringToArray(sumOfFour14.toString())
                        Log.d("Result", "$strArray")
                        if (strArray.size == 1) fourResult14 = strArray[0]
                        if (strArray.size == 2) fourResult14 = strArray[1]
                        if (strArray.size == 3) fourResult14 = strArray[2]
                        if (strArray.size == 4) fourResult14 = strArray[3]
                        if (strArray.size == 5) fourResult14 = strArray[4]

                    } else if (countDigits(sumOfFour14.toString()) > 5) {
                        var strArray = convertStringToArray(sumOfFour14.toString())
                        fourResult14 = strArray[5]
                    }

                    if (countDigits(sumOfFour25.toString()) in 1..5) {
                        var strArray = convertStringToArray(sumOfFour25.toString())
                        Log.d("Result", "$strArray")
                        if (strArray.size == 1) fourResult25 = strArray[0]
                        if (strArray.size == 2) fourResult25 = strArray[1]
                        if (strArray.size == 3) fourResult25 = strArray[2]
                        if (strArray.size == 4) fourResult25 = strArray[3]
                        if (strArray.size == 5) fourResult25 = strArray[4]

                    } else if (countDigits(sumOfFour25.toString()) > 5) {
                        var strArray = convertStringToArray(sumOfFour25.toString())
                        fourResult25 = strArray[5]
                    }

                    if (countDigits(sumOfFour36.toString()) in 1..5) {
                        var strArray = convertStringToArray(sumOfFour36.toString())
                        Log.d("Result", "$strArray")
                        if (strArray.size == 1) fourResult36 = strArray[0]
                        if (strArray.size == 2) fourResult36 = strArray[1]
                        if (strArray.size == 3) fourResult36 = strArray[2]
                        if (strArray.size == 4) fourResult36 = strArray[3]
                        if (strArray.size == 5) fourResult36 = strArray[4]

                    } else if (countDigits(sumOfFour36.toString()) > 5) {
                        var strArray = convertStringToArray(sumOfFour36.toString())
                        fourResult36 = strArray[5]
                    }

                    var threeNumbers = ThreeNumbers(
                        fourResult14!!.toInt(),
                        fourResult25!!.toInt(),
                        fourResult36!!.toInt()
                    )
                    threeNumberList.add(threeNumbers)
                }
                if (i == 28) {
                    val seven14 = sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14
                    val seven25 = sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25
                    val seven36 = sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36

                    val sumOfFour14 = getSumOfDigits(seven14)
                    val sumOfFour25 = getSumOfDigits(seven25)
                    val sumOfFour36 = getSumOfDigits(seven36)

                    var fourResult14: String? = null
                    var fourResult25: String? = null
                    var fourResult36: String? = null

                    if (countDigits(sumOfFour14.toString()) in 1..5) {
                        var strArray = convertStringToArray(sumOfFour14.toString())
                        Log.d("Result", "$strArray")
                        if (strArray.size == 1) fourResult14 = strArray[0]
                        if (strArray.size == 2) fourResult14 = strArray[1]
                        if (strArray.size == 3) fourResult14 = strArray[2]
                        if (strArray.size == 4) fourResult14 = strArray[3]
                        if (strArray.size == 5) fourResult14 = strArray[4]

                    } else if (countDigits(sumOfFour14.toString()) > 5) {
                        var strArray = convertStringToArray(sumOfFour14.toString())
                        fourResult14 = strArray[5]
                    }

                    if (countDigits(sumOfFour25.toString()) in 1..5) {
                        var strArray = convertStringToArray(sumOfFour25.toString())
                        Log.d("Result", "$strArray")
                        if (strArray.size == 1) fourResult25 = strArray[0]
                        if (strArray.size == 2) fourResult25 = strArray[1]
                        if (strArray.size == 3) fourResult25 = strArray[2]
                        if (strArray.size == 4) fourResult25 = strArray[3]
                        if (strArray.size == 5) fourResult25 = strArray[4]

                    } else if (countDigits(sumOfFour25.toString()) > 5) {
                        var strArray = convertStringToArray(sumOfFour25.toString())
                        fourResult25 = strArray[5]
                    }

                    if (countDigits(sumOfFour36.toString()) in 1..5) {
                        var strArray = convertStringToArray(sumOfFour36.toString())
                        Log.d("Result", "$strArray")
                        if (strArray.size == 1) fourResult36 = strArray[0]
                        if (strArray.size == 2) fourResult36 = strArray[1]
                        if (strArray.size == 3) fourResult36 = strArray[2]
                        if (strArray.size == 4) fourResult36 = strArray[3]
                        if (strArray.size == 5) fourResult36 = strArray[4]

                    } else if (countDigits(sumOfFour36.toString()) > 5) {
                        var strArray = convertStringToArray(sumOfFour36.toString())
                        fourResult36 = strArray[5]
                    }

                    var threeNumbers = ThreeNumbers(
                        fourResult14!!.toInt(),
                        fourResult25!!.toInt(),
                        fourResult36!!.toInt()
                    )
                    threeNumberList.add(threeNumbers)
                }
                if (i == 29) {
                    val seven14 = sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14
                    val seven25 = sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25
                    val seven36 = sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36

                    val sumOfFour14 = getSumOfDigits(seven14)
                    val sumOfFour25 = getSumOfDigits(seven25)
                    val sumOfFour36 = getSumOfDigits(seven36)

                    var fourResult14: String? = null
                    var fourResult25: String? = null
                    var fourResult36: String? = null

                    if (countDigits(sumOfFour14.toString()) in 1..5) {
                        var strArray = convertStringToArray(sumOfFour14.toString())
                        Log.d("Result", "$strArray")
                        if (strArray.size == 1) fourResult14 = strArray[0]
                        if (strArray.size == 2) fourResult14 = strArray[1]
                        if (strArray.size == 3) fourResult14 = strArray[2]
                        if (strArray.size == 4) fourResult14 = strArray[3]
                        if (strArray.size == 5) fourResult14 = strArray[4]

                    } else if (countDigits(sumOfFour14.toString()) > 5) {
                        var strArray = convertStringToArray(sumOfFour14.toString())
                        fourResult14 = strArray[5]
                    }

                    if (countDigits(sumOfFour25.toString()) in 1..5) {
                        var strArray = convertStringToArray(sumOfFour25.toString())
                        Log.d("Result", "$strArray")
                        if (strArray.size == 1) fourResult25 = strArray[0]
                        if (strArray.size == 2) fourResult25 = strArray[1]
                        if (strArray.size == 3) fourResult25 = strArray[2]
                        if (strArray.size == 4) fourResult25 = strArray[3]
                        if (strArray.size == 5) fourResult25 = strArray[4]

                    } else if (countDigits(sumOfFour25.toString()) > 5) {
                        var strArray = convertStringToArray(sumOfFour25.toString())
                        fourResult25 = strArray[5]
                    }

                    if (countDigits(sumOfFour36.toString()) in 1..5) {
                        var strArray = convertStringToArray(sumOfFour36.toString())
                        Log.d("Result", "$strArray")
                        if (strArray.size == 1) fourResult36 = strArray[0]
                        if (strArray.size == 2) fourResult36 = strArray[1]
                        if (strArray.size == 3) fourResult36 = strArray[2]
                        if (strArray.size == 4) fourResult36 = strArray[3]
                        if (strArray.size == 5) fourResult36 = strArray[4]

                    } else if (countDigits(sumOfFour36.toString()) > 5) {
                        var strArray = convertStringToArray(sumOfFour36.toString())
                        fourResult36 = strArray[5]
                    }

                    var threeNumbers = ThreeNumbers(
                        fourResult14!!.toInt(),
                        fourResult25!!.toInt(),
                        fourResult36!!.toInt()
                    )
                    threeNumberList.add(threeNumbers)
                }
                if (i == 30) {
                    val seven14 = sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14 * sumOfSpinner14
                    val seven25 = sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25 * sumOfSpinner25
                    val seven36 = sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36 * sumOfSpinner36

                    val sumOfFour14 = getSumOfDigits(seven14)
                    val sumOfFour25 = getSumOfDigits(seven25)
                    val sumOfFour36 = getSumOfDigits(seven36)

                    var fourResult14: String? = null
                    var fourResult25: String? = null
                    var fourResult36: String? = null

                    if (countDigits(sumOfFour14.toString()) in 1..5) {
                        var strArray = convertStringToArray(sumOfFour14.toString())
                        Log.d("Result", "$strArray")
                        if (strArray.size == 1) fourResult14 = strArray[0]
                        if (strArray.size == 2) fourResult14 = strArray[1]
                        if (strArray.size == 3) fourResult14 = strArray[2]
                        if (strArray.size == 4) fourResult14 = strArray[3]
                        if (strArray.size == 5) fourResult14 = strArray[4]

                    } else if (countDigits(sumOfFour14.toString()) > 5) {
                        var strArray = convertStringToArray(sumOfFour14.toString())
                        fourResult14 = strArray[5]
                    }

                    if (countDigits(sumOfFour25.toString()) in 1..5) {
                        var strArray = convertStringToArray(sumOfFour25.toString())
                        Log.d("Result", "$strArray")
                        if (strArray.size == 1) fourResult25 = strArray[0]
                        if (strArray.size == 2) fourResult25 = strArray[1]
                        if (strArray.size == 3) fourResult25 = strArray[2]
                        if (strArray.size == 4) fourResult25 = strArray[3]
                        if (strArray.size == 5) fourResult25 = strArray[4]

                    } else if (countDigits(sumOfFour25.toString()) > 5) {
                        var strArray = convertStringToArray(sumOfFour25.toString())
                        fourResult25 = strArray[5]
                    }

                    if (countDigits(sumOfFour36.toString()) in 1..5) {
                        var strArray = convertStringToArray(sumOfFour36.toString())
                        Log.d("Result", "$strArray")
                        if (strArray.size == 1) fourResult36 = strArray[0]
                        if (strArray.size == 2) fourResult36 = strArray[1]
                        if (strArray.size == 3) fourResult36 = strArray[2]
                        if (strArray.size == 4) fourResult36 = strArray[3]
                        if (strArray.size == 5) fourResult36 = strArray[4]

                    } else if (countDigits(sumOfFour36.toString()) > 5) {
                        var strArray = convertStringToArray(sumOfFour36.toString())
                        fourResult36 = strArray[5]
                    }

                    var threeNumbers = ThreeNumbers(
                        fourResult14!!.toInt(),
                        fourResult25!!.toInt(),
                        fourResult36!!.toInt()
                    )
                    threeNumberList.add(threeNumbers)
                }
            }
            var threePredictorAdapter: ThreePredictorAdapter = ThreePredictorAdapter(threeNumberList)
            binding.recyclerview3column.adapter = threePredictorAdapter
        }

    }

    fun getSumOfDigits(number: Int): Int {
        var number = number
        var sum = 0
        while (number > 0) {
            val r = number % 10
            sum += r
            number /= 10
        }
        return sum
    }

    fun countDigits(str: String): Int = str.filter { Character.isDigit(it) }.count()

    fun convertStringToArray(str: String): Array<String> {
        return str.toCharArray().map { it.toString() }.toTypedArray()
    }
}