package com.example.whatsappclone.ui

import android.animation.Animator
import android.animation.ObjectAnimator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.example.whatsappclone.R
import kotlinx.android.synthetic.main.activity_main.*

class MainScreen : AppCompatActivity() {

    private var previousPage : Int = 0
    private var TRANSLATED_Y : Float? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setUpAdapterAndTabLayout()
    }

    override fun onStart() {
        super.onStart()
        TRANSLATED_Y = 100f
    }

    private fun setUpAdapterAndTabLayout() {
        val fragmentList : ArrayList<Fragment> = ArrayList()
        val pageTitles : ArrayList<String> = ArrayList()
        fragmentList.add(ChatsFragment())
        pageTitles.add(resources.getString(R.string.chats))
        fragmentList.add(StatusFragment())
        pageTitles.add(resources.getString(R.string.status))
        fragmentList.add(CallsFragment())
        pageTitles.add(resources.getString(R.string.calls))

        val adapter = ViewPagerAdapter(supportFragmentManager, fragmentList, pageTitles)
        vpFragmentHolder.adapter = adapter
        navButtons.setupWithViewPager(vpFragmentHolder)
        vpFragmentHolder.addOnPageChangeListener(onPageChangeListener)
    }

    private val onPageChangeListener = object : ViewPager.OnPageChangeListener {
        override fun onPageScrollStateChanged(state: Int) {}

        override fun onPageScrolled(
            position: Int,
            positionOffset: Float,
            positionOffsetPixels: Int
        ) {}

        override fun onPageSelected(position: Int) {
            if (previousPage == 0) {
                fabMini.visibility = View.VISIBLE
                when (position) {
                    1 -> setDrawableAndAnimate(true, -1*TRANSLATED_Y!!, R.drawable.pen, R.drawable.ic_baseline_camera_alt_24)
                    2 -> setDrawableAndAnimate(true, -1*TRANSLATED_Y!!, R.drawable.video_call, R.drawable.phone_plus)
                }
            } else {
                when {
                    (previousPage == 1) and (position == 2) ->
                        setDrawableAndAnimate(false, -1*TRANSLATED_Y!!, R.drawable.video_call, R.drawable.phone_plus)
                    (previousPage == 2) and (position == 1) ->
                        setDrawableAndAnimate(false, -1*TRANSLATED_Y!!, R.drawable.pen, R.drawable.ic_baseline_camera_alt_24)
                    position == 0 -> {
                        setDrawableAndAnimate(true, 0f, R.drawable.pen, R.drawable.message_white)
                    }
                }
            }
            previousPage = position
        }

    }

    private fun setDrawableAndAnimate(
        toBeAnimated : Boolean,
        translatedY : Float?,
        miniDrawable : Int,
        normalDrawable : Int
    ) {
        fabMini.setImageDrawable(ContextCompat.getDrawable(applicationContext, miniDrawable))
        fabNormal.setImageDrawable(ContextCompat.getDrawable(applicationContext, normalDrawable))
        if (toBeAnimated) {
            val animatorY = ObjectAnimator.ofFloat(fabMini, View.TRANSLATION_Y, translatedY!!)
            animatorY.duration = 100
            animatorY.addListener(object : Animator.AnimatorListener {
                override fun onAnimationRepeat(p0: Animator?) {}
                override fun onAnimationEnd(p0: Animator?) {
                    if (translatedY == 0f) fabMini.visibility = View.INVISIBLE
                }
                override fun onAnimationCancel(p0: Animator?) {}
                override fun onAnimationStart(p0: Animator?) {}
            })
            animatorY.start()
        }
    }
}