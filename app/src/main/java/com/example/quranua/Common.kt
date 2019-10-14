package com.example.quranua

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import com.example.quranua.Model.Sura
import com.example.quranua.Model.Verse
import org.json.JSONObject

object Common:AppCompatActivity() {
    var suras=ArrayList<Sura>()
    var verses=ArrayList<Verse>()
   /* fun getAllSuras(context:Context):ArrayList<Sura>{
        var json: String? = null
        var jsonquranarabik:String?=null
        for (i in 1..114) {
            try {

                var inpstr = context!!.assets.open("quranJson/${i}.json")
                json = inpstr.bufferedReader().use { it.readText() }
                inpstr.close()
                inpstr = context!!.assets.open("Arabic JSON/surah_${i}.json")
                jsonquranarabik=inpstr.bufferedReader().use { it.readText() }
                inpstr.close()
                var jsonobj = JSONObject(json)
                var arabjsonobj=JSONObject(jsonquranarabik)
                var sura=Sura()
                sura.suraname=jsonobj.getString("")
            } catch (){}
    }
}*/
}