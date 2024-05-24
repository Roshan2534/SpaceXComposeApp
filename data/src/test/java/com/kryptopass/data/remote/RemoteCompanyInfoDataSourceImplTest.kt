package com.kryptopass.data.remote

import com.kryptopass.data.remote.network.info.CompanyInfoService
import com.kryptopass.data.remote.network.info.CompanyModel
import com.kryptopass.data.remote.source.RemoteCompanyInfoDataSourceImpl
import com.kryptopass.domain.entity.UseCaseException
import com.kryptopass.domain.entity.info.CompanyInfo
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever

class RemoteCompanyInfoDataSourceImplTest {

    private val service = mock<CompanyInfoService>()
    private val dataSource = RemoteCompanyInfoDataSourceImpl(service)

    @Test
    fun testGetCompanyInfo() = runTest {
        val remoteInfo =
            CompanyModel(
                null, null, null, null, 7000, 2002,
                "Elon Musk", null, 3, null, "SpaceX",
                null, null, 275000000, null
            )
        val expectedInfo =
            CompanyInfo(
                "SpaceX",  "Elon Musk", 2002,
                7000, 3, 275000000
            )

        whenever(service.getCompanyInfo()).thenReturn(remoteInfo)
        val result = dataSource.getCompanyInfo().first()

        assertEquals(expectedInfo, result)
    }

    @Test
    fun testCompanyInfoThrowsError() = runTest {
        whenever(service.getCompanyInfo()).thenThrow(RuntimeException())

        dataSource.getCompanyInfo().catch {
            Assert.assertTrue(it is UseCaseException.CompanyInfoException)
        }
    }
}