package com.kryptopass.domain.usecase

import com.kryptopass.domain.entity.Interaction
import com.kryptopass.domain.repo.InteractionRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class UpdateInteractionUseCase(
    configuration: Configuration,
    private val interactionRepository: InteractionRepository
) : UseCase<UpdateInteractionUseCase.Request, UpdateInteractionUseCase.Response>(configuration) {

    override fun process(request: Request): Flow<Response> {
        return interactionRepository.saveInteraction(request.interaction)
            .map {
                Response
            }
    }

    data class Request(val interaction: Interaction) : UseCase.Request

    object Response : UseCase.Response
}