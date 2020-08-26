package com.ht117.ktose

import io.ktor.client.*
import io.ktor.client.engine.android.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.features.logging.*
import io.ktor.client.request.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlinx.serialization.json.Json

object NetworkService {

    private val json = Json {
        isLenient = true
        ignoreUnknownKeys = true
        prettyPrint = true
        ignoreUnknownKeys = true
    }

    private val client = HttpClient(Android) {
        install(JsonFeature) {
            serializer = KotlinxSerializer(json)
        }
        install(Logging) {
            logger = Logger.ANDROID
            level = LogLevel.ALL
        }
    }

    suspend fun fetchWeather(): Info = withContext(Dispatchers.IO) {
        client.get {
            url("$BaseUrl/data/2.5/weather?q=London,uk&appid=$AppId")
        }
    }

    private const val BaseUrl = "https://samples.openweathermap.org"
    private const val AppId = "b6907d289e10d714a6e88b30761fae22"
}