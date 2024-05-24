package com.kryptopass.data.local.db.interaction

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface InteractionDao {

    @Query("SELECT * FROM interaction WHERE url = :url LIMIT 1")
    fun getInteraction(url: String?): Flow<InteractionEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertInteraction(interaction: InteractionEntity)
}