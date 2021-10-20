package com.frogobox.nutritionframework.recycler.core

import android.content.Context
import androidx.recyclerview.widget.*

/*
 * Created by faisalamir on 23/07/21
 * FrogoRecyclerView
 * -----------------------------------------
 * Name     : Muhammad Faisal Amir
 * E-mail   : faisalamircs@gmail.com
 * Github   : github.com/amirisback
 * -----------------------------------------
 * Copyright (C) 2021 FrogoBox Inc.      
 * All rights reserved
 *
 */
object NutriLayoutManager : INutriLayoutManager {

    override fun linearLayoutVertical(context: Context): RecyclerView.LayoutManager {
        return LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
    }

    override fun linearLayoutVertical(
        context: Context,
        reverseLayout: Boolean,
        stackFromEnd: Boolean
    ): RecyclerView.LayoutManager {
        return LinearLayoutManager(context).apply {
            orientation = LinearLayoutManager.VERTICAL
            this.stackFromEnd = stackFromEnd
            this.reverseLayout = reverseLayout
        }
    }

    override fun dividerItemVertical(context: Context): DividerItemDecoration {
        return DividerItemDecoration(context, LinearLayoutManager.VERTICAL)
    }

    override fun linearLayoutHorizontal(context: Context): RecyclerView.LayoutManager {
        return LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
    }

    override fun linearLayoutHorizontal(
        context: Context,
        reverseLayout: Boolean,
        stackFromEnd: Boolean
    ): RecyclerView.LayoutManager {
        return LinearLayoutManager(context).apply {
            orientation = LinearLayoutManager.VERTICAL
            this.stackFromEnd = stackFromEnd
            this.reverseLayout = reverseLayout
        }
    }

    override fun dividerItemHorizontal(context: Context): DividerItemDecoration {
        return DividerItemDecoration(context, LinearLayoutManager.HORIZONTAL)
    }

    override fun staggeredGridLayout(spanCount: Int): StaggeredGridLayoutManager {
        return StaggeredGridLayoutManager(
            spanCount,
            StaggeredGridLayoutManager.VERTICAL
        )
    }

    override fun gridLayout(context: Context, spanCount: Int): GridLayoutManager {
        return GridLayoutManager(context, spanCount)
    }

}