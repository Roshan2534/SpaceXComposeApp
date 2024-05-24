package com.kryptopass.space2x

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.kryptopass.common.nav.NavRoutes
import com.kryptopass.space2x.ui.info.CompanyInfoViewModel
import com.kryptopass.space2x.ui.launch.list.LaunchListScreen
import com.kryptopass.space2x.ui.launch.single.LaunchScreen
import com.kryptopass.space2x.ui.theme.Space2XTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SpaceXActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Space2XTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    App(navController = rememberNavController())
                }
            }
        }
    }
}

@Composable
fun App(navController: NavHostController) {
    NavHost(navController, startDestination = NavRoutes.Launches.route) {
        composable(route = NavRoutes.Launches.route) {
            val viewModel = hiltViewModel<CompanyInfoViewModel>()
            LaunchListScreen(hiltViewModel(), viewModel, navController)
        }
        composable(
            route = NavRoutes.Launch.route,
            arguments = NavRoutes.Launch.arguments
        ) {
            LaunchScreen(
                hiltViewModel(),
                NavRoutes.Launch.fromEntry(it)
            )
        }
    }
}
