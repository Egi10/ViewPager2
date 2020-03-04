package com.egi10.viewpager2.chats

import android.os.Bundle
import android.view.*
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.egi10.viewpager2.R
import com.egi10.viewpager2.devinder.DividerItemDecorator
import kotlinx.android.synthetic.main.fragment_chats.*
import java.text.SimpleDateFormat
import java.util.*


class ChatsFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_chats, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val formatter = SimpleDateFormat("HH:mm", Locale.getDefault())
        val date = Date()
        val dateNow = formatter.format(date)

        val chats = arrayListOf<Chats>()
        val dataChats =  Chats(
            "Lisa Blackpink",
            "당신을 사랑합니다",
            "https://risetcdn.jatimtimes.com/images/2018/12/22/Jarang-Diketahui-Ini-Sepuluh-Fakta-tentang-Lisa-Blackpink150660d3a8418aa2.md.jpg",
            dateNow,
            0)
        val dataChats1 =  Chats(
            "Kim Jennie Blackpink",
            "보고 싶어",
            "https://img.beritasatu.com/cache/beritasatu/600x350-2/1542169847.jpg",
            dateNow,
            4)
        val dataChats2 =  Chats(
            "Kim Ji - Soo Blackpink",
            "당신이 나를 만날 때",
            "https://pbs.twimg.com/media/D_3n0B8W4AARRSB.jpg",
            dateNow,
            0)
        val dataChats3 =  Chats(
            "Rose Blackpink",
            "너를 너무 사랑해",
            "https://www.wowkeren.com/display/images/photo/2019/09/02/00271050.jpg",
            dateNow,
            3)
        chats.add(dataChats)
        chats.add(dataChats1)
        chats.add(dataChats2)
        chats.add(dataChats3)

        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.addItemDecoration(DividerItemDecorator(ContextCompat.getDrawable(requireContext(), R.drawable.divinder_drawable)))
        recyclerView.adapter = ChatsAdapter(chats) {

        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_chats, menu)
    }
}
