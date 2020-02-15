package com.example.quranua.GLobalSearch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.widget.SearchView
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.quranua.Model.GlobalSearchResult
import com.example.quranua.R
import kotlinx.coroutines.*
import java.util.ArrayList
import kotlin.coroutines.CoroutineContext

class GlobalSearchActivity : AppCompatActivity(), CoroutineScope {

    override val coroutineContext: CoroutineContext = Dispatchers.Main
    private lateinit var model: ResultViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        var searchLogic = SearchLogic(this)
        var resultList=ArrayList<GlobalSearchResult>()
        CoroutineScope(Dispatchers.IO).launch {
            val result = searchLogic.allAyats/*.await()*/
            withContext(Dispatchers.Main) {
                resultList= result!!
            }}
        var adapter = ResultsAdapter(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_global_search)
        model = ViewModelProviders.of(this).get(ResultViewModel::class.java)
        val toolbar: Toolbar = findViewById(R.id.globalsearchtoolbar)
        setSupportActionBar(toolbar)
        var searchfield: SearchView = findViewById(R.id.foundsurassearchfield)
        var recyclerView: RecyclerView = findViewById(R.id.foundsuraslist)
        var layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = adapter
        model.currentResult.observe(this, object : Observer<List<GlobalSearchResult>> {
            override fun onChanged(t: List<GlobalSearchResult>) {
                adapter.setWords(t)
            }
        })
        searchfield.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            var searchFor = ""
            override fun onQueryTextSubmit(query: String?): Boolean {
                Log.d("RxSearch", "onQueryTextSubmit: $query")
                return false
            }
            override fun onQueryTextChange(newText: String?): Boolean {
                Log.d("RxSearch", "onQueryTextSubmit: $newText")
                runBlocking {
                    delay(500)
                    if (newText!!.isBlank()) {
                        var list = emptyList<GlobalSearchResult>()
                        model.currentResult.postValue(list)
                        return@runBlocking
                    }
                    var restList = resultList!!.filter { r ->
                        r.versearab.contains(newText.toString()) || r.verseUkr.contains(newText.toString())
                    }
                    model.currentResult.postValue(restList)
                }
                return true
            }
        })
    }

}


