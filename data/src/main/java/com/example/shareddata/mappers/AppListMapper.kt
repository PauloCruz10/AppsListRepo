package com.example.shareddata.mappers

import com.example.network.model.ListDto
import com.example.shareddata.db.entity.AppEntity
import com.example.shareddata.model.appsList.AppInfo

fun ListDto.mapToEntity(): AppEntity? {
    val appId = id ?: return null
    return AppEntity(
        appId,
        name,
        appPackage,
        storeId,
        storeName,
        vername,
        vercode,
        md5sum,
        apkTags,
        size,
        downloads,
        pdownloads,
        added,
        modified,
        updated,
        rating,
        icon,
        graphic,
        uptype
    )
}

fun List<ListDto>.mapToEntity() = this.mapNotNull { it.mapToEntity() }

fun List<AppEntity>.mapToAppInfoList(): List<AppInfo> {
    return this.map {
        it.mapToLib()
    }
}

fun AppEntity.mapToLib(): AppInfo {
    return AppInfo(
        id,
        name,
        appPackage,
        storeId,
        storeName,
        vername,
        vercode,
        md5sum,
        apkTags,
        size,
        downloads,
        pdownloads,
        added,
        modified,
        updated,
        rating,
        icon,
        graphic,
        uptype
    )
}

