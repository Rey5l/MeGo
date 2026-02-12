package com.mego.objectreview

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.uikit.R
import com.example.uikit.theme.CorporateMeGoPrimary

@Composable
fun StarRating(
    modifier: Modifier = Modifier,
    initialRating: Int = 0,
    onRatingChanged: (Int) -> Unit = {},
    enabled: Boolean = true
) {
    var rating by remember { mutableIntStateOf(initialRating) }
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        repeat(5) { index ->
            Box(modifier = Modifier.size(24.dp)) {
                Icon(
                    painter = if (index < rating) painterResource(R.drawable.star_fill_24) else painterResource(
                        R.drawable.star_24
                    ),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxSize()
                        .clickable(
                            enabled = enabled
                        ) {
                            rating = index + 1
                            onRatingChanged(rating)

                        },
                    tint = CorporateMeGoPrimary
                )
            }
        }
    }
}

@Preview
@Composable
private fun StarPreview() {
    StarRating(
        initialRating = 0,
        onRatingChanged = {}
    )
}
