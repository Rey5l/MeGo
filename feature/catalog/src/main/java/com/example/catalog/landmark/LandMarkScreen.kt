package com.example.catalog.landmark

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.catalog.landmark.composables.LandmarkTopBar
import com.example.uikit.component.common.GalleryImages
import com.example.uikit.theme.bgSecondary
import kotlinx.collections.immutable.toImmutableList


@Composable
fun LandMarkScreen(landmarkId: Int) {


}

@Composable
fun LandMarkDetailsScreenContent(
    viewState: LandMarkViewState,
    uiEvent: (LandMarkUiEvent) -> Unit,
) {
    val scrollState = rememberScrollState()

    Box {
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            containerColor = bgSecondary,
            topBar = {
                LandmarkTopBar(
                    onBackClick = { uiEvent(LandMarkUiEvent.BackClick) },
                    onNotificationClick = { uiEvent(LandMarkUiEvent.NotificationClick) },
                    onLikeClick = {

                    },
                    liked = viewState.landMark.isFavorite,
                    scrollState = scrollState,
                )
            },
        ) { innerPadding ->
            Column(
                modifier =
                    Modifier
                        .verticalScroll(scrollState)
                        .padding(innerPadding),
            ) {
                GalleryImages(images = viewState.landMark.images.toImmutableList())

            }
        }

    }

}


