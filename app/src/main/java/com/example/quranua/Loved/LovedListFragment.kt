package com.example.quranua.Loved

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.quranua.Database
import com.example.quranua.R
import com.example.quranua.SuraDetails.SuraDetailsFragment
import com.example.quranua.SwipeToDeleteCallback
import kotlinx.android.synthetic.main.activity_sura_details.*


class LovedListFragment: SuraDetailsFragment() {
 var adptr:LovedAdapter?=null
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        activity?.title="Улюбленi"
        var view = inflater.inflate(R.layout.activity_sura_details, container, false)
        recyclerView = view.findViewById(R.id.sura_details_list)
        var search:EditText=view.findViewById(R.id.search_edittext_details)
        search.visibility=EditText.GONE
        layoutManager = LinearLayoutManager(context)
        var database= Database(context!!)
       var bookmark= database.readdata("yes")
        adptr= LovedAdapter(bookmark, context!!, activity)
        recyclerView!!.layoutManager=layoutManager
        recyclerView!!.adapter=adptr
        var swipehelper= object : SwipeToDeleteCallback(context!!){
            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                var pos=viewHolder.adapterPosition
                adptr!!.removeAt(pos)

            }

        }
        var touchHelper= ItemTouchHelper(swipehelper)
        touchHelper.attachToRecyclerView(recyclerView)
        return view
    }
}