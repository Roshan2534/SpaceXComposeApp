package com.kryptopass.data.local.di

import com.kryptopass.data.local.source.LocalCompanyInfoDataSourceImpl
import com.kryptopass.data.local.source.LocalLaunchDataSourceImpl
import com.kryptopass.data.repository.source.local.LocalCompanyInfoDataSource
import com.kryptopass.data.repository.source.local.LocalLaunchDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class LocalDataSourceModule {

    @Binds
    abstract fun bindCompanyInfoDataSource(dataSource: LocalCompanyInfoDataSourceImpl): LocalCompanyInfoDataSource

    @Binds
    abstract fun bindLaunchDataSource(dataSource: LocalLaunchDataSourceImpl): LocalLaunchDataSource

}