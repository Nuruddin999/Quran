package com.example.quranua.SuraDetails

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.quranua.BaseFragment
import com.example.quranua.GLobalSearch.GlobalSearchActivity
import com.example.quranua.Model.Sura
import com.example.quranua.Model.Verse
import com.example.quranua.NavDrawerActivity
import com.example.quranua.R
import org.json.JSONObject

open class SuraDetailsFragment : BaseFragment() {
open var adapter:SuraDetailsAdapter?=null
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view = inflater.inflate(R.layout.activity_sura_details, container, false)
        recyclerView = view.findViewById(R.id.sura_details_list)
        layoutManager = LinearLayoutManager(context)
        val searchedittext: EditText =view.findViewById(R.id.search_edittext_details)
        searchedittext.visibility=EditText.GONE
        searchedittext.setOnClickListener {
            var intent = Intent(context, GlobalSearchActivity::class.java)
            startActivity(intent)
        }
        var json: String? = null
        var jsonquranarabik: String? = null
        var sura = Sura()
        var suranumber = arguments!!.getInt("suranumb", 0)
    var   pos=arguments!!.getInt("pos")
        var verses = ArrayList<Verse>()
        Log.d("suranumber", suranumber.toString())
        try {
            var inpstr = context!!.assets.open("quranJson/${suranumber}.json")
            json = inpstr.bufferedReader().use { it.readText() }
            inpstr.close()
            inpstr = context!!.assets.open("Arabic JSON/surah_${suranumber}.json")
            jsonquranarabik = inpstr.bufferedReader().use { it.readText() }
            inpstr.close()
            var jsonobj = JSONObject(json)
            var jsonquranarabikobject = JSONObject(jsonquranarabik)
            Log.d("suradetails", "$jsonquranarabikobject")
            var verse = jsonobj.getJSONObject("verse")
            var versearabik = jsonquranarabikobject.getJSONObject("verse")
            var o = jsonobj.getString("name")
            sura.suraname = o
            sura.count = jsonobj.getString("count").toInt()
            sura.translation = jsonobj.getString("translation")
            sura.suraindex = jsonobj.getString("index").toInt()
            for (i in 1..300) {
                if (!verse.getString("$i").isNullOrBlank()) {
                    var verse = Verse(i.toString(), verse.getString("$i"), versearabik.getString("verse_$i"))
                    verses.add(verse)
                    sura.verses = verses
                }
            }
        } catch (e: Exception) {
        }
        adapter = SuraDetailsAdapter(sura.verses!!, context!!, sura)
        recyclerView!!.layoutManager=layoutManager
        recyclerView!!.adapter=adapter
        if (pos!=null){
            recyclerView!!.scrollToPosition(pos)
        }
        /*recyclerView!!.adapter=adapter
        recyclerView!!.layoutManager=layoutManager*/
        // recyclerView!!.scrollToPosition()



        return view
    }
}