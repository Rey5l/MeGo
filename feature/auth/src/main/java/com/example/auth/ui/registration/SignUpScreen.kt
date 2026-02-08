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
    var state by remember {mutableStateOf(SignUpUiState())}

    SignUpContent(
        state = state,
        onLoginChange = { newValue ->
            state = state.copy(login = newValue, errorText = null)
                        },
        onAgreementCheckedChange = { newValue ->
            state = state.copy(isAgreementChecked = newValue)
        },
        onSubmit = {
            // Заглушка проверки (пока нет бэка)
            val isValid = looksLikeEmailOrPhone(state.login)
            state = if (!isValid) {
                state.copy(errorText = "Проверьте правильность введённых данных!")
            } else {
                state.copy(errorText = null)
            }
        }
    )
}

// Заглушка для валидации
private fun looksLikeEmailOrPhone(value: String): Boolean {
    val v = value.trim()
    val isEmail = android.util.Patterns.EMAIL_ADDRESS.matcher(v).matches()
    val digits = v.count { it.isDigit() }
    val isPhone = digits >= 10
    return isEmail || isPhone
}
