package com.example.shareddata.db.di

import android.content.Context
import androidx.room.Room
import com.example.shareddata.db.dao.AppInfoDao
import com.example.shareddata.db.database.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
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
}