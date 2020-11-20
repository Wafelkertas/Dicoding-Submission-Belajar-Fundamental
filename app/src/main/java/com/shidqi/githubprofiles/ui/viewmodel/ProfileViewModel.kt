package com.shidqi.githubprofiles.ui.viewmodel


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shidqi.githubprofiles.models.SearchResponse
import com.shidqi.githubprofiles.models.UserSearch

import com.shidqi.githubprofiles.repository.ProfileRepository
import com.shidqi.githubprofiles.utils.Resource
import kotlinx.coroutines.launch
import retrofit2.Response


class ProfileViewModel(
    val profileRepository: ProfileRepository
) : ViewModel() {


    val searchFollowing: MutableLiveData<Resource<List<UserSearch>>> = MutableLiveData()
    val searchFollower: MutableLiveData<Resource<List<UserSearch>>> = MutableLiveData()




    fun searchProfileFollower(username: String) = viewModelScope.launch {
        searchFollower.postValue(Resource.Loading())
        val response = profileRepository.getFollower(username)
        searchFollower.postValue(handleSearchProfileFollower(response))
    }

    private fun handleSearchProfileFollower(response: Response<List<UserSearch>>) : Resource<List<UserSearch>>{
        if(response.isSuccessful){
            response.body()?.let {resultResponse ->
                return Resource.Success(resultResponse)
            }
        }
        return Resource.Error(response.message())
    }

    fun searchProfileFollowing(username: String) = viewModelScope.launch {
        searchFollowing.postValue(Resource.Loading())
        val response = profileRepository.getFollowing(username)
        searchFollowing.postValue(handleSearchProfileFollowing(response))
    }

    private fun handleSearchProfileFollowing(response: Response<List<UserSearch>>) : Resource<List<UserSearch>>{
        if(response.isSuccessful){
            response.body()?.let {resultResponse ->
                return Resource.Success(resultResponse)
            }
        }
        return Resource.Error(response.message())
    }


}