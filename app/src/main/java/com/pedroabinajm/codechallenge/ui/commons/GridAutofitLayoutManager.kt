package com.pedroabinajm.codechallenge.ui.commons

import android.content.Context
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.TypedValue

class GridAutofitLayoutManager : GridLayoutManager {
    private var mColumnWidth: Int = 0
    private var mColumnWidthChanged = true
    private var mMaxSpanCount: Int = 0

    constructor(context: Context, columnWidth: Int) : super(context, 1) {
        setColumnWidth(checkedColumnWidth(context, columnWidth, 0))
    }

    constructor(context: Context, columnWidth: Int, maxSpanCount: Int) : super(context, 1) {
        setColumnWidth(checkedColumnWidth(context, columnWidth, maxSpanCount))
    }

    constructor(context: Context, columnWidth: Int, orientation: Int, reverseLayout: Boolean) : super(context, 1, orientation, reverseLayout) {
        setColumnWidth(checkedColumnWidth(context, columnWidth, 0))
    }

    constructor(context: Context, columnWidth: Int, orientation: Int, maxSpanCount: Int, reverseLayout: Boolean) : super(context, 1, orientation, reverseLayout) {
        setColumnWidth(checkedColumnWidth(context, columnWidth, maxSpanCount))
    }

    private fun checkedColumnWidth(context: Context, width: Int, maxSpanCount: Int): Int {
        var columnWidth = width
        mMaxSpanCount = maxSpanCount

        if (columnWidth <= 0) {
            /* Set default columnWidth value (48dp here). It is better to move this constant
            to static constant on top, but we need context to convert it to dp, so can't really
            do so. */
            columnWidth = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 48f,
                    context.resources.displayMetrics).toInt()
        }
        return columnWidth
    }

    private fun setColumnWidth(newColumnWidth: Int) {
        if (newColumnWidth > 0 && newColumnWidth != mColumnWidth) {
            mColumnWidth = newColumnWidth
            mColumnWidthChanged = true
        }
    }

    override fun onLayoutChildren(recycler: RecyclerView.Recycler?, state: RecyclerView.State) {
        if (mColumnWidthChanged && mColumnWidth > 0) {
            val totalSpace = if (orientation == LinearLayoutManager.VERTICAL) {
                width - paddingRight - paddingLeft
            } else {
                height - paddingTop - paddingBottom
            }
            var spanCount = Math.max(1, totalSpace / mColumnWidth)
            if (mMaxSpanCount > 0) {
                spanCount = Math.min(mMaxSpanCount, spanCount)
            }
            setSpanCount(spanCount)
            mColumnWidthChanged = false
        }
        try {
            super.onLayoutChildren(recycler, state)
        }catch (e: IndexOutOfBoundsException){

        }
    }
}