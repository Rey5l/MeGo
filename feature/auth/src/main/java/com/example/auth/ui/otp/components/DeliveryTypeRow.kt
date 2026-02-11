package com.example.auth.ui.otp.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
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

@Composable
fun DeliveryTypeRow(
    onTgLogoClick: () -> Unit,
    onWpLogoClick: () -> Unit,
    onSmsLogoClick: () -> Unit
) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(30.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            imageVector = MegoIcons.icTg,
            contentDescription = "Tg logo",
            modifier = Modifier.clickable {
                onTgLogoClick()
            }
        )
        Image(
            imageVector = MegoIcons.icWp,
            contentDescription = "WhatsApp logo",
            modifier = Modifier.clickable {
                onWpLogoClick()
            }
        )
        Icon(
            imageVector = MegoIcons.icSms,
            contentDescription = "Sms logo",
            tint = opacityDark60,
            modifier = Modifier.size(28.dp).clickable {
                onSmsLogoClick()
            }
        )
    }
}