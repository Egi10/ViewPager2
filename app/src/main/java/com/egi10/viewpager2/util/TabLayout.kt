package com.egi10.viewpager2.util

import android.view.ViewGroup
import android.widget.LinearLayout
import com.google.android.material.tabs.TabLayout

fun TabLayout.setTabWidthAsWrapContent(position: Int) {
    val layout = (this.getChildAt(0) as LinearLayout).getChildAt(position)
    val wrapContent = ViewGroup.LayoutParams.WRAP_CONTENT
    val matchParent = ViewGroup.LayoutParams.MATCH_PARENT
    val layoutParams = LinearLayout.LayoutParams(wrapContent, matchParent)
    layout.layoutParams = layoutParams
}