package com.kryptopass.domain.usecase

import com.kryptopass.domain.entity.launch.Launch
import com.kryptopass.domain.repo.LaunchRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GetLaunchesUseCase(
    configuration: Configuration,
    private val repository: LaunchRepository
) : UseCase<GetLaunchesUseCase.Request, GetLaunchesUseCase.Response>(configuration) {

    override fun process(request: Request): Flow<Response> =
        repository.getLaunches()
            .map {
                Response(it)
            }

    data object Request : UseCase.Request
    data class Response(val launches: List<Launch>) : UseCase.Response
}