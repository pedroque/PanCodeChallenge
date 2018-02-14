package com.pedroabinajm.codechallenge.extensions

import android.view.View
import android.view.ViewGroup
import com.pedroabinajm.codechallenge.ui.commons.ViewHelper

fun View.show() {
    ViewHelper.showViewAnimated(this)
}

fun View.hide() {
    ViewHelper.hideViewAnimated(this)
}

fun View.addPaddingTop(extraPaddingTop: Int) {
    setPadding(paddingLeft,
            paddingTop + extraPaddingTop,
            paddingRight,
            paddingBottom)
}

fun View.addStatusBarMargin() {
    val mlp = (layoutParams as ViewGroup.MarginLayoutParams)
    mlp.topMargin = mlp.topMargin + ViewHelper.getStatusBarHeight(context)
    layoutParams = mlp
}