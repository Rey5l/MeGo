package com.example.auth.ui.registration

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Divider
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
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
import com.example.uikit.components.buttons.button.ButtonSize
import com.example.uikit.components.buttons.button.ButtonType
import com.example.uikit.components.buttons.button.MeGoButton
import com.example.uikit.components.icons.MegoIcons
import com.example.uikit.components.text_input.TextInput
import com.example.uikit.theme.CorporateMeGoPrimary
import com.example.uikit.theme.UIKitTheme

@Preview
@Composable
fun SignUpScreen(

) {
    var isAgreementChecked by remember { mutableStateOf(false) }
    var login by remember { mutableStateOf("") }
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
        }
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
            Icon(
                imageVector = MegoIcons.close,
                contentDescription = null,
                tint = CorporateMeGoPrimary,
                modifier = Modifier.size(24.dp),
            )
            Spacer(modifier = Modifier.height(40.dp))
            TextInput(
                value = login,
                onValueChange = {},
                label = "Label",
                modifier = Modifier,
                placeholder = "Ваш email или номер телефона"
            )
            Spacer(Modifier.height(16.dp))
            AgreementRow(
                checked = isAgreementChecked,
                onCheckedChange = { isAgreementChecked = it }
            )
            Spacer(Modifier.height(18.dp))
            MeGoButton(
                "Отправить код",
                ButtonType.Empty,
                onClick = {},
                size = ButtonSize.Large,
                enabled = false
            )
        }
    }
}