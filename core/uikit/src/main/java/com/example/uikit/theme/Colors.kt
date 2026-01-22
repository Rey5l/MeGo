package com.example.uikit.theme

import androidx.compose.ui.graphics.Color

/**
 * Базовая палитра цветов UI‑кита.
 */
data class UIKitColors(
    val primary: Color,
    val secondary: Color,
    val textPrimary: Color,
    val textSecondary: Color,
    val error: Color,
    val disabled: Color,
    val border: Color,
    val background: Color,
)

internal val LightUIKitColors = UIKitColors(
    primary = Color(0xDC511BE3),
    secondary = Color(0xFFBC9DE5),
    textPrimary = Color(0xFF4C4C52),
    textSecondary = Color(0xFF6B7280),
    error = Color(0xFFDC2626),
    disabled = Color(0xFFD0D2D7),
    // Блекло-сереневый для границ Default и Fill состояний
    border = Color(0xFFC8CAD0),
    background = Color(0xFFFFFFFF),
)

