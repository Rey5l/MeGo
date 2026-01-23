package com.example.uikit.components.route


import androidx.compose.foundation.background
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.uikit.R
import com.example.uikit.Icon.MegaIcons
import com.example.uikit.theme.ColorPurpure
import com.example.uikit.theme.ColorRed
import com.example.uikit.theme.CorporateMeGoPrimary
import com.example.uikit.theme.MegoFontFamily
import com.example.uikit.theme.OpacityDark40
import com.example.uikit.theme.OpacityDark80
import com.example.uikit.theme.OpacityLight60


@Composable
fun PathItem(
    path: PathItemModel,
    onLikeClick: () -> Unit,
    onLongClick: () -> Unit,
    onClick: () -> Unit,
) {


    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(4.dp))
            .padding(16.dp)
            .combinedClickable(onClick = {onClick()}, onLongClick = {onLongClick()}),
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(OpacityLight60),


            ) {
            //коил для тестов/оставить так. Я хз в каком виде данные с бека приходят
            AsyncImage(
                model = path.image,
                contentDescription = "Фотокарточка пути",
                placeholder = painterResource(R.drawable.ic_placeholder_image_background), // заменить заглушку на лого из фигмы
                modifier = Modifier
                    .padding(4.dp)
                    .size(140.dp)
                    .clip(RoundedCornerShape(8.dp))
            )
            Column(
                modifier = Modifier
                    .padding(4.dp)
                    .weight(1f)
                    .height(140.dp),

                ) {
                Column(Modifier.padding(top = 4.dp), verticalArrangement = Arrangement.spacedBy(4.dp)) {
                    Text(
                        text = path.title,
                        fontFamily = MegoFontFamily,
                        fontWeight = FontWeight.Medium,
                        fontSize = 16.sp,
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis,
                        color = OpacityDark80,
                        lineHeight = 18.sp
                    )
                    Text(
                        text = "Создан ${path.createdAt}",
                        fontFamily = MegoFontFamily,
                        fontWeight = FontWeight.Normal,
                        fontSize = 12.sp,
                        color = OpacityDark40,
                        lineHeight = 14.sp
                    )
                    if (path.stage) {
                        Text(
                            text = "Пройден",
                            fontFamily = MegoFontFamily,
                            fontWeight = FontWeight.Normal,
                            fontSize = 12.sp,
                            color = ColorPurpure,
                            lineHeight = 14.sp
                        )
                    }
                }

                Spacer(modifier = Modifier.weight(1f))

                Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            imageVector = MegaIcons.icMyLocation(),
                            contentDescription = "my_location",
                            Modifier.size(16.dp),
                            tint = OpacityDark40
                        )
                        Spacer(Modifier.width(4.dp))
                        Text(
                            text = formatDotsText(path.markCount),
                            fontFamily = MegoFontFamily,
                            fontWeight = FontWeight.Normal,
                            fontSize = 12.sp,
                            color = OpacityDark80,
                            lineHeight = 14.sp
                        )
                    }
                    Row(modifier = Modifier.padding(bottom = 4.dp),verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            imageVector = MegaIcons.icClock(),
                            contentDescription = "clock",
                            Modifier.size(16.dp),
                            tint = OpacityDark40

                        )
                        Spacer(Modifier.width(4.dp))
                        Text(
                            text = formatDays(path.duration),
                            fontFamily = MegoFontFamily,
                            fontWeight = FontWeight.Normal,
                            fontSize = 12.sp,
                            color = OpacityDark80,
                            lineHeight = 14.sp
                        )
                    }
                }
            }
            IconButton(
                onClick = onLikeClick,
                modifier = Modifier
                    .align(Alignment.Top)
                    .padding(bottom = 2.dp),
            )
            {
                Icon(
                    imageVector = if (path.isFavorite) MegaIcons.icFavorite() else MegaIcons.icNotFavorite(),
                    contentDescription = null,
                    tint = if (path.isFavorite) ColorRed else OpacityDark40
                )
            }
        }
    }
}

//Функции для склонений. Когда локализацию будем добавлять - вырезать.
private fun formatDays(days: Int): String {
    val lastTwoDigits = days % 100
    val lastDigit = days % 10

    return when {
        lastTwoDigits in 11..14 -> "$days дней"
        lastDigit == 1 -> "$days день"
        lastDigit in 2..4 -> "$days дня"
        else -> "$days дней"
    }
}

private fun formatDotsText(count: Int): String {
    val lastTwoDigits = count % 100
    val lastDigit = count % 10

    val word = when {
        lastTwoDigits in 11..14 -> "точек"
        lastDigit == 1 -> "точка"
        lastDigit in 2..4 -> "точки"
        else -> "точек"
    }

    return "$count $word"
}
//для тестов
@Preview(showBackground = true)
@Composable
fun TestPathItem(){
    val item = PathItemModel(
        id = 1,
        title = "Первое путешествие",
        createdAt = "05.01.2047",
        description = "TODO()",
        image = "https://www.meme-arsenal.com/memes/d9156ddbe0074b2ac2e45d39e337d6b6.jpg",
        stage = true,
        isFavorite = true,
        duration = 15,
        markCount = 25,
    )

    Column(Modifier.background(CorporateMeGoPrimary)) {
        PathItem(
            path = item,
            onLikeClick = {},
            onLongClick = {},
            onClick = {}
        )
        PathItem(
            path = item,
            onLikeClick = {},
            onLongClick = {},
            onClick = {}
        )
        PathItem(
            path = item,
            onLikeClick = {},
            onLongClick = {},
            onClick = {}
        )
        PathItem(
            path = item,
            onLikeClick = {},
            onLongClick = {},
            onClick = {}
        )
    }

}