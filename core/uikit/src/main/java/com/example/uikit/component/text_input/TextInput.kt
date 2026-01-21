package com.example.uikit.component.text_input

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.uikit.theme.UIKitTheme

/**
 * Базовый компонент текстового поля UI‑кита.
 */
@Composable
fun TextInput(
    value: String,
    onValueChange: (String) -> Unit,
    label: String? = null,
    placeholder: String? = null,
    state: TextInputState = TextInputState.Default,
    enabled: Boolean = true,
    leadingIcon: TextInputIcon? = null,
    trailingIcon: TextInputIcon? = null,
    errorText: String? = null,
    modifier: Modifier = Modifier,
) {
    Column(modifier = modifier) {

        label?.let {
            Text(
                text = it,
                style = UIKitTheme.typography.caption,
                color = labelColor(state),
            )
        }

        OutlinedTextField(
            value = value,
            onValueChange = onValueChange,
            enabled = enabled && state != TextInputState.Disabled,
            placeholder = {
                placeholder?.let { Text(it) }
            },
            leadingIcon = {
                leadingIcon?.Content()
            },
            trailingIcon = {
                trailingIcon?.Content()
            },
            colors = textInputColors(state),
            modifier = Modifier.fillMaxWidth(),
            singleLine = true,
        )

        if (state is TextInputState.Error && errorText != null) {
            Text(
                text = errorText,
                color = UIKitTheme.colors.error,
                style = UIKitTheme.typography.caption,
            )
        }
    }
}

@Composable
private fun labelColor(state: TextInputState): Color =
    when (state) {
        TextInputState.Default,
        TextInputState.Focused -> UIKitTheme.colors.textSecondary

        TextInputState.Error -> UIKitTheme.colors.error
        TextInputState.Disabled -> UIKitTheme.colors.disabled
    }

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun textInputColors(state: TextInputState): TextFieldColors {
    val colors = UIKitTheme.colors

    return OutlinedTextFieldDefaults.colors(
        focusedTextColor = colors.textPrimary,
        unfocusedTextColor = colors.textPrimary,
        disabledTextColor = colors.disabled,
        errorTextColor = colors.error,
        cursorColor = colors.primary,
        focusedBorderColor = colors.primary,
        unfocusedBorderColor = colors.border,
        disabledBorderColor = colors.disabled,
        errorBorderColor = colors.error,
    )
}

