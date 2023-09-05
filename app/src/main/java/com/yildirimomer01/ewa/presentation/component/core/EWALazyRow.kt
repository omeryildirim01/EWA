package com.yildirimomer01.ewa.presentation.component.core

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.scale
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import kotlin.math.abs

@Composable
fun<T> EWALazyRow(
    modifier: Modifier = Modifier,
    horizontalContentPadding: Dp = 8.dp,
    verticalContentPadding: Dp = 4.dp,
    horizontalArrangement: Dp = 4.dp,
    boxSize: Dp = 120.dp,
    items: List<EWALazyRowData<T>>
) {
    val listState = rememberLazyListState()
    BoxWithConstraints {
        val halfRowWidth = constraints.maxWidth / 2
        LazyRow(
            state = listState,
            horizontalArrangement = Arrangement.spacedBy(horizontalArrangement),
            contentPadding = PaddingValues(
                horizontal = horizontalContentPadding,
                vertical = verticalContentPadding
            ),
            modifier = modifier.fillMaxWidth()
        ) {
            itemsIndexed(items) { index, item ->
                val opacity by remember {
                    derivedStateOf {
                        val currentItemInfo = listState.layoutInfo.visibleItemsInfo
                            .firstOrNull { it.index == index }
                            ?: return@derivedStateOf 0.2f
                        val itemHalfSize = currentItemInfo.size / 2
                        (1f - minOf(1f, abs(currentItemInfo.offset + itemHalfSize - halfRowWidth).toFloat() / halfRowWidth) * 0.5f)
                    }
                }
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .scale(opacity)
                        .alpha(opacity)
                        .height(boxSize)
                        .fillMaxWidth()
                ) {
                    item.content()
                }
            }
        }
    }
}

data class EWALazyRowData<T>(
    val item: T,
    val content: @Composable () -> Unit
)
