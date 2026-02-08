package com.example.uikit.component.text_input

import androidx.compose.runtime.Composable

/**
 * Иконка, которую можно передать в `TextInput` как `leadingIcon` / `trailingIcon`.
 *
 * ### Как использовать
 * Компонент намеренно не зависит от `material-icons`, поэтому иконка — это любой composable.
 *
 * Пример:
 * `leadingIcon = TextInputIcon { MyIcon(modifier = Modifier.size(16.dp)) }`
 */
fun interface TextInputIcon {
    @Composable
    fun Content()
}

