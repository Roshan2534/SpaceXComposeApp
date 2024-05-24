package com.kryptopass.space2x.ui.launch.list

import com.kryptopass.domain.entity.launch.LaunchSite
import com.kryptopass.domain.entity.launch.Links
import com.kryptopass.domain.entity.launch.Rocket

data class LaunchListModel(
    val items: List<LaunchListItemModel> = listOf()
)

data class LaunchListItemModel(
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