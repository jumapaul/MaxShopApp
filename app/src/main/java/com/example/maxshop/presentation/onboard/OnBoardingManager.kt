package com.example.maxshop.presentation.onboard

import android.content.Context

object OnBoardingManager {

    private const val PREFS_NAME = "OnBoardingPrefs"
    private const val PREFS_KEY_COMPLETED = "OnBoardingCompleted"

    fun isOnBoardingCompleted(context: Context): Boolean {
        val prefs = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        return prefs.getBoolean(PREFS_KEY_COMPLETED, false)
    }

    fun setOnBoardingCompleted(context: Context) {
        val prefs = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        prefs.edit().putBoolean(PREFS_KEY_COMPLETED, true).apply()
    }
}