package com.yildirimomer01.ewa.presentation.component.weather

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.yildirimomer01.ewa.R

@Composable
fun WeatherInfoRow(
    value: Int?,
    unit: String,
    @DrawableRes icon: Int,
    @StringRes description: Int,
    top: Dp,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.padding(
            start = 2.dp,
            top = top,
            bottom = 6.dp,
            end = 2.dp
        ),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = painterResource(id = icon),
            contentDescription = stringResource(id = description),
            modifier = Modifier.size(25.dp)
        )
        Spacer(modifier = Modifier.width(4.dp))
        Text(text = if (value == null) stringResource(id = R.string.unknown) else "$value$unit")
    }
}

@Preview(showBackground = true)
@Composable
fun WeatherInfoRowPreview() {
    WeatherInfoRow(
        value = 10,
        unit = "km/h",
        R.drawable.ic_wind_24,
        R.string.wind_speed,
        top = 16.dp
    )
}
