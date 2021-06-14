package com.example.android.newsapplication

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.android.newsapplication.databinding.ViewNewsItemBinding
import com.example.android.newsapplication.model.DealItemDiff
import com.example.android.newsapplication.model.NewsDetail

class NewsListAdapter(
    private val clickListenerParameter: NewsClickListenerParameter<NewsDetail>
) : ListAdapter<NewsDetail, NewsListAdapter.ViewHolder>(DealItemDiff()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsListAdapter.ViewHolder {
        val viewBinding = ViewNewsItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(viewBinding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.bindView(item)
    }

    inner class ViewHolder (private val viewBinding: ViewNewsItemBinding) :
        RecyclerView.ViewHolder(viewBinding.root) {

        init {
            viewBinding.root.setOnClickListener {
                clickListenerParameter.onClick(it,getItem(layoutPosition))
            }
        }

        fun bindView(news:NewsDetail) {
            viewBinding.newsList = news
            viewBinding.executePendingBindings()
        }
    }
}