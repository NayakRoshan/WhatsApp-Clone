package com.example.whatsappclone.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.whatsappclone.R
import com.example.whatsappclone.entity.UserMessageEntity
import kotlinx.android.synthetic.main.message_layout.view.*

class UserChatsRecyclerViewAdapter(
    private val context : Context,
    private val data : ArrayList<UserMessageEntity>
) : RecyclerView.Adapter<UserChatsRecyclerViewAdapter.ViewHolder>() {

    private var count = 0

    class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        val message: TextView = itemView.tvMessage
        val time: TextView = itemView.tvTime
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(context)
        return if (count%2 == 0) {
            count += 1
            ViewHolder(inflater.inflate(R.layout.message_layout, parent, false))
        } else {
            count += 1
            ViewHolder(inflater.inflate(R.layout.message_right_layout, parent, false))
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.message.text = data[position].message
        holder.time.text = data[position].time
    }
}