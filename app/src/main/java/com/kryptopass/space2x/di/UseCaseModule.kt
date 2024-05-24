package com.kryptopass.space2x.di

import com.kryptopass.domain.repo.CompanyInfoRepository
import com.kryptopass.domain.repo.InteractionRepository
import com.kryptopass.domain.repo.LaunchRepository
import com.kryptopass.domain.usecase.GetCompanyInfoUseCase
import com.kryptopass.domain.usecase.GetLaunchUseCase
import com.kryptopass.domain.usecase.GetLaunchWithInteractionsUseCase
import com.kryptopass.domain.usecase.GetLaunchesUseCase
import com.kryptopass.domain.usecase.GetLaunchesWithInteractionUseCase
import com.kryptopass.domain.usecase.UpdateInteractionUseCase
import com.kryptopass.domain.usecase.UseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.Dispatchers

@Module
@InstallIn(SingletonComponent::class)
class UseCaseModule {

    @Provides
    fun provideUseCaseConfiguration(): UseCase.Configuration = UseCase.Configuration(Dispatchers.IO)

    @Provides
    fun provideGetCompanyInfoUseCase(
        configuration: UseCase.Configuration,
        repository: CompanyInfoRepository
    ): GetCompanyInfoUseCase = GetCompanyInfoUseCase(
        configuration,
        repository
    )

    @Provides
    fun provideGetLaunchesUseCase(
        configuration: UseCase.Configuration,
        repository: LaunchRepository
    ): GetLaunchesUseCase = GetLaunchesUseCase(
        configuration,
        repository
    )

    @Provides
    fun provideGetLaunchUseCase(
        configuration: UseCase.Configuration,
        repository: LaunchRepository
    ): GetLaunchUseCase = GetLaunchUseCase(
        configuration,
        repository
    )

    @Provides
    fun provideInteractionUseCase(
        configuration: UseCase.Configuration,
        repository: InteractionRepository
    ): UpdateInteractionUseCase = UpdateInteractionUseCase(
        configuration,
        repository
    )

    @Provides
    fun provideGetLaunchesWithInteractionUseCase(
        configuration: UseCase.Configuration,
        launchRepo: LaunchRepository,
        interactionRepo: InteractionRepository
    ): GetLaunchesWithInteractionUseCase = GetLaunchesWithInteractionUseCase(
        configuration,
        launchRepo,
        interactionRepo
    )

    @Provides
    fun provideGetLaunchWithInteractionsUseCase(
        configuration: UseCase.Configuration,
        launchRepo: LaunchRepository,
        interactionRepo: InteractionRepository
    ): GetLaunchWithInteractionsUseCase = GetLaunchWithInteractionsUseCase(
        configuration,
        launchRepo,
        interactionRepo
    )
}