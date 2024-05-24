package com.kryptopass.space2x.util

import com.kryptopass.domain.entity.launch.Rocket
import com.kryptopass.space2x.R
import com.kryptopass.space2x.ui.launch.list.LaunchListItemModel
import java.time.LocalDate
import java.time.ZonedDateTime
import java.util.Calendar

fun launchItemHelper(item: LaunchListItemModel): FlightItemModel {
    return FlightItemModel(
        missionName = formatMissionName(item.missionName),
        dateTime = formatLocalDateTIme(item.launchDateLocal),
        rocket = formatRocketDetails(item.rocket),
        days = formatDaysSinceLaunch(item.launchDateLocal),
        patch = getDrawableResource(item.launchSuccess)
    )
}

fun formatMissionName(missionName: String?): String {
    val name = missionName ?: "No Mission Name"
    val truncName = if (name.length > 17) {
        "${name.substring(0, 17)}..."
    } else {
        name
    }

    return "Mission: $truncName"
}

fun formatLocalDateTIme(launchDateLocal: String?): String {
    val localDateTime = ZonedDateTime.parse(launchDateLocal)
    val date = localDateTime.toLocalDate()
    val time = localDateTime.toLocalTime()

    return "Date/time: $date at $time"
}

fun formatRocketDetails(rocket: Rocket?): String {
    val rocketName = rocket?.rocketName ?: "No Rocket Name"
    val rocketType = rocket?.rocketType ?: "No Rocket Type"
    return "Rocket: $rocketName / $rocketType"
}

fun formatDaysSinceLaunch(launchDateLocal: String?): String {
    val now = LocalDate.now()
    val launchDate = ZonedDateTime.parse(launchDateLocal).toLocalDate()

    val yearNow = now.year
    val yearLaunch = launchDate.year
    val yearDiff = yearNow - yearLaunch
    val leapDays = (yearDiff / 4) * 1
    var tense = if (yearNow < yearLaunch) "from" else "since"

    val monthNow = now.monthValue
    val monthLaunch = launchDate.monthValue
    val monthDiff = monthNow - monthLaunch
    if (yearNow == yearLaunch) {
        tense = if (monthNow < monthLaunch) "from" else "since"
    }

    val dayNow = now.dayOfMonth
    val dayLaunch = launchDate.dayOfMonth
    val dayDiff = dayNow - dayLaunch
     if (monthNow == monthLaunch) {
        tense = if (dayNow < dayLaunch) "from" else "since"
    }

    val days = dayDiff + (monthDiff * 30) + (yearDiff * 365) + leapDays

    return "Days $tense launch: $days"
}

fun getDrawableResource(launchSuccess: Boolean?): Int? {
    return launchSuccess?.let {
        if (it) R.drawable.ic_launch_success else R.drawable.ic_launch_failure
    }
}

data class FlightItemModel(
    val missionName: String = "No mission name",
    val dateTime: String? = "No datetime",
    val rocket: String? = "No rocket name/type",
    val days: String? = "No date for calculation",
    val patch: Int? = 0
)