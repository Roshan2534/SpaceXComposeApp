package com.kryptopass.domain.usecase

import com.kryptopass.domain.entity.launch.Launch
import com.kryptopass.domain.repo.LaunchRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GetLaunchUseCase(
    configuration: Configuration,
    private val repository: LaunchRepository
) : UseCase<GetLaunchUseCase.Request, GetLaunchUseCase.Response>(configuration) {

    override fun process(request: Request): Flow<Response> =
        repository.getLaunch(request.flightNumber)
            .map {
                Response(it)
            }

    data class Request(val flightNumber: Int?) : UseCase.Request
    data class Response(val launch: Launch) : UseCase.Response
}