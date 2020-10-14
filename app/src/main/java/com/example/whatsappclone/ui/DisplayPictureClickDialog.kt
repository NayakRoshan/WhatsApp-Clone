package com.example.whatsappclone.ui

import android.app.Dialog
import android.os.Bundle
import android.view.View
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.DialogFragment
import com.example.whatsappclone.R
import com.example.whatsappclone.entity.MyChatDetailsEntity
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import kotlinx.android.synthetic.main.display_picture_click_layout.*

class DisplayPictureClickDialog() : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dpViewDialogBuilder = MaterialAlertDialogBuilder(context!!)
        dpViewDialogBuilder.setView(R.layout.display_picture_click_layout)
        return dpViewDialogBuilder.create()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setUpUi()
    }

    private fun setUpUi() {
        dp.setImageDrawable(ResourcesCompat.getDrawable(resources, R.drawable.placeholder, resources.newTheme()))
    }
}