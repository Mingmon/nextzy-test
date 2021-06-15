package com.example.android.newsapplication

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.MultiTransformation
import com.bumptech.glide.load.resource.bitmap.FitCenter
import com.bumptech.glide.load.resource.bitmap.GranularRoundedCorners
import com.example.android.newsapplication.model.NewsDetail

@BindingAdapter("titleText")
fun TextView.setTitleText(news: NewsDetail?) {
    news?.title?.let {
        text = it
    }
}

@BindingAdapter("sourceText")
fun TextView.sourceText(news: NewsDetail?) {
    news?.source?.name?.let {
        text = it.substringBefore(".")
    }
}

@BindingAdapter("newsImage")
fun ImageView.setNewsImage(news: NewsDetail?){
    news?.urlToImage?.let {
        Glide.with(this)
            .load(it)
            .transform(
                MultiTransformation(
                    FitCenter(),
                    GranularRoundedCorners(15.0F, 0F, 0F, 15.0F)
                )
            )
            .into(this)
    }
}