package com.example.uikit.components.buttons.button


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
import androidx.compose.material3.Text
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.example.uikit.theme.ColorPurpure
import com.example.uikit.theme.ColorRed
import com.example.uikit.theme.CorporateMeGoPrimary
import com.example.uikit.theme.OpacityDark40
import com.example.uikit.theme.OpacityLight60


@Composable
fun MeGoButton(
    text: String,
    style: ButtonType,
    enabled: Boolean = true,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val interactionSource = remember { MutableInteractionSource() }
    val isPressed by interactionSource.collectIsPressedAsState()

    val backgroundColor = getBackgroundColor(style, enabled, isPressed)
    val contentColor = getContentColor(style, enabled, isPressed)
    val border = getBorder(style, enabled, isPressed)

    Box(
        modifier = modifier
            .clip(RoundedCornerShape(8.dp))
            .then(
                if (border != null) {
                    Modifier.border(border, RoundedCornerShape(8.dp))
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
            .padding(horizontal = 16.dp, vertical = 8.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = text,
            color = contentColor,
            fontSize = 14.sp,
            fontWeight = FontWeight.Medium
        )
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

// Добавил для теста
@Preview(showBackground = true)
@Composable
private fun MeGoButtonPreview() {
    Column(
        verticalArrangement = Arrangement.spacedBy(12.dp),
        modifier = Modifier.padding(16.dp)
    ) {
        MeGoButton("Label", ButtonType.Fill, onClick = {})
        MeGoButton("Label", ButtonType.Stroke, onClick = {})
        MeGoButton("Label", ButtonType.Empty, onClick = {})
        MeGoButton("Label", ButtonType.Error, onClick = {})
        MeGoButton("Label", ButtonType.Fill, enabled = false, onClick = {})
        MeGoButton("Label", ButtonType.Stroke, enabled = false, onClick = {})
        MeGoButton("Label", ButtonType.Empty, enabled = false, onClick = {})
        MeGoButton("Label", ButtonType.Error, enabled = false, onClick = {})
    }
}
