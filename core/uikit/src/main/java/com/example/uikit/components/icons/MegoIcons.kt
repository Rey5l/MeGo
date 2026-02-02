package com.example.uikit.components.icons

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

    // Icon для top bar в feature/auth модуля SignUpScreen экрана
    val close: ImageVector
        @Composable
        get() = ImageVector.vectorResource(R.drawable.ic_close)
}