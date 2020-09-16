package com.shidqi.githubprofiles.repository

import com.shidqi.githubprofiles.api.RetrofitInstance
import com.shidqi.githubprofiles.database.ItemDatabase

class SearchRepository(
    val db: ItemDatabase
) {
    suspend fun getSearchUser(searchQuery: String, pageNumber: Int) =
        RetrofitInstance.api.searchUsers(searchQuery, pageNumber)


}