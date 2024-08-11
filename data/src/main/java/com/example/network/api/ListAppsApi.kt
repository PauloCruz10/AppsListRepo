package com.example.network.api

import com.example.network.model.AllAppsInfo
import com.example.network.model.ListApps
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface ListAppsApi {
    @GET("bulkRequest/api_list/listApps")
    suspend fun getAll(): Response<AllAppsInfo>
}