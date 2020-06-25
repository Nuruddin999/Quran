package com.example.quranua

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.quranua.GLobalSearch.GlobalSearchActivity
import com.example.quranua.Model.Sura
import com.example.quranua.SuraDetails.SuraDetailsAdapter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.ArrayList

class NewSuraDetailed : AppCompatActivity() {
    var suras = ArrayList<Sura>()
    open var adapter: SuraDetailsAdapter? = null
    suspend fun get() = withContext(Dispatchers.IO) {
        return@withContext Common.getAllSuras(this@NewSuraDetailed)
    }

    suspend fun fetchDocs() {
        // Dispatchers.Main
        suras = get()
        // Dispatchers.Main
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sura_details)
        title="Коран"
        var actionBar = supportActionBar
        actionBar!!.run {
            setHomeButtonEnabled(true)
            setDisplayShowHomeEnabled(true)
        }
        var intent = intent
        var recyclerView: RecyclerView = findViewById(R.id.sura_details_list)
        var layoutManager: LinearLayoutManager = LinearLayoutManager(this)
        val searchedittext: EditText = findViewById(R.id.search_edittext_details)
        searchedittext.visibility = EditText.GONE
        searchedittext.setOnClickListener {
            var intent = Intent(this, GlobalSearchActivity::class.java)
            startActivity(intent)
        }
        var sura = Sura()
        var suranumber = intent!!.getIntExtra("suranumb", 0)
        CoroutineScope(Dispatchers.Main).launch {
            fetchDocs()
            sura = suras.get(suranumber - 1)
            var pos = intent!!.getIntExtra("pos", 0)
            adapter = SuraDetailsAdapter(sura.verses!!, this@NewSuraDetailed, sura)
            recyclerView!!.layoutManager = layoutManager
            recyclerView!!.adapter = adapter
            if (pos > 0) {
                recyclerView!!.scrollToPosition(pos)
            } else {
                recyclerView!!.scrollToPosition(1)
            }

        }

    }
}
