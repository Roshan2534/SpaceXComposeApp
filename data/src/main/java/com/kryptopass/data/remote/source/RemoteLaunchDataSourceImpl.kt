package com.kryptopass.data.remote.source

import com.kryptopass.data.remote.network.launch.LaunchModelItem
import com.kryptopass.data.remote.network.launch.LaunchService
import com.kryptopass.data.remote.network.launch.LaunchSite
import com.kryptopass.data.remote.network.launch.Links
import com.kryptopass.data.remote.network.launch.Rocket
import com.kryptopass.data.repository.source.remote.RemoteLaunchDataSource
import com.kryptopass.domain.entity.UseCaseException
import com.kryptopass.domain.entity.launch.Launch
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class RemoteLaunchDataSourceImpl @Inject constructor(
    private val service: LaunchService
) : RemoteLaunchDataSource {

    override fun getLaunches(): Flow<List<Launch>> = flow {
        emit(service.getLaunches())
    }.map { coins ->
        coins.map { apiModel ->
            convert(apiModel)
        }
    }.catch {
        throw UseCaseException.LaunchException(it)
    }

    override fun getLaunch(flightNumber: Int?): Flow<Launch> = flow {
        emit(service.getLaunch(flightNumber))
    }.map {
        convert(it)
    }.catch {
        throw UseCaseException.LaunchException(it)
    }

    private fun convert(model: LaunchModelItem) =
        Launch(
            model.details, model.flightNumber, model.launchDateLocal, model.launchDateUnix,
            model.launchDateUtc, convertLaunchSite(model.launchSite), model.launchSuccess,
            model.launchYear, convertLinks(model.links), model.missionName, convertRocket(model.rocket)
        )

    private fun convertLaunchSite(launchSite: LaunchSite?) =
        com.kryptopass.domain.entity.launch.LaunchSite(
            launchSite?.siteId, launchSite?.siteName, launchSite?.siteNameLong
        )

    private fun convertLinks(links: Links?) = com.kryptopass.domain.entity.launch.Links(
        links?.articleLink, links?.flickrImages, links?.missionPatch, links?.presskit,
        links?.redditCampaign, links?.redditLaunch, links?.redditMedia, links?.redditRecovery,
        links?.videoLink, links?.wikipedia
    )

    private fun convertRocket(rocket: Rocket?) = com.kryptopass.domain.entity.launch.Rocket(
        rocket?.rocketId, rocket?.rocketName, rocket?.rocketType
    )
}