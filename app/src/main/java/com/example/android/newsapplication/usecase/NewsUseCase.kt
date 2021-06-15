package com.example.android.newsapplication.usecase

import com.example.android.newsapplication.model.NewsDetail
import com.example.android.newsapplication.repo.NewsRepository

class NewsUseCase(private val newsRepository: NewsRepository) {
    suspend fun execute(): List<NewsDetail>? = newsRepository.getNews().articles
}