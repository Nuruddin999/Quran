package com.example.quranua

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.quranua.Model.Sura
import com.example.quranua.SuraDetails.SuraDetailsFragment
import kotlinx.android.synthetic.main.activity_sura_details.*

class LovedAya:SuraDetailsFragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view = inflater.inflate(R.layout.activity_sura_details, container, false)

        recyclerView = view.findViewById(R.id.sura_details_list)
        layoutManager = LinearLayoutManager(context)
        var sura = Sura()
        var db=Database(context!!)

        return view
    }
}