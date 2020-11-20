package com.shidqi.githubprofiles.api

import com.shidqi.githubprofiles.models.Item
import com.shidqi.githubprofiles.models.SearchResponse

import com.shidqi.githubprofiles.models.UserSearch
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import java.util.*

interface SearchAPI {

    //Fungsi suspend mencari user
    @GET("search/users")
    suspend fun searchUsers(
        @Query("q")
        searchQuery: String,
        @Query("page")
        pageNumber: Int = 1
    ) : Response<SearchResponse>


    @GET("users/{username}")
    suspend fun searchName(
        @Path("username")
        username: String
    ) : Response<UserSearch>


    @GET("users/{username}/followers")
    suspend fun getUserFollowers(
        @Path("username") username: String
    ) : Response<List<UserSearch>>

    @GET("users/{username}/following")
    suspend fun getUserFollowing(
        @Path("username") username: String
    ) : Response<List<UserSearch>>
}