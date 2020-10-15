package com.example.whatsappclone

import com.example.whatsappclone.entity.CallDetailsEntity
import com.example.whatsappclone.entity.MyChatDetailsEntity
import com.example.whatsappclone.entity.UserMessageEntity

object DummyDataClass {

    fun getChatsDummyData() : ArrayList<MyChatDetailsEntity> {
        val names = listOf(
            "Aaron Finch", "Virat Kohli", "A B D Villers", "Chris Morris",
            "Moeen Ali", "Valentino Rossi", "Rohit Sharma", "Navdeep Saini",
            "Yuzy Chahal", "V Bottas"
        )
        val lMessage = listOf(
            "This should have been done.",
            "A message is a discrete unit of communication intended.",
            "Provides some common examples of SMS applications to give.",
            "If you own an iPhone, you may have noticed something odd in the Messages app.",
            "Here's a very simple example to reproduce the situation I just described.",
            "If you know in advance what's the maximum number of lines you want to allow.",
            "This works fine but unfortunately might lead to performance degradation.",
            "On most situations, the issues mentioned here won't be a blocker",
            "Here's a very simple example to reproduce the situation I just described.",
            "If you know in advance what's the maximum number of lines you want to allow."
        )
        val dummyData = ArrayList<MyChatDetailsEntity>()
        var i = 0
        while (i < names.size) {
            val temp = MyChatDetailsEntity(names[i], lMessage[i])
            dummyData.add(temp)
            i += 1
        }
        return dummyData
    }

    fun getMessagesDummyData() : ArrayList<UserMessageEntity> {
        val messageList = listOf(
            "images need to be animated on screen. This is useful if you want to display a custom loading animation comprised of",
            " I had a ListView and an animation that should be applied to a particular child of all list item views",
            "When an object of this type is attached to an Editable, its methods will be called when the text is changed.",
            "Scale image into ImageView, then resize ImageView to match the image The question: How to ... When"
        )
        val timeList = listOf("1:30 pm", "2:45 pm", "8:20 am", "6:30 pm")

        val dummyData = ArrayList<UserMessageEntity>()
        var i = 0
        while (i < messageList.size) {
            val temp = UserMessageEntity(messageList[i], timeList[i])
            dummyData.add(temp)
            i += 1
        }
        return dummyData
    }

    fun getCallsDummyData() : ArrayList<CallDetailsEntity> {
        val names = listOf(
            "Aaron Finch", "Virat Kohli", "Moeen Ali", "Valentino Rossi",
            "Yuzy Chahal", "V Bottas", "Deepak", "Dinesh"
        )
        val time = listOf(
            "6 October, 10:00 am", "12 October, 12:30 pm", "15 October, 1:00 pm", "2 December, 3:00 pm",
            "12 January, 2:00 pm", "16 February, 8:00 am", "4 March, 5:00 am", "8 April, 6:00 pm"
        )
        val calledByMe = listOf(true, true, false, true, false, false, true, true)
        val mode = listOf("phone", "video", "video", "phone", "phone", "video", "video", "phone")
        val dummyData = ArrayList<CallDetailsEntity>()
        var i = 0
        while (i < names.size) {
            val temp = CallDetailsEntity(names[i], time[i], calledByMe[i], mode[i])
            dummyData.add(temp)
            i += 1
        }
        return dummyData
    }

    fun getImageIds() : ArrayList<Int> {
        val imageIds = ArrayList<Int>()
        imageIds.apply {
            add(R.drawable.bridge)
            add(R.drawable.moon)
            add(R.drawable.person)
            add(R.drawable.placeholder)
            add(R.drawable.scenary)
            add(R.drawable.more)
        }
        return imageIds
    }

}