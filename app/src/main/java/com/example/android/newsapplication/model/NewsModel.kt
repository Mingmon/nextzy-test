package com.example.android.newsapplication.model

data class NewsResponse (
    var status: String?,
    var totalResults : String?,
    var articles: List<NewsDetail>?
)

data class NewsDetail(
    val source : SourceItem?,
    val author : String?,
    val title : String?,
    val description : String?,
    val url : String?,
    val urlToImage : String?,
    val publishedAt : String?,
    val content : String?
)

data class SourceItem(
    val id : String?,
    val name : String?
)