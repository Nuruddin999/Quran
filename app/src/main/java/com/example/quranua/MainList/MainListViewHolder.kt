package com.example.quranua.MainList

import android.view.View
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import com.example.quranua.R

class MainListViewHolder(itemview:View):androidx.recyclerview.widget.RecyclerView.ViewHolder(itemview){
    var suraindex:TextView=itemview.findViewById(R.id.main_list_item_indexsura)
    var suraname:TextView=itemview.findViewById(R.id.main_list_item_namesura)
    var suraukrname:TextView=itemview.findViewById(R.id.main_list_item_ukrnamesura)
    var downloadicon:ImageView=itemview.findViewById(R.id.main_list_item_download_icon_sura)
    var mainlistlayout:RelativeLayout=itemview.findViewById(R.id.main_list_item_layout)
}