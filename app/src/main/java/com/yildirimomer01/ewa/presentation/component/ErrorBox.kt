package com.yildirimomer01.ewa.presentation.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.yildirimomer01.ewa.R
import com.yildirimomer01.ewa.presentation.theme.EWATheme

@Composable
fun ErrorBox() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(30.dp)
            .testTag(stringResource(id = R.string.error_tag)),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        Text(
            text = stringResource(R.string.something_went_wrong_please_try_again)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ErrorBoxPreview(modifier: Modifier = Modifier) {
    EWATheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            ErrorBox()
        }
    }
}
