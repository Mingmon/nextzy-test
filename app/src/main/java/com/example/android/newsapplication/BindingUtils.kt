package com.example.android.newsapplication

import android.annotation.SuppressLint
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.MultiTransformation
import com.bumptech.glide.load.resource.bitmap.CenterCrop
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

@BindingAdapter("authorText")
fun TextView.setAuthorText(news: NewsDetail?) {
    news?.author?.let {
        text = it.substringAfterLast("/").replace("-"," ")
    }
}
@BindingAdapter("dateTimeText")
fun TextView.setDateTimeText(news: NewsDetail?) {
    news?.publishedAt?.let {
        text = it.replace("[-TZ]".toRegex()," ")
    }
}

@BindingAdapter("contentText")
fun TextView.setContentText(news: NewsDetail?) {
    news?.content?.let {
        text = it
    }
}

@SuppressLint("SetTextI18n")
@BindingAdapter("urlText")
fun TextView.setUrlText(news: NewsDetail?) {
    news?.url?.let {
        text = "Source : $it"
    }
}

@BindingAdapter("newsImage")
fun ImageView.setNewsImage(news: NewsDetail?) {
    news?.urlToImage?.let {
        Glide.with(this)
            .load(it)
            .transform(
                MultiTransformation(
                    CenterCrop(),
                    GranularRoundedCorners(30.0F, 0F, 0F, 30.0F)
                )
            )
            .into(this)
    }
}

@BindingAdapter("newsDetailImage")
fun ImageView.setNewsDetailImage(news: NewsDetail?) {
    news?.urlToImage?.let {
        Glide.with(this)
            .load(it)
            .transform(
                MultiTransformation(
                    FitCenter(),
                    GranularRoundedCorners(0.0F, 0F, 100.0F, 100.0F)
                )
            )
            .into(this)
    }
}
