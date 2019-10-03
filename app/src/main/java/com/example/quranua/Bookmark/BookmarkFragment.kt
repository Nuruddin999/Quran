package com.example.quranua.Bookmark

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.quranua.BaseFragment
import com.example.quranua.Database
import com.example.quranua.Model.Bookmark
import com.example.quranua.R

class BookmarkFragment: BaseFragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
       var view=inflater.inflate(R.layout.bookmark_fragment,container,false)
        recyclerView=view.findViewById(R.id.bookmark_recyclerview)
        layoutManager=LinearLayoutManager(context)

var db=Database(context!!)


        adapter=BookMarkAdapter( db.readdata("no"),context!!,activity)as RecyclerView.Adapter<RecyclerView.ViewHolder>
        makeListView()
        return view
    }
}