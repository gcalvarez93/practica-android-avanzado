package com.gabrielcastro.practicaandroidavanzado.data.remote

import com.squareup.moshi.Json

data class GetLocationsResponse(
    @Json(name = "id") val id: String,
    @Json(name = "dateShow") val dateShow: String,
    @Json(name = "latitud") val latitud: Double,
    @Json(name = "longitud") val longitud: Double,
)
