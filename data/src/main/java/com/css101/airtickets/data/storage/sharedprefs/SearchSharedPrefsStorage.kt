package com.css101.airtickets.data.storage.sharedprefs

import android.content.Context
import com.css101.airtickets.data.storage.SearchStorage

class SearchSharedPrefsStorage(context: Context) : SearchStorage {
    private val sharedPrefs = context.getSharedPreferences("search", Context.MODE_PRIVATE)
    override fun getDeparture(): String? {
        return sharedPrefs.getString("departure", null)
    }

    override fun saveDeparture(departure: String?) {
        sharedPrefs.edit().putString("departure", departure).apply()
    }

    override fun getDestination(): String? {
        return sharedPrefs.getString("destination", null)
    }

    override fun saveDestination(destination: String?) {
        sharedPrefs.edit().putString("destination", destination).apply()
    }
}