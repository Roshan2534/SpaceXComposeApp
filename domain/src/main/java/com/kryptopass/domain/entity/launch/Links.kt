package com.kryptopass.domain.entity.launch

data class Links(
    val articleLink: String? = "",
    val flickrImages: List<String?>? = listOf(),
    val missionPatch: String? = "",
    val missionPatchSmall: String? = "",
    val presskit: String? = "",
    val redditCampaign: String? = "",
    val redditLaunch: String? = "",
    val redditMedia: String? = "",
    val redditRecovery: String? = "",
    val videoLink: String? = "",
    val wikipedia: String? = "",
    val youtubeId: String? = ""
)