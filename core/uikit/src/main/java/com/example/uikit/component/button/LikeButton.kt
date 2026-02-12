package com.example.uikit.component.button

import androidx.compose.animation.core.FastOutLinearInEasing
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.foundation.gestures.awaitEachGesture
import androidx.compose.foundation.gestures.awaitFirstDown
import androidx.compose.foundation.indication
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.uikit.icon.MegoIcons
import com.example.uikit.theme.opacityDark60
import com.example.uikit.theme.roseRed
import kotlinx.coroutines.delay
import kotlin.random.Random


@Composable
fun LikeButton(
    isLiked: Boolean,
    onClick: ((modifier: Modifier) -> Unit)?,
    modifier: Modifier = Modifier,
) {
    val (icon, color) = if (isLiked) {
        MegoIcons.favorite to roseRed
    } else {
        MegoIcons.notFavorite to opacityDark60
    }
    var isPressed by remember { mutableStateOf(false) }

    val innerScale by animateDpAsState(
        targetValue = if (isPressed) 24.dp else 34.dp,
        animationSpec = spring(
            dampingRatio = 0.3f,
            stiffness = 100f,
        ),
        label = "scale",
    )
    val outerScale by animateFloatAsState(
        targetValue = if (isPressed) 0.9f else 1f,
        label = "scale",
    )
    val likeEffectModifier = Modifier.graphicsLayer {
        scaleX = outerScale
        scaleY = outerScale
    }
    val interactionSource = remember { MutableInteractionSource() }
    Icon(
        imageVector = icon,
        contentDescription = null,
        tint = color,
        modifier = modifier
            .size(innerScale)
            .indication(interactionSource, null)
            .pointerInput(Unit) {
                awaitEachGesture {
                    awaitFirstDown()
                    isPressed = true

                    var released: Boolean
                    do {
                        val event = awaitPointerEvent()
                        released = event.changes.all { !it.pressed }
                    } while (!released)
                    onClick?.invoke(likeEffectModifier)
                    isPressed = false
                }
            },
    )
}

@Composable
fun LikedEffect(modifier: Modifier = Modifier, color: Color) {
    var animateOut by remember { mutableStateOf(true) }

    val offset by animateDpAsState(
        targetValue = if (animateOut) (-Random.nextDouble(35.0, 70.0)).dp else 0.dp,
        animationSpec = tween(
            durationMillis = 300,
            delayMillis = 0,
            easing = FastOutLinearInEasing,
        ),
        label = "LikeOffsetY",
    )
    val alpha by animateFloatAsState(
        targetValue = if (animateOut) 0f else 1f,
        animationSpec = tween(
            durationMillis = 300,
            delayMillis = 0,
            easing = FastOutLinearInEasing,
        ),
        label = "LikeAlpha",
    )

    if (alpha > 0f) {
        Icon(
            imageVector = MegoIcons.favorite,
            contentDescription = null,
            tint =
                color,
            modifier = modifier
                .offset(offset)
                .alpha(alpha)
                .size(24.dp),
        )
    }

    if (animateOut && alpha == 0f) {
        LaunchedEffect(Unit) {
            delay(100)
            animateOut = true
            delay(300)
            animateOut = false
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LikeButtonPreview() {
    LikeButton(
        isLiked = false,
        onClick = {},
    )
}
