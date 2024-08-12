package com.example.network.api

import com.example.network.model.AllAppsInfoDto
import retrofit2.Response
import retrofit2.http.GET

interface ListAppsApi {
    @GET("bulkRequest/api_list/listApps")
    suspend fun getAll(): Response<AllAppsInfoDto>
}