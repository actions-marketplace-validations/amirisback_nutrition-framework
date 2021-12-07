package com.frogobox.nutritionframework.recycler.core

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding

/**
 * Created by Faisal Amir
 * FrogoBox Inc License
 * =========================================
 * NutriRecyclerViewAdapter
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

    abstract fun initComponent(binding: VB, data: T, position: Int) // component view

    fun getLinearLayoutManager(recyclerView: RecyclerView): LinearLayoutManager {
        return recyclerView.layoutManager as LinearLayoutManager
    }

    fun bindItem(data: T?, position: Int, listener: NutriRecyclerBindingListener<T, VB>?) {
        if (data != null) {
            onItemViewClicked(data, position, listener)
            initComponent(binding, data, position)
        }
    }

    private fun onItemViewClicked(
        data: T?,
        position: Int,
        listener: NutriRecyclerBindingListener<T, VB>?
    ) {
        binding.root.setOnClickListener {
            if (data != null) {
                listener?.onItemClicked(binding, data, position)
            }
        }
        binding.root.setOnLongClickListener {
            if (data != null) {
                listener?.onItemLongClicked(binding, data, position)
            }
            true
        }
    }

}