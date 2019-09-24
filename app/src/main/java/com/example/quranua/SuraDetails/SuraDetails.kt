package com.example.quranua.SuraDetails

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.quranua.Model.Sura
import com.example.quranua.Model.Verse
import com.example.quranua.R
import org.json.JSONObject

class SuraDetails : AppCompatActivity() {
    lateinit var recyclerView: RecyclerView
   lateinit var adapter:SuraDetailsAdapter
    lateinit var layoutManager: LinearLayoutManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sura_details)
        recyclerView=findViewById(R.id.sura_details_list)
        layoutManager= LinearLayoutManager(this@SuraDetails)
        var json:String?=null
        var jsonquranarabik:String?=null
        var sura=Sura()

        var verses=ArrayList<Verse>()
var intent=intent
        var suranumber=intent.getIntExtra("suranumb",0)
        Log.d("suranumber",suranumber.toString())
        try {
            var inpstr = this@SuraDetails.assets.open("quranJson/${suranumber}.json")
            json = inpstr.bufferedReader().use { it.readText() }
            inpstr.close()
            inpstr=this@SuraDetails.assets.open("Arabic JSON/surah_${suranumber}.json")
            jsonquranarabik=inpstr.bufferedReader().use { it.readText() }
            inpstr.close()
            var jsonobj = JSONObject(json)
            var jsonquranarabikobject=JSONObject(jsonquranarabik)
            Log.d("suradetails","$jsonquranarabikobject")
            var verse=jsonobj.getJSONObject("verse")
            var versearabik=jsonquranarabikobject.getJSONObject("verse")
            var o = jsonobj.getString("name")
            sura.suraname=o
            sura.count=jsonobj.getString("count").toInt()
            sura.translation=jsonobj.getString("translation")
            sura.suraindex=jsonobj.getString("index").toInt()
           for (i in 1..300){
                if (!verse.getString("$i").isNullOrBlank()){
                   var verse=Verse(i.toString(),verse.getString("$i"),versearabik.getString("verse_$i"))
                   verses.add(verse)
                    sura.verses=verses
              }
           }
        } catch (e:Exception){

        }
        Log.d("sura","${sura.suraname} ${sura.translation} ${sura.suraindex} ")
       adapter=SuraDetailsAdapter(sura.verses!!,this@SuraDetails,sura)
        recyclerView.layoutManager=layoutManager
        recyclerView.adapter=adapter

    }
}
