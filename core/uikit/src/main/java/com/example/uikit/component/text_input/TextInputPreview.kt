package com.example.uikit.component.text_input

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.uikit.theme.UIKitTheme

@Preview(showBackground = true)
@Composable
private fun TextInputDefaultPreview() {
    UIKitTheme {
        TextInput(
            value = "MeGo",
            onValueChange = {},
            label = "Label",
            placeholder = "Placeholder",
            modifier = Modifier,
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun TextInputErrorPreview() {
    UIKitTheme {
        TextInput(
            value = "MeGo",
            onValueChange = {},
            label = "Label",
            placeholder = "Placeholder",
            state = TextInputState.Error,
            errorText = "Ошибка ввода",
            modifier = Modifier,
        )
    }
}

