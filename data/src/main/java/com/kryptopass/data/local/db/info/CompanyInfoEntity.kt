package com.kryptopass.data.local.db.info

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "company_info")
data class CompanyInfoEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id") val id: Long? = 0,
    @ColumnInfo(name = "companyName") val companyName: String?,
    @ColumnInfo(name = "founderName") val founderName: String?,
    @ColumnInfo(name = "foundedYear") val foundedYear: Int?,
    @ColumnInfo(name = "employeeCount") val employeeCount: Int?,
    @ColumnInfo(name = "launchSites") val launchSites: Int?,
    @ColumnInfo(name = "valuation") val valuation: Long?,
)