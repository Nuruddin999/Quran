package com.example.quranua.GLobalSearch

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.quranua.BaseFragment
import com.example.quranua.Database
import com.example.quranua.Model.GlobalSearchResult
import com.example.quranua.Model.Sura
import com.example.quranua.Model.Verse
import com.example.quranua.NewSuraDetailed
import com.example.quranua.R
import com.example.quranua.SuraDetails.SuraDetailsFragment
import com.example.quranua.SuraDetails.SuraDetailsViewHolder

class ResultsAdapter(
    var context: Context,
var activity: AppCompatActivity) : RecyclerView.Adapter<SuraDetailsViewHolder>() {
    var previousindex: Int = -1
    var list= emptyList<GlobalSearchResult>()
    var suraName=""
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SuraDetailsViewHolder {
        var view = LayoutInflater.from(context).inflate(R.layout.sura_details_item, parent, false)
        return SuraDetailsViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list!!.size
    }

    override fun onBindViewHolder(holder: SuraDetailsViewHolder, position: Int) {
        var verse = list?.get(position)
        holder.ayanumber.text = verse?.verseNumber
        holder.ayaukr.text = " ${verse?.verseUkr}"
        holder.ayaarabik.text = "${verse?.versearab}"
        holder.suraheader.text=verse.suraName
        holder.contextmenu.visibility = RelativeLayout.GONE
        holder.container.setOnClickListener {
            var intent= Intent(context, NewSuraDetailed::class.java)
            intent.putExtra("pos", verse.verseNumber.toInt()+1)
            intent.putExtra("suranumb", verse.suraIndex.toInt()!!)
            context.startActivity(intent)
        }

    }

    internal fun setWords(result: List<GlobalSearchResult>) {
        this.list = result
        notifyDataSetChanged()
    }
}

