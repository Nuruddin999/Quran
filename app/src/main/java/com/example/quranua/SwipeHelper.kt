package com.example.quranua

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.Drawable
import android.util.Log
import android.widget.Adapter
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import android.opengl.ETC1.getHeight



abstract class SwipeHelper(madapter: RecyclerView.Adapter<RecyclerView.ViewHolder>, context: Context) :
    ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.RIGHT) {
    private var mAdapter: RecyclerView.Adapter<RecyclerView.ViewHolder>? = null
    private var icon: Drawable? = null;
    private var background: ColorDrawable? = null
private var listener:removeitemlistener?=null
    init {
        mAdapter = madapter
        icon = ContextCompat.getDrawable(context, android.R.drawable.ic_delete)
        background = ColorDrawable(Color.RED)

    }





    override fun onMove(
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder,
        target: RecyclerView.ViewHolder
    ): Boolean {
        return false
    }


    override fun onChildDraw(
        c: Canvas,
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder,
        dX: Float,
        dY: Float,
        actionState: Int,
        isCurrentlyActive: Boolean
    ) {
        super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive)
        var itemview = viewHolder.itemView
        var backgroundoffset = 20;
        val iconMargin = (itemview.getHeight() - icon!!.getIntrinsicHeight()) / 2
        val iconTop = itemview.getTop() + (itemview.getHeight() - icon!!.getIntrinsicHeight()) / 2
        val iconBottom = iconTop + icon!!.getIntrinsicHeight()
        if (dX > 0) {
            val iconLeft = itemview.getLeft() + iconMargin + icon!!.getIntrinsicWidth()
            val iconRight = itemview.getLeft() + iconMargin
            icon!!.setBounds(
                iconLeft,
               iconTop,
               iconRight,iconBottom
            )

        } else if (dX < 0) {
            val iconLeft = itemview.getLeft()
            val iconRight = itemview.getLeft() - iconMargin
            icon!!.setBounds(
                iconLeft,
                iconTop,
                iconRight,iconBottom
            )

        } else { // view is unSwiped
            background!!.setBounds(0, 0, 0, 0);
        }
        background!!.draw(c)
icon!!.draw(c)
    }
}