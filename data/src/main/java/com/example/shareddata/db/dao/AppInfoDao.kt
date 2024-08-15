package com.example.shareddata.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.shareddata.db.entity.AppEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface AppInfoDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertApp(appEntity: AppEntity)

    @Query("SELECT * FROM apps")
    fun getAllAppsFlow(): Flow<List<AppEntity>>

    @Query("SELECT * FROM apps WHERE id = :appId")
    fun getAppByIdFlow(appId: String): Flow<AppEntity?>
}