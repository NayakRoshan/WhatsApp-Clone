package com.example.whatsappclone.ui

import android.os.Bundle
import android.view.Menu
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.whatsappclone.DummyDataClass
import com.example.whatsappclone.R
import com.google.android.material.appbar.AppBarLayout
import kotlinx.android.synthetic.main.activity_user_profile.*


class UserProfileActivity : AppCompatActivity() {

    private val USER_NAME_CLICKED = "Name Clicked"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_profile)
        setFadeProfileImage()
        setAppBar()
        setSharedDocList()
    }

    private fun setFadeProfileImage() {
        profileAppBar.addOnOffsetChangedListener(AppBarLayout.OnOffsetChangedListener { appBarLayout, verticalOffset ->
            val range = (-appBarLayout.totalScrollRange).toFloat()
            profileImage.imageAlpha = (255 * (1.0f - verticalOffset.toFloat() / range)).toInt()
        })
    }

    private fun setAppBar() {
        setSupportActionBar(profileToolBar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = intent.getStringExtra(USER_NAME_CLICKED)
    }

    private fun setSharedDocList() {
        val linearLayoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        val adapter = SharedImagesRecyclerViewAdapter(this, DummyDataClass.getImageIds())
        sharedItems.layoutManager = linearLayoutManager
        sharedItems.adapter = adapter
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.profile_menu, menu)
        return true
    }
}