package com.example.quranua

import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.quranua.Model.Sura
import com.example.quranua.SuraDetails.SuraDetailsAdapter

class GlobalSearchActivity : AppCompatActivity() {
    var allsuras = ArrayList<Sura>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_global_search)
        val toolbar: Toolbar = findViewById(R.id.globalsearchtoolbar)
        setSupportActionBar(toolbar)
        var searchfield: EditText = findViewById(R.id.foundsurassearchfield)
        var recyclerView: RecyclerView = findViewById(R.id.foundsuraslist)
        var layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager
        searchfield.addTextChangedListener(object : TextWatcher {

            override fun afterTextChanged(s: Editable?) {

            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }
        })
    }

}


