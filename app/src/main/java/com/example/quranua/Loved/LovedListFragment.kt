package com.example.quranua.Loved

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.quranua.Database
import com.example.quranua.R
import com.example.quranua.SuraDetails.SuraDetailsFragment

class LovedListFragment: SuraDetailsFragment() {
 var adptr:LovedAdapter?=null
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view = inflater.inflate(R.layout.activity_sura_details, container, false)
        recyclerView = view.findViewById(R.id.sura_details_list)
        layoutManager = LinearLayoutManager(context)
        var database= Database(context!!)
       var bookmark= database.readdata("yes")
        adptr= LovedAdapter(bookmark, context!!, activity)
        recyclerView!!.layoutManager=layoutManager
        recyclerView!!.adapter=adptr

        return view
    }
}