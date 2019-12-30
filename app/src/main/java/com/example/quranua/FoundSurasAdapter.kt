package com.example.quranua

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.quranua.Model.Sura
import com.example.quranua.SuraDetails.SuraDetailsViewHolder

class FoundSurasAdapter(var list: ArrayList<Sura>, var context: Context) :
    RecyclerView.Adapter<FoundSurasviewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoundSurasviewHolder {
        var viewHolder = LayoutInflater.from(context).inflate(R.layout.foundsurasitem_layout, parent, false)
        return FoundSurasviewHolder(viewHolder)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: FoundSurasviewHolder, position: Int) {

        holder.container.setOnClickListener {
            Log.d("foundsuracontainer","works")
        }
        holder.suraheader.text = list[position].suraname
        for (verse in list[position].verses!!) {
            holder.ayaukr.text = verse.ayaukr
            holder.ayaarabik.text = verse.ayaarab
            holder.ayanumber.text = verse.ayaindex
        }
    }

}