package com.yildirimomer01.ewa.presentation.component.core

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun EWAHorizontalDivider(heightDp: Dp = 1.dp) {
    Divider(modifier = Modifier.fillMaxWidth().height(heightDp))
}
