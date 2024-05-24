package com.kryptopass.data.local

import com.kryptopass.data.local.db.launch.LaunchDao
import com.kryptopass.data.local.db.launch.LaunchEntity
import com.kryptopass.data.local.source.LocalLaunchDataSourceImpl
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

class LocalLaunchDataSourceImplTest {

    private val dao = mock<LaunchDao>()
    private val dataSource = LocalLaunchDataSourceImpl(dao)

    @Test
    fun testGetLaunches() = runTest {
        val localLaunches = listOf(
            LaunchEntity(
                null,
                "Details", 1, "Launch Date Local", 2,
                "Launch Date UTC", LaunchSite(), false, "Launch Year",
                Links(), "Mission Name", Rocket()
            )
        )
        val expectedLaunches = listOf(
            Launch(
                "Details", 1, "Launch Date Local", 2,
                "Launch Date UTC", LaunchSite(), false, "Launch Year",
                Links(), "Mission Name", Rocket()
            )
        )

        whenever(dao.getLaunches()).thenReturn(flowOf(localLaunches))
        val result = dataSource.getLaunches().first()

        assertEquals(expectedLaunches, result)
    }

    @Test
    fun testAddLaunches() = runTest {
        val localLaunches = listOf(
            LaunchEntity(
                null,
                "Details", 1, "Launch Date Local", 2,
                "Launch Date UTC", LaunchSite(), false, "Launch Year",
                Links(), "Mission Name", Rocket()
            )
        )
        val launches = listOf(
            Launch(
                "Details", 1, "Launch Date Local", 2,
                "Launch Date UTC", LaunchSite(), false, "Launch Year",
                Links(), "Mission Name", Rocket()
            )
        )

        dataSource.addLaunches(launches)

        verify(dao).insertLaunches(localLaunches)
    }
}