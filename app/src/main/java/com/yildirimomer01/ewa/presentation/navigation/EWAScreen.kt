package com.yildirimomer01.ewa.presentation.navigation

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.yildirimomer01.ewa.presentation.home.HomeScreen
import com.yildirimomer01.ewa.presentation.settings.SettingsScreen
import com.yildirimomer01.ewa.presentation.theme.EWATheme

sealed class EWAScreen(val route: String) {
    data object HomeScreen : EWAScreen("home_screen")
    data object SettingsScreen : EWAScreen("settings_screen")
}

@Composable
fun EWAApplication() {
    EWATheme {
        Surface(color = MaterialTheme.colorScheme.background) {
            val navController = rememberNavController()
            NavHost(
                navController = navController,
                startDestination = EWAScreen.HomeScreen.route
            ) {
                composable(route = EWAScreen.HomeScreen.route) {
                    HomeScreen(navController = navController)
                }
                composable(route = EWAScreen.SettingsScreen.route) {
                    SettingsScreen(navController = navController)
                }
            }
        }
    }
}
