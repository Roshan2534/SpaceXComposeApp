package com.kryptopass.data.local.source

import com.kryptopass.data.local.db.interaction.InteractionDao
import com.kryptopass.data.local.db.interaction.InteractionEntity
import com.kryptopass.data.repository.source.local.LocalInteractionDataSource
import com.kryptopass.domain.entity.Interaction
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class LocalInteractionDataSourceImpl @Inject constructor(
    private val dao: InteractionDao
): LocalInteractionDataSource {

    override fun getInteraction(url: String?): Flow<Interaction> =
        dao.getInteraction(url).map {
            Interaction(
                it.url, it.clickCount
            )
        }

    override suspend fun addInteraction(interaction: Interaction) =
        dao.insertInteraction(
            InteractionEntity(
                null, interaction.url, interaction.clickCount
            )
        )
}