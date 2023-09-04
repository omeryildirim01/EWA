package com.yildirimomer01.ewa.presentation.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.yildirimomer01.ewa.presentation.settings.SettingsScreen

fun NavController.navigateToSettingsScreen(navOptions: NavOptions? = null) {
    this.navigate(EWAScreen.SettingsScreen.route, navOptions)
}

fun NavGraphBuilder.toSettingsScreen(navController: NavController) {
    composable(route = EWAScreen.SettingsScreen.route) {
        SettingsScreen(navController = navController)
    }
}
