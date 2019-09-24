package com.example.quranua.SuraDetails

import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.TextView
import com.example.quranua.R

class SuraDetailsViewHolder(itemview: View):androidx.recyclerview.widget.RecyclerView.ViewHolder(itemview){
    var ayaukr: TextView =itemview.findViewById(R.id.sura_details_item_aya_ukr)
    var ayaarabik: TextView =itemview.findViewById(R.id.sura_details_item_aya_arabic)
    var addbookmark: ImageView =itemview.findViewById(R.id.sura_details_item_context_menu_bookmark)
    var share: ImageView =itemview.findViewById(R.id.sura_details_item_context_menu_share)
    var container:LinearLayout=itemview.findViewById(R.id.sura_details_container)
    var contextmenu: RelativeLayout =itemview.findViewById(R.id.sura_details_item_context_menu_block)

}