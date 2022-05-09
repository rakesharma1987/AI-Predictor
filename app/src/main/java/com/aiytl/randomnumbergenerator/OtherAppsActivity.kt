package com.aiytl.randomnumbergenerator

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.aiytl.randomnumbergenerator.addapter.MyRecyclerViewAdapter
import com.aiytl.randomnumbergenerator.databinding.ActivityOtherAppsBinding
import com.aiytl.randomnumbergenerator.model.DataItems

class OtherAppsActivity : AppCompatActivity() {
    private lateinit var binding : ActivityOtherAppsBinding
    private lateinit var context : Context

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOtherAppsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        context = this
        supportActionBar!!.title = getString(R.string.msg_title_other_apps)

        binding.recyclerview.layoutManager = GridLayoutManager(context, 2)

        var listItems = ArrayList<DataItems>()
        listItems.add(DataItems(R.drawable.ic_live_lotto_app, "Lotto 6/49 Play like real", "AIYTL Games", "com.livelotto.aitylgames"))
        listItems.add(DataItems(R.drawable.ic_keno_app, "Keno Play Like Real", "AIYTL Games", "com.keno.aitylgames"))
        listItems.add(DataItems(R.drawable.ic_christmas_lottery_app, "elGordo Christmas Lottery Live", "AIYTL Games", "com.elgordo.aitylgames"))
        listItems.add(DataItems(R.drawable.ic_lottery_number_generator_app, "Lotto/Lottery Number Generator", "AIYTL Games", "com.staticlotto.aitylgames"))
        listItems.add(DataItems(R.drawable.ic_lottery_generator_australia, "Lottery Generator Australia", "AIYTL Games", "com.lotto.aitylgames"))
        listItems.add(DataItems(R.drawable.ic_who_is_your_true_partner, "Who is Your True Partner", "AIYTL Games", "com.cmp.aityl"))


        val myAdapter : MyRecyclerViewAdapter = MyRecyclerViewAdapter(listItems, context)
        binding.recyclerview.adapter = myAdapter

    }

}