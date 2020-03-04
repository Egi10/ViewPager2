package com.egi10.viewpager2

import android.graphics.Color
import android.graphics.PorterDuff
import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import com.egi10.viewpager2.chats.ChatsFragment
import com.egi10.viewpager2.util.setTabWidthAsWrapContent
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(toolBar)

        val pages = listOf(
            StatusFragment(),
            ChatsFragment(),
            StatusFragment(),
            CallsFragment()
        )

        val title = listOf(
            "Photo",
            "CHATS",
            "STATUS",
            "CALLS"
        )

        val tabLayoutAdapter = TabLayoutAdapter(this, pages)
        viewPager.adapter = tabLayoutAdapter
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            when(position) {
                0 -> {
                    tab.setIcon(R.drawable.ic_photo_camera)
                    tab.icon?.setColorFilter(Color.parseColor("#ffffff"), PorterDuff.Mode.SRC_IN)
                }

                else -> {
                    tab.text = title[position]
                }
            }
        }.attach()
        viewPager.currentItem = 1
        tabLayout.setTabWidthAsWrapContent(0)
    }
}
