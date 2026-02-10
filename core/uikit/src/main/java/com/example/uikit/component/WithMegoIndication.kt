package com.example.uikit.component

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LocalRippleConfiguration
import androidx.compose.material3.RippleConfiguration
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import com.example.uikit.theme.blue

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WithMegoIndication(content: @Composable () -> Unit) {
    CompositionLocalProvider(LocalRippleConfiguration provides RippleConfiguration(blue)) {
        content()
    }
}