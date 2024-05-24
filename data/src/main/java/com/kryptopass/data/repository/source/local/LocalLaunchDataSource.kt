package com.kryptopass.data.repository.source.local

import com.kryptopass.domain.entity.launch.Launch
import kotlinx.coroutines.flow.Flow

interface LocalLaunchDataSource {

    fun getLaunches(): Flow<List<Launch>>

    suspend fun addLaunches(launches: List<Launch>)
}