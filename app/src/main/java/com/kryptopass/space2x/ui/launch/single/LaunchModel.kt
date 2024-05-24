package com.kryptopass.space2x.ui.launch.single

import com.kryptopass.domain.entity.launch.LaunchSite
import com.kryptopass.domain.entity.launch.Links
import com.kryptopass.domain.entity.launch.Rocket

data class LaunchModel(
    val details: String? = "",
    val flightNumber: Int? = 0,
    val launchDateLocal: String? = "",
    val launchDateUnix: Int? = 0,
    val launchDateUtc: String? = "",
    val launchSite: LaunchSite? = LaunchSite(),
    val launchSuccess: Boolean? = false,
    val launchYear: String? = "",
    val links: Links? = Links(),
    val missionName: String? = "",
    val rocket: Rocket? = Rocket()
)