package com.example.uikit.component.text_input

/**
 * Состояние текстового поля UI‑кита.
 *
 * ### Подсказка по использованию
 * В обычном рантайме чаще всего достаточно `Default`, а фокус определяется автоматически.
 * Явно передавать `Active` удобно для Preview/дизайн-скринов.
 */
sealed class TextInputState {
    data object Default : TextInputState()
    data object Active : TextInputState()
    data object Fill : TextInputState()
    data object Error : TextInputState()
    data object Disabled : TextInputState()
}

