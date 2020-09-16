package com.shidqi.githubprofiles.api

import com.shidqi.githubprofiles.models.Item
import com.shidqi.githubprofiles.models.SearchResponse
import com.shidqi.githubprofiles.models.UserDetail
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import java.util.*

interface SearchAPI {

    @GET("search/users")
    suspend fun searchUsers(
        @Query("q")
        searchQuery: String,
        @Query("page")
        pageNumber: Int = 1
    ) : Response<SearchResponse>

    @GET("users/{username}")
    suspend fun searchName(
        @Query("users/{username}")
        username: String
    ) : Response<UserDetail>


    @GET("users/{username}/followers")
    suspend fun getUserFollowers(
        @Path("username") username: String
    ): Response<List<UserDetail>>

    @GET("users/{username}/following")
    suspend fun getUserFollowing(
        @Path("username") username: String
    ): Response<List<UserDetail>>
}