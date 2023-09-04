package com.yildirimomer01.ewa.presentatin.home

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import com.yildirimomer01.ewa.domain.model.WeatherInfo
import com.yildirimomer01.ewa.presentation.home.HomeContract
import com.yildirimomer01.ewa.presentation.home.HomeScreen
import dagger.hilt.android.testing.HiltAndroidTest
import org.junit.Rule
import org.junit.Test
import java.lang.Error

@HiltAndroidTest
class HomeScreenTest {
    @get:Rule
    val composeRule = createComposeRule()

    @Test
    fun initialStateShowLoadingProgress() {
        composeRule.setContent {
            HomeScreen(
                viewState = HomeContract.HomeViewState(
                    isLoading = true
                )
            )
        }

        composeRule
            .onNodeWithTag("loading")
            .assertIsDisplayed()
    }

    @Test
    fun weatherInfoShownWithSuccessResponse() {
        composeRule.setContent {
            HomeScreen(
                viewState = HomeContract.HomeViewState(
                    isLoading = false,
                    error = null,
                    data = WeatherInfo()
                )
            )
        }

        composeRule
            .onNodeWithTag("weather")
            .assertIsDisplayed()
    }

    @Test
    fun errorInfoShownWithFailureResponse() {
        composeRule.setContent {
            HomeScreen(
                viewState = HomeContract.HomeViewState(
                    isLoading = false,
                    error = Error("Failed to load the weather info"),
                    data = null
                )
            )
        }

        composeRule
            .onNodeWithTag("error")
            .assertIsDisplayed()
    }
}
