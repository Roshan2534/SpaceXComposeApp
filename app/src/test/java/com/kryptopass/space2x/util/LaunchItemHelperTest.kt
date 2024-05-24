package com.kryptopass.space2x.util

import com.kryptopass.domain.entity.launch.Rocket
import junit.framework.TestCase.assertEquals
import org.junit.Test

class LaunchItemHelperTest {

    @Test
    fun testFormatMissionName() {
        val missionName = "FalconSat"

        val result = formatMissionName(missionName)

        assert(result == "Mission: FalconSat")
    }

    @Test
    fun testFormatLocalDateTIme() {
        val launchDateLocal = "2006-03-25T10:30:00+12:00"
        val expected = "Date/time: 2006-03-25 at 10:30"

        val result = formatLocalDateTIme(launchDateLocal)

        assertEquals(expected, result)
    }

    @Test
    fun testFormatRocketDetails() {
        val rocket = Rocket(
            "falcon1", "Falcon 1", "Merlin A"
        )
        val expected = "Rocket: Falcon 1 / Merlin A"

        val result = formatRocketDetails(rocket)

        assertEquals(expected, result)
    }

    @Test
    fun testFormatDaysSinceLaunch() {
        val launchDateLocal = "2006-03-25T10:30:00+12:00"
        val expected = "Days since launch: 6538"

        val result = formatDaysSinceLaunch(launchDateLocal)

        assertEquals(result, expected)
    }

    // FalconSat
    // 2006-03-25T10:30:00+12:00
    // 1143239400
    // Rocket -> falcon1, Falcon 1, Merlin A
    // false

}