package com.css101.airtickets.data.storage.sharedprefs

import android.content.Context
import com.css101.airtickets.data.storage.SearchStorage
import java.util.Date

class SearchSharedPrefsStorage(context: Context) : SearchStorage {
    private val sharedPrefs = context.getSharedPreferences("search", Context.MODE_PRIVATE)
    override fun getDeparture(): String? {
        return sharedPrefs.getString("departure", null)
    }

    override fun saveDate(date: Date?) {
        sharedPrefs.edit().putLong("date", date?.time ?: 0).apply()
    }

    override fun getDate(): Date? {
        val dateLong = sharedPrefs.getLong("date", 0)
        return if (dateLong != 0L) {
            Date(dateLong)
        } else null
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