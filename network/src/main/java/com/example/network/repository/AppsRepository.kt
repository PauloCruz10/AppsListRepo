package com.example.network.repository

import com.example.shareddata.common.Resource
import com.example.shareddata.model.appsList.AppInfo

interface AppsRepository {
    suspend fun getApps(): Resource<List<AppInfo>>
    suspend fun getAppById(id: Long): Resource<AppInfo>
}