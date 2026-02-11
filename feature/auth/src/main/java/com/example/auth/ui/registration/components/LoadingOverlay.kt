package com.example.auth.ui.registration.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.uikit.component.common.ProgressBar

@Composable
fun LoadingOverlay() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White.copy(alpha = 0.6f))
            .clickable(enabled = false) {} // заблокируем нажатие по экрану
    ) {
        ProgressBar(
            iconSize = 109.dp,
            modifier = Modifier.align(Alignment.Center)
        )
    }
}