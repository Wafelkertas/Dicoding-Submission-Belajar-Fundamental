package com.shidqi.githubprofiles.database

import android.database.Cursor
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

    @Query("SELECT * FROM profiles WHERE id = :userId")
    fun getUserById(userId: Int): Cursor

    @Query("DELETE FROM profiles WHERE id = :userId")
    fun deleteUser(userId: Int): Int

    @Query("SELECT * FROM profiles ORDER BY name ASC")
    fun getUsers(): Cursor

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUser(item: Item): Long



}