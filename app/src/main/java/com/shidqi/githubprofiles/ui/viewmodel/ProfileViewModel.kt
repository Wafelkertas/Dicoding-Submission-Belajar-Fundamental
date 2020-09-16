package com.shidqi.githubprofiles.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shidqi.githubprofiles.models.SearchResponse
import com.shidqi.githubprofiles.models.UserDetail
import com.shidqi.githubprofiles.repository.ProfileRepository
import com.shidqi.githubprofiles.utils.Resource
import kotlinx.coroutines.launch
import retrofit2.Response

class ProfileViewModel(
    val ProfileRepository: ProfileRepository
) : ViewModel() {
    val getName: MutableLiveData<Resource<UserDetail>> = MutableLiveData()



}