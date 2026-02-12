package com.mego.objectreview

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.uikit.R
import com.example.uikit.theme.Green
import com.example.uikit.theme.MegoFontFamily
import com.example.uikit.theme.OpacityDark80
import com.example.uikit.theme.UIKitTheme


@Composable
fun OperatingMode(
    modeItem: ModeItem
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(UIKitTheme.colors.background)
            .padding(horizontal = 16.dp)
            .padding(top = 14.dp)
    ) {
        Column {
            Text(
                text = modeItem.title,
                fontSize = 18.sp,
                fontWeight = FontWeight.W500,
                fontFamily = MegoFontFamily,
                color = OpacityDark80,
                modifier = Modifier.padding(bottom = 16.dp)
            )
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(16.dp),
            ) {
                Icon(
                    painter = painterResource(modeItem.icon),
                    contentDescription = "Timer",
                    tint = OpacityDark80,
                    modifier = Modifier
                        .padding(vertical = 9.dp)
                        .size(32.dp)
                )
                Column(
                    modifier = Modifier.padding(bottom = 16.dp)
                ) {
                    Text(
                        text = "Пн-Пт: ${modeItem.timeRangeFirst};",
                        color = OpacityDark80,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.W500,
                        fontFamily = MegoFontFamily

                    )
                    Text(
                        text = "Сб, Вс: ${modeItem.timeRangeSecond}",
                        color = OpacityDark80,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.W500,
                        fontFamily = MegoFontFamily
                    )
                    Text(
                        text = if (modeItem.isOpenTime) "Открыто" else "Закрыто",
                        color = if (modeItem.isOpenTime) Green else UIKitTheme.colors.error,
                        fontWeight = FontWeight.W400,
                        fontFamily = MegoFontFamily
                    )
                }
            }
        }
    }
}


@Composable
fun AddressBox(
    addressItem: AddressItem,
    onSeeMap: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(UIKitTheme.colors.background)
            .padding(horizontal = 16.dp)
    ) {
        Column {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = addressItem.title,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.W500,
                    fontFamily = MegoFontFamily,
                    color = OpacityDark80,
                )
                TextButton(
                    onClick = onSeeMap
                ) {
                    Text(
                        text = addressItem.seeMap,
                        color = UIKitTheme.colors.primary,
                        fontWeight = FontWeight.W500,
                        fontSize = 14.sp,
                    )
                }
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Icon(
                    painter = painterResource(addressItem.icon),
                    contentDescription = "Timer",
                    tint = OpacityDark80,
                    modifier = Modifier.size(32.dp)
                )
                Column(
                    modifier = Modifier.padding(bottom = 16.dp)
                ) {
                    Text(
                        text = addressItem.location,
                        color = OpacityDark80,
                        fontSize = 15.sp,
                        fontWeight = FontWeight.W500,
                        fontFamily = MegoFontFamily,
                    )
                    Text(
                        text = if (addressItem.isOpenLocation) "Открыто" else "Закрыто",
                        color = if (addressItem.isOpenLocation) Green else UIKitTheme.colors.error,
                        fontWeight = FontWeight.W400,
                        fontFamily = MegoFontFamily
                    )
                }

            }
        }
    }
}

@Preview
@Composable
private fun AddressBoxPreview() {
    AddressBox(
        AddressItem(
            title = "Адрес",
            icon = R.drawable.location_32,
            location = "Алматы, Центральный проспект, стр. 17 Б, центральный вход",
            isOpenLocation = true,
            seeMap = "Смотреть на карте"
        ),
        onSeeMap = {}
    )
}

@Preview
@Composable
private fun OperatingModePreview() {
    OperatingMode(
        ModeItem(
            title = "Режим работы",
            icon = R.drawable.timer_32,
            timeRangeFirst = "9:00-22:00",
            timeRangeSecond = "10:00-20:00",
            isOpenTime = true,
        )
    )
}