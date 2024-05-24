package com.kryptopass.domain.repo

import com.kryptopass.domain.entity.Interaction
import kotlinx.coroutines.flow.Flow

interface InteractionRepository {

    fun getInteraction(url: String?): Flow<Interaction>

    fun saveInteraction(interaction: Interaction): Flow<Interaction>
}