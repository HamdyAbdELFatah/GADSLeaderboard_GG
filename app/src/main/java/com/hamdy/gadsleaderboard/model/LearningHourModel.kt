package com.hamdy.gadsleaderboard.model
import com.google.gson.annotations.SerializedName

data class LearningHourModel(
    val name: String,
    val hours: Int,
    val country: String,
    val badgeUrl: String
)