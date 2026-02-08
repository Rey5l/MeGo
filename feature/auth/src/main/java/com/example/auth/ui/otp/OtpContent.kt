package com.example.auth.ui.otp

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
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
import com.example.auth.ui.otp.components.InfoMessageCode
import com.example.auth.ui.otp.components.OtpCodeInput
import com.example.auth.ui.registration.components.AuthTopBar
import com.example.auth.ui.registration.components.LoadingOverlay
import com.example.uikit.component.button.ButtonType
import com.example.uikit.component.button.MeGoButton
import com.example.uikit.icon.MegoIcons
import com.example.uikit.theme.UIKitTheme

@Composable
fun OtpContent(
    state: OtpUiState,
    onCodeChange: (String) -> Unit,
    onResendClick: () -> Unit,
    onEditEmail: () -> Unit,
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
        Box(
            modifier = Modifier.fillMaxSize()
        ) {
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
                Spacer(modifier = Modifier.height(32.dp))
                Image(
                    imageVector = MegoIcons.logo,
                    contentDescription = null,
                )
                Spacer(modifier = Modifier.height(40.dp))
                InfoMessageCode(state.email)
                Spacer(Modifier.height(16.dp))

                OtpCodeInput(
                    code = state.code,
                    onCodeChange = onCodeChange
                )

                Spacer(Modifier.height(90.dp))

                if (state.timer > 0) {
                    MeGoButton(
                        "Отправить код повторно ${state.timer} сек.",
                        ButtonType.Empty,
                        enabled = false,
                        onClick = {})
                } else {
                    MeGoButton(
                        "Отправить код повторно",
                        ButtonType.Empty,
                        onClick = { onResendClick() })
                }

                Spacer(Modifier.height(24.dp))

                MeGoButton(
                    "Указать другую почту/номер",
                    ButtonType.Empty,
                    onClick = { onEditEmail() })
            }
            if (state.isLoading) {
                LoadingOverlay()
            }
        }
    }
}
