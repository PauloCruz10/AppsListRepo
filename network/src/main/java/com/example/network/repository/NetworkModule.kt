package com.example.network.repository

import com.example.network.api.ListAppsApi
import com.example.shareddata.db.dao.AppInfoDao
import dagger.Provides
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    @Provides
    fun provideApiService(retrofit: Retrofit): ListAppsApi {
        return retrofit.create(ListAppsApi::class.java)
    }

    @Provides
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://ws2.aptoide.com/api/6/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    fun provideUserRepository(apiService: ListAppsApi, appInfoDao: AppInfoDao): AppsRepository {
        return AppsRepositoryImplement(apiService, appInfoDao)
    }
}