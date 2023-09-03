package com.yildirimomer01.ewa.data.mapper

import com.yildirimomer01.ewa.data.dto.WeatherDto
import com.yildirimomer01.ewa.domain.model.WeatherModel

fun WeatherDto.toModel(): WeatherModel {
    return WeatherModel(name = this.name)
}
