package com.example.uikit.components.topbar

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.uikit.components.icons.MegoIcons

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(
    title: String,
    onBackClick: () -> Unit,
    onSearchClick: () -> Unit,
    onFilterClick: () -> Unit,
    onNotificationClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    TopAppBar(
        title = {
            Text(
                text = title,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                style = MaterialTheme.typography.titleLarge,
            )
        },
        navigationIcon = {
            TopBarButton(
                image = MegoIcons.arrowBack,
                onClick = onBackClick,
                iconSize = 24.dp,
                modifier = Modifier
            )
        },
        actions = {
            TopBarButton(
                image = MegoIcons.search,
                onClick = onSearchClick,
                iconSize = 24.dp,
                modifier = Modifier
            )
            TopBarButton(
                image = MegoIcons.filter,
                onClick = onFilterClick,
                iconSize = 24.dp,
                modifier = Modifier
            )
            TopBarButton(
                image = MegoIcons.notification,
                onClick = onNotificationClick,
                iconSize = 24.dp,
                modifier = Modifier
            )

        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color.White
        ),
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun MainTopAppBarPreview() {
    TopBar(
        title = "Routes",
        onBackClick = {},
        onSearchClick = {},
        onFilterClick = {},
        onNotificationClick = {}
    )
}

