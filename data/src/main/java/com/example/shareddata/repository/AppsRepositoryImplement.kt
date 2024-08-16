package com.example.shareddata.repository

import com.example.network.api.ListAppsApi
import com.example.shareddata.common.Resource
import com.example.shareddata.db.dao.AppInfoDao
import com.example.shareddata.logger.Logger
import com.example.shareddata.mappers.mapToAppInfoList
import com.example.shareddata.mappers.mapToEntity
import com.example.shareddata.mappers.mapToLib
import com.example.shareddata.model.appsList.AppInfo
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emitAll
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import javax.inject.Inject
import kotlin.random.Random

/**
 * Implementation of [AppsRepository]
 */
class AppsRepositoryImplement @Inject constructor(private val listAppsApi: ListAppsApi, private val appInfoDao: AppInfoDao) : AppsRepository {
    /**
     * Loads the apps from the network, and save into the database.
     * The consumers will be notified when collecting to the flow provided by room engine
     */
    override suspend fun loadApps(): Resource<Unit> {
        return withDelay {
            try {
                val response = listAppsApi.getAll()
                val body = if (!response.isSuccessful) return@withDelay Resource.Failure() else response.body()
                if (body != null) {
                    val apps = body.responses?.listApps?.datasets?.all?.data?.list?.mapToEntity()
                    if (apps != null) {
                        apps.forEach { app ->
                            Logger.d("loadApps", "app=$app")
                            appInfoDao.insertApp(app)
                        }
                        Resource.Success(Unit)
                    } else {
                        Logger.d("loadApps", "empty body")
                        Resource.Failure()
                    }
                } else {
                    Resource.Failure()
                }
            } catch (e: Exception) {
                println("dude e=$e")
                Logger.e("loadApps", "unable to load the apps", "$e")
                Resource.Failure()
            }
        }
    }

    /**
     * Gets all apps from the database with flow. Listeners will be notified on any changes
     */
    override suspend fun getApps(): Flow<Resource<List<AppInfo>>> {
        return flow {
            emit(Resource.Loading())

            emitAll(
                appInfoDao.getAllAppsFlow().map { apps ->
                    Logger.d("getApps", "apps=$apps")
                    Resource.Success(apps.mapToAppInfoList())
                }
            )
        }.flowOn(Dispatchers.IO)
    }

    /**
     * Get app for a given[id] with flow
     */
    override suspend fun getAppById(id: Long): Flow<Resource<AppInfo>> {
        return flow {
            emit(Resource.Loading())

            emitAll(
                appInfoDao.getAppByIdFlow(id.toString()).map { app ->
                    Logger.d("getAppById", "app=$app")
                    if (app == null) Resource.Failure() else Resource.Success(app.mapToLib())
                }
            )
        }.flowOn(Dispatchers.IO)
    }
}

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
