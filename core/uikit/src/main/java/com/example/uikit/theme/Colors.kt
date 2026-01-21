package com.example.uikit.theme

import androidx.compose.ui.graphics.Color

/**
 * Базовая палитра цветов UI‑кита.
 */
data class UIKitColors(
    val primary: Color,
    val textPrimary: Color,
    val textSecondary: Color,
    val error: Color,
    val disabled: Color,
    val border: Color,
    val background: Color,
)

internal val LightUIKitColors = UIKitColors(
    primary = Color(0xFF0066FF),
    textPrimary = Color(0xFF111827),
    textSecondary = Color(0xFF6B7280),
    error = Color(0xFFDC2626),
    disabled = Color(0xFF9CA3AF),
    border = Color(0xFFE5E7EB),
    background = Color(0xFFFFFFFF),
)

