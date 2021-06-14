package com.example.android.newsapplication.newsList

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.android.newsapplication.model.NewsDetail
import com.example.android.newsapplication.repo.NewsRepository

class NewsListViewModel(
    private val newsRepository: NewsRepository
) : ViewModel() {

    val news: LiveData<List<NewsDetail>> = liveData {
        newsRepository.getNews().articles?.let { emit(it) }
    }
}