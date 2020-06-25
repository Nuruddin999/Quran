package com.example.quranua.Bookmark

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.quranua.*
import com.example.quranua.Model.Bookmark
import com.example.quranua.Model.Sura
import com.example.quranua.SuraDetails.SuraDetailsFragment
import java.util.*
import kotlin.collections.ArrayList

open class BookMarkAdapter(var bookmark: ArrayList<Bookmark>, var context: Context, var activity: FragmentActivity?) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    var db = Database(context)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        var view = LayoutInflater.from(context).inflate(R.layout.bookmark_item2, parent, false)
        return BookmarkViewHolder(view)
    }

    override fun getItemCount(): Int {
        return bookmark.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        var holder=holder as BookmarkViewHolder
        holder.suraname.text = bookmark[position].suraname
        holder.ukr.text = "${bookmark[position].translation} - аят №${bookmark[position].ayanumber} "
        holder.date.text = "${Date().day}"
        holder.bookmarkbutton.setOnClickListener {

            db.deleteData(position,"no",bookmark[position].ukr!!)
            bookmark.remove(bookmark[position])

            notifyDataSetChanged()
        }
        holder.bookmarkLayout.setOnClickListener {
            var intent=Intent(context,NewSuraDetailed::class.java)
            intent.putExtra("pos", bookmark[position].suraIndex!!)
            intent.putExtra("suranumb", bookmark[position].suraNumber!!)
            context.startActivity(intent)
        }


    }
    fun removeAt(position: Int) {
        db.deleteData(bookmark[position].suraIndex!!,bookmark[position].loved!!,bookmark[position].ukr!!)
        bookmark.removeAt(position)
        notifyItemRemoved(position)
    }
}