package com.yildirimomer01.ewa.domain.model

import com.yildirimomer01.ewa.core.Constants.LAT
import com.yildirimomer01.ewa.core.Constants.LON

data class UserLocation(
    val id: Long,
    val name: String,
    val latitude: Double,
    val longitude: Double
) {
    companion object {
        fun getCurrentUserLocation() = UserLocation(
            id = 745044L,
            name = "Istanbul",
            latitude = LAT,
            longitude = LON
        )
    }
}
