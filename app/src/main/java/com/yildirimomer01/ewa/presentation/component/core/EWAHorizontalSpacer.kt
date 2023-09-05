package com.yildirimomer01.ewa.presentation.component.core

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun EWAHorizontalSpacer(
    horizontalSpace: Dp = 16.dp
) {
    Spacer(modifier = Modifier.height(horizontalSpace))
}
