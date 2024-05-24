package com.kryptopass.space2x.di

import com.kryptopass.data.repository.CompanyInfoRepositoryImpl
import com.kryptopass.data.repository.InteractionRepositoryImpl
import com.kryptopass.data.repository.LaunchRepositoryImpl
import com.kryptopass.data.repository.source.local.LocalCompanyInfoDataSource
import com.kryptopass.data.repository.source.local.LocalInteractionDataSource
import com.kryptopass.data.repository.source.local.LocalLaunchDataSource
import com.kryptopass.data.repository.source.remote.RemoteCompanyInfoDataSource
import com.kryptopass.data.repository.source.remote.RemoteLaunchDataSource
import com.kryptopass.domain.repo.CompanyInfoRepository
import com.kryptopass.domain.repo.InteractionRepository
import com.kryptopass.domain.repo.LaunchRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Provides
    fun provideCompanyInfoRepository(
        remoteSource: RemoteCompanyInfoDataSource,
        localSource: LocalCompanyInfoDataSource
    ): CompanyInfoRepository = CompanyInfoRepositoryImpl(
        remoteSource,
        localSource
    )

    @Provides
    fun provideLaunchRepository(
        remoteSource: RemoteLaunchDataSource,
        localSource: LocalLaunchDataSource
    ): LaunchRepository = LaunchRepositoryImpl(
        remoteSource,
        localSource
    )

    @Provides
    fun provideInteractionRepository(
        localSource: LocalInteractionDataSource
    ): InteractionRepository = InteractionRepositoryImpl(
        localSource
    )
}