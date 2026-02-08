package com.example.auth.ui.registration


import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview


@Preview
@Composable
fun SignUpScreen(

) {
    var state by remember { mutableStateOf(SignUpUiState()) }

    SignUpContent(
        state = state,
        onLoginChange = { },
        onAgreementCheckedChange = {
        },
        onSubmit = {

        }
    )
}
