package com.example.shareddata.model.appsList

data class AppInfo(
    val id: Long,
    val name: String? = null,
    val appPackage: String? = null,
    val storeId: Int? = null,
    val storeName: String? = null,
    val vername: String? = null,
    val vercode: Int? = null,
    val md5sum: String? = null,
    val apkTags: List<String> = listOf(),
    val size: Int? = null,
    val downloads: Int? = null,
    val pdownloads: Int? = null,
    val added: String? = null,
    val modified: String? = null,
    val updated: String? = null,
    val rating: String? = null,
    val icon: String? = null,
    val graphic: String? = null,
    val uptype: String? = null,
)