package com.kryptopass.data.repository

import com.kryptopass.data.repository.source.local.LocalCompanyInfoDataSource
import com.kryptopass.data.repository.source.remote.RemoteCompanyInfoDataSource
import com.kryptopass.domain.entity.info.CompanyInfo
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runTest
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify
import org.mockito.kotlin.whenever

class CompanyInfoRepositoryImplTest {

    private val remoteSource = mock<RemoteCompanyInfoDataSource>()
    private val localSource = mock<LocalCompanyInfoDataSource>()
    private val repo = CompanyInfoRepositoryImpl(remoteSource, localSource)

    @Test
    fun testGetCompanyInfo() = runTest {
        val info =
            CompanyInfo(
                "Space X",
                "Elon Musk",
                2002,
                7000,
                3,
                275000000
            )

        whenever(remoteSource.getCompanyInfo()).thenReturn(flowOf(info))
        val result = repo.getCompanyInfo().first()

        assertEquals(info, result)
        verify(localSource).addCompanyInfo(info)
    }
}