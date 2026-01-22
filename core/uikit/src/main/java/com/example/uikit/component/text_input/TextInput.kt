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
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.uikit.theme.UIKitTheme
import kotlinx.coroutines.withTimeout

/**
 * Базовый компонент текстового поля UI‑кита.
 *
 * ### Как использовать
 * - **Что импортировать**: `com.example.uikit.component.text_input.TextInput`
 * - **Что ещё понадобится**:
 *   - `com.example.uikit.component.text_input.TextInputState` — если нужно форсировать состояние (Error/Focused)
 *   - `com.example.uikit.component.text_input.TextInputIcon` — если нужны иконки слева/справа
 *   - `com.example.uikit.theme.UIKitTheme` — обычно вы уже оборачиваете экран/превью темой, но компонент и без этого соберётся
 *
 * ### Параметры (коротко)
 * - `value` / `onValueChange`: текущее значение и обработчик изменений.
 * - `label`: “плавающий” лейбл — **показывается на рамке только в фокусе**, как в дизайне.
 * - `placeholder`: текст внутри поля, когда оно пустое и не в фокусе. Если `placeholder == null`, используем `label`.
 * - `state`:
 *   - `Default`: обычное состояние.
 *   - `Focused`: можно форсировать фокус-вид (например, для Preview).
 *   - `Error`: красная рамка/текст (лейбл на рамке не показываем).
 *   - `Disabled`: можно выставить через `enabled=false` (приоритетнее).
 * - `leadingIcon` / `trailingIcon`: composable-иконки слева/справа.
 * - `supportingText`: подпись под полем (ошибка/подсказка/предупреждение).
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

    // NOTE: `state` позволяет форсировать визуальное состояние (полезно в превью/дизайн-демо).
    // В рантайме фокус также определяется автоматически через interactionSource.
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

    // Плейсхолдер показываем только когда поле пустое и НЕ в Active/ошибке.
    // В Default состоянии внутри поля показывается `label` (который потом переходит на границу в Active).
    // В Error состоянии placeholder не показывается — только введённый текст.
    val placeholderText = when {
        value.isNotEmpty() -> null
        visualState == TextInputState.Active -> null
        visualState == TextInputState.Error -> null
        else -> label ?: placeholder
    }

    Column(modifier = modifier) {
        Box(modifier = Modifier.fillMaxWidth()) {
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
                    if (leadingIcon != null) {
                        leadingIcon.Content()
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
                                // Placeholder всегда светлосерый (border), независимо от цвета границы
                                Text(
                                    text = placeholderText,
                                    style = UIKitTheme.typography.body.copy(color = UIKitTheme.colors.border),
                                )
                            }
                            innerTextField()
                        },
                    )

                    if (trailingIcon != null) {
                        Spacer(Modifier.width(8.dp))
                        trailingIcon.Content()
                    }
                }
            }

            // Лейбл "врезается" в верхнюю линию рамки за счёт background.
            // Показываем только в Active состоянии.
            if (label != null && visualState == TextInputState.Active) {
                Text(
                    text = label,
                    modifier = Modifier
                        // NOTE: offset подобран под текущие размеры (height=46dp, padding=12dp).
                        // Если дизайн изменится — регулируем x/y тут.
                        .offset(x = 18.dp, y = (-8).dp)
                        .background(UIKitTheme.colors.background)
                        .padding(horizontal = 4.dp),

                    style = UIKitTheme.typography.caption,
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
    // Default и Fill: блекло-сереневый (border)
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
    // Default: серый (border), Fill: почти чёрный (textPrimary), Active: почти чёрный (textPrimary)
    TextInputState.Default -> UIKitTheme.colors.border
    TextInputState.Fill -> UIKitTheme.colors.textPrimary
    TextInputState.Active -> UIKitTheme.colors.textPrimary
    TextInputState.Error -> UIKitTheme.colors.error
    TextInputState.Disabled -> UIKitTheme.colors.disabled
}

