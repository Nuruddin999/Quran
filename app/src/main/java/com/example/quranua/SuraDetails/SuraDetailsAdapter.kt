package com.example.quranua.SuraDetails

import android.content.Context
import android.graphics.Color
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.RelativeLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.quranua.DBHelper
import com.example.quranua.Model.Sura
import com.example.quranua.Model.Verse
import com.example.quranua.R

class SuraDetailsAdapter(
    var list: ArrayList<Verse>,
    var context: Context,
  var  sura: Sura
) : RecyclerView.Adapter<SuraDetailsViewHolder>() {
    var previousindex:Int=-1
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SuraDetailsViewHolder {
        var view=LayoutInflater.from(context).inflate(R.layout.sura_details_item,parent,false )
        return SuraDetailsViewHolder(view)
    }

    override fun getItemCount(): Int {
        return  list.size
    }

    override fun onBindViewHolder(holder: SuraDetailsViewHolder, position: Int) {

  var verse=list[position]
        holder.contextmenu.setBackgroundColor(Color.BLUE)
        holder.ayaukr.text="${verse.ayaindex}  ${verse.ayaukr}"
        holder.ayaarabik.text="${verse.ayaarab}"
        holder.container.setOnClickListener {
            Log.d("suradetals","container clicks")
            previousindex=position
            notifyDataSetChanged()
        }
        if (previousindex==position){
            holder.contextmenu.visibility=RelativeLayout.VISIBLE
        }
        else {
            holder.contextmenu.visibility=RelativeLayout.GONE
        }
        holder.addbookmark.setOnClickListener {
            var db=DBHelper(context)
            db.inserdata(sura,position)

        }



    }

}