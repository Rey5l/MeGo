package com.example.uikit.components.loader

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.uikit.R
import com.example.uikit.theme.CorporateMeGoPrimary
import com.example.uikit.theme.OpacityDark40
import kotlinx.coroutines.delay

/**
 * Компонент загрузки, с инстантным переключением раз в 600мс.
 *
 * ### Параметры
 *  - "size" - размер компонента загрузки.
 *  - "modifier" - Modifier
 */

@Preview(showBackground = true)
@Composable
fun MeGoLoader(
    size: Dp = 109.dp,
    modifier: Modifier = Modifier
) {

    var rotationAngle by remember { mutableStateOf(0f) }
    LaunchedEffect(Unit) {
        while (true){
            delay(600)
            rotationAngle+= 90f
            if (rotationAngle >= 360f) {
                rotationAngle = 0f
            }

        }
    }
    val finalModifier = modifier.then(Modifier.size(size))


    Box(modifier = finalModifier.size(size),
        contentAlignment = Alignment.Center){
        Canvas(
            modifier = Modifier.fillMaxSize().padding(4.dp),
            contentDescription = "Loader"
        ) {
            val strokeWidth = size.toPx() * 0.05f

            drawArc(
                color = OpacityDark40,
                startAngle = 20f + rotationAngle,  // 20
                sweepAngle = 240f, // 240
                useCenter = false,
                style = Stroke(strokeWidth)
            )

            drawArc(
                color = CorporateMeGoPrimary,
                startAngle = 275f + rotationAngle, //275
                sweepAngle = 90f, // 90
                useCenter = false,
                style = Stroke(strokeWidth, cap = StrokeCap.Round)
            )


        }
        Icon(imageVector = ImageVector.vectorResource(R.drawable.logo_mego), "logo",
            modifier = Modifier.size(width = size*0.413f, height = size*0.11f ),
            tint = CorporateMeGoPrimary
            )
    }
}