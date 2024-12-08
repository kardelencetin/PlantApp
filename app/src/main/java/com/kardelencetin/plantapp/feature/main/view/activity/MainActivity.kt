package com.kardelencetin.plantapp.feature.main.view.activity

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.kardelencetin.plantapp.R
import com.kardelencetin.plantapp.core.preferences.PreferencesManager
import com.kardelencetin.plantapp.feature.homepage.view.activity.HomeActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        if (PreferencesManager.isOnboardingCompleted(this)) {
            navigateToHome()
        } else {
            setContentView(R.layout.activity_main)
        }
    }

    private fun navigateToHome() {
        startActivity(Intent(this, HomeActivity::class.java))
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
        finish()
    }
}