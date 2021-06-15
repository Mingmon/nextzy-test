package com.example.android.newsapplication.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.android.newsapplication.model.NewsDetail
import com.example.android.newsapplication.usecase.NewsUseCase

class NewsListViewModel(
    private val newsUseCase: NewsUseCase
) : ViewModel() {

    val news: LiveData<List<NewsDetail>> = liveData {
        emit(newsUseCase.execute()!!)
    }
}