package com.example.uikit.component.place

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import com.example.uikit.theme.MegoFontFamily
import com.example.uikit.theme.OpacityDark80
import com.example.uikit.theme.OpacityDark80Lighter

@Composable
fun TextNameForPlaceItem(
    name: String,
    fontFamily: FontFamily = MegoFontFamily,
    fontWeight: FontWeight = FontWeight.Medium,
    color: Color = OpacityDark80,
    lineHeight: TextUnit = 18.sp,
    fontSize: TextUnit = 16.sp,
    maxLines: Int = 5,
    modifier: Modifier = Modifier,
) {
    Text(
        name,
        fontFamily = fontFamily,
        fontWeight = fontWeight,
        fontSize = fontSize,
        color = color,
        lineHeight = lineHeight,
        overflow = TextOverflow.Ellipsis,
        maxLines = maxLines,
        modifier = modifier
    )
}
@Composable
fun AddressForPlaceItem(
    address: String,
    fontFamily: FontFamily = MegoFontFamily,
    fontWeight: FontWeight = FontWeight.Medium,
    color: Color = OpacityDark80Lighter,
    lineHeight: TextUnit = 16.sp,
    fontSize: TextUnit = 12.sp,
    maxLines: Int = 5,
    modifier: Modifier = Modifier,
) {
    Text(
        address,
        fontFamily = fontFamily,
        fontWeight = fontWeight,
        fontSize = fontSize,
        color = color,
        lineHeight = lineHeight,
        overflow = TextOverflow.Ellipsis,
        maxLines = maxLines,
        modifier = modifier
    )
}

