package com.example.quranua

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.quranua.MainList.ListFragment
import com.example.quranua.MainList.MainListAdapter

class MainActivity : AppCompatActivity() {
    lateinit var recyclerView: RecyclerView
    lateinit var adapter: MainListAdapter
    lateinit var layoutManager: LinearLayoutManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_list_layout)
        var fragment=ListFragment()
        var baseFragment=BaseFragment().getFragment(fragment,R.id.fragment_content,this)

    }


    }

