package com.kryptopass.domain.usecase

import com.kryptopass.domain.entity.Interaction
import com.kryptopass.domain.repo.InteractionRepository
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever

class UpdateInteractionUseCaseTest {

    private val repository = mock<InteractionRepository>()
    private val useCase = UpdateInteractionUseCase(
        mock(),
        repository
    )

    @Test
    fun testProcess() = runTest {
        val interaction = Interaction("https://en.wikipedia.org/wiki/Dragon_C2%2B", 11)
        val request = UpdateInteractionUseCase.Request(interaction)

        whenever(repository.saveInteraction(interaction)).thenReturn(flowOf(interaction))
        val response = useCase.process(request).first()

        Assert.assertEquals(UpdateInteractionUseCase.Response, response)
    }
}