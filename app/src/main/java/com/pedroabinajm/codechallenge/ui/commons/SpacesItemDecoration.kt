package com.pedroabinajm.codechallenge.ui.commons

import android.graphics.Rect
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View

class SpacesItemDecoration : RecyclerView.ItemDecoration {
    private var leftSpace: Int = 0
    private var topSpace: Int = 0
    private var rightSpace: Int = 0
    private var bottomSpace: Int = 0

    constructor(space: Int) {
        this.leftSpace = space
        this.rightSpace = space
        this.topSpace = space
        this.bottomSpace = space
    }

    constructor(left: Int, top: Int, right: Int, bottom: Int) {
        this.leftSpace = left
        this.rightSpace = right
        this.topSpace = top
        this.bottomSpace = bottom
    }

    override fun getItemOffsets(outRect: Rect, view: View,
                                parent: RecyclerView, state: RecyclerView.State?) {
        var top = topSpace
        var spanCount = 1
        val layoutManager = parent.layoutManager
        if (layoutManager is GridLayoutManager) {
            spanCount = layoutManager.spanCount
        }
        if (parent.getChildAdapterPosition(view) < spanCount) {
            top *= 2
        }
        var bottom = bottomSpace
        if (parent.getChildAdapterPosition(view) < parent.adapter.itemCount - spanCount) {
            bottom *= 2
        }
        outRect.left = leftSpace
        outRect.right = rightSpace
        outRect.bottom = bottom
        outRect.top = top
    }
}