package com.example.uikit.components.text_input

import androidx.compose.runtime.Composable

/**
 * Иконка, которую можно передать в `TextInput` как `leftIcon` / `rightIcon`.
 *
 * ### Как использовать
 * Компонент намеренно не зависит от `material-icons`, поэтому иконка — это любой composable.
 *
 * Пример:
 * `leftIcon = TextInputIcon { MyIcon(modifier = Modifier.size(16.dp)) }`
 */
fun interface TextInputIcon {
    @Composable
    fun Content()
}

