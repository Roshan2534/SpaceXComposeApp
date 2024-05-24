package com.kryptopass.data.repository

import com.kryptopass.data.repository.source.local.LocalInteractionDataSource
import com.kryptopass.domain.entity.Interaction
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runTest
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify
import org.mockito.kotlin.whenever

class InteractionRepositoryImplTest {

    private val localSource = mock<LocalInteractionDataSource>()
    private val repository = InteractionRepositoryImpl(localSource)

    private val url = "https://en.wikipedia.org/wiki/Dragon_C2%2B"

    @Test
    fun testGetInteraction() = runTest {
        val interaction = Interaction(url, 10)

        whenever(localSource.getInteraction(url)).thenReturn(flowOf(interaction))
        val result = repository.getInteraction(url).first()

        assertEquals(interaction, result)
    }

    @Test
    fun testSaveInteraction() = runTest {
        val interaction = Interaction(url, 10)

        whenever(localSource.getInteraction(url)).thenReturn(flowOf(interaction))
        val result = repository.saveInteraction(interaction).first()

        verify(localSource).addInteraction(interaction)
        assertEquals(interaction, result)
    }
}