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
import org.json.JSONObject

class ListFragment : BaseFragment(){

var suras:ArrayList<Sura>?=null
    var searchView:SearchView?=null
    var adptr:MainListAdapter?=null
    var verses:ArrayList<Verse>?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        var view = inflater.inflate(R.layout.activity_list_main, container, false)
        recyclerView = view.findViewById(R.id.main_list_recycler)
        layoutManager = LinearLayoutManager(context)
        var json: String? = null
         suras = ArrayList<Sura>()
        verses=ArrayList<Verse>()
        for (i in 1..114) {
            try {

                var inpstr = context!!.assets.open("quranJson/${i}.json")
                json = inpstr.bufferedReader().use { it.readText() }
                inpstr.close()
                var jsonobj = JSONObject(json)
                var verse = jsonobj.getJSONObject("verse")

                var o = jsonobj.getString("name")
                var sura = Sura(i, o, jsonobj.getString("translation"), jsonobj.getInt("count"), null)
                suras!!.add(sura)
                Log.d("name", o)


            } catch (e: Exception) {

            }
        }

        adptr = MainListAdapter(suras!!, context!!, this.activity)
        recyclerView!!.layoutManager=layoutManager
        recyclerView!!.adapter=adptr
        return view
    }

    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
       inflater!!.inflate(R.menu.nav_drawer, menu)

        val searchItem = menu!!.findItem(R.id.action_search)
        // Optional: if you want to expand SearchView from icon to edittext view
        searchItem.expandActionView()
            searchView = searchItem.actionView as SearchView

        searchView!!.setOnQueryTextListener(object :SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                var newList=ArrayList<Sura>()
                Log.d("query","works")
                for (s in suras!!){
                    var name=newText!!.toLowerCase().trim()
                    if (s.suraname!!.contains(name)){
                            newList.add(s)
                        }
                }
                adptr!!.filterList(newList)
                return true
            }
        })
    }

}