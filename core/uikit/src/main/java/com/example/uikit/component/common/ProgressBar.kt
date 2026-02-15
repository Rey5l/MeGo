package com.example.uikit.component.common

import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.Dp
import com.example.uikit.R
import kotlinx.collections.immutable.persistentListOf
import kotlinx.coroutines.delay
@Composable
fun ProgressBar(
    iconSize: Dp,
    modifier: Modifier = Modifier,
) {
    val shapes =
        remember {
            persistentListOf(
                R.drawable.loader_shape1,
                R.drawable.loader_shape2,
                R.drawable.loader_shape3,
                R.drawable.loader_shape4,
            )
        }
    val currentIndex = remember { mutableIntStateOf(0) }

    LaunchedEffect(Unit) {
        while (true) {
            delay(400)
            currentIndex.intValue = (currentIndex.intValue + 1) % shapes.size
        }
    }

    Icon(
        imageVector = ImageVector.vectorResource(shapes[currentIndex.intValue]),
        contentDescription = null,
        tint = Color.Unspecified,
        modifier = modifier.size(iconSize),
    )
}