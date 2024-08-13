package com.example.network.repository

import com.example.shareddata.model.appsList.AllAppsInfo

interface AppsRepository {
    suspend fun getApps(): AllAppsInfo?
}