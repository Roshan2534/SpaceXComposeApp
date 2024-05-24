package com.kryptopass.domain.usecase

import com.kryptopass.domain.entity.Interaction
import com.kryptopass.domain.entity.launch.Launch
import com.kryptopass.domain.entity.launch.LaunchSite
import com.kryptopass.domain.entity.launch.Links
import com.kryptopass.domain.entity.launch.Rocket
import com.kryptopass.domain.repo.InteractionRepository
import com.kryptopass.domain.repo.LaunchRepository
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runTest
import org.junit.Ignore
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever

class GetLaunchesWithInteractionUseCaseTest {

    private val launchRepo = mock<LaunchRepository>()
    private val interactionRepo = mock<InteractionRepository>()

    private val useCase = GetLaunchesWithInteractionUseCase(
        mock(),
        launchRepo,
        interactionRepo
    )

    @Ignore("TODO: Fix this test")
    //@Test
    fun testProcess() = runTest {
        val url = "https://en.wikipedia.org/wiki/Dragon_C2%2B"
        val request = GetLaunchesWithInteractionUseCase.Request(url)
        val launch1 = Launch(
            "Details", 1, "Launch Date Local", 2,
            "Launch Date UTC", LaunchSite(), false, "Launch Year",
            Links(articleLink = url, wikipedia = url), "Mission Name", Rocket()
        )
        val launch2 = Launch(
            "Details2", 2, "Launch Date Local2", 3,
            "Launch Date UTC2", LaunchSite(), true, "Launch Year2",
            Links(articleLink = url, wikipedia = url), "Mission Name2", Rocket()
        )
        val interaction = Interaction(url,10)

        whenever(launchRepo.getLaunches()).thenReturn(flowOf(listOf(launch1, launch1)))
        whenever(interactionRepo.getInteraction(url)).thenReturn(flowOf(interaction))
        val response = useCase.process(request).first()

        assertEquals(
            GetLaunchesWithInteractionUseCase.Response(
                listOf(
                    launch1, launch2
                ), interaction
            ),
            response
        )
    }
}