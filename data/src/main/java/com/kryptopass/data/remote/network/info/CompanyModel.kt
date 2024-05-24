package com.kryptopass.data.remote.network.info

import com.google.gson.annotations.SerializedName

data class CompanyModel(
    @SerializedName("ceo")
    val ceo: String? = "",
    @SerializedName("coo")
    val coo: String? = "",
    @SerializedName("cto")
    val cto: String? = "",
    @SerializedName("cto_propulsion")
    val ctoPropulsion: String? = "",
    @SerializedName("employees")
    val employees: Int? = 0,
    @SerializedName("founded")
    val founded: Int? = 0,
    @SerializedName("founder")
    val founder: String? = "",
    @SerializedName("headquarters")
    val headquarters: Headquarters? = Headquarters(),
    @SerializedName("launch_sites")
    val launchSites: Int? = 0,
    @SerializedName("links")
    val links: Links? = Links(),
    @SerializedName("name")
    val name: String? = "",
    @SerializedName("summary")
    val summary: String? = "",
    @SerializedName("test_sites")
    val testSites: Int? = 0,
    @SerializedName("valuation")
    val valuation: Long? = 0,
    @SerializedName("vehicles")
    val vehicles: Int? = 0
)