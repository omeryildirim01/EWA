package com.yildirimomer01.ewa.presentation.component.core

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun LabelText(
    text: String? = ""
) {
    text?.let {
        Text(text = text)
    }
}
