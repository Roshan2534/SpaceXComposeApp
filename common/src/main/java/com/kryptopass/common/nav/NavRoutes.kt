package com.kryptopass.common.nav

import androidx.navigation.NamedNavArgument
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavType
import androidx.navigation.navArgument

private const val ROUTE_LAUNCHES = "launches"
private const val ROUTE_LAUNCH = "launches/%s"
private const val ARG_LAUNCH_ID = "flightNumber"

sealed class NavRoutes(
    val route: String,
    val arguments: List<NamedNavArgument> = emptyList()
) {

    data object Launches : NavRoutes(ROUTE_LAUNCHES)

    data object Launch : NavRoutes(
        route = String.format(ROUTE_LAUNCH, "{$ARG_LAUNCH_ID}"),
        arguments = listOf(navArgument(ARG_LAUNCH_ID) {
            type = NavType.IntType
        })
    ) {

        fun routeForLaunch(input: LaunchInput) = String.format(ROUTE_LAUNCH, input.flightNumber)

        fun fromEntry(entry: NavBackStackEntry): LaunchInput {
            return LaunchInput(entry.arguments?.getInt(ARG_LAUNCH_ID) ?: 0)
        }
    }
}