package com.yildirimomer01.ewa.presentation.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.yildirimomer01.ewa.presentation.home.HomeContent

fun NavController.navigateToHomeScreen(navOptions: NavOptions? = null) {
    this.navigate(EWAScreen.HomeScreen.route, navOptions)
}

fun NavGraphBuilder.toHomeScreen(navController: NavController) {
    composable(route = EWAScreen.HomeScreen.route) {
        HomeContent(navController = navController)
    }
}
