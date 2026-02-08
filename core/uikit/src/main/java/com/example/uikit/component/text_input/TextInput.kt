package com.example.uikit.component.text_input

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsFocusedAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.uikit.theme.UIKitTheme

/**
 * Базовый компонент текстового поля UI‑кита.
 *
 * ### Параметры
 * - `value` / `onValueChange`: текущий текст и обработчик изменений
 * - `label`: лейбл (в Default показывается внутри, в Active — на границе)
 * - `placeholder`: альтернативный placeholder (если не задан, используется `label`)
 * - `state`: визуальное состояние (Default/Active/Fill/Error/Disabled)
 * - `enabled`: доступность поля
 * - `leftIcon` / `rightIcon`: иконки слева/справа от текста
 * - `supportingText`: текст под полем (ошибка/подсказка)
 *
 * ### Для частных случаев используйте wrapper'ы:
 * - `TextInputWithLeftIcon` — только иконка слева
 * - `TextInputWithRightIcon` — только иконка справа
 * - `TextInputWithIcons` — обе иконки
 */

@Composable
fun TextInput(
    value: String,
    onValueChange: (String) -> Unit,
    label: String? = null,
    placeholder: String? = null,
    state: TextInputState = TextInputState.Default,
    enabled: Boolean = true,
    leftIcon: TextInputIcon? = null,
    rightIcon: TextInputIcon? = null,
    supportingText: String? = null,
    modifier: Modifier = Modifier,
    keyboardOptions: KeyboardOptions = KeyboardOptions(
        capitalization = KeyboardCapitalization.None,
        autoCorrectEnabled = true,
        keyboardType = KeyboardType.Text,
        imeAction = ImeAction.Done,
    ),
) {
    val interactionSource = remember { MutableInteractionSource() }
    val isFocused = interactionSource.collectIsFocusedAsState().value

    // Определение визуального состояния: фокус определяется автоматически, state позволяет форсировать
    val visualState = when {
        !enabled -> TextInputState.Disabled
        state is TextInputState.Error -> TextInputState.Error
        state is TextInputState.Active -> TextInputState.Active
        state is TextInputState.Fill -> TextInputState.Fill
        isFocused -> TextInputState.Active
        value.isNotEmpty() -> TextInputState.Fill
        else -> TextInputState.Default
    }

    val shape = RoundedCornerShape(10.dp)
    val borderColor = borderColor(visualState)
    val borderWidth = if (visualState == TextInputState.Active) 1.25.dp else 1.dp
    val labelColor = labelColor(visualState)
    val textColor = textColor(visualState)

    // Placeholder: показывается только когда поле пустое и не в Active/Error
    val placeholderText = when {
        value.isNotEmpty() -> null
        visualState == TextInputState.Active -> null
        visualState == TextInputState.Error -> null
        else -> label ?: placeholder
    }

    Column(modifier = modifier) {
        Box(modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 4.dp, vertical = 8.dp)) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(46.dp)
                    .background(UIKitTheme.colors.background, shape)
                    .border(BorderStroke(borderWidth, borderColor), shape)
                    .padding(horizontal = 12.dp, vertical = 12.dp),
                contentAlignment = Alignment.CenterStart,
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Start,
                ) {
                    if (leftIcon != null) {
                        leftIcon.Content()
                        Spacer(Modifier.width(8.dp))
                    }

                    BasicTextField(
                        value = value,
                        onValueChange = onValueChange,
                        enabled = enabled,
                        interactionSource = interactionSource,
                        singleLine = true,
                        keyboardOptions = keyboardOptions,
                        textStyle = UIKitTheme.typography.body.copy(color = textColor),
                        modifier = Modifier
                            .weight(1f)
                            .padding(top = 1.dp),
                        decorationBox = { innerTextField ->
                            if (placeholderText != null) {
                                Text(
                                    text = placeholderText,
                                    style = UIKitTheme.typography.body.copy(color = UIKitTheme.colors.border),
                                )
                            }
                            innerTextField()
                        },
                    )

                    if (rightIcon != null) {
                        Spacer(Modifier.width(8.dp))
                        rightIcon.Content()
                    }
                }
            }

            // Лейбл на границе (показывается только в Active)
            if (label != null && visualState == TextInputState.Active) {
                Text(
                    text = label,
                    modifier = Modifier
                        .offset(x = 18.dp, y = (-8).dp)
                        .background(UIKitTheme.colors.background)
                        .padding(horizontal = 4.dp),
                    style = UIKitTheme.typography.caption.copy(fontWeight = FontWeight.Light),
                    color = labelColor,
                )
            }
        }

        if (supportingText != null) {
            Spacer(Modifier.height(6.dp))
            Text(
                text = supportingText,
                style = UIKitTheme.typography.caption,
                color = if (visualState == TextInputState.Error) UIKitTheme.colors.error else UIKitTheme.colors.textSecondary,
            )
        }
    }
}

@Composable
private fun borderColor(state: TextInputState): Color = when (state) {
    TextInputState.Default -> UIKitTheme.colors.secondary
    TextInputState.Fill -> UIKitTheme.colors.secondary
    TextInputState.Active -> UIKitTheme.colors.primary
    TextInputState.Error -> UIKitTheme.colors.error
    TextInputState.Disabled -> UIKitTheme.colors.disabled
}

@Composable
private fun labelColor(state: TextInputState): Color = when (state) {
    TextInputState.Default -> UIKitTheme.colors.border
    TextInputState.Fill -> UIKitTheme.colors.border
    TextInputState.Active -> UIKitTheme.colors.primary
    TextInputState.Error -> UIKitTheme.colors.error
    TextInputState.Disabled -> UIKitTheme.colors.disabled
}


@Composable
private fun textColor(state: TextInputState): Color = when (state) {
    TextInputState.Default -> UIKitTheme.colors.border
    TextInputState.Fill -> UIKitTheme.colors.textPrimary
    TextInputState.Active -> UIKitTheme.colors.textPrimary
    TextInputState.Error -> UIKitTheme.colors.error
    TextInputState.Disabled -> UIKitTheme.colors.disabled
}

/**
 * Поле ввода с иконкой слева.
 */
@Composable
fun TextInputWithLeftIcon(
    value: String,
    onValueChange: (String) -> Unit,
    leftIcon: @Composable () -> Unit,
    label: String? = null,
    placeholder: String? = null,
    state: TextInputState = TextInputState.Default,
    enabled: Boolean = true,
    supportingText: String? = null,
    modifier: Modifier = Modifier,
    keyboardOptions: KeyboardOptions = KeyboardOptions(
        capitalization = KeyboardCapitalization.None,
        autoCorrectEnabled = true,
        keyboardType = KeyboardType.Text,
        imeAction = ImeAction.Done,
    ),
) {
    TextInput(
        value = value,
        onValueChange = onValueChange,
        label = label,
        placeholder = placeholder,
        state = state,
        enabled = enabled,
        leftIcon = TextInputIcon { leftIcon() },
        supportingText = supportingText,
        modifier = modifier,
        keyboardOptions = keyboardOptions,
    )
}

/**
 * Поле ввода с иконкой справа.
 */
@Composable
fun TextInputWithRightIcon(
    value: String,
    onValueChange: (String) -> Unit,
    rightIcon: @Composable () -> Unit,
    label: String? = null,
    placeholder: String? = null,
    state: TextInputState = TextInputState.Default,
    enabled: Boolean = true,
    supportingText: String? = null,
    modifier: Modifier = Modifier,
    keyboardOptions: KeyboardOptions = KeyboardOptions(
        capitalization = KeyboardCapitalization.None,
        autoCorrectEnabled = true,
        keyboardType = KeyboardType.Text,
        imeAction = ImeAction.Done,
    ),
) {
    TextInput(
        value = value,
        onValueChange = onValueChange,
        label = label,
        placeholder = placeholder,
        state = state,
        enabled = enabled,
        rightIcon = TextInputIcon { rightIcon() },
        supportingText = supportingText,
        modifier = modifier,
        keyboardOptions = keyboardOptions,
    )
}

/**
 * Поле ввода с иконками слева и справа.
 */
@Composable
fun TextInputWithIcons(
    value: String,
    onValueChange: (String) -> Unit,
    leftIcon: @Composable () -> Unit,
    rightIcon: @Composable () -> Unit,
    label: String? = null,
    placeholder: String? = null,
    state: TextInputState = TextInputState.Default,
    enabled: Boolean = true,
    supportingText: String? = null,
    modifier: Modifier = Modifier,
    keyboardOptions: KeyboardOptions = KeyboardOptions(
        capitalization = KeyboardCapitalization.None,
        autoCorrectEnabled = true,
        keyboardType = KeyboardType.Text,
        imeAction = ImeAction.Done,
    ),
) {
    TextInput(
        value = value,
        onValueChange = onValueChange,
        label = label,
        placeholder = placeholder,
        state = state,
        enabled = enabled,
        leftIcon = TextInputIcon { leftIcon() },
        rightIcon = TextInputIcon { rightIcon() },
        supportingText = supportingText,
        modifier = modifier,
        keyboardOptions = keyboardOptions,
    )
}
