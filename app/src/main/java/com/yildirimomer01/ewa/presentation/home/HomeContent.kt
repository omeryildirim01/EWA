package com.yildirimomer01.ewa.presentation.home

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarResult
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.yildirimomer01.ewa.R
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeContent(
    navController: NavController,
    viewModel: HomeViewModel = hiltViewModel()
) {
    val state: State<HomeContract.HomeViewState> = viewModel.viewState.collectAsState()
    val effectFlow: Flow<HomeContract.HomeViewEffect> = viewModel.effect
    val coroutineScope = rememberCoroutineScope()
    val hostState = remember { SnackbarHostState() }
    val defaultMessage = stringResource(R.string.something_went_wrong_please_try_again)
    if (state.value.error != null) {
        LaunchedEffect("listen-to-effects") {
            effectFlow.onEach { effect ->
                when (effect) {
                    HomeContract.HomeViewEffect.OnError -> {
                        coroutineScope.launch {
                            val snack = hostState.showSnackbar(
                                message = state.value.error?.message ?: defaultMessage,
                                actionLabel = "Retry",
                                withDismissAction = true,
                                duration = SnackbarDuration.Indefinite
                            )
                            when (snack) {
                                SnackbarResult.ActionPerformed -> viewModel.fetchWeatherData(refresh = true)
                                else -> Unit
                            }
                        }
                    }
                }
            }.collect()
        }
    }

    Scaffold(
        snackbarHost = { SnackbarHost(hostState) },
        content = { padding ->
            Surface(
                modifier = Modifier
                    .padding(padding)
                    .fillMaxSize()
            ) {
                HomeScreen(
                    viewState = state.value
                )
            }
        }
    )
}
