package com.mego.objectreview

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.uikit.components.buttons.button.ButtonSize
import com.example.uikit.components.buttons.button.ButtonType
import com.example.uikit.components.buttons.button.IconPosition
import com.example.uikit.components.buttons.button.MeGoButton
import com.example.uikit.theme.UIKitTheme

@Preview
@Composable
fun BottomBox() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(UIKitTheme.colors.background)
    ) {
        Column(
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            MeGoButton(
                text = "Добавить к маршруту",
                style = ButtonType.Fill,
                onClick = {},
                iconPosition = IconPosition.Start,
                modifier = Modifier.fillMaxWidth(),
                size = ButtonSize.Large
            )
            MeGoButton(
                text = "Пригласить гида",
                style = ButtonType.Stroke,
                onClick = {},
                iconPosition = IconPosition.Start,
                modifier = Modifier.fillMaxWidth(),
                size = ButtonSize.Large
            )
        }
    }
}