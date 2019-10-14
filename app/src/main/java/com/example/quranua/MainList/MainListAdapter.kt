package com.example.quranua.MainList

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.quranua.BaseFragment

import com.example.quranua.MainActivity
import com.example.quranua.Model.Sura
import com.example.quranua.R
import com.example.quranua.SuraDetails.SuraDetailsFragment

open class MainListAdapter(
    var list: ArrayList<Sura>,
    var context: Context,
   var  activity: FragmentActivity?
):RecyclerView.Adapter<MainListViewHolder>() {
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
          var fragment=SuraDetailsFragment()
            var bundle=Bundle()
            bundle.putInt("suranumb",sura.suraindex!!)
            fragment.arguments=bundle
BaseFragment().getFragment(fragment,R.id.fragment_content, activity as AppCompatActivity)

        }
    }
   fun filterList(newlist:ArrayList<Sura>){
        list=newlist
        notifyDataSetChanged()
    }
}