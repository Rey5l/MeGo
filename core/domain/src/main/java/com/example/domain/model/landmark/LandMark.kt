package com.example.domain.model.landmark

import com.example.domain.model.feedback.Feedback
import java.util.UUID

data class LandMark(
    val id: String = UUID.randomUUID().toString(),
    val location: String,
    val images: List<String>,
    val title: String,
    val description: String,
    val isFavorite: Boolean,
    val linkToWeb: String,
    val rating: Float,
    val tags: List<String>,
    val workMode: WorkMode,
    val isOpenNow: Boolean,
    val address: String,
    val feedbacks: List<Feedback>,
)

data class WorkMode(
    val from: String,
    val till: String,
)