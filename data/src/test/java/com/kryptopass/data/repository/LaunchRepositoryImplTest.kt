package com.kryptopass.data.repository

import com.kryptopass.data.repository.source.local.LocalLaunchDataSource
import com.kryptopass.data.repository.source.remote.RemoteLaunchDataSource
import com.kryptopass.domain.entity.launch.Launch
import com.kryptopass.domain.entity.launch.LaunchSite
import com.kryptopass.domain.entity.launch.Links
import com.kryptopass.domain.entity.launch.Rocket
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runTest
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify
import org.mockito.kotlin.whenever

class LaunchRepositoryImplTest {

    private val remoteSource = mock<RemoteLaunchDataSource>()
    private val localSource = mock<LocalLaunchDataSource>()
    private val repo = LaunchRepositoryImpl(remoteSource, localSource)

    @Test
    fun testGetLaunches() = runTest {
        val launches = listOf(
            Launch(
                "Details", 1, "Launch Date Local", 2,
                "Launch Date UTC", LaunchSite(), false, "Launch Year",
                Links(), "Mission Name", Rocket()
            )
        )

        whenever(remoteSource.getLaunches()).thenReturn(flowOf(launches))
        val result = repo.getLaunches().first()

        assertEquals(launches, result)
        verify(localSource).addLaunches(launches)
    }

    @Test
    fun testGetLaunch() = runTest {
        val flightNumber = 1
        val launch = Launch(
            "Details", flightNumber, "Launch Date Local", 2,
            "Launch Date UTC", LaunchSite(), false, "Launch Year",
            Links(), "Mission Name", Rocket()
        )

        whenever(remoteSource.getLaunch(flightNumber)).thenReturn(flowOf(launch))
        val result = repo.getLaunch(flightNumber).first()

        assertEquals(launch, result)
        verify(localSource).addLaunches(listOf(launch))
    }
}