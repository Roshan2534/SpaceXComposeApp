package com.kryptopass.space2x.ui.launch.list

import android.content.Context
import com.kryptopass.common.state.CommonResultConverter
import com.kryptopass.domain.usecase.GetLaunchesUseCase
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class LaunchListConverter @Inject constructor(
    @ApplicationContext private val context: Context
) : CommonResultConverter<GetLaunchesUseCase.Response, LaunchListModel>() {

    override fun convertSuccess(
        data: GetLaunchesUseCase.Response
    ): LaunchListModel {
        return LaunchListModel(
            items = data.launches.map {
                LaunchListItemModel(
                    details = it.details,
                    flightNumber = it.flightNumber,
                    launchDateLocal = it.launchDateLocal,
                    launchDateUnix = it.launchDateUnix,
                    launchDateUtc = it.launchDateUtc,
                    launchSite = it.launchSite,
                    launchSuccess = it.launchSuccess,
                    launchYear = it.launchYear,
                    links = it.links,
                    missionName = it.missionName,
                    rocket = it.rocket
                )
            }
        )
    }
}