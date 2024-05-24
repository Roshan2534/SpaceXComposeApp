package com.kryptopass.domain.usecase

import com.kryptopass.domain.repo.InteractionRepository
import com.kryptopass.domain.repo.LaunchRepository
import kotlinx.coroutines.test.runTest
import org.junit.Test
import org.mockito.kotlin.mock

class GetLaunchWithInteractionsUseCaseTest {

    private val launchRepo = mock<LaunchRepository>()
    private val interactionRepo = mock<InteractionRepository>()

    private val useCase = GetLaunchesWithInteractionUseCase(
        mock(),
        launchRepo,
        interactionRepo
    )

    @Test
    fun testProcess() = runTest {

    }
}