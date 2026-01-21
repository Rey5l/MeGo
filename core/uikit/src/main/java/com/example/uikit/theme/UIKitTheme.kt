package com.example.uikit.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.staticCompositionLocalOf

private val LocalUIKitColors = staticCompositionLocalOf { LightUIKitColors }
private val LocalUIKitTypography = staticCompositionLocalOf { DefaultUIKitTypography }

/**
 * Глобальный доступ к дизайн‑системе UI‑кита.
 */
object UIKitTheme {

    val colors: UIKitColors
        @Composable
        get() = LocalUIKitColors.current

    val typography: UIKitTypography
        @Composable
        get() = LocalUIKitTypography.current
}

/**
 * Базовая тема UI‑кита. Можно расширять для тёмной темы и брендинга.
 */
@Composable
fun UIKitTheme(
    colors: UIKitColors = LightUIKitColors,
    typography: UIKitTypography = DefaultUIKitTypography,
    content: @Composable () -> Unit,
) {
    CompositionLocalProvider(
        LocalUIKitColors provides colors,
        LocalUIKitTypography provides typography,
    ) {
        content()
    }
}

