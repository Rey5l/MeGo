package com.example.uikit.component.text_input

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.uikit.theme.UIKitTheme

@Preview(showBackground = true)
@Composable
private fun TextInputDefaultPreview() {
    UIKitTheme {
        // Default: пустое поле, внутри показывается "Label" (placeholder)
        TextInput(
            value = "",
            onValueChange = {},
            label = "Label",
            modifier = Modifier,
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun TextInputActivePreview() {
    UIKitTheme {
        // Active: пустое поле, label на границе, курсор внутри
        TextInput(
            value = "",
            onValueChange = {},
            label = "Label",
            state = TextInputState.Active,
            modifier = Modifier,
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun TextInputWithValuePreview() {
    UIKitTheme {
        // Input: есть текст, label на границе (в Active)
        TextInput(
            value = "Input",
            onValueChange = {},
            label = "Label",
            state = TextInputState.Active,
            modifier = Modifier,
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun TextInputFilledPreview() {
    UIKitTheme {
        // Fill: есть текст, не в фокусе, label не показывается
        TextInput(
            value = "Input",
            onValueChange = {},
            label = "Label",
            modifier = Modifier,
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun TextInputErrorPreview() {
    UIKitTheme {
        // Error: есть текст, красная рамка и текст, label не показывается
        TextInput(
            value = "Input",
            onValueChange = {},
            label = "Label",
            state = TextInputState.Error,
            modifier = Modifier,
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun TextInputDisabledPreview() {
    UIKitTheme {
        // Disable: пустое поле, блеклый "Label" внутри
        TextInput(
            value = "",
            onValueChange = {},
            label = "Label",
            enabled = false,
            modifier = Modifier,
        )
    }
}


