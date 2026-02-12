package com.example.uikit.component.button

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.uikit.component.WithMegoIndication
import com.example.uikit.theme.bodyMedium500
import com.example.uikit.theme.medium
import com.example.uikit.theme.megoOpacity
import com.example.uikit.theme.megoPrimary
import kotlin.coroutines.coroutineContext

@Composable
fun SelectableButton(
    title: String,
    isSelected: Boolean,
    onClick: (() -> Unit)?,
) {
    val (buttonColor, textColor) =
        if (isSelected) {
            megoOpacity to Color.White
        } else {
            Color.White to megoPrimary
        }
    WithMegoIndication {
        Box(
            modifier =
                Modifier
                    .clip(RoundedCornerShape(16.dp))
                    .background(buttonColor)
                    .let {
                        if (onClick != null) {
                            it.selectable(
                                selected = isSelected,
                                onClick = onClick,
                            )
                        } else {
                            it
                        }
                    }
                    .padding(vertical = 7.dp, horizontal = 16.dp),
        ) {
            Text(
                text = title,
                style = bodyMedium500,
                fontFamily = medium,
                color = textColor,
            )
        }
    }
}



@Preview
@Composable
fun PreviewSelectableButtonIsSelected(){
    SelectableButton(
        title = "Button",
        onClick = {},
        isSelected = true
    )
}

@Preview
@Composable
fun PreviewSelectableButtonUnSelected(){
    SelectableButton(
        title = "Button",
        onClick = {},
        isSelected = false
    )
}
