package com.example.uikit.components.buttons.button


import android.R.attr.fontWeight
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.example.uikit.Icon.MegaIcons
import com.example.uikit.theme.ColorPurpure
import com.example.uikit.theme.ColorRed
import com.example.uikit.theme.CorporateMeGoPrimary
import com.example.uikit.theme.OpacityDark40
import com.example.uikit.theme.OpacityLight60
import com.google.android.material.internal.ViewUtils.getBackgroundColor


@Composable
fun MeGoButton(
    text: String? = null,
    style: ButtonType,
    size: ButtonSize = ButtonSize.Default,
    iconPosition: IconPosition? = null,
    enabled: Boolean = true,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val interactionSource = remember { MutableInteractionSource() }
    val isPressed by interactionSource.collectIsPressedAsState()
    val shape = RoundedCornerShape(size.cornerRadius)
    val (startPadding, endPadding) = size.getHorizontalPaddings(text, iconPosition)
    val verticalPadding = size.verticalPadding
    val backgroundColor = getBackgroundColor(style, enabled, isPressed)
    val contentColor = getContentColor(style, enabled, isPressed)
    val border = getBorder(style, enabled, isPressed)

    Box(
        modifier = modifier
            .clip(shape)
            .then(
                if (border != null) {
                    Modifier.border(border, shape)
                } else {
                    Modifier
                }
            )
            .background(backgroundColor)
            .clickable(
                enabled = enabled,
                interactionSource = interactionSource,
                indication = null,
                onClick = onClick
            )
            .padding(
                start = startPadding,
                end = endPadding,
                top = verticalPadding,
                bottom = verticalPadding
            ),
        contentAlignment = Alignment.Center
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            if (iconPosition == IconPosition.Start || text == null) {
                MeGoIconHome(contentColor)
            }
            text?.let {
                Text(
                    text = text,
                    color = contentColor,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Medium
                )
            }
            if (iconPosition == IconPosition.End && text != null) {
                MeGoIconHome(contentColor)
            }
        }
    }
}

private fun getBackgroundColor(
    style: ButtonType,
    enabled: Boolean,
    pressed: Boolean,
): Color {
    if (!enabled) {
        return when (style) {
            ButtonType.Fill ->
                OpacityLight60

            ButtonType.Stroke ->
                Color.Transparent

            ButtonType.Empty ->
                Color.Transparent

            ButtonType.Error ->
                OpacityLight60
        }
    }

    return when (style) {
        ButtonType.Fill ->
            if (pressed) ColorPurpure else CorporateMeGoPrimary

        ButtonType.Stroke ->
            Color.Transparent

        ButtonType.Empty ->
            Color.Transparent

        ButtonType.Error ->
            Color.Transparent
    }
}

private fun getContentColor(
    style: ButtonType,
    enabled: Boolean,
    pressed: Boolean,
): Color {
    if (!enabled) return OpacityDark40

    return when (style) {
        ButtonType.Fill -> Color.White
        ButtonType.Stroke -> if (pressed) ColorPurpure else CorporateMeGoPrimary
        ButtonType.Empty -> if (pressed) ColorPurpure else CorporateMeGoPrimary
        ButtonType.Error -> ColorRed
    }
}

private fun getBorder(
    style: ButtonType,
    enabled: Boolean,
    pressed: Boolean,
): BorderStroke? {
    if (!enabled) {
        return when (style) {
            ButtonType.Stroke ->
                BorderStroke(2.dp, OpacityDark40)

            else -> null
        }
    }

    return when (style) {
        ButtonType.Stroke ->
            if (pressed)
                BorderStroke(2.dp, ColorPurpure)
            else BorderStroke(2.dp, CorporateMeGoPrimary)

        else -> null
    }
}

@Composable
private fun MeGoIconHome(tint: Color) {
    Icon(
        imageVector = MegaIcons.icHome(),
        contentDescription = null,
        modifier = Modifier.size(20.dp),
        tint = tint
    )
}

// Тест button тип fill, состояния enable/press
@Preview(showBackground = true)
@Composable
private fun MeGoButtonFillPreview() {
    Column(
        verticalArrangement = Arrangement.spacedBy(12.dp),
        modifier = Modifier.padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        MeGoButton("Label", ButtonType.Fill, onClick = {})
        MeGoButton("Label", ButtonType.Fill, onClick = {}, size = ButtonSize.Large)
        MeGoButton(
            "Label",
            ButtonType.Fill,
            onClick = {},
            size = ButtonSize.Default,
            iconPosition = IconPosition.Start // Если кнопка с иконкой, то передаем ее позицию
        )
        MeGoButton(
            "Label",
            ButtonType.Fill,
            onClick = {},
            size = ButtonSize.Large,
            iconPosition = IconPosition.Start
        )
        MeGoButton(
            "Label",
            ButtonType.Fill,
            onClick = {},
            size = ButtonSize.Default,
            iconPosition = IconPosition.End
        )
        MeGoButton(
            "Label",
            ButtonType.Fill,
            onClick = {},
            size = ButtonSize.Large,
            iconPosition = IconPosition.End
        )
    }
}

// Тест button тип fill, состояние disable
@Preview(showBackground = true)
@Composable
private fun MeGoButtonFillPreviewDisable() {
    Surface(
        color = Color.Black,
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(12.dp),
            modifier = Modifier.padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {

            // Тип fill, состояние disable
            MeGoButton("Label", ButtonType.Fill, onClick = {}, enabled = false)
            MeGoButton(
                "Label",
                ButtonType.Fill,
                onClick = {},
                size = ButtonSize.Large,
                enabled = false
            )
            MeGoButton(
                "Label",
                ButtonType.Fill,
                onClick = {},
                size = ButtonSize.Default,
                iconPosition = IconPosition.Start,
                enabled = false
            )
            MeGoButton(
                "Label",
                ButtonType.Fill,
                onClick = {},
                size = ButtonSize.Large,
                iconPosition = IconPosition.Start,
                enabled = false
            )
            MeGoButton(
                "Label",
                ButtonType.Fill,
                onClick = {},
                size = ButtonSize.Default,
                iconPosition = IconPosition.End,
                enabled = false
            )
            MeGoButton(
                "Label",
                ButtonType.Fill,
                onClick = {},
                size = ButtonSize.Large,
                iconPosition = IconPosition.End,
                enabled = false
            )
        }
    }
}

// Тест button тип stroke, состояния enable/press
@Preview(showBackground = true)
@Composable
private fun MeGoButtonStrokePreview() {
    Column(
        verticalArrangement = Arrangement.spacedBy(12.dp),
        modifier = Modifier.padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        MeGoButton("Label", ButtonType.Stroke, onClick = {})
        MeGoButton("Label", ButtonType.Stroke, onClick = {}, size = ButtonSize.Large)
        MeGoButton(
            "Label",
            ButtonType.Stroke,
            onClick = {},
            size = ButtonSize.Default,
            iconPosition = IconPosition.Start
        )
        MeGoButton(
            "Label",
            ButtonType.Stroke,
            onClick = {},
            size = ButtonSize.Large,
            iconPosition = IconPosition.Start
        )
        MeGoButton(
            "Label",
            ButtonType.Stroke,
            onClick = {},
            size = ButtonSize.Default,
            iconPosition = IconPosition.End
        )
        MeGoButton(
            "Label",
            ButtonType.Stroke,
            onClick = {},
            size = ButtonSize.Large,
            iconPosition = IconPosition.End
        )
    }
}

// Тест button тип stroke, состояние disable
@Preview(showBackground = true)
@Composable
private fun MeGoButtonStrokePreviewDisable() {
    Column(
        verticalArrangement = Arrangement.spacedBy(12.dp),
        modifier = Modifier.padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        MeGoButton("Label", ButtonType.Stroke, onClick = {}, enabled = false)
        MeGoButton(
            "Label",
            ButtonType.Stroke,
            onClick = {},
            size = ButtonSize.Large,
            enabled = false
        )
        MeGoButton(
            "Label",
            ButtonType.Stroke,
            onClick = {},
            size = ButtonSize.Default,
            iconPosition = IconPosition.Start,
            enabled = false
        )
        MeGoButton(
            "Label",
            ButtonType.Stroke,
            onClick = {},
            size = ButtonSize.Large,
            iconPosition = IconPosition.Start,
            enabled = false
        )
        MeGoButton(
            "Label",
            ButtonType.Stroke,
            onClick = {},
            size = ButtonSize.Default,
            iconPosition = IconPosition.End,
            enabled = false
        )
        MeGoButton(
            "Label",
            ButtonType.Stroke,
            onClick = {},
            size = ButtonSize.Large,
            iconPosition = IconPosition.End,
            enabled = false
        )
    }
}

// Тест button тип empty, состояния enable/press
@Preview(showBackground = true)
@Composable
private fun MeGoButtonEmptyPreview() {
    Column(
        verticalArrangement = Arrangement.spacedBy(12.dp),
        modifier = Modifier.padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        MeGoButton("Label", ButtonType.Empty, onClick = {})
        MeGoButton("Label", ButtonType.Empty, onClick = {}, size = ButtonSize.Large)
        MeGoButton(
            "Label",
            ButtonType.Empty,
            onClick = {},
            size = ButtonSize.Default,
            iconPosition = IconPosition.Start
        )
        MeGoButton(
            "Label",
            ButtonType.Empty,
            onClick = {},
            size = ButtonSize.Large,
            iconPosition = IconPosition.Start
        )
        MeGoButton(
            "Label",
            ButtonType.Empty,
            onClick = {},
            size = ButtonSize.Default,
            iconPosition = IconPosition.End
        )
        MeGoButton(
            "Label",
            ButtonType.Empty,
            onClick = {},
            size = ButtonSize.Large,
            iconPosition = IconPosition.End
        )
    }
}


// Тест button тип empty, состояние disable
@Preview(showBackground = true)
@Composable
private fun MeGoButtonEmptyPreviewDisable() {
    Column(
        verticalArrangement = Arrangement.spacedBy(12.dp),
        modifier = Modifier.padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        MeGoButton("Label", ButtonType.Empty, onClick = {}, enabled = false)
        MeGoButton(
            "Label",
            ButtonType.Empty,
            onClick = {},
            size = ButtonSize.Large,
            enabled = false
        )
        MeGoButton(
            "Label",
            ButtonType.Empty,
            onClick = {},
            size = ButtonSize.Default,
            iconPosition = IconPosition.Start,
            enabled = false
        )
        MeGoButton(
            "Label",
            ButtonType.Empty,
            onClick = {},
            size = ButtonSize.Large,
            iconPosition = IconPosition.Start,
            enabled = false
        )
        MeGoButton(
            "Label",
            ButtonType.Empty,
            onClick = {},
            size = ButtonSize.Default,
            iconPosition = IconPosition.End,
            enabled = false
        )
        MeGoButton(
            "Label",
            ButtonType.Empty,
            onClick = {},
            size = ButtonSize.Large,
            iconPosition = IconPosition.End,
            enabled = false
        )
    }
}

// Тест button тип error, состояния enable/press
@Preview(showBackground = true)
@Composable
private fun MeGoButtonErrorPreview() {
    Column(
        verticalArrangement = Arrangement.spacedBy(12.dp),
        modifier = Modifier.padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        MeGoButton("Label", ButtonType.Error, onClick = {})
        MeGoButton("Label", ButtonType.Error, onClick = {}, size = ButtonSize.Large)
        MeGoButton(
            "Label",
            ButtonType.Error,
            onClick = {},
            size = ButtonSize.Default,
            iconPosition = IconPosition.Start
        )
        MeGoButton(
            "Label",
            ButtonType.Error,
            onClick = {},
            size = ButtonSize.Large,
            iconPosition = IconPosition.Start
        )
        MeGoButton(
            "Label",
            ButtonType.Error,
            onClick = {},
            size = ButtonSize.Default,
            iconPosition = IconPosition.End
        )
        MeGoButton(
            "Label",
            ButtonType.Error,
            onClick = {},
            size = ButtonSize.Large,
            iconPosition = IconPosition.End
        )
    }
}

// Тест button тип error, состояние disable
@Preview(showBackground = true)
@Composable
private fun MeGoButtonErrorPreviewDisable() {
    Surface(
        color = Color.Black,
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(12.dp),
            modifier = Modifier.padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            MeGoButton("Label", ButtonType.Error, onClick = {}, enabled = false)
            MeGoButton(
                "Label",
                ButtonType.Error,
                onClick = {},
                size = ButtonSize.Large,
                enabled = false
            )
            MeGoButton(
                "Label",
                ButtonType.Error,
                onClick = {},
                size = ButtonSize.Default,
                iconPosition = IconPosition.Start,
                enabled = false
            )
            MeGoButton(
                "Label",
                ButtonType.Error,
                onClick = {},
                size = ButtonSize.Large,
                iconPosition = IconPosition.Start,
                enabled = false
            )
            MeGoButton(
                "Label",
                ButtonType.Error,
                onClick = {},
                size = ButtonSize.Default,
                iconPosition = IconPosition.End,
                enabled = false
            )
            MeGoButton(
                "Label",
                ButtonType.Error,
                onClick = {},
                size = ButtonSize.Large,
                iconPosition = IconPosition.End,
                enabled = false
            )
        }
    }
}


// Тест button тип fill, состояния enable/press, icon only
@Preview(showBackground = true)
@Composable
private fun MeGoButtonFillPreviewIconOnly() {
    Column(
        verticalArrangement = Arrangement.spacedBy(12.dp),
        modifier = Modifier.padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        MeGoButton(
            style = ButtonType.Fill,
            onClick = {},
            size = ButtonSize.Default
        )
        MeGoButton(
            style = ButtonType.Fill,
            onClick = {},
            size = ButtonSize.Large
        )
    }
}

// Тест button тип fill, состояние disable, icon only
@Preview(showBackground = true)
@Composable
private fun MeGoButtonFillPreviewIconOnlyDisable() {
    Surface(
        color = Color.Black
    ) {

        Column(
            verticalArrangement = Arrangement.spacedBy(12.dp),
            modifier = Modifier.padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            MeGoButton(
                style = ButtonType.Fill,
                onClick = {},
                size = ButtonSize.Default,
                enabled = false
            )
            MeGoButton(
                style = ButtonType.Fill,
                onClick = {},
                size = ButtonSize.Large,
                enabled = false
            )
        }
    }
}


// Тест button тип stroke, состояния enable/press, icon only
@Preview(showBackground = true)
@Composable
private fun MeGoButtonStrokePreviewIconOnly() {
    Column(
        verticalArrangement = Arrangement.spacedBy(12.dp),
        modifier = Modifier.padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        MeGoButton(
            style = ButtonType.Stroke,
            onClick = {},
            size = ButtonSize.Default
        )
        MeGoButton(
            style = ButtonType.Stroke,
            onClick = {},
            size = ButtonSize.Large
        )
    }
}


// Тест button тип stroke, состояние disable, icon only
@Preview(showBackground = true)
@Composable
private fun MeGoButtonStrokePreviewIconOnlyDisable() {
    Column(
        verticalArrangement = Arrangement.spacedBy(12.dp),
        modifier = Modifier.padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        MeGoButton(
            style = ButtonType.Stroke,
            onClick = {},
            size = ButtonSize.Default,
            enabled = false
        )
        MeGoButton(
            style = ButtonType.Stroke,
            onClick = {},
            size = ButtonSize.Large,
            enabled = false
        )
    }
}


// Тест button тип empty, состояния enable/press, icon only
@Preview(showBackground = true)
@Composable
private fun MeGoButtonEmptyPreviewIconOnly() {
    Column(
        verticalArrangement = Arrangement.spacedBy(12.dp),
        modifier = Modifier.padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        MeGoButton(
            style = ButtonType.Empty,
            onClick = {},
            size = ButtonSize.Default
        )
        MeGoButton(
            style = ButtonType.Empty,
            onClick = {},
            size = ButtonSize.Large
        )
    }
}

// Тест button тип empty, состояние disable, icon only
@Preview(showBackground = true)
@Composable
private fun MeGoButtonEmptyPreviewIconOnlyDisable() {
    Column(
        verticalArrangement = Arrangement.spacedBy(12.dp),
        modifier = Modifier.padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        MeGoButton(
            style = ButtonType.Empty,
            onClick = {},
            size = ButtonSize.Default,
            enabled = false
        )
        MeGoButton(
            style = ButtonType.Empty,
            onClick = {},
            size = ButtonSize.Large,
            enabled = false
        )
    }
}


// Тест button тип error, состояния enable/press, icon only
@Preview(showBackground = true)
@Composable
private fun MeGoButtonErrorPreviewIconOnly() {
    Column(
        verticalArrangement = Arrangement.spacedBy(12.dp),
        modifier = Modifier.padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        MeGoButton(
            style = ButtonType.Error,
            onClick = {},
            size = ButtonSize.Default
        )
        MeGoButton(
            style = ButtonType.Error,
            onClick = {},
            size = ButtonSize.Large
        )
    }
}

// Тест button тип error, состояние disable, icon only
@Preview(showBackground = true)
@Composable
private fun MeGoButtonErrorPreviewIconOnlyDisable() {
    Surface(
        color = Color.Black
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(12.dp),
            modifier = Modifier.padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            MeGoButton(
                style = ButtonType.Error,
                onClick = {},
                size = ButtonSize.Default,
                enabled = false
            )
            MeGoButton(
                style = ButtonType.Error,
                onClick = {},
                size = ButtonSize.Large,
                enabled = false
            )
        }
    }
}





