package com.example.quranua.Loved

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.RelativeLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.quranua.BaseFragment
import com.example.quranua.Database
import com.example.quranua.Model.Bookmark
import com.example.quranua.NewSuraDetailed
import com.example.quranua.R
import com.example.quranua.SuraDetails.SuraDetailsFragment

class LovedAdapter(var bookmark: ArrayList<Bookmark>, var context: Context,  var activity: FragmentActivity?) :
    RecyclerView.Adapter<LovedViewHolder>()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LovedViewHolder {
        var view = LayoutInflater.from(context).inflate(R.layout.sura_details_item, parent, false)
        return LovedViewHolder(view)

    }
    override fun getItemCount(): Int {
        return bookmark.size
    }


    override fun onBindViewHolder(holder: LovedViewHolder, position: Int) {
        holder.contextmenu.visibility=RelativeLayout.GONE
holder.suraheader.text=bookmark[position].suraname
        holder.ayanumber.text=bookmark[position].ayanumber
        holder.ayaukr.text= bookmark[position].ukr
        holder.ayaarabik.text=bookmark[position].arab
        holder.container.setOnClickListener {
            var intent= Intent(context, NewSuraDetailed::class.java)
            intent.putExtra("pos", bookmark[position].suraIndex!!)
            intent.putExtra("suranumb", bookmark[position].suraNumber!!)
            context.startActivity(intent)

        }
    }
    fun removeAt(position: Int) {
        var database= Database(context!!)
        database.deleteData(bookmark[position].suraIndex!!,bookmark[position].loved!!,bookmark[position].ukr!!)

        bookmark.removeAt(position)
        notifyItemRemoved(position)
    }
}