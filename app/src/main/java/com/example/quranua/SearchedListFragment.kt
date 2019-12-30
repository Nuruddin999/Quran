package com.example.quranua

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toolbar
import androidx.appcompat.app.AppCompatActivity

class SearchedListFragment: BaseFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view=inflater.inflate(R.layout.searchedsuras_layout,container,false)
        val toolbar:androidx.appcompat.widget.Toolbar=view.findViewById(R.id.searchedsura_layout_toolbar)
        (activity as AppCompatActivity).setSupportActionBar(toolbar)
        return view
    }
}