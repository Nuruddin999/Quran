package com.example.quranua.GLobalSearch

import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.TextView
import com.example.quranua.R

class ResultsViewHolder (itemview: View):androidx.recyclerview.widget.RecyclerView.ViewHolder(itemview){
    var ayaukr: TextView =itemview.findViewById(R.id.sura_details_item_aya_ukr)
    var ayaarabik: TextView =itemview.findViewById(R.id.sura_details_item_aya_arabic)
    var ayanumber: TextView =itemview.findViewById(R.id.sura_details_item_aya_number)
    var suraheader: TextView =itemview.findViewById(R.id.suraheader)
    var container: LinearLayout =itemview.findViewById(R.id.sura_details_container)
}