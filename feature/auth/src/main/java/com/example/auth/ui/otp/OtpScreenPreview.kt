package com.example.auth.ui.otp

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview
import com.example.uikit.theme.UIKitTheme

@Preview(showBackground = true)
@Composable
fun OtpScreenPreviewEmail() {
    var code by remember { mutableStateOf("") }
    UIKitTheme {
        OtpContent(
            state = OtpUiState(
                type = OtpType.Email,
                target = "abc@mail.su",
                code = code,
                timer = 59
            ),
            onCodeChange = { code = it},
            onResendClick = {},
            onEditEmail = {},
            onSubmit = {}
        )
    }
}

@Preview(showBackground = true)
@Composable
fun OtpScreenPreviewEmail_Loading() {
    UIKitTheme {
        OtpContent(
            state = OtpUiState(
                type = OtpType.Email,
                target = "abc@mail.su",
                code = "8888",
                timer = 59,
                isLoading = true
            ),
            onCodeChange = {},
            onResendClick = {},
            onEditEmail = {},
            onSubmit = {}
        )
    }
}

@Preview(showBackground = true)
@Composable
fun OtpScreenPreviewEmail_WrongInput() {
    UIKitTheme {
        OtpContent(
            state = OtpUiState(
                type = OtpType.Email,
                target = "abc@mail.su",
                code = "8888",
                timer = 0,
                isValid = false
            ),
            onCodeChange = {},
            onResendClick = {},
            onEditEmail = {},
            onSubmit = {}
        )
    }
}


@Preview(showBackground = true)
@Composable
fun OtpScreenPreviewPhoneTelegram() {
    UIKitTheme {
        OtpContent(
            state = OtpUiState(
                type = OtpType.Phone.Telegram,
                target = "+7 (999) 123-45-67",
                code = "88",
                timer = 59
            ),
            onCodeChange = {},
            onResendClick = {},
            onEditEmail = {},
            onSubmit = {}
        )
    }
}

@Preview(showBackground = true)
@Composable
fun OtpScreenPreviewPhoneWhatsApp() {
    UIKitTheme {
        OtpContent(
            state = OtpUiState(
                type = OtpType.Phone.WhatsApp,
                target = "+7 (999) 123-45-67",
                code = "88",
                timer = 59
            ),
            onCodeChange = {},
            onResendClick = {},
            onEditEmail = {},
            onSubmit = {}
        )
    }
}

@Preview(showBackground = true)
@Composable
fun OtpScreenPreviewPhoneSms() {
    UIKitTheme {
        OtpContent(
            state = OtpUiState(
                type = OtpType.Phone.Sms,
                target = "+7 (999) 123-45-67",
                code = "88",
                timer = 59
            ),
            onCodeChange = {},
            onResendClick = {},
            onEditEmail = {},
            onSubmit = {}
        )
    }
}

@Preview(showBackground = true)
@Composable
fun OtpScreenPreviewPhone_Loading() {
    UIKitTheme {
        OtpContent(
            state = OtpUiState(
                type = OtpType.Phone.Telegram,
                target = "+7 (999) 123-45-67",
                code = "8888",
                timer = 59,
                isLoading = true
            ),
            onCodeChange = {},
            onResendClick = {},
            onEditEmail = {},
            onSubmit = {}
        )
    }
}

@Preview(showBackground = true)
@Composable
fun OtpScreenPreviewPhone_WrongInput() {
    UIKitTheme {
        OtpContent(
            state = OtpUiState(
                type = OtpType.Phone.WhatsApp,
                target = "+7 (999) 123-45-67",
                code = "8888",
                timer = 0,
                isValid = false
            ),
            onCodeChange = {},
            onResendClick = {},
            onEditEmail = {},
            onSubmit = {}
        )
    }
}





