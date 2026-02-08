package com.example.auth.ui.otp


data class OtpUiState(
    val type: OtpType = OtpType.EMAIL,
    val target: String = "",
    val code: String = "",
    val timer: Int = 60,
    val isLoading: Boolean = false,
    val isValid: Boolean = true
)

enum class OtpType {
    EMAIL, PHONE
}