package com.kryptopass.data.local.db.interaction

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "interaction")
data class InteractionEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id") val id: Long? = 0,
    @ColumnInfo(name = "url") val url: String? = "",
    @ColumnInfo(name = "clickCount") val clickCount: Int? = 0,
)