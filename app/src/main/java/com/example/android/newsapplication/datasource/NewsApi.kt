package com.example.android.newsapplication.datasource

import com.example.android.newsapplication.model.NewsResponse
import retrofit2.http.GET

interface NewsApi {
    @GET("everything?q=Apple")
    suspend fun getNews(): NewsResponse
}