package com.example.android.newsapplication.newsList

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.example.android.newsapplication.R
import com.example.android.newsapplication.databinding.NewsListFragmentBinding
import com.example.android.newsapplication.model.NewsResponse
import org.koin.androidx.viewmodel.ext.android.viewModel

class NewsListFragment : Fragment() {

    val newsListViewModel: NewsListViewModel by viewModel()
    private lateinit var newsListBinding: NewsListFragmentBinding

    private val observer = Observer<NewsResponse>{
        newsListBinding.testTextView.text = "test get title from article news index 0 = ${it.articles?.get(0)?.title}"
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        newsListBinding = DataBindingUtil.inflate(inflater,R.layout.news_list_fragment, container, false)
        newsListViewModel.news.observe(viewLifecycleOwner,observer)
        return newsListBinding.root
    }

}