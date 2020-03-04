package com.egi10.viewpager2

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class TabLayoutAdapter(fragmentManager: FragmentActivity, private val pages: List<Fragment>)
    : FragmentStateAdapter(fragmentManager) {
    override fun getItemCount(): Int {
        return pages.count()
    }

    override fun createFragment(position: Int): Fragment {
        return pages[position]
    }


}