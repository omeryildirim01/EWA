package com.yildirimomer01.ewa.presentation.component.core

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun TemperatureText(
    modifier: Modifier = Modifier,
    temperature: Int,
    type: String = "°C"
) {
    Text(
        text = "$temperature$type",
        modifier = modifier
    )
}
