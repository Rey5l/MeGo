package com.example.catalog.landmark.composables

import android.R.attr.background
import android.R.id.background
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.catalog.compose_model.LandmarkInfoTabDVO
import com.example.uikit.component.button.SelectableButton
import kotlin.collections.forEach

@Composable
internal fun LandmarkHeadersRow(
    selectedTab: LandmarkInfoTabDVO,
    onSelectTab: (LandmarkInfoTabDVO) -> Unit,
) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        modifier =
            Modifier
                .background(Color.White)
                .padding(vertical = 12.dp)
                .horizontalScroll(rememberScrollState()),
    ) {
        Box(Modifier.size(6.dp)) {}
        LandmarkInfoTabDVO.entries.forEach { currentTab ->
            SelectableButton(
                title = currentTab.titleRes,
                isSelected = selectedTab == currentTab,
                onClick = {
                    onSelectTab.invoke(currentTab)
                },
            )
        }
    }
}

@Preview(showBackground = true, name = "LandmarkHeadersRow Default")
@Composable
private fun LandmarkHeadersRowPreview() {
    MaterialTheme {
        Surface {
            LandmarkHeadersRow(
                selectedTab = LandmarkInfoTabDVO.Description,
                onSelectTab = { }
            )
        }
    }
}

