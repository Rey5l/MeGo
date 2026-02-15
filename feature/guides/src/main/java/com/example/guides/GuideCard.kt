package com.example.guides

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.uikit.R
import com.example.uikit.component.button.LikeButton
import com.example.uikit.component.guide.GuideDescription
import com.example.uikit.component.guide.GuideTags
import com.example.uikit.component.guide.PriceBlock
import com.example.uikit.theme.MegoFontFamily
import com.example.uikit.theme.OpacityDark40
import com.example.uikit.theme.UIKitTheme
import com.example.uikit.theme.bodyMedium400

@Composable
fun GuideCard(guide : GuideCardModel, onLikeClick : () -> Unit = {}) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .clip(RoundedCornerShape(10.dp))
    ) {
        Box(modifier = Modifier.background(UIKitTheme.colors.background)){
            Column(modifier = Modifier.padding(horizontal = 4.dp),verticalArrangement = Arrangement.spacedBy(8.dp)) {
                Row( verticalAlignment = Alignment.Top,
                    horizontalArrangement = Arrangement.spacedBy(8.dp),) {
                    AsyncImage(
                        model = guide.photo,
                        contentDescription = "Фотокарточка гида",
                        placeholder = painterResource(R.drawable.logo_mego),
                        modifier = Modifier
                            .padding(top = 4.dp, end = 4.dp)
                            .size(80.dp)
                            .clip(RoundedCornerShape(6.dp))
                    )
                    GuideDescription(
                        name = guide.name,
                        surname = guide.surname,
                        rating = guide.rating,
                        status = guide.isOnline,
                        modifier = Modifier.padding(top = 4.dp)
                    )
                    Spacer(Modifier.weight(1f))
                    LikeButton(
                        modifier = Modifier.padding(end = 4.dp, top = 8.dp),
                        onClick = { onLikeClick() },
                        isLiked = guide.isLiked,
                    )
                }
                Text(
                    text = guide.desc,
                    fontFamily = MegoFontFamily,
                    fontWeight = FontWeight.Normal,
                    style = bodyMedium400,
                    color = OpacityDark40,
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 2
                )
                GuideTags(guide.languages,guide.interests, modifier = Modifier.padding(start = 4.dp))

                HorizontalDivider(thickness = 1.dp)
                PriceBlock(price = guide.price, placeCount = guide.markCount, hours = guide.hour, modifier = Modifier.padding(bottom = 8.dp))

            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GuideCardPreview(){
    Column(Modifier.background(Color.Gray)) {
        GuideCard(
            guide = GuideCardModel(
                id = 1,
                name = "Бауржан",
                surname = "Кекильбаев",
                photo = "https://www.meme-arsenal.com/memes/d9156ddbe0074b2ac2e45d39e337d6b6.jpg",
                isOnline = false,
                isLiked = false,
                rating = 1.5,
                desc = "Краткое описание и любая другая сопутствующая информация в двух-трёх строках. Краткое описание и любая другая сопутствующая информация в двух-трёх строках",
                languages = listOf("Английский", "казахский", "китайский"),
                interests = listOf("Культура", "Кухня"),
                price = 1000,
                hour = 1,
                markCount = 3
            )
        )
    }
}


