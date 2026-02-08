package com.example.auth.ui.registration

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.auth.ui.registration.components.AgreementRow
import com.example.auth.ui.registration.components.AuthTopBar
import com.example.uikit.component.button.ButtonSize
import com.example.uikit.component.button.ButtonType
import com.example.uikit.component.button.MeGoButton
import com.example.uikit.component.text_input.TextInput
import com.example.uikit.icon.MegoIcons
import com.example.uikit.theme.UIKitTheme

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
