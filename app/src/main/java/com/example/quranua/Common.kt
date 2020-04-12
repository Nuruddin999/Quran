package com.example.quranua

import android.content.Context
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.quranua.Model.GlobalSearchResult
import com.example.quranua.Model.Room.Ayat
import com.example.quranua.Model.Room.AyatRoomDatabase
import com.example.quranua.Model.Sura
import com.example.quranua.Model.Verse
import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.Default
import kotlinx.coroutines.Dispatchers.Main
import org.json.JSONObject
import java.io.InputStream
import kotlin.random.Random

object Common : AppCompatActivity() {
    var surasList = ArrayList<Sura>()
    var list = ArrayList<Sura>()
    fun getAllSuras(context: Context): java.util.ArrayList<Sura> {
        var suras = java.util.ArrayList<Sura>()

        var json: String? = null
        var jsonquranarabik: String? = null
        for (i in 1..114) {

            try {
                var inpstr: InputStream = context.assets.open("quranJson/${i}.json")
                json = inpstr.bufferedReader().use { it.readText() }
                inpstr.close()
                inpstr = context.assets.open("Arabic JSON/surah_${i}.json")
                jsonquranarabik = inpstr.bufferedReader().use { it.readText() }
                inpstr.close()
                var jsonquranarabikobject = JSONObject(jsonquranarabik)
                var versearabik = jsonquranarabikobject.getJSONObject("verse")
                var jsonobj = JSONObject(json)
                var verse = jsonobj.getJSONObject("verse")
                var suraName = jsonobj.getString("name")
                var suracount = jsonobj.getString("count")
                var suranameeng = jsonquranarabikobject.getString("name")
                var translation = jsonobj.getString("translation")
                var sura = Sura(i, suraName, translation, suranameeng,jsonobj.getInt("count"), null)
                var globalSearchResult = GlobalSearchResult()
                var verses = ArrayList<Verse>()

                for (v in 1..Integer.parseInt(suracount)) {
                    var ayat = Verse(
                        v.toString(), verse.getString("$v"),
                        versearabik.getString("verse_$v")
                    )
                    verses.add(ayat)
                    sura.verses = verses
                }
                suras!!.add(sura)
            } catch (e: Exception) {
                Log.e("error", e.message)
            }
        }
        return suras
    }

    fun getAllAyats(context: Context): java.util.ArrayList<GlobalSearchResult> {
        var globalSearchResultList = java.util.ArrayList<GlobalSearchResult>()
        var json: String? = null
        var jsonquranarabik: String? = null
        for (i in 1..114) {
            try {
                var inpstr: InputStream = context.assets.open("quranJson/${i}.json")
                json = inpstr.bufferedReader().use { it.readText() }
                inpstr.close()
                inpstr = context.assets.open("Arabic JSON/surah_${i}.json")
                jsonquranarabik = inpstr.bufferedReader().use { it.readText() }
                inpstr.close()
                var jsonquranarabikobject = JSONObject(jsonquranarabik)
                var versearabik = jsonquranarabikobject.getJSONObject("verse")
                var jsonobj = JSONObject(json)
                var verse = jsonobj.getJSONObject("verse")
                var suraName = jsonobj.getString("name")
                var suracount = jsonobj.getString("count")
                var suraindex = jsonobj.getString("index")
                var translation = jsonobj.getString("translation")
                for (v in 1..Integer.parseInt(suracount)) {
                    var globalSearchResult = GlobalSearchResult()
                    globalSearchResult.versearab = versearabik.getString("verse_$v")
                    globalSearchResult.verseUkr = verse.getString("$v")
                    globalSearchResult.suraIndex = suraindex
                    globalSearchResult.suraName = suraName
                    globalSearchResult.suraTranslation = translation
                    globalSearchResult.verseNumber = v.toString()
                    globalSearchResult.ayatCount = suracount
                    globalSearchResultList.add(globalSearchResult)
                }

            } catch (e: Exception) {
                Log.e("error", e.message)
            }

        }


        return globalSearchResultList
    }
}