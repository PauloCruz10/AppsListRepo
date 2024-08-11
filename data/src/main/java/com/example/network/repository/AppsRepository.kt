package com.example.network.repository

import com.example.network.model.AllAppsInfo

interface AppsRepository {
    suspend fun getApps(): AllAppsInfo?
}