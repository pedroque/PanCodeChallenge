package com.pedroabinajm.codechallenge.ui.base

import android.os.Handler
import com.pedroabinajm.codechallenge.R


abstract class EndlessAdapter<T : Any> : BaseAdapter<T>() {

    val handler = Handler()

    var loading: Boolean = false
        set (value) {
            if (field != value) {
                field = value
                handler.post {
                    if (value) notifyItemInserted(itemCount - 1) else notifyItemRemoved(itemCount)
                }
            }
        }

    override fun getLayoutIdForPosition(position: Int) =
            if (position == itemCount - 1 && loading) R.layout.item_progress else getItemIdForPosition(position)

    abstract fun getItemIdForPosition(position: Int): Int

    override fun getItemCount() =
            if (loading) items?.size ?: 0 + 1 else super.getItemCount()

}