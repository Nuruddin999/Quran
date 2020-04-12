package com.example.quranua.SuraDetails

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.quranua.Database
import com.example.quranua.GLobalSearch.GlobalSearchActivity
import com.example.quranua.MainList.MainListViewHolder
import com.example.quranua.Model.Sura
import com.example.quranua.Model.Verse
import com.example.quranua.R
import com.example.quranua.SearchViewholder

open class SuraDetailsAdapter(
    var list: ArrayList<Verse>,
    var context: Context,
    var sura: Sura
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    var previousindex: Int = -1
    override fun getItemViewType(position: Int): Int {
        return when (position) {
            0 -> 1
            1 -> 2
            else -> 3
        }

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            1 -> {
                var view = LayoutInflater.from(context).inflate(R.layout.search_field, parent, false)
                SearchViewholder (view)
            }
            2 -> {
                var view = LayoutInflater.from(context).inflate(R.layout.start_suradetails_layout, parent, false)
                StartViewholder(view)
            }
            else -> {
                var view = LayoutInflater.from(context).inflate(R.layout.sura_details_item, parent, false)
                return SuraDetailsViewHolder(view) }
        }
    }

    override fun getItemCount(): Int {
        return list.size+2
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        val sharedPref = context.getSharedPreferences("settings", Context.MODE_PRIVATE)
        var set = sharedPref.getBoolean("Arabictext", false)
        when(holder.itemViewType){
            1->{
                var searchViewholder:SearchViewholder= holder as SearchViewholder
                searchViewholder.searchfield.setOnClickListener {
                    var intent = Intent(context, GlobalSearchActivity::class.java)
                    context.startActivity(intent)
                }
            }
            2->{
                var holder:StartViewholder=holder as StartViewholder
                holder.suratitle.text=sura.nameeng
                holder.suratitleukr.text=sura.translation
                holder.surabismi.text="Ім’ям Аллага Милостивого, Милосердного!"
                holder.suratitlebismiarab.text="بِسْمِ اللَّهِ الرَّحْمَٰنِ الرَّحِيمِ"
            }
            3->{
                var verse = list[position-2]
                var holder:SuraDetailsViewHolder=holder as SuraDetailsViewHolder
                if (!sharedPref.contains("Arabictext")) {
                    holder.ayaarabik.visibility = View.GONE
                }
                if (!sharedPref.contains("Textsize")) {
                    holder.ayaarabik.textSize=sharedPref.getInt("Textsize",12).toFloat()
                    holder.ayaukr.textSize=sharedPref.getInt("Textsize",12).toFloat()
                }

                holder.contextmenu.setBackgroundColor(Color.BLUE)
                holder.ayanumber.text = verse.ayaindex
                holder.ayaukr.text = " ${verse.ayaukr}"
                holder.ayaarabik.text = "${verse.ayaarab}"
                holder.container.setOnClickListener {
                    if (    holder.contextmenu.visibility == RelativeLayout.VISIBLE){
                        holder.contextmenu.visibility = RelativeLayout.GONE
                        return@setOnClickListener
                    }
                    Log.d("suradetals", "container clicks")
                    previousindex = position
                    notifyDataSetChanged()
                }
                holder.suraheader.visibility = TextView.GONE
                var db = Database(context)
                if (previousindex == position) {
                    holder.contextmenu.visibility = RelativeLayout.VISIBLE
                } else {
                    holder.contextmenu.visibility = RelativeLayout.GONE
                }
                holder.addbookmark.setOnClickListener {
                    Log.d("db", "${verse.ayaukr} ${verse.ayaarab}  ${verse.ayaindex} ")

                    db.inserdata(
                        sura.suraname!!,
                        position,
                        sura.suraindex!!,
                        sura.translation!!,
                        verse.ayaindex!!.toInt(),
                        verse.ayaukr!!,
                        verse.ayaarab!!,
                        "no"
                    )
                }
                holder.share.setOnClickListener {
                    db.inserdata(
                        sura.suraname!!,
                        position,
                        sura.suraindex!!,
                        sura.translation!!,
                        verse.ayaindex!!.toInt(),
                        verse.ayaukr!!,
                        verse.ayaarab!!,
                        "yes"
                    )
                }
            }
        }

        Log.d("Arabictext  ", set.toString())

    }

    fun filterList(newlist: ArrayList<Verse>, newsura: Sura) {
        list = newlist
        sura = newsura
        notifyDataSetChanged()
    }

}