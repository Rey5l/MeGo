package com.example.catalog.landmark.composables

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.WindowInsetsSides
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.only
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.uikit.component.button.LikeButton
import com.example.uikit.component.topbar.TopBarButton
import com.example.uikit.icon.MegoIcons
import com.example.uikit.theme.MegoFontFamily
import com.example.uikit.theme.OpacityDark80
import com.example.uikit.theme.bgPrimary
import com.example.uikit.theme.bgSecondary
import com.example.uikit.theme.opacityDark20
import com.example.uikit.theme.titleLarge500

@Composable
fun LandmarkTopBar(
    onBackClick: () -> Unit,
    onNotificationClick: () -> Unit,
    onLikeClick: () -> Unit,
    liked: Boolean,
    scrollState: ScrollState,
) {
    val upColor by remember {
        derivedStateOf {
            when (scrollState.value) {
                in 0..813 -> bgPrimary
                else -> bgSecondary
            }
        }
    }
    val showLikeButton by remember {
        derivedStateOf {
            scrollState.value > 980
        }
    }
    Column {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(upColor)
                .windowInsetsPadding(WindowInsets.safeDrawing.only(WindowInsetsSides.Top))
                .padding(horizontal = 16.dp, vertical = 5.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            TopBarButton(
                image = MegoIcons.arrowBack,
                onClick = onBackClick,
                iconSize = 20.dp,
            )
            Text(
                text = " ",
                color = OpacityDark80,
                style = titleLarge500,
                fontFamily = MegoFontFamily,
                fontWeight = FontWeight.Medium
            )
            if (showLikeButton) {
                LikeButton(
                    isLiked = liked,
                    onClick = { _ -> onLikeClick() },
                    modifier = Modifier.size(24.dp),
                )
            } else {
                TopBarButton(
                    image = MegoIcons.notification,
                    onClick = onNotificationClick,
                    iconSize = 24.dp,
                )
            }
        }
        HorizontalDivider(color = opacityDark20)
    }
}

@Preview(showBackground = true)
@Composable
fun LandmarkTopBarPreview() {
    LandmarkTopBar(
        onBackClick = {},
        onNotificationClick = {},
        onLikeClick = {},
        liked = false,
        scrollState = ScrollState(0),
    )
}
