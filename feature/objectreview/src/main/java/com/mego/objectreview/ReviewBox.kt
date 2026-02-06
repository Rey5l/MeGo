package com.mego.objectreview

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.uikit.theme.BGSecondary
import com.example.uikit.theme.MegoFontFamily
import com.example.uikit.theme.OpacityDark80
import com.example.uikit.theme.UIKitTheme


@Composable
fun ReviewBox(
    reviewBoxIem: ReviewBoxIem
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(BGSecondary)
    ) {
        Column(
            modifier = Modifier.padding(bottom = 14.dp)
        ) {
            RowWithTextAndButton(
                title = "Отзывы",
                onSeeMap = {},
                seeMap = "Показать все",
                modifier = Modifier.padding(horizontal = 16.dp)
            )
            LazyRow(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                contentPadding = PaddingValues(horizontal = 16.dp)
            ) {
                items(reviewBoxIem.reviewSize) {
                    BoxForSeeUsersReview(
                        reviewBoxIem
                    )
                }
            }
        }
    }
}



@Composable
private fun BoxForSeeUsersReview(
    reviewBoxItem: ReviewBoxIem
) {
    Box(
        modifier = Modifier
            .height(156.dp)
            .width(280.dp)
            .clip(RoundedCornerShape(8.dp))
            .background(UIKitTheme.colors.background)
    ) {
        Column(
            modifier = Modifier
                .padding(8.dp)
        ) {
            Text(
                text = reviewBoxItem.review,
                maxLines = 3,
                modifier = Modifier.padding(bottom = 10.dp),
                overflow = TextOverflow.Ellipsis,
                fontSize = 16.sp,
                fontWeight = FontWeight.W400,
                color = OpacityDark80,
                fontFamily = MegoFontFamily
            )
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Оценка:",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.W500,
                    modifier = Modifier.padding(end = 8.dp, bottom = 8.dp),
                    color = OpacityDark80,
                    fontFamily = MegoFontFamily
                )
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Box(
                    modifier = Modifier
                        .size(40.dp)
                        .clip(RoundedCornerShape(6.dp))
                ) {
                    Image(
                        painter = painterResource(reviewBoxItem.image),
                        contentDescription = "",
                        modifier = Modifier.fillMaxSize(),
                        contentScale = ContentScale.Crop
                    )
                }
                Column {
                    Text(
                        text = reviewBoxItem.name,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.W500,
                        fontFamily = MegoFontFamily,
                        color = OpacityDark80
                    )
                    Text(
                        text = reviewBoxItem.location,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.W400,
                        fontFamily = MegoFontFamily,
                        color = OpacityDark80
                    )
                }
            }
        }
    }
}


@Preview
@Composable
private fun ReviewBoxPreview() {
    ReviewBox(
        ReviewBoxIem(
            image = com.example.uikit.R.drawable.ic_placeholder_image_background,// тут user_avatar
            name = "Валерия Бриг",
            location = "Минск, Беларусь",
            rating = 4.3f,
            review = "Текст отзыва туриста об определённом месте или об экскурсии в нескольких строках. Текст отзыва туриста об определённом месте или об экскурсии в нескольких строках. ",
            reviewSize = 4
        )
    )
}


@Composable
fun RowWithTextAndButton(
    title: String,
    onSeeMap: () -> Unit,
    seeMap: String,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = title,
            fontSize = 18.sp,
            fontWeight = FontWeight.W500,
            fontFamily = MegoFontFamily,
            color = OpacityDark80,
        )
        TextButton(
            onClick = onSeeMap
        ) {
            Text(
                text = seeMap,
                color = UIKitTheme.colors.primary,
                fontWeight = FontWeight.W500,
                fontSize = 14.sp,
            )
        }
    }
}