package com.aiytl.randomnumbergenerator.addapter

import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.aiytl.randomnumbergenerator.model.DataItems
import com.aiytl.randomnumbergenerator.R

class OtherAppsAdapter(private val items : List<DataItems>, private val context : Context) : RecyclerView.Adapter<OtherAppsAdapter.MyViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view : View = LayoutInflater.from(parent.context).inflate(R.layout.layout_items, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val dataItems : DataItems? = items[position]
        holder.imageView.setImageResource(dataItems!!.imgeResource)
        holder.itemName.setText(dataItems!!.itemName)
        holder.itemProviderName.setText(dataItems!!.itemProviderName)

        holder.imageView.setOnClickListener {
//            Toast.makeText(context, items[position].itemName, Toast.LENGTH_SHORT).show()
            openPlayStoreApp(dataItems!!.packageName)
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView : ImageView = itemView.findViewById(R.id.item_imageview);
        val itemName : TextView = itemView.findViewById(R.id.tv_itemname)
        val itemProviderName : TextView = itemView.findViewById(R.id.tv_item_providetr_name)
    }

    fun openPlayStoreApp(pkgName:String?){
        if(!pkgName.isNullOrEmpty()) {
            try {
                context.startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=$pkgName")))
            } catch (e: ActivityNotFoundException) {
                context.startActivity(
                    Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse("https://play.google.com/store/apps/details?id=$pkgName")
                    )
                )
            }
        }
    }
}