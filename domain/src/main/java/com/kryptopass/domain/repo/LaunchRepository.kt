package com.kryptopass.domain.repo

import com.kryptopass.domain.entity.launch.Filter
import com.kryptopass.domain.entity.launch.Launch
import kotlinx.coroutines.flow.Flow

interface LaunchRepository {

    fun getLaunches(): Flow<List<Launch>>
    fun getLaunches(filter: Filter): Flow<List<Launch>>

    fun getLaunch(flightNumber: Int?): Flow<Launch>
}