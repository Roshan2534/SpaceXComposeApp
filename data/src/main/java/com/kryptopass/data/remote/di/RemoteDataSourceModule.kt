package com.kryptopass.data.remote.di

import com.kryptopass.data.remote.source.RemoteCompanyInfoDataSourceImpl
import com.kryptopass.data.remote.source.RemoteLaunchDataSourceImpl
import com.kryptopass.data.repository.source.remote.RemoteCompanyInfoDataSource
import com.kryptopass.data.repository.source.remote.RemoteLaunchDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RemoteDataSourceModule {

    @Binds
    abstract fun bindCompanyInfoDataSource(datasource: RemoteCompanyInfoDataSourceImpl): RemoteCompanyInfoDataSource

    @Binds
    abstract fun bindLaunchDataSource(datasource: RemoteLaunchDataSourceImpl): RemoteLaunchDataSource
}
