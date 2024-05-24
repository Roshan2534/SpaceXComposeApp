package com.kryptopass.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.kryptopass.data.local.db.info.CompanyInfoDao
import com.kryptopass.data.local.db.info.CompanyInfoEntity
import com.kryptopass.data.local.db.interaction.InteractionDao
import com.kryptopass.data.local.db.interaction.InteractionEntity
import com.kryptopass.data.local.db.launch.LaunchDao
import com.kryptopass.data.local.db.launch.LaunchEntity
import com.kryptopass.data.local.util.SpaceConverters

@Database(
    entities = [
        CompanyInfoEntity::class,
        InteractionEntity::class,
        LaunchEntity::class
    ],
    version = 2,
    exportSchema = false
)
@TypeConverters(SpaceConverters::class)
abstract class SpaceXDatabase : RoomDatabase() {

    abstract fun companyInfoDao(): CompanyInfoDao

    abstract fun launchDao(): LaunchDao

    abstract fun interactionDao(): InteractionDao
}