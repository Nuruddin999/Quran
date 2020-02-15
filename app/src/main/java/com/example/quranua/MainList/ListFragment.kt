package com.example.quranua.MainList

import android.app.SearchManager
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.quranua.BaseFragment
import com.example.quranua.Model.Sura
import com.example.quranua.Model.Verse
import com.example.quranua.R
import com.example.quranua.Common
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.json.JSONObject

class ListFragment : BaseFragment() {

    var suras: ArrayList<Sura>? = null
    var searchView: SearchView? = null
    var adptr: MainListAdapter? = null
    var verses: ArrayList<Verse>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        var view = inflater.inflate(R.layout.activity_list_main, container, false)
        recyclerView = view.findViewById(R.id.main_list_recycler)
        layoutManager = LinearLayoutManager(context)
        var json: String? = null
        suras = Common.getAllSuras(context!!)
        verses = ArrayList<Verse>()
        adptr = MainListAdapter(suras!!, context!!, this.activity)
        recyclerView!!.layoutManager = layoutManager
        recyclerView!!.adapter = adptr
        return view
    }

    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
        inflater!!.inflate(R.menu.nav_drawer, menu)

        val searchItem = menu!!.findItem(R.id.action_search)
        // Optional: if you want to expand SearchView from icon to edittext view

    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item!!.itemId) {
            R.id.action_search -> {
                Log.d("search icon", "search selected")

            }
        }
        return true
    }

}