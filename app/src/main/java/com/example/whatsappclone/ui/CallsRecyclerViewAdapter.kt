package com.example.whatsappclone.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.whatsappclone.R
import com.example.whatsappclone.entity.CallDetailsEntity
import kotlinx.android.synthetic.main.call_view_layout.view.*
import kotlinx.android.synthetic.main.message_layout.view.*

class CallsRecyclerViewAdapter(
    private val context : Context,
    private val data : ArrayList<CallDetailsEntity>
) : RecyclerView.Adapter<CallsRecyclerViewAdapter.ViewHolder>() {

    class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        val name : TextView = itemView.tvName
        val calledBy : ImageView = itemView.ivDenote
        val time : TextView = itemView.tvCallTime
        val mode : ImageView = itemView.ivMode
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(context)
        return ViewHolder(inflater.inflate(R.layout.call_view_layout, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.name.text = data[position].name
        holder.time.text = data[position].time

        if (data[position].calledByMe) holder.calledBy.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.call_made))
        else holder.calledBy.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.call_received))

        if (data[position].mode == "phone") holder.mode.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.phone))
        else holder.mode.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.video_call))
    }
}