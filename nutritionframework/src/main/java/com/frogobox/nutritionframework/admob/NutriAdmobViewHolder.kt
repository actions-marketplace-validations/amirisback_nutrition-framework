package com.frogobox.nutritionframework.admob

import android.view.View
import android.view.ViewGroup
import com.frogobox.recycler.core.FrogoRecyclerViewHolder
import com.google.android.gms.ads.AdView

/**
 * Created by Faisal Amir
 * FrogoBox Inc License
 * =========================================
 * SpeechBooster
 * Copyright (C) 10/09/2019.
 * All rights reserved
 * -----------------------------------------
 * Name     : Muhammad Faisal Amir
 * E-mail   : faisalamircs@gmail.com
 * Github   : github.com/amirisback
 * LinkedIn : linkedin.com/in/faisalamircs
 * -----------------------------------------
 * FrogoBox Software Industries
 * com.frogobox.speechbooster.cheery
 *
 */

abstract class NutriAdmobViewHolder<T>(view: View) : FrogoRecyclerViewHolder<T>(view) {

    fun bindItemAdView(data: T) {
        val adView = data as AdView
        val adCardView = itemView as ViewGroup

        if (adCardView.childCount > 0) {
            adCardView.removeAllViews()
        }
        if (adView.parent != null) {
            (adView.parent as ViewGroup).removeView(adView)
        }

        adCardView.addView(adView)
    }

}