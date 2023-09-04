package com.yildirimomer01.ewa.presentation.navigation

import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.yildirimomer01.ewa.presentation.theme.EWATheme

sealed class EWAScreen(val route: String) {
    data object HomeScreen : EWAScreen("home_screen")
    data object SettingsScreen : EWAScreen("settings_screen")
}

@Composable
fun EWAApplication() {
    EWATheme {
        Surface(color = Color.White) {
            val navController = rememberNavController()
            NavHost(
                navController = navController,
                startDestination = EWAScreen.HomeScreen.route
            ) {
                toHomeScreen(navController)
                toSettingsScreen(navController)
            }
        }
    }
}
