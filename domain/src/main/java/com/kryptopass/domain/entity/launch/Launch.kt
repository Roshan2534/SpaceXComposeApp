package com.kryptopass.domain.entity.launch

data class Launch(
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
    val rocket: Rocket? = Rocket(),
)