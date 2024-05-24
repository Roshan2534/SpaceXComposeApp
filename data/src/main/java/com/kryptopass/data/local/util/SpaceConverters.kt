package com.kryptopass.data.local.util

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.kryptopass.domain.entity.launch.LaunchSite
import com.kryptopass.domain.entity.launch.Links
import com.kryptopass.domain.entity.launch.Rocket

class SpaceConverters {

    @TypeConverter
    fun listToJsonString(value: List<String?>?): String? = Gson().toJson(value)
    @TypeConverter
    fun jsonStringToList(value: String?) =
        Gson().fromJson(value, Array<String?>::class.java).toList()

    @TypeConverter
    fun launchSiteToString(value: LaunchSite?): String? {
        return value?.let {
            Gson().toJson(it)
        }
    }
    @TypeConverter
    fun stringToLaunchSite(date: String?) = Gson().fromJson(date, LaunchSite::class.java)


    @TypeConverter
    fun linksToString(value: Links?): String? {
        return value?.let {
            Gson().toJson(it)
        }
    }
    @TypeConverter
    fun stringToLinks(date: String?) = Gson().fromJson(date, Links::class.java)

    @TypeConverter
    fun rocketToString(value: Rocket?): String? {
        return value?.let {
            Gson().toJson(it)
        }
    }
    @TypeConverter
    fun stringToRocket(date: String?) = Gson().fromJson(date, Rocket::class.java)
}