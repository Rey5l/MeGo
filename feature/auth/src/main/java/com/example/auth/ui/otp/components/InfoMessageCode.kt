package com.example.auth.ui.otp.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.sp
import com.example.auth.ui.otp.OtpType
import com.example.uikit.theme.CorporateMeGoPrimary
import com.example.uikit.theme.MegoFontFamily
import com.example.uikit.theme.OpacityDark80
import com.example.uikit.theme.roseRed

@Composable
fun InfoMessageCode(
    value: String,
    type: OtpType,
    isValid: Boolean = true,
) {
    if (isValid) {
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
                    when (type) {
                        OtpType.Email -> append("На почту ")
                        OtpType.Phone.WhatsApp -> append("На номер ")
                        OtpType.Phone.Telegram -> append("На номер ")
                        OtpType.Phone.Sms -> append("На номер ")
                    }
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
                    when (type) {
                        OtpType.Phone.WhatsApp -> append(" в WhatsApp")
                        OtpType.Phone.Telegram -> append(" в Telegram")
                        OtpType.Phone.Sms -> append(" в SMS")
                        else -> {}
                    }
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
    } else {
        Text(
            text = "Вы ввели неверный код, пожалуйста, запросите новый!",
            fontWeight = FontWeight.Medium,
            fontFamily = MegoFontFamily,
            fontSize = 18.sp,
            color = roseRed,
            textAlign = TextAlign.Center
        )
    }
}