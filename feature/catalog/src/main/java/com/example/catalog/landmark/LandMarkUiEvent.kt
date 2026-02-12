package com.example.catalog.landmark

import com.example.catalog.compose_model.LandmarkInfoTabDVO


sealed interface LandMarkUiEvent {
    data object BackClick : LandMarkUiEvent

    data object NotificationClick : LandMarkUiEvent

    data class LandmarkInfoTabSelect(val tab: LandmarkInfoTabDVO) : LandMarkUiEvent
}
