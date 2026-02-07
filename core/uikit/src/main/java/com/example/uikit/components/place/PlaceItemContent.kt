package com.example.uikit.components.place

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.uikit.R
import com.example.uikit.components.buttons.button.ButtonType
import com.example.uikit.components.buttons.button.IconPosition
import com.example.uikit.components.buttons.button.MeGoButton
import com.example.uikit.components.icons.MegoIcons
import com.example.uikit.theme.ColorRed
import com.example.uikit.theme.CorporateMeGoPrimary
import com.example.uikit.theme.MegoFontFamily
import com.example.uikit.theme.OpacityDark40
import com.example.uikit.theme.OpacityDark80
import com.example.uikit.theme.OpacityDark80Lighter
import com.example.uikit.theme.OpacityLight60

/**
 * PlaceItemContent.
 * Через When() реализована варианция карты под каждый вид из фигмы
 */

@Composable
fun PlaceItemContent(
    data: PlaceItemModel,
    variant: PlaceItemVariant,
    onFavoriteClick: () -> Unit,
    onDeleteClick: () -> Unit,
    onActionClick: () -> Unit,
    modifier: Modifier = Modifier
   ) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(4.dp))
            .padding(16.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(OpacityLight60),


            ) {
            //коил для тестов/оставить так. Я хз в каком виде данные с бека приходят
            AsyncImage(
                model = data.image,
                contentDescription = "Фотокарточка пути",
                placeholder = painterResource(R.drawable.logo_mego),
                modifier = Modifier
                    .padding(4.dp)
                    .size(140.dp)
                    .clip(RoundedCornerShape(8.dp))
            )
                when (variant) {
                    is PlaceItemVariant.Default -> {
                        Box(
                            modifier = Modifier
                                .padding(4.dp)
                                .weight(1f)
                                .height(140.dp)
                        ) {
                            Column(
                                modifier = Modifier.fillMaxSize(),
                                verticalArrangement = Arrangement.SpaceBetween
                            ) {
                                TextNameForPlaceItem(data.name, modifier = Modifier.padding(end=40.dp), maxLines = 5)
                                Spacer(Modifier.weight(1f))

                                Row(
                                    modifier = Modifier.padding(bottom = 12.dp),
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Icon(
                                        MegoIcons.star,
                                        contentDescription = null,
                                        tint = CorporateMeGoPrimary,
                                        modifier = Modifier.size(16.dp)
                                    )
                                    Text(
                                        "${data.rating}",
                                        fontFamily = MegoFontFamily,
                                        fontWeight = FontWeight.Medium,
                                        fontSize = 14.sp,
                                        color = OpacityDark80
                                    )
                                }
                            }

                            LikeButton(
                                onFavoriteClick = onFavoriteClick,
                                isFavorite = data.isFavorite,
                                modifier = Modifier
                                    .align(Alignment.TopEnd)
                                    .offset(y = (-6).dp)
                            )
                        }
                    }


                    is PlaceItemVariant.ForPathWithButton -> {
                        Box(
                            modifier = Modifier
                                .padding(4.dp)
                                .weight(1f)
                                .height(140.dp)
                        ) {
                            Column(
                                modifier = Modifier.fillMaxSize()
                            ) {
                                TextNameForPlaceItem(
                                    data.name,
                                    maxLines = 2,
                                    modifier = Modifier.padding(end = 40.dp)
                                )
                                AddressForPlaceItem(
                                    data.address ?: "",
                                    maxLines = 3,
                                    modifier = Modifier.padding(end = 40.dp, top = 2.dp)
                                )
                                Spacer(modifier = Modifier.weight(1f))

                                MeGoButton(
                                    onClick = onActionClick,
                                    iconPosition = IconPosition.End,
                                    style = ButtonType.Fill,
                                    text = "К следующей точке",
                                    modifier = Modifier
                                        .align(Alignment.Start)
                                        .fillMaxWidth()
                                        .padding(bottom = 4.dp)
                                )
                            }

                            LikeButton(
                                onFavoriteClick = onFavoriteClick,
                                isFavorite = data.isFavorite,
                                modifier = Modifier.align(Alignment.TopEnd).padding(bottom = 8.dp).offset(y = (-6).dp)
                            )
                        }
                    }

                    is PlaceItemVariant.ForPathWithExtendedAddress -> {
                        Box(
                            modifier = Modifier
                                .padding(4.dp)
                                .weight(1f)
                                .height(140.dp)
                        ) {
                            Column(modifier = Modifier.fillMaxSize()) {
                                TextNameForPlaceItem(data.name, maxLines = 3, modifier = Modifier.padding(end = 40.dp))
                                AddressForPlaceItem(data.address ?: "", modifier = Modifier.padding(end = 40.dp, top = 2.dp))
                            }

                            LikeButton(
                                onFavoriteClick = onFavoriteClick,
                                isFavorite = data.isFavorite,
                                modifier = Modifier
                                    .align(Alignment.TopEnd)
                                    .offset(y = (-6).dp)
                            )
                        }
                    }


                    is PlaceItemVariant.ForPathWithOnDelete -> {
                        Box(modifier = Modifier
                            .padding(4.dp)
                            .weight(1f)
                            .height(140.dp)) {
                            Column(modifier = Modifier.fillMaxSize()) {
                                TextNameForPlaceItem(data.name, maxLines = 3, modifier = Modifier.padding(end = 40.dp))
                                AddressForPlaceItem(data.address ?: "", maxLines = 3, modifier = Modifier.padding(end = 40.dp, top = 2.dp))
                                Spacer(Modifier.weight(1f))
                                Row(
                                    modifier = Modifier.padding(bottom = 12.dp),
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Icon(
                                        MegoIcons.star,
                                        "star",
                                        tint = CorporateMeGoPrimary,
                                        modifier = Modifier.size(16.dp)
                                    )
                                    Text(
                                        "${data.rating}",
                                        fontFamily = MegoFontFamily,
                                        fontWeight = FontWeight.Medium,
                                        fontSize = 14.sp,
                                        color = OpacityDark80,
                                        lineHeight = 14.sp
                                    )
                                }
                            }
                            LikeButton(
                                onFavoriteClick = onFavoriteClick,
                                isFavorite = data.isFavorite,
                                modifier = Modifier.align(Alignment.TopEnd).padding(bottom = 8.dp).offset(y = (-6).dp)
                            )
                            IconButton(onClick = onDeleteClick, Modifier.align(Alignment.BottomEnd)) {
                                Icon(imageVector = MegoIcons.delete, "помойка", Modifier.size(20.dp))
                            }
                        }
                    }

                    is PlaceItemVariant.WithAddress -> {
                        Box(
                            modifier = Modifier
                                .padding(4.dp)
                                .weight(1f)
                                .height(140.dp)
                        ) {
                            Column(
                                modifier = Modifier.fillMaxSize(),
                                verticalArrangement = Arrangement.SpaceBetween
                            ) {
                                Column {
                                    TextNameForPlaceItem(data.name, modifier = Modifier.padding(end = 40.dp), maxLines = 3)
                                    AddressForPlaceItem(data.address ?: "", maxLines = 2, modifier = Modifier.padding(end = 40.dp, top = 2.dp))
                                }

                                Row(
                                    modifier = Modifier.padding(bottom = 12.dp),
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Icon(
                                        MegoIcons.star,
                                        contentDescription = null,
                                        tint = CorporateMeGoPrimary,
                                        modifier = Modifier.size(16.dp)
                                    )
                                    Text(
                                        "${data.rating}",
                                        fontFamily = MegoFontFamily,
                                        fontWeight = FontWeight.Medium,
                                        fontSize = 14.sp,
                                        color = OpacityDark80
                                    )
                                }
                            }

                            LikeButton(
                                onFavoriteClick = onFavoriteClick,
                                isFavorite = data.isFavorite,
                                modifier = Modifier
                                    .align(Alignment.TopEnd)
                                    .offset(y = (-6).dp)
                            )
                        }
                    }


            }
        }
    }
}


@Composable
fun TextNameForPlaceItem(name: String,
                         fontFamily: FontFamily = MegoFontFamily,
                         fontWeight : FontWeight = FontWeight.Medium,
                         color : Color = OpacityDark80,
                         lineHeight : TextUnit = 18.sp,
                         fontSize : TextUnit = 16.sp,
                         maxLines : Int = 5,
                         modifier: Modifier = Modifier,
                         ) {
    Text(name,
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
fun AddressForPlaceItem(address : String,
                        fontFamily: FontFamily = MegoFontFamily,
                        fontWeight : FontWeight = FontWeight.Medium,
                        color : Color = OpacityDark80Lighter,
                        lineHeight : TextUnit = 16.sp,
                        fontSize : TextUnit = 12.sp,
                        maxLines : Int = 5,
                        modifier: Modifier = Modifier,
) {
    Text(address,
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
fun LikeButton(onFavoriteClick: () -> Unit, isFavorite : Boolean, modifier: Modifier = Modifier){
    IconButton(
        onClick = onFavoriteClick,
        modifier = modifier
    ) {
        Icon(
            imageVector = if (isFavorite) MegoIcons.favorite else MegoIcons.notFavorite,
            contentDescription = null,
            tint = if (isFavorite) ColorRed else OpacityDark40
        )
    }
}
