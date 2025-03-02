package com.example.zensay

import android.content.Context
import androidx.compose.runtime.mutableStateOf
import com.example.zensay.models.Quote
import com.google.gson.Gson

import android.util.Log

object DataManager {
    var data = emptyArray<Quote>()
    var isDataLoaded = mutableStateOf(false)

    fun LoadAssetFromFile(context: Context) {
        try {
            val inputStream = context.assets.open("Quotes.json")
            val size: Int = inputStream.available()
            val buffer = ByteArray(size)
            inputStream.read(buffer)
            inputStream.close()

            val json = String(buffer, Charsets.UTF_8)
            val gson = Gson()
            data = gson.fromJson(json, Array<Quote>::class.java)

            isDataLoaded.value = true

            // ✅ Log the loaded data
            Log.d("DataManager", "Loaded Quotes: ${data.size}")
            data.forEach { Log.d("DataManager", it.toString()) }

        } catch (e: Exception) {
            Log.e("DataManager", "Error loading JSON", e)
        }
    }
}
