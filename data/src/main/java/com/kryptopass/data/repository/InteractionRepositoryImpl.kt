package com.kryptopass.data.repository

import com.kryptopass.data.repository.source.local.LocalInteractionDataSource
import com.kryptopass.domain.entity.Interaction
import com.kryptopass.domain.repo.InteractionRepository
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.flow

@OptIn(ExperimentalCoroutinesApi::class)
class InteractionRepositoryImpl(
    private val dataSource: LocalInteractionDataSource
) : InteractionRepository {

    override fun getInteraction(url: String?): Flow<Interaction> =
        dataSource.getInteraction(url)

    override fun saveInteraction(interaction: Interaction): Flow<Interaction> =
        flow {
            dataSource.addInteraction(interaction)
            this.emit(Unit)
        }.flatMapLatest {
            getInteraction(interaction.url)
        }
}