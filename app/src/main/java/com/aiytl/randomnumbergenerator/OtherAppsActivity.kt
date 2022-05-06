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
        listItems.add(DataItems(R.drawable.ic_android, "Android", "AIYTL Games"))
        listItems.add(DataItems(R.drawable.ic_android, "Android", "AIYTL Games"))
        listItems.add(DataItems(R.drawable.ic_android, "Android", "AIYTL Games"))
        listItems.add(DataItems(R.drawable.ic_android, "Android", "AIYTL Games"))
        listItems.add(DataItems(R.drawable.ic_android, "Android", "AIYTL Games"))
        listItems.add(DataItems(R.drawable.ic_android, "Android", "AIYTL Games"))
        listItems.add(DataItems(R.drawable.ic_android, "Android", "AIYTL Games"))
        listItems.add(DataItems(R.drawable.ic_android, "Android", "AIYTL Games"))
        listItems.add(DataItems(R.drawable.ic_android, "Android", "AIYTL Games"))

        val myAdapter : MyRecyclerViewAdapter = MyRecyclerViewAdapter(listItems, context)
        binding.recyclerview.adapter = myAdapter

    }
}