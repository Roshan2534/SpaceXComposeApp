package com.kryptopass.domain.usecase

import com.kryptopass.domain.entity.info.CompanyInfo
import com.kryptopass.domain.repo.CompanyInfoRepository
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runTest
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever

class GetCompanyInfoUseCaseTest {

    private val repository = mock<CompanyInfoRepository>()

    private val useCase = GetCompanyInfoUseCase(
        mock(),
        repository
    )

    @Test
    fun testProcess() = runTest {
        val request = GetCompanyInfoUseCase.Request
        val info = CompanyInfo(
            "SpaceX", "Elon Musk", 2002,
            7000, 3, 27500000
        )

        whenever(repository.getCompanyInfo()).thenReturn(flowOf(info))
        val response = useCase.process(request).first()

        assertEquals(GetCompanyInfoUseCase.Response(info), response)
    }
}