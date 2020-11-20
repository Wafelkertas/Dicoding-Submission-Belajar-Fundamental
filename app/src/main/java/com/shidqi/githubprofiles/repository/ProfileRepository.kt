package com.shidqi.githubprofiles.repository


import com.shidqi.githubprofiles.api.RetrofitInstance
import com.shidqi.githubprofiles.api.SearchAPI
import com.shidqi.githubprofiles.database.ItemDatabase
import com.shidqi.githubprofiles.models.Item
import com.shidqi.githubprofiles.models.SearchResponse
import com.shidqi.githubprofiles.models.UserSearch
import retrofit2.Response


class ProfileRepository(
    val db: ItemDatabase
) {
    suspend fun searchName(username: String) =
        RetrofitInstance.api.searchName(username)

    suspend fun getFollowing(username: String): Response<List<UserSearch>> {
        return RetrofitInstance.api.getUserFollowing(username)
    }

    suspend fun getFollower(username: String): Response<List<UserSearch>> {
        return RetrofitInstance.api.getUserFollowers(username)
    }

    suspend fun upsert(item: Item) = db.getItemDao().upsert(item)


    fun getProfiles() = db.getItemDao().getAllProfile()

    suspend fun deleteProfile(item: Item) = db.getItemDao().deleteProfile(item)

}