package com.kryptopass.domain.usecase

import com.kryptopass.domain.entity.Interaction
import com.kryptopass.domain.entity.launch.Launch
import com.kryptopass.domain.repo.InteractionRepository
import com.kryptopass.domain.repo.LaunchRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.combine

class GetLaunchWithInteractionsUseCase(
    configuration: UseCase.Configuration,
    private val launchRepo: LaunchRepository,
    private val interactionRepo: InteractionRepository
): UseCase<GetLaunchWithInteractionsUseCase.Request,
        GetLaunchWithInteractionsUseCase.Response>(configuration) {

    override fun process(request: Request): Flow<Response> =
        combine(
            launchRepo.getLaunch(request.flightNumber),
            interactionRepo.getInteraction(request.url)
        ) { launch, interaction ->
            Response(launch, interaction)
        }

    data class Request(val flightNumber: Int?, val url: String?) : UseCase.Request

    data class Response(
        val launch: Launch,
        val interaction: Interaction
    ) : UseCase.Response
}