package com.example.uikit.component.guide

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.uikit.icon.MegoIcons
import com.example.uikit.theme.CorporateMeGoPrimary
import com.example.uikit.theme.Gray
import com.example.uikit.theme.Green
import com.example.uikit.theme.MegoFontFamily
import com.example.uikit.theme.OpacityDark80
import com.example.uikit.theme.bodyLarge500
import com.example.uikit.theme.bodyLarge600
import com.example.uikit.theme.bodyMedium500
import com.example.uikit.theme.labelMedium400
import com.example.uikit.util.RussianPlural


@Composable
fun GuideDescription(name : String, surname : String, rating : Double, status : Boolean, modifier: Modifier = Modifier){
    Column(modifier = modifier, verticalArrangement = Arrangement.spacedBy(2.dp)) {
        val isOnlineText = if (status) "online" else "offline"
        val isOnlineColor = if (status) Green else Gray
        Text(name,
            fontFamily = MegoFontFamily,
            fontWeight = FontWeight.Medium,
            style = bodyLarge500
        )
        Text(surname,
            fontFamily = MegoFontFamily,
            fontWeight = FontWeight.Medium,
            style = bodyLarge500
        )
        Text(
            isOnlineText,
            fontFamily = MegoFontFamily,
            fontWeight = FontWeight.Medium,
            style = labelMedium400,
            color = isOnlineColor
        )
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            Icon(
                MegoIcons.star,
                contentDescription = null,
                tint = CorporateMeGoPrimary,
                modifier = Modifier.size(16.dp)
            )
            Text(
                "$rating",
                fontFamily = MegoFontFamily,
                fontWeight = FontWeight.Normal,
                style = bodyMedium500,
                color = OpacityDark80
            )
        }
    }
}
@Composable
fun GuideTags(languages : List<String>, interests : List<String>, modifier: Modifier = Modifier){

    Column(modifier = modifier, verticalArrangement = Arrangement.spacedBy(4.dp)) {
        Row(horizontalArrangement = Arrangement.spacedBy(4.dp),verticalAlignment = Alignment.CenterVertically) {
            Icon(imageVector = MegoIcons.translate, "translate",
                modifier = Modifier.size(16.dp))
            Text(
                "${languages.joinToString(", ")}",
                fontFamily = MegoFontFamily,
                fontWeight = FontWeight.Normal,
                style = labelMedium400,
                color = OpacityDark80
            )
        }
        Row(horizontalArrangement = Arrangement.spacedBy(4.dp), verticalAlignment = Alignment.CenterVertically) {
            Icon(imageVector = MegoIcons.interests, "translate",
                modifier = Modifier.size(16.dp))
            Text(
                "${interests.joinToString(", ")}",
                fontFamily = MegoFontFamily,
                fontWeight = FontWeight.Normal,
                style = labelMedium400,
                color = OpacityDark80
            )
        }
    }
}

@Composable
fun PriceBlock(modifier: Modifier = Modifier, price : Int, placeCount : Int, hours : Int){
    Row(modifier = modifier) {
        Text("Цена услуг",
            modifier = Modifier.align(Alignment.CenterVertically),
            fontFamily = MegoFontFamily,
            fontWeight = FontWeight.Normal,
            style = labelMedium400,
            color = CorporateMeGoPrimary)
        Spacer(Modifier.weight(1f))
        Column() {
            Text("от $price ₽",
                fontFamily = MegoFontFamily,
                fontWeight = FontWeight.SemiBold,
                style = bodyLarge600,
                color = CorporateMeGoPrimary)

            Text("(${RussianPlural.formatHours(hours)} / ${RussianPlural.formatDotsText(placeCount)})",
                fontFamily = MegoFontFamily,
                fontWeight = FontWeight.Normal,
                style = labelMedium400,
                color = CorporateMeGoPrimary)
        }
    }
}