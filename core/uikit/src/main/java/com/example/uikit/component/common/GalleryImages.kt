package com.example.uikit.component.common


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import coil.compose.SubcomposeAsyncImage
import com.example.uikit.icon.MegoIcons
import com.example.uikit.theme.bgPrimary
import com.example.uikit.theme.black
import com.example.uikit.theme.bodyMedium500
import com.example.uikit.theme.medium
import kotlinx.collections.immutable.ImmutableList

@Composable
fun GalleryImages(images: ImmutableList<String>) {
    val pagerState = rememberPagerState(pageCount = { images.size })

    ZoomableContent {
        Box(
            Modifier
                .zIndex(2f)
                .align(Alignment.BottomEnd)
                .padding(8.dp)
                .clip(RoundedCornerShape(16.dp))
                .background(bgPrimary)
                .padding(vertical = 6.dp, horizontal = 16.dp),
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    imageVector = MegoIcons.gallery,
                    contentDescription = null,
                    modifier = Modifier.size(14.dp),
                )
                Spacer(Modifier.width(8.dp))
                Text(
                    text = "${pagerState.currentPage + 1}",
                    color = black,
                    style = bodyMedium500,
                    fontFamily = medium,
                )
                Text(
                    text = "/${images.size}",
                    color = black,
                    style = bodyMedium500,
                    fontFamily = medium,
                )
            }
        }
        HorizontalPager(state = pagerState) { currentPage ->
            val imageModifier = Modifier.size(412.dp, 232.dp)
            SubcomposeAsyncImage(
                model = images[currentPage],
                contentDescription = null,
                error = {
                    Box(
                        modifier = imageModifier,
                        contentAlignment = Alignment.Center,
                    ) {
                        Image(
                            // placeholder
                            painter = painterResource(
                                com.example.uikit.R.drawable.ic_placeholder_image_background,
                            ),
                            contentDescription = null,
                            contentScale = ContentScale.FillBounds,
                            modifier = Modifier.size(412.dp, 300.dp),
                        )
                        Icon(
                            imageVector = ImageVector.vectorResource(com.example.uikit.R.drawable.ic_error),
                            contentDescription = null,
                            modifier = Modifier.size(60.dp),
                        )
                    }
                },
                loading = {
                    Box(
                        modifier = imageModifier,
                        contentAlignment = Alignment.Center,
                    ) {
                        Image(
                            // loading placeholder
                            painter = painterResource(com.example.uikit.R.drawable.ic_placeholder_image_background),
                            contentDescription = null,
                            contentScale = ContentScale.FillBounds,
                            modifier = Modifier.size(412.dp, 300.dp),
                        )
                        ProgressBar(
                            iconSize = 80.dp,
                            modifier = Modifier.zIndex(2f),
                        )
                    }
                },
                contentScale = ContentScale.FillBounds,
                modifier = imageModifier,
            )
        }
    }
}