package com.example.android.newsapplication.newsList

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.android.newsapplication.model.NewsResponse
import com.example.android.newsapplication.repo.NewsRepository

class NewsListViewModel(
    private val newsRepository: NewsRepository
) : ViewModel() {

    val news: LiveData<NewsResponse> = liveData {
        emit(newsRepository.getNews())
    }
}