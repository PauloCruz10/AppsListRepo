package com.example.shareddata.db.di

import android.content.Context
import androidx.room.Room
import com.example.network.api.ListAppsApi
import com.example.shareddata.db.dao.AppInfoDao
import com.example.shareddata.db.database.AppDatabase
import com.example.shareddata.repository.AppsRepository
import com.example.shareddata.repository.AppsRepositoryImplement
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModule {
    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java,
        "test_database"
        ).build()
    }

    @Provides
    @Singleton
    fun provideAppInfoDao(db: AppDatabase): AppInfoDao {
        return db.appInfoDao()
    }

    @Provides
    fun provideAppsRepository(apiService: ListAppsApi, appInfoDao: AppInfoDao): AppsRepository {
        return AppsRepositoryImplement(apiService, appInfoDao)
    }
}