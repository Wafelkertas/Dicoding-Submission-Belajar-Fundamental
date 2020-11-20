package com.shidqi.githubprofiles.ui.viewmodel


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shidqi.githubprofiles.models.Item
import com.shidqi.githubprofiles.models.SearchResponse
import com.shidqi.githubprofiles.repository.SearchRepository
import com.shidqi.githubprofiles.utils.Resource
import kotlinx.coroutines.launch
import retrofit2.Response

class ItemViewModel (
    val searchRepository: SearchRepository
) : ViewModel() {

    val searchUsers: MutableLiveData<Resource<SearchResponse>> = MutableLiveData()
    val searchUserPage = 1

    fun searchUsers(searchQuery: String) = viewModelScope.launch {
        searchUsers.postValue(Resource.Loading())
        val response = searchRepository.getSearchUser(searchQuery, searchUserPage)
        searchUsers.postValue(handleSearchUsersResponse(response))
    }

    private fun handleSearchUsersResponse(response: Response<SearchResponse>) : Resource<SearchResponse>{
        if(response.isSuccessful){
            response.body()?.let {resultResponse ->
                return Resource.Success(resultResponse)
            }
        }
        return Resource.Error(response.message())
    }


}