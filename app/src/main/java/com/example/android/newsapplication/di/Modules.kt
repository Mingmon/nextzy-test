package com.example.android.newsapplication.di

import com.example.android.newsapplication.datasource.AuthInterceptor
import com.example.android.newsapplication.datasource.provideNewsApi
import com.example.android.newsapplication.datasource.provideOkHttpClient
import com.example.android.newsapplication.datasource.provideRetrofit
import com.example.android.newsapplication.view.NewsListFragment
import com.example.android.newsapplication.viewModel.NewsListViewModel
import com.example.android.newsapplication.repo.NewsRepository
import com.example.android.newsapplication.usecase.NewsUseCase
import org.koin.dsl.module

val networkModule = module {
    factory { AuthInterceptor() }
    factory { provideOkHttpClient(get()) }
    factory { provideRetrofit(get()) }
    single { provideNewsApi(get()) }
}

val repoModule = module {
    factory { NewsRepository(get()) }
}

val viewModelModule = module {
    factory { NewsListViewModel(get()) }
}

val fragmentModule = module {
    factory { NewsListFragment() }
}

val useCaseModule = module {
    factory { NewsUseCase(get()) }
}