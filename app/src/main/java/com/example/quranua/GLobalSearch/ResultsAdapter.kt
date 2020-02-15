package com.example.quranua.GLobalSearch

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.quranua.Model.GlobalSearchResult
import com.example.quranua.Model.Sura
import com.example.quranua.Model.Verse
import com.example.quranua.R

class ResultsAdapter(
    var context: Context
) : RecyclerView.Adapter<ResultsViewHolder>() {
    var previousindex: Int = -1
    var list= emptyList<GlobalSearchResult>()
    var suraName=""
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ResultsViewHolder {
        var view = LayoutInflater.from(context).inflate(R.layout.sura_details_item, parent, false)
        return ResultsViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list!!.size
    }

    override fun onBindViewHolder(holder: ResultsViewHolder, position: Int) {

        var verse = list?.get(position)
        holder.ayanumber.text = verse?.verseNumber
        holder.ayaukr.text = " ${verse?.verseUkr}"
        holder.ayaarabik.text = "${verse?.versearab}"
        holder.suraheader.text=verse.suraName
    }

    internal fun setWords(result: List<GlobalSearchResult>) {
        this.list = result
        notifyDataSetChanged()
    }
}

