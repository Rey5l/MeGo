package com.example.auth.ui.otp


data class OtpUiState(
    val email: String = "",
    val code: String = "",
    val timer: Int = 60,
    val isLoading: Boolean = false,
    val errorText: String? = null
)