package com.example.auth.ui.otp

import android.R.attr.fontFamily
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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.auth.ui.otp.components.DeliveryTypeRow
import com.example.auth.ui.otp.components.InfoMessageCode
import com.example.auth.ui.registration.components.AuthTopBar
import com.example.uikit.icon.MegoIcons
import com.example.uikit.theme.MegoFontFamily
import com.example.uikit.theme.OpacityDark80
import com.example.uikit.theme.UIKitTheme

@Preview
@Composable
fun DeliveryMethodScreen(

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
                Spacer(modifier = Modifier.height(140.5.dp))
                Image(
                    imageVector = MegoIcons.logo,
                    contentDescription = null,
                )
                Spacer(modifier = Modifier.height(40.dp))
                Text(
                    text = "Куда выслать код?",
                    fontFamily = MegoFontFamily,
                    fontWeight = FontWeight.Medium,
                    fontSize = 18.sp,
                    color = OpacityDark80
                )
                Spacer(modifier = Modifier.height(16.dp))
                DeliveryTypeRow()
            }
        }
    }
}