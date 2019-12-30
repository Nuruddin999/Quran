package com.example.quranua

import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class FoundSurasviewHolder(itemview:View):RecyclerView.ViewHolder(itemview) {
    var ayaukr: TextView =itemview.findViewById(R.id.foundsurassura_details_item_aya_ukr)
    var ayaarabik: TextView =itemview.findViewById(R.id.foundsurassura_details_item_aya_arabic)
    var ayanumber: TextView =itemview.findViewById(R.id.foundsurassura_details_item_aya_number)
    var suraheader: TextView =itemview.findViewById(R.id.foundsurassuraheader)
    var container: LinearLayout =itemview.findViewById(R.id.foundsurassura_details_container)

}