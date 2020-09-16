package com.shidqi.githubprofiles.repository


import com.shidqi.githubprofiles.api.RetrofitInstance
import com.shidqi.githubprofiles.api.SearchAPI
import com.shidqi.githubprofiles.database.ItemDatabase



class ProfileRepository(
    val db: ItemDatabase

) {
    suspend fun searchName(usernane: String) =
        RetrofitInstance.api.searchUsers(usernane)

    suspend fun getFollowing(searchQuery: String) =
        RetrofitInstance.api.getUserFollowing(searchQuery)

    suspend fun getFollower(searchQuery: String) =
        RetrofitInstance.api.getUserFollowers(searchQuery)

}