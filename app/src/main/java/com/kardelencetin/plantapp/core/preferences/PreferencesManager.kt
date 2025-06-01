package com.kardelencetin.plantapp.core.preferences

import android.content.Context
import androidx.core.content.edit
import com.kardelencetin.plantapp.core.constant.Constants

object PreferencesManager {

    fun isOnboardingCompleted(context: Context): Boolean {
        val prefs = context.getSharedPreferences(Constants.PREF_NAME, Context.MODE_PRIVATE)
        return prefs.getBoolean(Constants.KEY_ONBOARDING_COMPLETED, false)
    }

    fun setOnboardingCompleted(context: Context) {
        val prefs = context.getSharedPreferences(Constants.PREF_NAME, Context.MODE_PRIVATE)
        prefs.edit() { putBoolean(Constants.KEY_ONBOARDING_COMPLETED, true) }
    }
}