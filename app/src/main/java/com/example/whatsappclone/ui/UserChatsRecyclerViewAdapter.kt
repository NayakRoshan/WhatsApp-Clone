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
import java.lang.IllegalArgumentException

class UserChatsRecyclerViewAdapter(
    private val context : Context,
    private val data : ArrayList<UserMessageEntity>
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val MESSAGE_RECEIVED = 1
    private val MESSAGE_SENT = 2

    class ViewHolderMessageReceived(itemView : View) : RecyclerView.ViewHolder(itemView) {
        val message: TextView = itemView.tvMessage
        val time: TextView = itemView.tvTime
    }

    class ViewHolderMessageSent(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val message: TextView = itemView.tvMessage
        val time: TextView = itemView.tvTime
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(context)
        return when (viewType) {
            MESSAGE_RECEIVED -> ViewHolderMessageReceived(inflater.inflate(R.layout.message_layout, parent, false))
            MESSAGE_SENT -> ViewHolderMessageSent(inflater.inflate(R.layout.message_right_layout, parent, false))
            else -> throw IllegalArgumentException()
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (data[position].type == MESSAGE_RECEIVED) {
            val viewHolder : ViewHolderMessageReceived = holder as ViewHolderMessageReceived
            viewHolder.message.text = data[position].message
            viewHolder.time.text = data[position].time
        } else if (data[position].type == MESSAGE_SENT) {
            val viewHolder : ViewHolderMessageSent = holder as ViewHolderMessageSent
            viewHolder.message.text = data[position].message
            viewHolder.time.text = data[position].time
        }
    }

    override fun getItemViewType(position: Int): Int {
        return data[position].type
    }
}