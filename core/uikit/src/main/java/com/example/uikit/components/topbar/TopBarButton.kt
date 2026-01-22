package com.example.uikit.components.topbar

import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.uikit.theme.CorporateMeGoPrimary

@Composable
fun TopBarButton(
    image: ImageVector,
    onClick: () -> Unit = {},
    imageTint: Color = CorporateMeGoPrimary,
    iconSize: Dp = 24.dp,
    modifier: Modifier = Modifier,
) {
    IconButton(
        onClick = onClick,
        modifier = modifier,
    ) {
        Icon(
            imageVector = image,
            contentDescription = null,
            tint = imageTint,
            modifier = Modifier.size(iconSize),
        )
    }
}
