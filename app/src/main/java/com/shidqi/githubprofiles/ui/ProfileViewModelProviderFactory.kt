package com.shidqi.githubprofiles.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.shidqi.githubprofiles.repository.ProfileRepository
import com.shidqi.githubprofiles.repository.SearchRepository
import com.shidqi.githubprofiles.ui.viewmodel.ItemViewModel
import com.shidqi.githubprofiles.ui.viewmodel.ProfileViewModel

class ProfileViewModelProviderFactory(
    val ProfileRepository: ProfileRepository
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ProfileViewModel(
            ProfileRepository
        ) as T
    }
}