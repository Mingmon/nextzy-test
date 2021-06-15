package com.example.android.newsapplication.repo

import com.example.android.newsapplication.datasource.NewsApi

class NewsRepository(private val newsApi: NewsApi) {
    suspend fun getNews() = newsApi.getNews()
}



