package com.example.auth.ui.registration.components

import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.uikit.components.icons.MegoIcons
import com.example.uikit.theme.CorporateMeGoPrimary
import com.example.uikit.theme.MegoFontFamily

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AuthTopBar(
    title: String,
    onClose: () -> Unit,
) {
    TopAppBar(
        title = {
            Text(
                title,
                fontFamily = MegoFontFamily,
                fontWeight = FontWeight.Medium,
                fontSize = 20.sp,
            )
        },
        navigationIcon = {
            TopBarCloseButton(
                onClick = onClose,
                modifier = Modifier
            )
        },
    )
}

@Composable
fun TopBarCloseButton(
    onClick: () -> Unit = {},
    modifier: Modifier = Modifier,
) {
    IconButton(
        onClick = onClick,
        modifier = modifier,
    ) {
        Icon(
            imageVector = MegoIcons.close,
            contentDescription = null,
            tint = CorporateMeGoPrimary,
            modifier = modifier.size(24.dp),
        )
    }
}

@Preview
@Composable
fun AuthTopBarPreview() {
    AuthTopBar(
        title = "Регистрация",
        onClose = {}
    )
}

