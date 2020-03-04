package com.egi10.viewpager2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(toolBar)

        val pages = listOf(
            ChatsFragment(),
            StatusFragment(),
            CallsFragment()
        )

        val title = listOf(
            "CHATS",
            "STATUS",
            "CALLS"
        )

        val tabLayoutAdapter = TabLayoutAdapter(this, pages)
        viewPager.adapter = tabLayoutAdapter
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = title[position]
        }.attach()
    }
}
