package com.example.network.repository

import com.example.network.api.ListAppsApi
import com.example.network.mappers.mapToLib
import com.example.shareddata.model.appsList.AllAppsInfo

import javax.inject.Inject

class AppsRepositoryImplement @Inject constructor(private val listAppsApi: ListAppsApi): AppsRepository {
    override suspend fun getApps(): AllAppsInfo? {
        return listAppsApi.getAll().body()?.mapToLib()
    }
}