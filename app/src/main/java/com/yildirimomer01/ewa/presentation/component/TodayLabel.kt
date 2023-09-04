package com.yildirimomer01.ewa.presentation.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@Composable
fun TodayLabel(
    modifier: Modifier = Modifier,
    localDateTime: LocalDateTime
) {
    val formattedTime = localDateTime.format(DateTimeFormatter.ofPattern("HH:mm"))
    Row(
        horizontalArrangement = Arrangement.Center,
        modifier = modifier.fillMaxWidth()
    ) {
        Text(
            text = "Today $formattedTime"
        )
    }
}

@Preview(name = "TodayLabelPreview", showBackground = true)
@Composable
fun TodayLabelPreview() {
    TodayLabel(localDateTime = LocalDateTime.now())
}
