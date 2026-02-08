package com.example.auth.ui.registration.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.uikit.theme.CorporateMeGoPrimary

@Composable
fun AgreementRow(
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    enabled: Boolean = true,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Checkbox(
            checked = checked,
            onCheckedChange = onCheckedChange,
            enabled = enabled,
            colors = CheckboxDefaults.colors(
                checkedColor = CorporateMeGoPrimary,
                uncheckedColor = CorporateMeGoPrimary,
                checkmarkColor = Color.White,
            )
        )
        Spacer(Modifier.width(8.dp))
        AgreementText(
            onUserAgreementClick = { /*TODO*/ },
            onPrivacyPolicyClick = { /*TODO*/ }
        )
    }
}