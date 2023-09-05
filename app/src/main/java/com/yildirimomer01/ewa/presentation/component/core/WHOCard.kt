package com.yildirimomer01.ewa.presentation.component.core

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun WHOCard(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    var toggled by rememberSaveable {
        mutableStateOf(false)
    }
    val animatedDp by animateDpAsState(
        if (toggled) 3.dp else 1.dp,
        label = "padding"
    )
    Card(
        border = BorderStroke(animatedDp, Color.Cyan),
        colors = CardDefaults.cardColors(
            containerColor = Color.Transparent
        ),
        modifier = modifier
            .clip(RoundedCornerShape(0))
            .padding(2.dp)
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = null
            ) {
                toggled = !toggled
            },
        content = { content() }
    )
}
