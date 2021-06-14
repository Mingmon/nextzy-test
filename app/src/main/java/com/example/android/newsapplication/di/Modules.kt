package com.example.android.newsapplication.di

import com.example.android.newsapplication.datasource.provideNewsApi
import com.example.android.newsapplication.datasource.provideOkHttpClient
import com.example.android.newsapplication.datasource.provideRetrofit
import com.example.android.newsapplication.newsList.NewsListFragment
import com.example.android.newsapplication.newsList.NewsListViewModel
import com.example.android.newsapplication.repo.NewsRepository
import org.koin.dsl.module

val networkModule = module {
    factory { provideOkHttpClient() }
    factory { provideRetrofit(get()) }
    single { provideNewsApi(get()) }
}

val repoModule = module {
    factory { NewsRepository(get()) }
}

val viewModelModule = module{
    factory { NewsListViewModel(get()) }
}

val fragmentModule = module {
    factory { NewsListFragment() }
}