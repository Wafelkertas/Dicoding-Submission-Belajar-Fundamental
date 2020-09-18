package com.shidqi.githubprofiles.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize
import java.io.Serializable

@Entity(
    tableName = "profiles"

)
data class ItemEntity(
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null,
    val avatar_url: String,
    val events_url: String,
    val followers_url: String,
    val following_url: String,
    val gists_url: String,
    val gravatar_id: String,
    val html_url: String,
    val login: String,
    val url: String,
    val name: String
) : Serializable