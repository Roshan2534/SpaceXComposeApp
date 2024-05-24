package com.kryptopass.data.local

import com.kryptopass.data.local.db.interaction.InteractionDao
import com.kryptopass.data.local.db.interaction.InteractionEntity
import com.kryptopass.data.local.source.LocalInteractionDataSourceImpl
import com.kryptopass.domain.entity.Interaction
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runTest
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify
import org.mockito.kotlin.whenever

class LocalInteractionDataSourceImplTest {

    private val dao = mock<InteractionDao>()
    private val dataSource = LocalInteractionDataSourceImpl(dao)

    private val clicks = 10
    private val url = "https://en.wikipedia.org/wiki/Dragon_C2%2B"

    @Test
    fun testGetInteraction() = runTest {
        val localInteraction = InteractionEntity(null, url, clicks)
        val expectedInteraction = Interaction(url, clicks)

        whenever(dao.getInteraction(url)).thenReturn(flowOf(localInteraction))
        val result = dataSource.getInteraction(url).first()

        assertEquals(expectedInteraction, result)
    }

    @Test
    fun testAddInteraction() = runTest {
        val localInteraction = InteractionEntity(null, url, clicks)
        val interaction = Interaction(url, clicks)

        dataSource.addInteraction(interaction)

        verify(dao).insertInteraction(localInteraction)
    }
}