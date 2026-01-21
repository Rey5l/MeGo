package com.example.uikit.component.text_input

/**
 * Состояние текстового поля UI‑кита.
 */
sealed class TextInputState {
    data object Default : TextInputState()
    data object Focused : TextInputState()
    data object Error : TextInputState()
    data object Disabled : TextInputState()
}

