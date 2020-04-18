package com.example.quranua.Bookmark

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.quranua.*
import com.example.quranua.Model.Bookmark

class BookmarkFragment: BaseFragment() {
    var adapter:BookMarkAdapter?=null
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        activity?.title="Закладки"
       var view=inflater.inflate(R.layout.bookmark_fragment,container,false)
        recyclerView=view.findViewById(R.id.bookmark_recyclerview)
    //    recyclerView!!.addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
        layoutManager=LinearLayoutManager(context)

var db=Database(context!!)


        adapter=BookMarkAdapter( db.readdata("no"),context!!,activity)
        recyclerView!!.layoutManager=layoutManager
        recyclerView!!.adapter=adapter
        var swipehelper= object :SwipeToDeleteCallback(context!!){
            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                var pos=viewHolder.adapterPosition
                adapter!!.removeAt(pos)

            }

        }
        var touchHelper=ItemTouchHelper(swipehelper)
        touchHelper.attachToRecyclerView(recyclerView)


        return view
    }
}