package com.example.uikit.Icon

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import com.example.uikit.R

object MegaIcons {
    @Composable fun icFavorite() = ImageVector.vectorResource(R.drawable.baseline_favorite_24)
    @Composable fun icNotFavorite() = ImageVector.vectorResource(R.drawable.outline_favorite_24)
    @Composable fun icMyLocation() = ImageVector.vectorResource(R.drawable.outline_my_location_24)
    @Composable fun icClock() = ImageVector.vectorResource(R.drawable.outline_nest_clock_farsight_analog_24)

}