package com.example.quranua

import android.view.View
import android.widget.EditText
import androidx.recyclerview.widget.RecyclerView

class SearchViewholder(itemview:View):RecyclerView.ViewHolder(itemview) {
    var searchfield:EditText=itemview.findViewById(R.id.searchfield_edittext)
}