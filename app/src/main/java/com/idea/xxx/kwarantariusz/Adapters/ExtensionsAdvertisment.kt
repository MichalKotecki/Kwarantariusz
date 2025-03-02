package com.idea.xxx.kwarantariusz.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes

// this is used with advertisment RecyclerView
// https://www.raywenderlich.com/1560485-android-recyclerview-tutorial-with-kotlin


fun ViewGroup.inflate(@LayoutRes layoutRes: Int, attachToRoot: Boolean = false): View {
    return LayoutInflater.from(context).inflate(layoutRes, this, attachToRoot)
}