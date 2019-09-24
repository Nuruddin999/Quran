package com.example.quranua.MainList

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.quranua.Model.Sura
import com.example.quranua.R
import org.json.JSONObject

class ListMain : AppCompatActivity() {
    lateinit var recyclerView: RecyclerView
    lateinit var adapter: MainListAdapter
    lateinit var layoutManager: LinearLayoutManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_main)
        recyclerView=findViewById(R.id.main_list_recycler)
        layoutManager= LinearLayoutManager(this@ListMain)
        var json:String?=null
        var suras=ArrayList<Sura>()
        for (i in 1..114) {
            try {

                var inpstr = this@ListMain.assets.open("quranJson/${i}.json")
                json = inpstr.bufferedReader().use { it.readText() }
                inpstr.close()
                var jsonobj = JSONObject(json)
                var verse=jsonobj.getJSONObject("verse")

                var o = jsonobj.getString("name")
                var sura= Sura(i,o,jsonobj.getString("translation"),jsonobj.getInt("count"),null)
                suras.add(sura)
                Log.d("name",o )


            } catch (e: Exception) {

            }
        }

        adapter= MainListAdapter(suras, this)
        recyclerView.layoutManager=layoutManager
        recyclerView.adapter=adapter

    }
    }

