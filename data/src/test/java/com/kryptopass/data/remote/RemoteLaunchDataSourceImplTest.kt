package com.kryptopass.data.remote

import com.kryptopass.data.remote.network.launch.LaunchModelItem
import com.kryptopass.data.remote.network.launch.LaunchService
import com.kryptopass.data.remote.network.launch.LaunchSite
import com.kryptopass.data.remote.network.launch.Links
import com.kryptopass.data.remote.network.launch.Rocket
import com.kryptopass.data.remote.source.RemoteLaunchDataSourceImpl
import com.kryptopass.domain.entity.UseCaseException
import com.kryptopass.domain.entity.launch.Launch
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertTrue
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever

class RemoteLaunchDataSourceImplTest {

    private val service = mock<LaunchService>()
    private val dataSource = RemoteLaunchDataSourceImpl(service)

    private val launchId = "Launch ID"
    private val flightNumber = 1

    @Test
    fun testGetLaunches() = runTest {
        val remoteLaunches = listOf(
            LaunchModelItem(
                null, "Details", flightNumber, null,
                null, null, null,
                null, null, null,
                "Launch Date Local", null, 2,
                "Launch Date UTC", null, LaunchSite(), false,
                null, "Launch Year", Links(), null,
                "Mission Name", Rocket(), null, null, null, null
            )
        )
        val expectedLaunches = listOf(
            Launch(
                "Details", flightNumber, "Launch Date Local", 2,
                "Launch Date UTC", com.kryptopass.domain.entity.launch.LaunchSite(),
                false, "Launch Year",
                com.kryptopass.domain.entity.launch.Links(), "Mission Name",
                com.kryptopass.domain.entity.launch.Rocket()
            )
        )

        whenever(service.getLaunches()).thenReturn(remoteLaunches)
        val result = dataSource.getLaunches().first()

        assertEquals(expectedLaunches, result)
    }

    @Test
    fun testGetLaunch() = runTest {
        val remoteLaunch = LaunchModelItem(
            null, "Details", flightNumber, null,
            null, null, null,
            null, null, null,
            "Launch Date Local", null, 2,
            "Launch Date UTC", null, LaunchSite(), false,
            null, "Launch Year", Links(), null,
            "Mission Name", Rocket(), null, null, null, null
        )
        val expectedLaunch = Launch(
            "Details", flightNumber, "Launch Date Local", 2,
            "Launch Date UTC", com.kryptopass.domain.entity.launch.LaunchSite(),
            false, "Launch Year",
            com.kryptopass.domain.entity.launch.Links(), "Mission Name",
            com.kryptopass.domain.entity.launch.Rocket()
        )

        whenever(service.getLaunch(flightNumber)).thenReturn(remoteLaunch)
        val result = dataSource.getLaunch(flightNumber).first()

        assertEquals(expectedLaunch, result)
    }

    @Test
    fun testGetLaunchesThrowsError() = runTest {
        whenever(service.getLaunches()).thenThrow(RuntimeException())

        dataSource.getLaunches().catch {
            assertTrue(it is UseCaseException.LaunchException)
        }
    }



}