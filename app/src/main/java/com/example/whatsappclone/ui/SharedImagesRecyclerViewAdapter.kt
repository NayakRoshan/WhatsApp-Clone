package com.example.whatsappclone.ui

import android.content.Context
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.whatsappclone.R
import kotlinx.android.synthetic.main.shared_doc_layout.view.*

class SharedImagesRecyclerViewAdapter(
    private val context : Context,
    private val data : ArrayList<Int>
) : RecyclerView.Adapter<SharedImagesRecyclerViewAdapter.ViewHolder>() {

    class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        val sharedImage: ImageView = itemView.ivSharedImage
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(context)
        return ViewHolder(inflater.inflate(R.layout.shared_doc_layout, parent, false))
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.sharedImage.setImageDrawable(ContextCompat.getDrawable(context, data[position]))
    }
}