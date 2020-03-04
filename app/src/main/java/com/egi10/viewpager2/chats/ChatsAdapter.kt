package com.egi10.viewpager2.chats

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.egi10.viewpager2.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.items_chats.view.*

class ChatsAdapter(private val data: List<Chats>, private val listener: (Chats) -> Unit) :
    RecyclerView.Adapter<ChatsAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.items_chats, parent, false))

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
        holder.bind(data[position], listener)

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: Chats, listener: (Chats) -> Unit) {
            with(itemView) {
                tvName.text = item.name
                tvMessage.text = item.message
                tvHours.text = item.hours

                Picasso.get()
                    .load(item.image)
                    .placeholder(R.drawable.ic_launcher_background)
                    .error(R.drawable.ic_search)
                    .into(ivImage)

                if (item.badge != 0) {
                    tvBadge.visibility = View.VISIBLE
                    tvBadge.text = item.badge.toString()
                } else {
                    tvBadge.visibility = View.GONE
                }

                setOnClickListener {
                    listener(item)
                }
            }
        }
    }
}