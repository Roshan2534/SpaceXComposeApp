package com.kryptopass.data.local.source

import com.kryptopass.data.local.db.launch.LaunchDao
import com.kryptopass.data.local.db.launch.LaunchEntity
import com.kryptopass.data.repository.source.local.LocalLaunchDataSource
import com.kryptopass.domain.entity.launch.Launch
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class LocalLaunchDataSourceImpl @Inject constructor(
    private val dao: LaunchDao
) : LocalLaunchDataSource {

    override fun getLaunches(): Flow<List<Launch>> =
        dao.getLaunches().map {
            it.map { launch ->
                Launch(
                    launch.details, launch.flightNumber, launch.launchDateLocal, launch.launchDateUnix,
                    launch.launchDateUtc, launch.launchSite, launch.launchSuccess, launch.launchYear,
                    launch.links, launch.missionName, launch.rocket
                )
            }
        }

    override suspend fun addLaunches(launches: List<Launch>) =
        dao.insertLaunches(launches.map { launch ->
            LaunchEntity(
               null,
                launch.details, launch.flightNumber, launch.launchDateLocal, launch.launchDateUnix,
                launch.launchDateUtc, launch.launchSite, launch.launchSuccess, launch.launchYear,
                launch.links, launch.missionName, launch.rocket
            )
        })
}