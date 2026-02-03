package com.example.auth.ui.registration.components

import androidx.compose.foundation.text.ClickableText
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.sp
import com.example.uikit.theme.CorporateMeGoPrimary
import com.example.uikit.theme.MegoFontFamily

@Composable
fun AgreementText(
    onUserAgreementClick: () -> Unit,
    onPrivacyPolicyClick: () -> Unit,
) {
    val annotatedText = buildAnnotatedString {
        append("Я ознакомился и согласен с ")
        pushStringAnnotation(tag = "userAgreement", annotation = "userAgreement")
        withStyle(style = SpanStyle(color = CorporateMeGoPrimary)) {
            append("Пользовательским соглашением")
        }
        pop()
        append(" и ")
        pushStringAnnotation(tag = "privacy_policy", annotation = "privacy_policy")
        withStyle(style = SpanStyle(color = CorporateMeGoPrimary)) {
            append("Политикой конфиденциальности")
        }
        pop()
    }

    ClickableText(
        text = annotatedText,
        style = TextStyle(
            fontFamily = MegoFontFamily,
            fontSize = 12.sp,
            fontWeight = FontWeight.Medium
        ),
        onClick = { offset ->
            annotatedText.getStringAnnotations(start = offset, end = offset)
                .firstOrNull()?.let { annotation ->
                    when (annotation.tag) {
                        "userAgreement" -> onUserAgreementClick()
                        "privacy_policy" -> onPrivacyPolicyClick()
                    }
                }
        }
    )
}