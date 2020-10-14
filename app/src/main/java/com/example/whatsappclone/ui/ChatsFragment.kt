package com.example.whatsappclone.ui

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.whatsappclone.DummyDataClass
import com.example.whatsappclone.R
import kotlinx.android.synthetic.main.fragment_chats.*

class ChatsFragment : Fragment(),
    ChatsRecyclerViewAdapter.ItemViewClickListener {

    private val USER_NAME_CLICKED = "Name Clicked"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_chats, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setUpRecyclerView()
    }

    private fun setUpRecyclerView() {
        val dummyData = DummyDataClass.getChatsDummyData()
        val adapter = ChatsRecyclerViewAdapter(context!!, this, fragmentManager!!, dummyData)
        myChatsList.layoutManager = LinearLayoutManager(activity)
        myChatsList.adapter = adapter
    }

    override fun onItemViewClickListener(nameClicked : String) {
        val callChatActivity = Intent(activity, ChatActivity::class.java)
        callChatActivity.putExtra(USER_NAME_CLICKED, nameClicked)
        startActivity(callChatActivity)
    }

}