package com.shidqi.githubprofiles.models

import com.shidqi.githubprofiles.models.Item

//Kelas Resource untuk status
data class SearchResponse(
    val incomplete_results: Boolean,
    val items: List<Item>,
    val total_count: Int
)