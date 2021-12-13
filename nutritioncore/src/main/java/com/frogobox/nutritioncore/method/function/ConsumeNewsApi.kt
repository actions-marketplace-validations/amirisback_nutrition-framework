package com.frogobox.nutritioncore.method.function

import com.frogobox.nutritioncore.core.NutriResponse
import com.frogobox.nutritioncore.method.interfaces.IConsumeNewsApi
import com.frogobox.nutritioncore.model.news.ArticleResponse
import com.frogobox.nutritioncore.model.news.SourceResponse
import com.frogobox.nutritioncore.sources.news.NewsRepository

/**
 * Created by Faisal Amir
 * FrogoBox Inc License
 * =========================================
 * consumable-code-news-api
 * Copyright (C) 15/03/2020.
 * All rights reserved
 * -----------------------------------------
 * Name     : Muhammad Faisal Amir
 * E-mail   : faisalamircs@gmail.com
 * Github   : github.com/amirisback
 * LinkedIn : linkedin.com/in/faisalamircs
 * -----------------------------------------
 * FrogoBox Software Industries
 * com.frogobox.frogoconsumeapi.news
 *
 */
class ConsumeNewsApi(private val apiKey: String) : IConsumeNewsApi {

    private val newsRepository = NewsRepository

    override suspend fun getTopHeadline(
        q: String?,
        sources: String?,
        category: String?,
        country: String?,
        pageSize: Int?,
        page: Int?,
        callback: NutriResponse.DataResponse<ArticleResponse>
    ) {
        newsRepository.getTopHeadline(
            apiKey,
            q,
            sources,
            category,
            country,
            pageSize,
            page,
            callback
        )
    }

    override suspend fun getEverythings(
        q: String?,
        from: String?,
        to: String?,
        qInTitle: String?,
        sources: String?,
        domains: String?,
        excludeDomains: String?,
        language: String?,
        sortBy: String?,
        pageSize: Int?,
        page: Int?,
        callback: NutriResponse.DataResponse<ArticleResponse>
    ) {
        newsRepository.getEverythings(
            apiKey,
            q,
            from,
            to,
            qInTitle,
            sources,
            domains,
            excludeDomains,
            language,
            sortBy,
            pageSize,
            page,
            callback
        )
    }

    override suspend fun getSources(
        language: String,
        country: String,
        category: String,
        callback: NutriResponse.DataResponse<SourceResponse>
    ) {
        newsRepository.getSources(
            apiKey,
            language,
            country,
            category,
            callback
        )
    }

    // Please Add Your Code Under This Line --------------------------------------------------------

}