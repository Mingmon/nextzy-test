package com.example.android.newsapplication.datasource

import okhttp3.Interceptor
import okhttp3.Response

class AuthInterceptor() : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        var req = chain.request()
        val url = req.url().newBuilder()
            .addQueryParameter("apiKey", "38294b59ee0146a0b7c7868be03fcab4").build()
        req = req.newBuilder().url(url).build()
        return chain.proceed(req)
    }
}