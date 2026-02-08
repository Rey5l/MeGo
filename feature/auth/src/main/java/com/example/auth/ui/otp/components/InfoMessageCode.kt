package com.example.auth.ui.otp.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.sp
import com.example.uikit.theme.CorporateMeGoPrimary
import com.example.uikit.theme.MegoFontFamily
import com.example.uikit.theme.OpacityDark80

@Composable
fun InfoMessageCode(
    value: String,
) {
    Text(
        text = buildAnnotatedString {
            withStyle(
                style = SpanStyle(
                    fontFamily = MegoFontFamily,
                    fontWeight = FontWeight.Medium,
                    fontSize = 18.sp,
                    color = OpacityDark80
                )
            ) {
                append("На почту ")
            }
            withStyle(
                SpanStyle(
                    fontFamily = MegoFontFamily,
                    fontWeight = FontWeight.Medium,
                    fontSize = 18.sp,
                    color = CorporateMeGoPrimary
                )
            ) {
                append(value)
            }
            withStyle(
                style = SpanStyle(
                    fontFamily = MegoFontFamily,
                    fontWeight = FontWeight.Medium,
                    fontSize = 18.sp,
                    color = OpacityDark80
                )
            ) {
                append(" отправлен 4-значный код")
            }
        },
        textAlign = TextAlign.Center
    )
}