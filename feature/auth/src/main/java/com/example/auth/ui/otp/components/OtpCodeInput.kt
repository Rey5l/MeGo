package com.example.auth.ui.otp.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.uikit.icon.MegoIcons
import com.example.uikit.theme.MegoFontFamily
import com.example.uikit.theme.OpacityDark80

@Composable
fun OtpCodeInput(
    code: String,
    onCodeChange: (String) -> Unit,
) {
    Box {
        BasicTextField(
            value = code,
            onValueChange = { if (it.length <= 4) onCodeChange(it) },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            decorationBox = {}
        )

        Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
            repeat(4) { index ->
                val isFilled = code.length > index
                val symbol = code.getOrNull(index)?.toString() ?: ""
                Box(
                    modifier = Modifier
                        .size(40.dp)
                        .background(
                            color = Color(0xFFF2F2F7),
                            shape = RoundedCornerShape(8.dp)
                        ),
                    contentAlignment = Alignment.Center
                ) {
                    if (isFilled) {
                        Text(
                            text = symbol,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Medium,
                            fontFamily = MegoFontFamily,
                            color = OpacityDark80
                        )
                    }
                    else {
                        Icon(
                            imageVector = MegoIcons.radioButtonUnchecked,
                            contentDescription = null,
                            tint = OpacityDark80,
                            modifier = Modifier.size(16.dp)
                        )
                    }
                }
            }
        }
    }
}