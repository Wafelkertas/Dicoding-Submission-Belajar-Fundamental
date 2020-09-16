package com.shidqi.githubprofiles.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.shidqi.githubprofiles.repository.SearchRepository
import com.shidqi.githubprofiles.ui.viewmodel.ItemViewModel

class ItemViewModelProviderFactory(
    val SearchRepository: SearchRepository
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ItemViewModel(
            SearchRepository
        ) as T
    }
}