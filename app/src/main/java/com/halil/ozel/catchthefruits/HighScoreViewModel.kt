package com.halil.ozel.catchthefruits

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import android.content.Context

class HighScoreViewModel(application: Application) : AndroidViewModel(application) {
    private val preferences = application.getSharedPreferences("game_preferences", Context.MODE_PRIVATE)

    val highScore: MutableLiveData<Int> = MutableLiveData()

    init {
        highScore.value = preferences.getInt("high_score", 0)
    }

    fun saveHighScore(newScore: Int) {
        val currentHighScore = highScore.value ?: 0
        if (newScore > currentHighScore) {
            preferences.edit().putInt("high_score", newScore).apply()
            highScore.value = newScore
        }
    }
}
