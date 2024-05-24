package com.kryptopass.data.local.db.info

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface CompanyInfoDao {

    @Query("SELECT * FROM company_info")
    fun getCompanyInfo(): Flow<CompanyInfoEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCompanyInfo(info: CompanyInfoEntity)
}