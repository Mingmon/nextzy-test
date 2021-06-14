package com.example.android.newsapplication

import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.example.android.newsapplication.model.NewsDetail

@BindingAdapter("titleText")
fun TextView.setTitleText(news: NewsDetail?) {
    news?.title?.let {
        text = it
    }
}

@BindingAdapter("authorText")
fun TextView.setAuthorText(news: NewsDetail?) {
    news?.author?.let {
        text = it
    }
}