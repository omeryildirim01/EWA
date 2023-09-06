package com.yildirimomer01.ewa

import kotlinx.serialization.json.Json
import java.io.InputStreamReader

object ResourceFileHelper {

    fun json() = Json { ignoreUnknownKeys = true }

    fun readFileResource(fileName: String): String {
        runCatching {
            val inputStream = ResourceFileHelper::class.java.getResourceAsStream(fileName)
            val stringBuilder = StringBuilder()
            val reader = InputStreamReader(inputStream, "UTF-8")
            reader.readLines().forEach { stringBuilder.append(it) }
            return stringBuilder.toString()
        }.getOrElse {
            return "[]"
        }
    }
}
