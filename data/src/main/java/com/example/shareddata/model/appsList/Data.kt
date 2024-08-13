package com.example.shareddata.model.appsList

data class Data(
    val total: Int? = null,
    val offset: Int? = null,
    val limit: Int? = null,
    val next: Int? = null,
    val hidden: Int? = null,
    val list: List<AppInfo> = listOf(),
)