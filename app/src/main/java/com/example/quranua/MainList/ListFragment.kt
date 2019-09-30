package com.example.quranua.MainList

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.quranua.BaseFragment
import com.example.quranua.Model.Sura
import com.example.quranua.R
import org.json.JSONObject

class ListFragment : BaseFragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        var view = inflater.inflate(R.layout.activity_list_main, container, false)
        recyclerView = view.findViewById(R.id.main_list_recycler)
        layoutManager = LinearLayoutManager(context)
        var json: String? = null
        var suras = ArrayList<Sura>()
        for (i in 1..114) {
            try {

                var inpstr = context!!.assets.open("quranJson/${i}.json")
                json = inpstr.bufferedReader().use { it.readText() }
                inpstr.close()
                var jsonobj = JSONObject(json)
                var verse = jsonobj.getJSONObject("verse")

                var o = jsonobj.getString("name")
                var sura = Sura(i, o, jsonobj.getString("translation"), jsonobj.getInt("count"), null)
                suras.add(sura)
                Log.d("name", o)


            } catch (e: Exception) {

            }
        }

        adapter = MainListAdapter(suras, context!!, this.activity) as RecyclerView.Adapter<RecyclerView.ViewHolder>
        makeListView()
        return view
    }
}