package com.example.catalog.landmark.components

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
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import dev.mego.core.domain.localization.MegoStrings
import dev.mego.core.domain.localization.stringRes
import dev.mego.core.uikit.R
import dev.mego.core.uikit.component.button.LikeButton
import dev.mego.core.uikit.component.topbar.TopBarButton
import dev.mego.core.uikit.theme.MegoTheme

@Composable
fun LandmarkTopBar(
    onBackClick: () -> Unit,
    onNotificationClick: () -> Unit,
    onLikeClick: () -> Unit,
    liked: Boolean,
    scrollState: ScrollState,
) {
    val bgPrimary = MegoTheme.colors.bgPrimary
    val bgSecondary = MegoTheme.colors.bgSecondary

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
            modifier =
                Modifier
                    .fillMaxWidth()
                    .background(upColor)
                    .windowInsetsPadding(WindowInsets.safeDrawing.only(WindowInsetsSides.Top))
                    .padding(horizontal = 16.dp).padding(vertical = 5.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            TopBarButton(
                imageId = R.drawable.arrow_back,
                onClick = { onBackClick.invoke() },
                iconSize = 20.dp,
            )
            Text(
                text = stringRes(MegoStrings.Any),
                color = MegoTheme.colors.opacityDark80,
                style = MegoTheme.typography.titleLarge500,
                fontFamily = MegoTheme.fonts.medium,
            )
            if (showLikeButton) {
                IconButton(onClick = { onLikeClick.invoke() }) {
                    LikeButton(
                        isLiked = liked,
                        onClick = null,
                        modifier = Modifier.size(24.dp),
                    )
                }
            } else {
                TopBarButton(
                    imageId = R.drawable.ic_notification,
                    onClick = { onNotificationClick.invoke() },
                    iconSize = 24.dp,
                )
            }
        }
        HorizontalDivider(color = MegoTheme.colors.opacityDark20)
    }
}
