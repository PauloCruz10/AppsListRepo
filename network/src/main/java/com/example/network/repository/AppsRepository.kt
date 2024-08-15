package com.example.network.repository

import com.example.shareddata.common.Resource
import com.example.shareddata.model.appsList.AppInfo
import kotlinx.coroutines.flow.Flow

/**
 * Defines the Apps repository actions
 */
interface AppsRepository {
    /**
     * Loads all the apps
     */
    suspend fun loadApps(): Resource<Unit>

    /**
     * Get all the apps hold in an [Flow]
     */
    suspend fun getApps(): Flow<Resource<List<AppInfo>>>

    /**
     * Get app by [id] on [Flow]
     */
    suspend fun getAppById(id: Long): Flow<Resource<AppInfo>>
}