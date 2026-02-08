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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.auth.ui.registration.components.AgreementRow
import com.example.auth.ui.registration.components.AuthTopBar
import com.example.uikit.component.button.ButtonSize
import com.example.uikit.component.button.ButtonType
import com.example.uikit.component.button.MeGoButton
import com.example.uikit.component.text_input.TextInput
import com.example.uikit.component.text_input.TextInputState
import com.example.uikit.icon.MegoIcons
import com.example.uikit.theme.UIKitTheme

@Composable
fun SignUpContent(
    state: SignUpUiState,
    onLoginChange: (String) -> Unit,
    onAgreementCheckedChange: (Boolean) -> Unit,
    onSubmit: () -> Unit,
) {
    Scaffold(
        topBar = {
            Column {
                AuthTopBar(
                    title = "Регистрация",
                    onClose = {}
                )
                HorizontalDivider(
                    modifier = Modifier.fillMaxWidth(),
                    thickness = 1.dp
                )
            }
        },
        containerColor = UIKitTheme.colors.background,
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
                .imePadding() // для клавиатуры
                .navigationBarsPadding() // для системных кнопок Android
                .padding(horizontal = 16.dp)
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(56.dp))
            Image(
                imageVector = MegoIcons.logo,
                contentDescription = null,
            )
            Spacer(modifier = Modifier.height(40.dp))
            TextInput(
                value = state.login,
                onValueChange = onLoginChange,
                label = "Ваш email или номер телефона",
                state = if (state.errorText != null) TextInputState.Error else TextInputState.Default,
                supportingText = state.errorText,
                modifier = Modifier
            )
            Spacer(Modifier.height(16.dp))
            AgreementRow(
                checked = state.isAgreementChecked,
                onCheckedChange = onAgreementCheckedChange,
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(Modifier.height(18.dp))
            MeGoButton(
                "Отправить код",
                style = if (state.canSubmit) ButtonType.Fill else ButtonType.Empty,
                onClick = onSubmit,
                size = ButtonSize.Large,
                enabled = state.canSubmit,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}