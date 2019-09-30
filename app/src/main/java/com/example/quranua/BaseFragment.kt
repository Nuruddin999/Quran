package com.example.quranua

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView

open class BaseFragment:Fragment() {
    var fragment = Fragment()
    var view: Int? = null
    var recyclerView: RecyclerView? = null
    var layoutManager: RecyclerView.LayoutManager? = null
    var adapter: RecyclerView.Adapter<RecyclerView.ViewHolder>? = null
    fun getFragment(fragment: Fragment, view: Int, activity: AppCompatActivity) {
        activity.supportFragmentManager
        var fragmentTransaction = activity.supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(view, fragment)
        fragmentTransaction.commit()
    }

    fun makeListView() {
        if (recyclerView != null && layoutManager != null && adapter != null) {
            recyclerView!!.layoutManager = layoutManager
            recyclerView!!.adapter = adapter
        }
    }
}