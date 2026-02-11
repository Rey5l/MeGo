package com.example.auth.ui.otp


data class OtpUiState(
    val type: OtpType = OtpType.Email,
    val target: String = "",
    val code: String = "",
    val timer: Int = 60,
    val isLoading: Boolean = false,
    val isValid: Boolean = true
)

sealed class OtpType {
    data object Email: OtpType()

    sealed class Phone: OtpType() {
        data object Sms: Phone()
        data object Telegram: Phone()
        data object WhatsApp: Phone()
    }
}