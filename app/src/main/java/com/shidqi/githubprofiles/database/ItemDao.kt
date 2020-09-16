package com.shidqi.githubprofiles.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.shidqi.githubprofiles.models.Item

@Dao
interface ItemDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(item: Item): Long

    @Query("SELECT * FROM profiles")
    fun getAllProfile(): LiveData<List<Item>>

    @Delete
    suspend fun deleteProfile(item: Item)
}