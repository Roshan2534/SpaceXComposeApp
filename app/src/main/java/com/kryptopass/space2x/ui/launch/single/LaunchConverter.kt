package com.kryptopass.space2x.ui.launch.single

import android.content.Context
import com.kryptopass.common.state.CommonResultConverter
import com.kryptopass.domain.usecase.GetLaunchUseCase
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class LaunchConverter @Inject constructor(
    @ApplicationContext private val context: Context
) : CommonResultConverter<GetLaunchUseCase.Response, LaunchModel>() {

    override fun convertSuccess(data: GetLaunchUseCase.Response): LaunchModel {
        return LaunchModel(
            data.launch.details,
            data.launch.flightNumber,
            data.launch.launchDateLocal,
            data.launch.launchDateUnix,
            data.launch.launchDateUtc,
            data.launch.launchSite,
            data.launch.launchSuccess,
            data.launch.launchYear,
            data.launch.links,
            data.launch.missionName,
            data.launch.rocket
        )
    }
}