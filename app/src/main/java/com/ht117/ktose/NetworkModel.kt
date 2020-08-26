package com.ht117.ktose

import kotlinx.serialization.Serializable

@Serializable
data class Info(val coord: Coordinate, val weather: List<Weather>, val base: String)

@Serializable
data class Weather(val id: Int, val main: String, val description: String, val icon: String)

@Serializable
data class Coordinate(val lon: Float, val lat: Float)