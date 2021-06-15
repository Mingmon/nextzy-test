package com.example.android.newsapplication.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.android.newsapplication.common.NewsClickListenerParameter
import com.example.android.newsapplication.common.NewsListAdapter
import com.example.android.newsapplication.R
import com.example.android.newsapplication.databinding.NewsListFragmentBinding
import com.example.android.newsapplication.model.NewsDetail
import com.example.android.newsapplication.newsList.NewsListFragmentDirections
import com.example.android.newsapplication.viewModel.NewsListViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class NewsListFragment : Fragment() {

    private val newsListViewModel: NewsListViewModel by viewModel()
    private lateinit var newsListFragmentBinding: NewsListFragmentBinding
    private lateinit var newsListAdapter: NewsListAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        newsListFragmentBinding =
            DataBindingUtil.inflate(inflater, R.layout.news_list_fragment, container, false)
        return newsListFragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpRecycleView()
        setUpViewModel()
    }

    private fun setUpRecycleView() {
        newsListAdapter = NewsListAdapter(OnNewsItemClick())
        newsListFragmentBinding.newsRecycler.run {
            adapter = newsListAdapter
            layoutManager = GridLayoutManager(this@NewsListFragment.context, 1)
        }
    }

    private fun setUpViewModel() {
        newsListViewModel.news.observe(viewLifecycleOwner, Observer {
            newsListAdapter.submitList(it?.toMutableList())
        })
    }

    private class OnNewsItemClick : NewsClickListenerParameter<NewsDetail> {
        override fun onClick(v: View?, item: NewsDetail) {
            v?.findNavController()?.navigate(
                NewsListFragmentDirections.actionNewsListFragmentToNewsDetailFragment(
                    item
                )
            )
        }
    }

}