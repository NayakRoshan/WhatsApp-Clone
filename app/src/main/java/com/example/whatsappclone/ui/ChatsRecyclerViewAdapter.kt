package com.example.whatsappclone.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.RecyclerView
import com.example.whatsappclone.R
import com.example.whatsappclone.callback.OnUserClickedListener
import com.example.whatsappclone.entity.MyChatDetailsEntity
import kotlinx.android.synthetic.main.view_layout.view.*

class ChatsRecyclerViewAdapter(
    private val context : Context,
    private val listener : OnUserClickedListener,
    private val fragmentManager: FragmentManager,
    detailsEntity: ArrayList<MyChatDetailsEntity>
) : RecyclerView.Adapter<ChatsRecyclerViewAdapter.ViewHolder>() {

    private val data : ArrayList<MyChatDetailsEntity> = detailsEntity

    inner class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        private val displayPicture : ImageView = itemView.civDisplayPicture
        val userName: TextView = itemView.tvUserName
        val latestMessage: TextView = itemView.tvLatestMessage

        init {
            displayPictureListener()
            itemViewClickListener()
        }

        private fun displayPictureListener() {
            displayPicture.setOnClickListener {
                val dialog = DisplayPictureClickDialog()
                dialog.show(fragmentManager, "DP Click Dialog.")
            }
        }

        private fun itemViewClickListener() {
            itemView.setOnClickListener {
                listener.onUserClickListener(itemView.tvUserName.text.toString())
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(context)
        return ViewHolder(inflater.inflate(R.layout.view_layout, parent, false))
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.userName.text = data[position].userName
        holder.latestMessage.text = data[position].latestMessage
    }

}