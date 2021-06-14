package com.example.android.newsapplication.newsDetail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.navArgs
import com.example.android.newsapplication.R
import com.example.android.newsapplication.databinding.NewsDetailFragmentBinding

class NewsDetailFragment : Fragment() {

    private lateinit var detailBinding: NewsDetailFragmentBinding
    private val args: NewsDetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        detailBinding = DataBindingUtil.inflate(inflater,R.layout.news_detail_fragment, container, false)
        return detailBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpDetail()
    }

    private fun setUpDetail() {
        detailBinding.newsList = args.news
    }
}