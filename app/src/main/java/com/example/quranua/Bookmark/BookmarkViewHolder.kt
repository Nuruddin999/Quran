package com.example.quranua.Bookmark

import android.view.TextureView
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.quranua.R
import com.google.android.material.internal.NavigationMenuItemView

class BookmarkViewHolder(var itemview:View):RecyclerView.ViewHolder(itemview) {
    var suraname:TextView=itemview.findViewById(R.id.bookmark_item_suraname2)
    var ukr:TextView=itemview.findViewById(R.id.bookmark_item_suratranslation2)
    var buttonanddate:LinearLayout=itemview.findViewById(R.id.bookmark_item_bookmarkbuttonanddate2)
    var bookmarkbutton:ImageView=itemview.findViewById(R.id.bookmark_item_bookmarkbutton2)
    var date:TextView=itemview.findViewById(R.id.bookmark_item_date2)
var bookmarkLayout:RelativeLayout=itemview.findViewById(R.id.bookmark_item_layout2)
}