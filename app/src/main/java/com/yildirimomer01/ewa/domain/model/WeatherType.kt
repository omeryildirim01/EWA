package com.yildirimomer01.ewa.domain.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.yildirimomer01.ewa.R

sealed class WeatherType(
    @StringRes val descriptionRes: Int,
    @DrawableRes val iconRes: Int
) {
    data object ClearSky : WeatherType(
        descriptionRes = R.string.clear_sky,
        iconRes = R.drawable.ic_sunny
    )

    data object MainlyClear : WeatherType(
        descriptionRes = R.string.mainly_clear,
        iconRes = R.drawable.ic_cloudy
    )

    data object PartlyCloudy : WeatherType(
        descriptionRes = R.string.partly_cloudy,
        iconRes = R.drawable.ic_cloudy
    )

    data object Overcast : WeatherType(
        descriptionRes = R.string.overcast,
        iconRes = R.drawable.ic_cloudy
    )

    data object Foggy : WeatherType(
        descriptionRes = R.string.foggy,
        iconRes = R.drawable.ic_very_cloudy
    )

    data object DepositingRimeFog : WeatherType(
        descriptionRes = R.string.depositing_rime_fog,
        iconRes = R.drawable.ic_very_cloudy
    )

    data object LightDrizzle : WeatherType(
        descriptionRes = R.string.light_drizzle,
        iconRes = R.drawable.ic_rainshower
    )

    data object ModerateDrizzle : WeatherType(
        descriptionRes = R.string.moderate_drizzle,
        iconRes = R.drawable.ic_rainshower
    )

    data object DenseDrizzle : WeatherType(
        descriptionRes = R.string.dense_drizzle,
        iconRes = R.drawable.ic_rainshower
    )

    data object LightFreezingDrizzle : WeatherType(
        descriptionRes = R.string.light_freezing_drizzle,
        iconRes = R.drawable.ic_snowyrainy
    )

    data object DenseFreezingDrizzle : WeatherType(
        descriptionRes = R.string.dense_freezing_drizzle,
        iconRes = R.drawable.ic_snowyrainy
    )

    data object SlightRain : WeatherType(
        descriptionRes = R.string.slight_rain,
        iconRes = R.drawable.ic_rainy
    )

    data object ModerateRain : WeatherType(
        descriptionRes = R.string.rainy,
        iconRes = R.drawable.ic_rainy
    )

    data object HeavyRain : WeatherType(
        descriptionRes = R.string.heavy_rain,
        iconRes = R.drawable.ic_rainy
    )

    data object HeavyFreezingRain : WeatherType(
        descriptionRes = R.string.heavy_freezing_rain,
        iconRes = R.drawable.ic_snowyrainy
    )

    data object SlightSnowFall : WeatherType(
        descriptionRes = R.string.slight_snow_fall,
        iconRes = R.drawable.ic_snowy
    )

    data object ModerateSnowFall : WeatherType(
        descriptionRes = R.string.moderate_snow_fall,
        iconRes = R.drawable.ic_heavysnow
    )

    data object HeavySnowFall : WeatherType(
        descriptionRes = R.string.heavy_snow_fall,
        iconRes = R.drawable.ic_heavysnow
    )

    data object SnowGrains : WeatherType(
        descriptionRes = R.string.snow_grains,
        iconRes = R.drawable.ic_heavysnow
    )

    data object SlightRainShowers : WeatherType(
        descriptionRes = R.string.slight_rain_showers,
        iconRes = R.drawable.ic_rainshower
    )

    data object ModerateRainShowers : WeatherType(
        descriptionRes = R.string.moderate_rain_showers,
        iconRes = R.drawable.ic_rainshower
    )

    data object ViolentRainShowers : WeatherType(
        descriptionRes = R.string.violent_rain_showers,
        iconRes = R.drawable.ic_rainshower
    )

    data object SlightSnowShowers : WeatherType(
        descriptionRes = R.string.slight_snow_showers,
        iconRes = R.drawable.ic_snowy
    )

    data object HeavySnowShowers : WeatherType(
        descriptionRes = R.string.heavy_snow_showers,
        iconRes = R.drawable.ic_snowy
    )

    data object ModerateThunderstorm : WeatherType(
        descriptionRes = R.string.moderate_thunderstorm,
        iconRes = R.drawable.ic_thunder
    )

    data object SlightHailThunderstorm : WeatherType(
        descriptionRes = R.string.slight_hail_thunder_storm,
        iconRes = R.drawable.ic_rainythunder
    )

    data object HeavyHailThunderstorm : WeatherType(
        descriptionRes = R.string.heavy_hail_thunder_storm,
        iconRes = R.drawable.ic_rainythunder
    )

    companion object {
        fun fromWMO(code: Int): WeatherType {
            return when (code) {
                0 -> ClearSky
                1 -> MainlyClear
                2 -> PartlyCloudy
                3 -> Overcast
                45 -> Foggy
                48 -> DepositingRimeFog
                51 -> LightDrizzle
                53 -> ModerateDrizzle
                55 -> DenseDrizzle
                56 -> LightFreezingDrizzle
                57 -> DenseFreezingDrizzle
                61 -> SlightRain
                63 -> ModerateRain
                65 -> HeavyRain
                66 -> LightFreezingDrizzle
                67 -> HeavyFreezingRain
                71 -> SlightSnowFall
                73 -> ModerateSnowFall
                75 -> HeavySnowFall
                77 -> SnowGrains
                80 -> SlightRainShowers
                81 -> ModerateRainShowers
                82 -> ViolentRainShowers
                85 -> SlightSnowShowers
                86 -> HeavySnowShowers
                95 -> ModerateThunderstorm
                96 -> SlightHailThunderstorm
                99 -> HeavyHailThunderstorm
                else -> ClearSky
            }
        }
    }
}
