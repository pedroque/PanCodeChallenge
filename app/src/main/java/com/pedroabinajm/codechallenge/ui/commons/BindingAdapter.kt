package com.pedroabinajm.codechallenge.ui.commons

import android.databinding.BindingAdapter
import android.view.View
import android.widget.ImageView
import com.pedroabinajm.codechallenge.extensions.hide
import com.pedroabinajm.codechallenge.extensions.show

object BindingAdapter {
    @JvmStatic
    @BindingAdapter("showIf")
    fun showIf(view: View, show: Boolean) {
        if (show) view.show() else view.hide()
    }

    @JvmStatic
    @BindingAdapter("android:src")
    fun setImageResource(imageView: ImageView, resource: Int) {
        imageView.setImageResource(resource)
    }

}