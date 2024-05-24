package com.kryptopass.domain.usecase

import com.kryptopass.domain.entity.launch.Launch
import com.kryptopass.domain.entity.launch.LaunchSite
import com.kryptopass.domain.entity.launch.Links
import com.kryptopass.domain.entity.launch.Rocket
import com.kryptopass.domain.repo.LaunchRepository
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runTest
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever

class GetLaunchesUseCaseTest {

    private val repository = mock<LaunchRepository>()

    private val useCase = GetLaunchesUseCase(
        mock(),
        repository
    )

    @Test
    fun testProcess() = runTest {
        val launch = Launch(
            "Details", 1, "Launch Date Local", 2,
            "Launch Date UTC", LaunchSite(), false, "Launch Year",
            Links(), "Mission Name", Rocket()
        )
        val launch2 = Launch(
            "Details2", 2, "Launch Date Local2", 3,
            "Launch Date UTC2", LaunchSite(), false, "Launch Year2",
            Links(), "Mission Name2", Rocket()
        )

        whenever(repository.getLaunches()).thenReturn(flowOf(listOf(launch, launch2)))
        val response = useCase.process(GetLaunchesUseCase.Request).first()

        assertEquals(GetLaunchesUseCase.Response(listOf(launch, launch2)), response)
    }
}