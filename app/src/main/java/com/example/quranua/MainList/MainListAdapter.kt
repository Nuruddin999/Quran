package com.example.quranua.MainList

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.quranua.Model.Sura
import com.example.quranua.R
import com.example.quranua.SuraDetails.SuraDetails

open class MainListAdapter(var list:ArrayList<Sura>, var context: Context):RecyclerView.Adapter<MainListViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainListViewHolder {
var view=LayoutInflater.from(context).inflate(R.layout.main_list_item,parent,false)
        return MainListViewHolder(view)
    }

    override fun getItemCount(): Int {
    return list.size
    }

    override fun onBindViewHolder(holder: MainListViewHolder, position: Int) {
var sura=list[position]
        holder.suraname.text=sura.suraname
        holder.suraindex.text="${sura.suraindex.toString()}."
        holder.downloadicon.setImageResource(R.drawable.cloud_computing_2x)
        holder.mainlistlayout.setOnClickListener {
           var intent=Intent(context,SuraDetails::class.java)
            intent.putExtra("suranumb",sura.suraindex)
            context.startActivity(intent)

        }
    }
}