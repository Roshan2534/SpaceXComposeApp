package com.kryptopass.data.local.db.launch

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.kryptopass.domain.entity.launch.LaunchSite
import com.kryptopass.domain.entity.launch.Links
import com.kryptopass.domain.entity.launch.Rocket

@Entity(tableName = "launch")
data class LaunchEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id") val id: Long? = 0,
    @ColumnInfo(name = "details") val details: String? = "",
    @ColumnInfo(name = "flightNumber") val flightNumber: Int? = 0,
    @ColumnInfo(name = "launchDateLocal") val launchDateLocal: String? = "",
    @ColumnInfo(name = "launchDateUnix") val launchDateUnix: Int? = 0,
    @ColumnInfo(name = "launchDateUtc") val launchDateUtc: String? = "",
    @ColumnInfo(name = "launchSite") val launchSite: LaunchSite? = LaunchSite(),
    @ColumnInfo(name = "launchSuccess") val launchSuccess: Boolean? = false,
    @ColumnInfo(name = "launchYear") val launchYear: String? = "",
    @ColumnInfo(name = "links") val links: Links? = Links(),
    @ColumnInfo(name = "missionName") val missionName: String? = "",
    @ColumnInfo(name = "rocket") val rocket: Rocket? = Rocket(),
)
