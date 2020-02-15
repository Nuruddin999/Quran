package com.example.quranua.GLobalSearch

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.quranua.Model.GlobalSearchResult
import com.example.quranua.Model.Sura
import java.util.ArrayList

class ResultViewModel : ViewModel() {
    val currentResult: MutableLiveData<List<GlobalSearchResult>> by lazy {
        MutableLiveData<List<GlobalSearchResult>>()
    }
}