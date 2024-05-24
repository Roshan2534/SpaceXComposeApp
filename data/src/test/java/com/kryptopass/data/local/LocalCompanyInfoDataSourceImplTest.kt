package com.kryptopass.data.local

import com.kryptopass.data.local.db.info.CompanyInfoDao
import com.kryptopass.data.local.db.info.CompanyInfoEntity
import com.kryptopass.data.local.source.LocalCompanyInfoDataSourceImpl
import com.kryptopass.domain.entity.info.CompanyInfo
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runTest
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify
import org.mockito.kotlin.whenever

class LocalCompanyInfoDataSourceImplTest {

    private val dao = mock<CompanyInfoDao>()
    private val dataSource = LocalCompanyInfoDataSourceImpl(dao)

    @Test
    fun testGetCompanyInfo() = runTest {
        val localInfo = CompanyInfoEntity(
            null,
            "SpaceX",
            "Elon Musk",
            2002,
            7000,
            3,
            275000000
        )
        val expectedInfo = CompanyInfo(
            "SpaceX",
            "Elon Musk",
            2002,
            7000,
            3,
            275000000
        )

        whenever(dao.getCompanyInfo()).thenReturn(flowOf(localInfo))
        val result = dataSource.getCompanyInfo().first()

        assertEquals(expectedInfo, result)
    }

    @Test
    fun testAddCompanyInfo() = runTest {
        val localInfo =
            CompanyInfoEntity(
                null,
                "SpaceX",
                "Elon Musk",
                2002,
                7000,
                3,
                275000000
            )
        val info =
            CompanyInfo(
                "SpaceX",
                "Elon Musk",
                2002,
                7000,
                3,
                275000000
            )

        dataSource.addCompanyInfo(info)

        verify(dao).insertCompanyInfo(localInfo)
    }
}