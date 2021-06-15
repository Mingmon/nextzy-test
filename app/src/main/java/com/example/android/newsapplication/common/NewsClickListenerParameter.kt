package com.example.android.newsapplication.common

import android.view.View

interface NewsClickListenerParameter<T> {
    fun onClick(v: View?, item: T)
}
