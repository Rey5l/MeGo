package com.example.uikit.components.buttons.button

import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

enum class ButtonType {
    Fill,
    Stroke,
    Empty,
    Error
}

// Размер кнопки
enum class ButtonSize(
    val cornerRadius: Dp,
    val verticalPadding: Dp,
    val paddingWithoutIcon: Dp, // 20dp для Large, 16dp для Default
    val paddingWithIcon: Dp     // 16dp для Large, 12dp для Default
) {
    Default(cornerRadius = 8.dp, verticalPadding = 8.dp, paddingWithoutIcon = 16.dp, paddingWithIcon = 12.dp),
    Large(cornerRadius = 12.dp, verticalPadding = 18.dp, paddingWithoutIcon = 20.dp, paddingWithIcon = 16.dp);

    fun getHorizontalPaddings(text: String?, iconPosition: IconPosition?): Pair<Dp, Dp> {
        return when {
            text == null -> {
                val padding = if (this == Default) paddingWithIcon else paddingWithoutIcon
                padding to padding
            }
            iconPosition == IconPosition.Start -> paddingWithIcon to paddingWithoutIcon
            iconPosition == IconPosition.End -> paddingWithoutIcon to paddingWithIcon
            else -> paddingWithoutIcon to paddingWithoutIcon
        }
    }
}

enum class IconPosition {
    Start, End
}