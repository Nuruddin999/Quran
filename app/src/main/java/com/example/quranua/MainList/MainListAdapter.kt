package com.example.quranua.MainList

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat.startActivity
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.quranua.BaseFragment
import com.example.quranua.GLobalSearch.GlobalSearchActivity

import com.example.quranua.MainActivity
import com.example.quranua.Model.Sura
import com.example.quranua.R
import com.example.quranua.SearchViewholder
import com.example.quranua.SuraDetails.SuraDetailsFragment

open class MainListAdapter(
    var list: ArrayList<Sura>,
    var context: Context,
    var activity: FragmentActivity?
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun getItemViewType(position: Int): Int {
        return if (position == 0) 1
        else 2
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType==1){
            var view = LayoutInflater.from(context).inflate(R.layout.search_field, parent, false)
            SearchViewholder (view)
        }else {
            var view = LayoutInflater.from(context).inflate(R.layout.main_list_item, parent, false)
            MainListViewHolder(view)
        }
    }

    override fun getItemCount(): Int {
        return list.size+1
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
when(holder.itemViewType){
    1->{
        var searchViewholder:SearchViewholder= holder as SearchViewholder
        searchViewholder.searchfield.setOnClickListener {
            var intent = Intent(context, GlobalSearchActivity::class.java)
            context.startActivity(intent)
        }
    }
    2->{
        var holder:MainListViewHolder=holder as MainListViewHolder
        var sura = list[position-1]
        holder.suraname.text = sura.suraname
        holder.suraukrname.text = sura.translation
        holder.suraindex.text = "${sura.suraindex.toString()}."
        holder.downloadicon.setImageResource(R.drawable.cloud_computing_2x)
        holder.mainlistlayout.setOnClickListener {
            var fragment = SuraDetailsFragment()
            var bundle = Bundle()
            bundle.putInt("suranumb", sura.suraindex!!)
            fragment.arguments = bundle
            BaseFragment().getFragment(fragment, R.id.fragment_content, activity as AppCompatActivity)

        }
    }
}




    }

    fun filterList(newlist: ArrayList<Sura>) {
        list = newlist
        notifyDataSetChanged()
    }
}