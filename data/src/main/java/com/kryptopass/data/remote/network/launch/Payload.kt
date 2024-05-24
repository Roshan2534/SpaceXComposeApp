package com.kryptopass.data.remote.network.launch

import com.google.gson.annotations.SerializedName

data class Payload(
    @SerializedName("cap_serial")
    val capSerial: String? = "",
    @SerializedName("cargo_manifest")
    val cargoManifest: String? = "",
    @SerializedName("customers")
    val customers: List<String?>? = listOf(),
    @SerializedName("flight_time_sec")
    val flightTimeSec: Int? = 0,
    @SerializedName("manufacturer")
    val manufacturer: String? = "",
    @SerializedName("mass_returned_kg")
    val massReturnedKg: Double? = 0.0,
    @SerializedName("mass_returned_lbs")
    val massReturnedLbs: Double? = 0.0,
    @SerializedName("nationality")
    val nationality: String? = "",
    @SerializedName("norad_id")
    val noradId: List<Int?>? = listOf(),
    @SerializedName("orbit")
    val orbit: String? = "",
    @SerializedName("orbit_params")
    val orbitParams: OrbitParams? = OrbitParams(),
    @SerializedName("payload_id")
    val payloadId: String? = "",
    @SerializedName("payload_mass_kg")
    val payloadMassKg: Double? = 0.0,
    @SerializedName("payload_mass_lbs")
    val payloadMassLbs: Double? = 0.0,
    @SerializedName("payload_type")
    val payloadType: String? = "",
    @SerializedName("reused")
    val reused: Boolean? = false,
    @SerializedName("uid")
    val uid: String? = ""
)