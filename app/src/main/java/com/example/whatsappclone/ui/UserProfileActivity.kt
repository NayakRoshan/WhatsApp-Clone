package com.example.whatsappclone.ui

import android.graphics.drawable.BitmapDrawable
import android.os.Bundle
import android.view.Menu
import androidx.appcompat.app.AppCompatActivity
import androidx.palette.graphics.Palette
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.whatsappclone.DummyDataClass
import com.example.whatsappclone.R
import com.google.android.material.appbar.AppBarLayout
import kotlinx.android.synthetic.main.activity_user_profile.*
import kotlinx.android.synthetic.main.media_view.*


class UserProfileActivity : AppCompatActivity() {

    private val USER_NAME_CLICKED = "Name Clicked"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_profile)
        setFadeProfileImage()
        setAppBar()
        setSharedDocList()
    }

    override fun onStart() {
        super.onStart()
        setUpToolBar()
    }

    private fun setUpToolBar() {
        val bitmapImage = (ivProfileImage.drawable as BitmapDrawable).bitmap

        Palette.from(bitmapImage).maximumColorCount(32).generate { palette ->
            val lightVibrantSwatch = palette?.darkVibrantSwatch
            if (lightVibrantSwatch != null) {
                ctbProfile.setBackgroundColor(lightVibrantSwatch.rgb)
            }
        }
    }

    private fun setFadeProfileImage() {
        abProfile.addOnOffsetChangedListener(AppBarLayout.OnOffsetChangedListener { appBarLayout, verticalOffset ->
            val range = (-appBarLayout.totalScrollRange).toFloat()
            ivProfileImage.imageAlpha = (255 * (1.0f - verticalOffset.toFloat() / range)).toInt()
        })
    }

    private fun setAppBar() {
        setSupportActionBar(tbProfile)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = intent.getStringExtra(USER_NAME_CLICKED)
    }

    private fun setSharedDocList() {
        val linearLayoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        val adapter = SharedImagesRecyclerViewAdapter(this, DummyDataClass.getImageIds())
        rvSharedItems.layoutManager = linearLayoutManager
        rvSharedItems.adapter = adapter
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.profile_menu, menu)
        return true
    }
}