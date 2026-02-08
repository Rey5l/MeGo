package com.example.auth.ui.otp.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.uikit.icon.MegoIcons
import com.example.uikit.theme.OpacityDark80
import com.example.uikit.theme.opacityDark60

@Preview
@Composable
fun DeliveryTypeRow(

) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = MegoIcons.icSms,
            contentDescription = null,
            tint = opacityDark60,
            modifier = Modifier.size(28.dp)
        )
        Icon(
            imageVector = MegoIcons.icSms,
            contentDescription = null,
            tint = opacityDark60,
            modifier = Modifier.size(28.dp)
        )
        Icon(
            imageVector = MegoIcons.icSms,
            contentDescription = null,
            tint = opacityDark60,
            modifier = Modifier.size(28.dp)
        )
    }
}