package com.egi10.viewpager2.devinder

import android.graphics.Canvas
import android.graphics.drawable.Drawable
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class DividerItemDecorator(private val drawable: Drawable?) : RecyclerView.ItemDecoration() {
    override fun onDrawOver(c: Canvas, parent: RecyclerView, state: RecyclerView.State) {
        val dividerLeft = 195
        val dividerRight = parent.width - 25

        val childCount = parent.childCount
        for (i in 0..childCount - 2) {
            val child: View = parent.getChildAt(i)
            val params =
                child.layoutParams as RecyclerView.LayoutParams
            val dividerTop: Int = child.bottom + params.bottomMargin
            drawable?.intrinsicHeight?.let {
                val dividerBottom: Int = dividerTop + drawable.intrinsicHeight
                drawable.setBounds(dividerLeft, dividerTop, dividerRight, dividerBottom)
                drawable.draw(c)
            }
        }
    }
}