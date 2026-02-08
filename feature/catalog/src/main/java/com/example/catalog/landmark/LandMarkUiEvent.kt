package com.example.catalog.landmark



sealed interface LandMarkUiEvent {
    data object BackClick : LandMarkUiEvent

    data object NotificationClick : LandMarkUiEvent
}
