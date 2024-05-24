package com.kryptopass.data.local.di

import android.content.Context
import androidx.room.Room
import com.kryptopass.data.local.db.SpaceXDatabase
import com.kryptopass.data.local.db.info.CompanyInfoDao
import com.kryptopass.data.local.db.launch.LaunchDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class PersistenceModule {

    @Provides
    fun provideAppDatabase(@ApplicationContext context: Context): SpaceXDatabase =
        Room.databaseBuilder(
            context,
            SpaceXDatabase::class.java, "spacex-database"
        ).fallbackToDestructiveMigration()
            .build()

    @Provides
    fun provideCompanyInfoDao(database: SpaceXDatabase): CompanyInfoDao = database.companyInfoDao()

    @Provides
    fun provideLaunchDao(database: SpaceXDatabase): LaunchDao = database.launchDao()

}