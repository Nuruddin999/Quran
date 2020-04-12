package com.example.quranua.SuraDetails

import android.view.View
import android.widget.TextView
import com.example.quranua.R

class StartViewholder (itemview: View):androidx.recyclerview.widget.RecyclerView.ViewHolder(itemview){
var suratitle:TextView=itemview.findViewById(R.id.sura_details_title)
    var suratitleukr:TextView=itemview.findViewById(R.id.sura_details_titleukr)
    var surabismi:TextView=itemview.findViewById(R.id.sura_details_bismi_arabik)
    var suratitlebismiarab:TextView=itemview.findViewById(R.id.sura_details_bismi_ukr)
}