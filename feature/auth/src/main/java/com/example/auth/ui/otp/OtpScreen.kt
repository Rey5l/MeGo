package com.example.auth.ui.otp

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

@Composable
fun OtpScreen(

) {
    var state by remember { mutableStateOf(OtpUiState())}
    OtpContent(
        state = state,
        onCodeChange = {
        },
        onResendClick = {

        },
        onEditEmail = {

        },
        onSubmit = {

        }
    )

}