package com.mego.objectreview

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.uikit.R
import com.example.uikit.components.text_input.TextInput
import com.example.uikit.components.text_input.TextInputState
import com.example.uikit.theme.BGSecondary
import com.example.uikit.theme.CorporateMeGoPrimary
import com.example.uikit.theme.MegoFontFamily
import com.example.uikit.theme.OpacityDark40
import com.example.uikit.theme.OpacityDark80
import kotlinx.coroutines.DelicateCoroutinesApi

@OptIn(DelicateCoroutinesApi::class)
@Composable
fun MyReview(
    myReviewItem: MyReviewItem,
    onSave: (String, Int) -> Unit = { _, _ -> },
    onEdit: () -> Unit = {},
) {
    var mode by remember {
        mutableStateOf(
            if (myReviewItem.isSave) ReviewMode.VIEW else ReviewMode.EDIT
        )
    }
    var currentRating by remember { mutableIntStateOf(myReviewItem.rating) }
    var reviewText by remember { mutableStateOf(myReviewItem.value) }
    var isExpanded by remember { mutableStateOf(false) }
    val canSave = currentRating > 0 || reviewText.isNotEmpty()

    Box(
        modifier = Modifier
            .background(BGSecondary)
            .padding(horizontal = 16.dp)
    ) {
        Column(
            modifier = Modifier.padding(bottom = 14.dp, top = 14.dp)
        ) {
            Text(
                text = "Мой отзыв",
                color = OpacityDark80,
                fontFamily = MegoFontFamily,
                fontWeight = FontWeight.W500,
                fontSize = 18.sp,
            )
            when (mode) {
                ReviewMode.EDIT -> {
                    TextInput(
                        value = reviewText,
                        onValueChange = {
                            reviewText = it
                        },
                        placeholder = "Ваш отзыв",
                        label = "Ваш отзыв",
                        state = if (myReviewItem.isError) {
                            TextInputState.Error
                        } else {
                            TextInputState.Default
                        }
                    )
                }

                ReviewMode.VIEW -> {
                    Column {
                        Text(
                            text = reviewText,
                            color = OpacityDark80,
                            fontFamily = MegoFontFamily,
                            fontWeight = FontWeight.W400,
                            fontSize = 16.sp,
                            maxLines = 5,
                            overflow = if (isExpanded) TextOverflow.Visible else TextOverflow.Ellipsis,
                            modifier = Modifier.padding(top = 8.dp)
                        )
                        if (reviewText.length > 100) {
                            Spacer(Modifier.height(4.dp))
                            Text(
                                text = if (isExpanded) "Свернуть отзыв" else "Развернуть отзыв",
                                fontSize = 14.sp,
                                fontWeight = FontWeight.W400,
                                fontFamily = MegoFontFamily,
                                color = CorporateMeGoPrimary,
                                modifier = Modifier.clickable {
                                    isExpanded = !isExpanded
                                }
                            )
                        }
                    }
                }
            }
            Spacer(Modifier.height(6.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Text(
                    text = "Оценка:",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.W500,
                    modifier = Modifier,
                    color = OpacityDark80,
                    fontFamily = MegoFontFamily
                )
                StarRating(
                    initialRating = currentRating,
                    onRatingChanged = { newRating ->
                        currentRating = newRating
                    },
                    enabled = mode == ReviewMode.EDIT,
                )
            }
            Spacer(Modifier.height(16.dp))
            when (mode) {
                ReviewMode.EDIT -> {
                    SaveOrEditReviewButton(
                        text = "Сохранить отзыв",
                        image = R.drawable.save_20,
                        onEdit = {
                            if (canSave) {
                                myReviewItem.value = reviewText
                                myReviewItem.rating = currentRating
                                myReviewItem.isSave = true
                                mode = ReviewMode.VIEW
                                onSave(reviewText, currentRating)
                            }
                        },
                        canSave = canSave,
                        color = if (canSave) CorporateMeGoPrimary else OpacityDark40
                    )
                }

                ReviewMode.VIEW -> {
                    SaveOrEditReviewButton(
                        text = "Редактировать отзыв",
                        image = R.drawable.edit_20,
                        onEdit = {
                            mode = ReviewMode.EDIT
                            onEdit()
                        },
                        canSave = canSave,
                        color = CorporateMeGoPrimary
                    )
                }
            }
        }
    }
}


@Preview
@Composable
private fun MyReviewPreview() {
    MyReview(
        myReviewItem = MyReviewItem(
            value = "",
            onValueChange = {},
        )
    )
}

@Composable
fun SaveOrEditReviewButton(
    text: String,
    image: Int,
    onEdit: () -> Unit,
    canSave: Boolean,
    color: androidx.compose.ui.graphics.Color
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(
                enabled = canSave
            ) {
                onEdit()
            },
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Icon(
            painter = painterResource(image),
            contentDescription = "Редактировать",
            tint = color
        )
        Text(
            text = text,
            fontSize = 14.sp,
            fontWeight = FontWeight.W400,
            fontFamily = MegoFontFamily,
            color = color,
        )
    }
}