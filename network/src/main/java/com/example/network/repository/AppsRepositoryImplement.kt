package com.example.network.repository

import com.example.network.api.ListAppsApi
import com.example.network.mappers.mapToLib
import com.example.shareddata.common.Resource
import com.example.shareddata.model.appsList.AllAppsInfo
import com.example.shareddata.model.appsList.AppInfo
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Delay
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

import javax.inject.Inject
import kotlin.random.Random

class AppsRepositoryImplement @Inject constructor(private val listAppsApi: ListAppsApi) : AppsRepository {
    override suspend fun getApps(): Resource<List<AppInfo>> {
        return withDelay {
            val response = listAppsApi.getAll()
            val body = response.body()
            if (response.isSuccessful && body != null) {
                val apps = body.mapToLib().responses?.listApps?.datasets?.all?.data?.list
                if (apps != null) Resource.Success(apps) else Resource.Failure()
            } else {
                Resource.Failure()
            }
        }
    }

    override suspend fun getAppById(id: Long): Resource<AppInfo> {
        val appsResource = getApps()
        return handleResult(id, appsResource)
    }

    private fun handleResult(appId: Long, info: Resource<List<AppInfo>>): Resource<AppInfo> {
        return when (info) {
            is Resource.Success -> {
                val app = info.data.firstOrNull { it.id == appId}
                if (app != null) Resource.Success(app) else Resource.Failure()
            }
            is Resource.Failure -> Resource.Failure()
            is Resource.Loading -> Resource.Loading()
        }
    }
}

/**
 * Mock some delay on [task] execution
 */
private suspend fun <T> withDelay(
    delayInMilSec: Long = Random.nextLong(300, 1500),
    coroutineDispatcher: CoroutineDispatcher = Dispatchers.IO,
    task: suspend () -> T,
): T {
    return withContext(context = coroutineDispatcher) {
        delay(delayInMilSec)
        task()
    }
}
