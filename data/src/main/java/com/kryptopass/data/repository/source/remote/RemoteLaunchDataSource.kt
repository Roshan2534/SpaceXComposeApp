package com.kryptopass.data.repository.source.remote

import com.kryptopass.domain.entity.launch.Launch
import kotlinx.coroutines.flow.Flow

interface RemoteLaunchDataSource {

    fun getLaunches(): Flow<List<Launch>>

    fun getLaunch(flightNumber: Int?): Flow<Launch>
}