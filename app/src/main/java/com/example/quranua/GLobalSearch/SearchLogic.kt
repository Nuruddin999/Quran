package com.example.quranua.GLobalSearch

import android.content.Context
import com.example.quranua.Common
import java.util.ArrayList
import com.example.quranua.Model.GlobalSearchResult


class SearchLogic(context: Context) {
    var allAyats: ArrayList<GlobalSearchResult>? = Common.getAllAyats(context)
    fun makeSearch(text: String): List<GlobalSearchResult> {
        var filteredlist = allAyats!!.filter { it.verseUkr.contains(text) || it.versearab.contains(text) }
        return filteredlist
    }
}