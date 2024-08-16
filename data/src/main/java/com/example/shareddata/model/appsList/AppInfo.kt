package com.example.shareddata.model.appsList

data class AppInfo(
    val id: Long,
    val name: String? = null,
    val appPackage: String? = null,
    val storeId: Long? = null,
    val storeName: String? = null,
    val vername: String? = null,
    val vercode: Long? = null,
    val md5sum: String? = null,
    val apkTags: List<String> = listOf(),
    val size: Long? = null,
    val downloads: Long? = null,
    val pdownloads: Long? = null,
    val added: String? = null,
    val modified: String? = null,
    val updated: String? = null,
    val rating: String? = null,
    val icon: String? = null,
    val graphic: String? = null,
    val uptype: String? = null,
)