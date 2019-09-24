package com.example.quranua

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.quranua.MainList.ListMain
import com.example.quranua.MainList.MainListAdapter

class MainActivity : AppCompatActivity() {
    lateinit var recyclerView: RecyclerView
    lateinit var adapter: MainListAdapter
    lateinit var layoutManager: LinearLayoutManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_list_layout)
   /*     recyclerView=findViewById(R.id.main_list_recycler)
        layoutManager= LinearLayoutManager(this)
        var json:String?=null
        var suras=ArrayList<Sura>()
        for (i in 1..114) {
            try {

                var inpstr = applicationContext.assets.open("quranJson/${i}.json")
                json = inpstr.bufferedReader().use { it.readText() }
                inpstr.close()
                var jsonobj = JSONObject(json)
                var verse=jsonobj.getJSONObject("verse")

                var o = jsonobj.getString("name")
                var sura= Sura(Integer.parseInt(jsonobj.getString("index")),o,null)
                suras.add(sura)
                Log.d("name",o )


            } catch (e: Exception) {

            }
        }

        adapter= MainListAdapter(suras,this)
        recyclerView.layoutManager=layoutManager
        recyclerView.adapter=adapter*/
        var intent=Intent(this@MainActivity, ListMain::class.java)
        startActivity(intent)

    }


    }

