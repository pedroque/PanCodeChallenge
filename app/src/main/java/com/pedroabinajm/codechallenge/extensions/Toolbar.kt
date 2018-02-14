package com.pedroabinajm.codechallenge.extensions

import android.os.Build
import android.support.v7.widget.Toolbar
import android.view.ViewTreeObserver
import com.pedroabinajm.codechallenge.ui.commons.ViewHelper

fun Toolbar.setTransparentStatusBarEnabled() {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
        viewTreeObserver.addOnPreDrawListener(object : ViewTreeObserver.OnPreDrawListener {
            override fun onPreDraw(): Boolean {
                viewTreeObserver.removeOnPreDrawListener(this)
                val statusTopPadding = ViewHelper.getStatusBarHeight(context)
                layoutParams.height = layoutParams.height + statusTopPadding
                addPaddingTop(statusTopPadding)
                return true
            }
        })
    }
}