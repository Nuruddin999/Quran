package com.example.quranua.SuraDetails

import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.TextView
import com.example.quranua.R

open class SuraDetailsViewHolder(itemview: View):androidx.recyclerview.widget.RecyclerView.ViewHolder(itemview){
    var ayaukr: TextView =itemview.findViewById(R.id.sura_details_item_aya_ukr)
    var ayaarabik: TextView =itemview.findViewById(R.id.sura_details_item_aya_arabic)
    var addbookmark: ImageView =itemview.findViewById(R.id.sura_details_item_context_menu_bookmark)
    var ayanumber:TextView=itemview.findViewById(R.id.sura_details_item_aya_number)
    var suraheader:TextView=itemview.findViewById(R.id.suraheader)
    var share: ImageView =itemview.findViewById(R.id.sura_details_item_context_menu_share)
    var web:ImageView=itemview.findViewById(R.id.sura_details_item_context_menu_loved)
    var container:LinearLayout=itemview.findViewById(R.id.sura_details_container)
    var contextmenu: RelativeLayout =itemview.findViewById(R.id.sura_details_item_context_menu_block)

}