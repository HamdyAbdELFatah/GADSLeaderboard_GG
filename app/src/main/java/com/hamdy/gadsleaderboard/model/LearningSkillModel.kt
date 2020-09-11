package com.hamdy.gadsleaderboard.model
import com.google.gson.annotations.SerializedName

data class LearningSkillModel(
    val name: String,
    val score: Int,
    val country: String,
    val badgeUrl: String
)