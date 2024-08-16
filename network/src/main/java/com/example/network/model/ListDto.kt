package com.example.network.model

import com.google.gson.annotations.SerializedName

data class ListDto(
    @SerializedName("id") var id: Long? = null,
    @SerializedName("name") var name: String? = null,
    @SerializedName("package") var appPackage: String? = null,
    @SerializedName("store_id") var storeId: Long? = null,
    @SerializedName("store_name") var storeName: String? = null,
    @SerializedName("vername") var vername: String? = null,
    @SerializedName("vercode") var vercode: Long? = null,
    @SerializedName("md5sum") var md5sum: String? = null,
    @SerializedName("apk_tags") var apkTags: List<String> = listOf(),
    @SerializedName("size") var size: Long? = null,
    @SerializedName("downloads") var downloads: Long? = null,
    @SerializedName("pdownloads") var pdownloads: Long? = null,
    @SerializedName("added") var added: String? = null,
    @SerializedName("modified") var modified: String? = null,
    @SerializedName("updated") var updated: String? = null,
    @SerializedName("rating") var rating: String? = null,
    @SerializedName("icon") var icon: String? = null,
    @SerializedName("graphic") var graphic: String? = null,
    @SerializedName("uptype") var uptype: String? = null

)