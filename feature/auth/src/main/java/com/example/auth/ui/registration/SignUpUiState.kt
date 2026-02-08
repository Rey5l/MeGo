package com.example.auth.ui.registration

// State машина для Preview
data class SignUpUiState(
    val login: String = "",
    val isAgreementChecked: Boolean = false,
    val isLoading: Boolean = false,
    val errorText: String? = null
) {
    val canSubmit: Boolean
        get() = login.isNotBlank() && isAgreementChecked && !isLoading && errorText == null
}