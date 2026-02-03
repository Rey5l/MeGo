package com.example.auth.ui.registration.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.uikit.theme.CorporateMeGoPrimary
import com.example.uikit.theme.MegoFontFamily

@Composable
fun AgreementRow(
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Checkbox(
            checked = checked,
            onCheckedChange = onCheckedChange,
            colors = CheckboxDefaults.colors(
                checkedColor = CorporateMeGoPrimary,
                uncheckedColor = CorporateMeGoPrimary,
                checkmarkColor = CorporateMeGoPrimary,
            )
        )
        Spacer(Modifier.width(8.dp))
        AgreementText(
            onUserAgreementClick = { /*TODO*/ },
            onPrivacyPolicyClick = { /*TODO*/ }
        )
    }
}