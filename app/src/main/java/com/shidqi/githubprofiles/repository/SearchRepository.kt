package com.shidqi.githubprofiles.repository

import com.shidqi.githubprofiles.api.RetrofitInstance


class SearchRepository() {
    suspend fun getSearchUser(searchQuery: String, pageNumber: Int) =
        RetrofitInstance.api.searchUsers(searchQuery, pageNumber)


}