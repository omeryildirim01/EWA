package com.yildirimomer01.ewa.presentation.home

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController

@Composable
fun HomeScreen(
    navController: NavController,
    viewModel: HomeViewModel = hiltViewModel()
) {
    val state: HomeContract.HomeViewState = viewModel.viewState.value
    Column {
        Text(text = "Hello world")
        state.data?.let {
            Text(text = "Data is ready!")
        }
    }
}
