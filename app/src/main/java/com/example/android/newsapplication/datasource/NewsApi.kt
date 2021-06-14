package com.example.android.newsapplication.datasource

import com.example.android.newsapplication.model.NewsResponse
import retrofit2.http.GET

interface NewsApi {
    @GET("everything?q=Apple&apiKey=38294b59ee0146a0b7c7868be03fcab4")
    suspend fun getNews(): NewsResponse
}