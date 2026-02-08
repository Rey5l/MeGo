package com.example.auth.ui.registration

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.uikit.theme.UIKitTheme

@Preview(name = "Default")
@Composable
fun SignUpPreview_Default() {
    UIKitTheme {
        SignUpContent(
            state = SignUpUiState(),
            onLoginChange = {},
            onAgreementCheckedChange = {},
            onSubmit = {}
        )
    }
}

@Preview(name = "Error")
@Composable
fun SignUpPreview_Error() {
    UIKitTheme {
        SignUpContent(
            state = SignUpUiState(
                login = "wrong",
                isAgreementChecked = true,
                errorText = "Проверьте правильность введённых данных!"
            ),
            onLoginChange = {},
            onAgreementCheckedChange = {},
            onSubmit = {}
        )
    }
}

@Preview(name = "Ready to submit")
@Composable
fun SignUpPreview_Ready() {
    UIKitTheme {
        SignUpContent(
            state = SignUpUiState(
                login = "test@example.com",
                isAgreementChecked = true,
                errorText = null
            ),
            onLoginChange = {},
            onAgreementCheckedChange = {},
            onSubmit = {}
        )
    }
}

@Preview(name = "SignUp - Loading")
@Composable
fun SignUpPreview_Loading() {
    UIKitTheme {
        SignUpContent(
            state = SignUpUiState(
                login = "test@example.com",
                isAgreementChecked = true,
                isLoading = true,
                errorText = null
            ),
            onLoginChange = {},
            onAgreementCheckedChange = {},
            onSubmit = {}
        )
    }
}
