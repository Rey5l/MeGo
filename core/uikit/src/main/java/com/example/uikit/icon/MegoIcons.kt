package com.example.uikit.icon

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import com.example.uikit.R

@Immutable
object MegoIcons {

    val arrowBack: ImageVector
        @Composable
        get() = ImageVector.vectorResource(R.drawable.arrow_back)

    val search: ImageVector
        @Composable
        get() = ImageVector.vectorResource(R.drawable.ic_search)

    val filter: ImageVector
        @Composable
        get() = ImageVector.vectorResource(R.drawable.ic_filter)

    val notification: ImageVector
        @Composable
        get() = ImageVector.vectorResource(R.drawable.ic_notification)

    val icFavorite: ImageVector
        @Composable
        get() = ImageVector.vectorResource(R.drawable.baseline_favorite_24)
    val icNotFavorite: ImageVector
        @Composable
        get() = ImageVector.vectorResource(R.drawable.outline_favorite_24)
    val icMyLocation: ImageVector
        @Composable
        get() = ImageVector.vectorResource(R.drawable.outline_my_location_24)
    val icClock: ImageVector
        @Composable
        get() = ImageVector.vectorResource(R.drawable.outline_nest_clock_farsight_analog_24)
    val icHome: ImageVector
        @Composable
        get() = ImageVector.vectorResource(R.drawable.home_outline_24)

}