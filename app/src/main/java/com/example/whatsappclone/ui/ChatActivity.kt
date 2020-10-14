package com.example.whatsappclone.ui

import android.animation.Animator
import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.*
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.whatsappclone.DummyDataClass
import com.example.whatsappclone.R
import kotlinx.android.synthetic.main.activity_chat.*

class ChatActivity : AppCompatActivity() {

    private val USER_NAME_CLICKED = "Name Clicked"
    private var translateBy : Float? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat)
        setUpUi()
        setReturnToChatsActivityClick()
        loadPreviousChats()
        setTitleClickListener()
        setFirstCharacterEnteredListener()
    }

    private fun setUpUi() {
        actTitle.text = intent.getStringExtra(USER_NAME_CLICKED)
    }

    private fun setReturnToChatsActivityClick() {
        goBack.setOnClickListener {
            finish()
        }
    }

    private fun loadPreviousChats() {
        val linearLayout = LinearLayoutManager(this)
        messageList.layoutManager = linearLayout
        val adapter = UserChatsRecyclerViewAdapter(this, DummyDataClass.getMessagesDummyData())
        messageList.adapter = adapter
    }

    private fun setTitleClickListener() {
        actTitle.setOnClickListener {
            val viewUserProfileIntent = Intent(this@ChatActivity, UserProfileActivity::class.java)
            viewUserProfileIntent.putExtra(USER_NAME_CLICKED, intent.getStringExtra(USER_NAME_CLICKED))
            startActivity(viewUserProfileIntent)
        }
    }

    private fun setFirstCharacterEnteredListener() {
        enterMessage.addTextChangedListener(object : TextWatcher{
            override fun afterTextChanged(s: Editable?) {

            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (translateBy == null) translateBy = clickImage.right.toFloat() - selectImage.right.toFloat()
                if ((before == 0) and (count > 0)) {
                    animateObject(translateBy as Float)
                    changeIcon(R.drawable.send)
                } else if (count == 0) {
                    animateObject(-1 * translateBy!!)
                    changeIcon(R.drawable.mic)
                }
            }

        })
    }

    private fun animateObject(translateBy : Float) {
        val translate : Float = if (translateBy < 0) 0f
        else translateBy

        if (translate == 0f) clickImage.visibility = View.VISIBLE
        val animatorSet = AnimatorSet()
        animatorSet.playTogether(
            ObjectAnimator.ofFloat(selectImage, View.TRANSLATION_X, translate),
            ObjectAnimator.ofFloat(clickImage, View.TRANSLATION_X, translate)
        )
        animatorSet.duration = 200
        animatorSet.addListener(object : Animator.AnimatorListener {
            override fun onAnimationRepeat(p0: Animator?) {}
            override fun onAnimationEnd(p0: Animator?) {
                if (translate > 0) clickImage.visibility = View.INVISIBLE
            }
            override fun onAnimationCancel(p0: Animator?) {}
            override fun onAnimationStart(p0: Animator?) {}
        })
        animatorSet.start()
    }

    private fun changeIcon(imageId : Int) {
        val fadeOut = ObjectAnimator.ofFloat(micImage, View.ALPHA, 1f, 0f)
        val fadeIn = ObjectAnimator.ofFloat(micImage, View.ALPHA, 0f, 1f)
        fadeOut.start()
        micImage.setImageDrawable(ResourcesCompat.getDrawable(resources, imageId, resources.newTheme()))
        fadeIn.start()
    }
}