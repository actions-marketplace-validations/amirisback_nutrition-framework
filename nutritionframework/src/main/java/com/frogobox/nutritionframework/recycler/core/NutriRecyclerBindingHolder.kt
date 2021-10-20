package com.frogobox.nutritionframework.recycler.core

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding

/**
 * Created by Faisal Amir
 * FrogoBox Inc License
 * =========================================
 * FrogoRecyclerViewAdapter
 * Copyright (C) 20/12/2019.
 * All rights reserved
 * -----------------------------------------
 * Name     : Muhammad Faisal Amir
 * E-mail   : faisalamircs@gmail.com
 * Github   : github.com/amirisback
 * LinkedIn : linkedin.com/in/faisalamircs
 * -----------------------------------------
 * FrogoBox Software Industries
 * com.frogobox.frogoviewadapter
 *
 */
abstract class NutriRecyclerBindingHolder<T, VB : ViewBinding>(private val binding: VB) :
    RecyclerView.ViewHolder(binding.root) {

    abstract fun initComponent(data: T) // component view

    fun getLinearLayoutManager(recyclerView: RecyclerView): LinearLayoutManager {
        return recyclerView.layoutManager as LinearLayoutManager
    }

    fun bindItem(data: T?, listener: NutriRecyclerViewListener<T>?) {
        if (data != null) {
            onItemViewClicked(data, listener)
            initComponent(data)
        }
    }

    private fun onItemViewClicked(data: T?, listener: NutriRecyclerViewListener<T>?) {
        binding.root.setOnClickListener {
            if (data != null) {
                listener?.onItemClicked(data)
            }
        }
        binding.root.setOnLongClickListener {
            if (data != null) {
                listener?.onItemLongClicked(data)
            }
            true
        }
    }

}