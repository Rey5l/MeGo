package com.example.uikit.component.text_input

import androidx.compose.runtime.Composable

/**
 * Иконка, которую можно передать в `TextInput` как leading / trailing.
 */
fun interface TextInputIcon {
    @Composable
    fun Content()
}

