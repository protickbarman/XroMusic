package com.xromuse.app

import android.app.Activity
import android.app.Application
import androidx.appcompat.app.AppCompatDelegate
import com.xromuse.app.activities.SettingsActivity.SettingsSharedPrefManager
import com.xromuse.app.utils.MusicPlayerManager
import com.xromuse.app.utils.SharedPreferenceManager

open class BaseApplicationClass : Application() {
    private val TAG = "ApplicationClass"

    override fun onCreate() {
        super.onCreate()

        sharedPreferenceManager = SharedPreferenceManager.getInstance(this)
        com.xromuse.app.utils.ThemeManager.init(this)
        MusicPlayerManager.init(this)

        sharedPreferenceManager!!.migrateFromOldPrefs(this) { sharedPreferenceManager!!.clearOldPrefsAsync(this, null) }
    }

    companion object {
        var sharedPreferenceManager: SharedPreferenceManager? = null
        var currentActivity: Activity? = null

        fun updateTheme() {
            val act = currentActivity ?: return
            com.xromuse.app.utils.ThemeManager.applyNightMode(
                com.xromuse.app.utils.ThemeManager.getThemeMode(act)
            )
        }
    }
}
