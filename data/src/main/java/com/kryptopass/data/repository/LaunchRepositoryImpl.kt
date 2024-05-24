package com.kryptopass.data.repository

import com.kryptopass.data.repository.source.local.LocalLaunchDataSource
import com.kryptopass.data.repository.source.remote.RemoteLaunchDataSource
import com.kryptopass.domain.entity.launch.Filter
import com.kryptopass.domain.entity.launch.Launch
import com.kryptopass.domain.repo.LaunchRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.onEach

class LaunchRepositoryImpl(
    private val remoteSource: RemoteLaunchDataSource,
    private val localSource: LocalLaunchDataSource
): LaunchRepository {

    override fun getLaunches(): Flow<List<Launch>> =
        remoteSource.getLaunches().onEach {
            localSource.addLaunches(it)
        }

    override fun getLaunches(filter: Filter): Flow<List<Launch>> {
        TODO("Not yet implemented")
    }

    override fun getLaunch(flightNumber: Int?): Flow<Launch> =
        remoteSource.getLaunch(flightNumber).onEach{
            localSource.addLaunches(listOf(it))
        }
}