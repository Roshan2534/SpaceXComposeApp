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

class GetLaunchUseCaseTest {

    private val repository = mock<LaunchRepository>()
    private val useCase = GetLaunchUseCase(
        mock(),
        repository
    )

    @Test
    fun testProcess() = runTest {
        val request = GetLaunchUseCase.Request(1)
        val launch = Launch(
            "Details", 1, "Launch Date Local", 2,
            "Launch Date UTC", LaunchSite(), false, "Launch Year",
            Links(), "Mission Name", Rocket()
        )

        whenever(repository.getLaunch(request.flightNumber)).thenReturn(flowOf(launch))
        val response = useCase.process(request).first()

        assertEquals(GetLaunchUseCase.Response(launch), response)
    }
}