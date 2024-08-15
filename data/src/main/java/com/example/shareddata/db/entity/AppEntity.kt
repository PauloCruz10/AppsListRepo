package com.example.shareddata.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "apps")
data class AppEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0, // Set default value to 0
    val name: String?,
    val appPackage: String?,
    val storeId: Int?,
    val storeName: String?,
    val vername: String?,
    val vercode: Int?,
    val md5sum: String?,
    val apkTags: List<String>,
    val size: Int?,
    val downloads: Int?,
    val pdownloads: Int?,
    val added: String?,
    val modified: String?,
    val updated: String?,
    val rating: String?,
    val icon: String?,
    val graphic: String?,
    val uptype: String?,
)