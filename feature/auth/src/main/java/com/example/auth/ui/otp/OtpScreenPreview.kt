package com.example.auth.ui.otp

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.uikit.theme.UIKitTheme

@Preview(showBackground = true)
@Composable
fun OtpScreenPreview() {
    UIKitTheme {
        OtpContent(
            state = OtpUiState(
                email = "abc@mail.su",
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
fun OtpScreenPreview_Loading() {
    UIKitTheme {
        OtpContent(
            state = OtpUiState(
                email = "abc@mail.su",
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

