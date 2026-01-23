package com.example.uikit.theme

import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

/**
 * Набор типографики для компонентов UI‑кита.
 */
data class UIKitTypography(
    val body: TextStyle,
    val caption: TextStyle,
)

internal val DefaultUIKitTypography = UIKitTypography(
    body = TextStyle(
        fontSize = 16.sp,
        lineHeight = 22.sp,
        fontWeight = FontWeight.Normal,
    ),
    caption = TextStyle(
        fontSize = 12.sp,
        lineHeight = 16.sp,
        fontWeight = FontWeight.Medium,
    ),
)

