package com.kryptopass.data.repository.source.local

import com.kryptopass.domain.entity.Interaction
import kotlinx.coroutines.flow.Flow

interface LocalInteractionDataSource {

    fun getInteraction(url: String?): Flow<Interaction>

    suspend fun addInteraction(interaction: Interaction)
}