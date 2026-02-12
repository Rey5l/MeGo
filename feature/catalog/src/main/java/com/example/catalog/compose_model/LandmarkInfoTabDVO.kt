package com.example.catalog.compose_model

import androidx.compose.runtime.Stable

@Stable
enum class LandmarkInfoTabDVO(
    val titleRes: String,
) {
    Description("Description"),
    Feedbacks("Feedback"),
    Schedules("Schedule"),
    Details("Details"),
}
