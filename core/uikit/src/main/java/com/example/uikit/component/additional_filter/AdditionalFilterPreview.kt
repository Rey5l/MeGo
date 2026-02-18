package com.example.uikit.component.additional_filter

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.uikit.icon.MegoIcons
import com.example.uikit.theme.UIKitTheme

@Composable
private fun sampleFilters(): List<AdditionalFilterItem> = listOf(
    AdditionalFilterItem(
        id = "all",
        icon = MegoIcons.formatListBulleted,
        label = "Всё",
        isSelected = true
    ),
    AdditionalFilterItem(
        id = "popular",
        icon = MegoIcons.thumpUpOutline,
        label = "Популярное",
        isSelected = false
    ),
    AdditionalFilterItem(
        id = "unusual",
        icon = MegoIcons.drewAbstractOutlineSharp,
        label = "Необычное",
        isSelected = false
    ),
    AdditionalFilterItem(
        id = "ethnotourism",
        icon = MegoIcons.mountainFlagOutline,
        label = "Этнотуризм",
        isSelected = false
    ),
    AdditionalFilterItem(
        id = "restaurants",
        icon = MegoIcons.restaurant,
        label = "Рестораны",
        isSelected = false
    ),
    AdditionalFilterItem(
        id = "family",
        icon = MegoIcons.familyRestroomSharp,
        label = "Семейный",
        isSelected = false
    ),
    AdditionalFilterItem(
        id = "culture",
        icon = MegoIcons.theaterComedyOutline,
        label = "Культура",
        isSelected = false
    ),
    AdditionalFilterItem(
        id = "shopping",
        icon = MegoIcons.shoppingBagSpeedOutlineSharp,
        label = "Шопинг",
        isSelected = false
    ),
    AdditionalFilterItem(
        id = "nature",
        icon = MegoIcons.hiking,
        label = "Природа",
        isSelected = false
    ),
    AdditionalFilterItem(
        id = "romance",
        icon = MegoIcons.favoriteOutline,
        label = "Романтика",
        isSelected = false
    ),
    AdditionalFilterItem(
        id = "likeLocal",
        icon = MegoIcons.translate,
        label = "Как местный",
        isSelected = false
    ),
)

@Preview(showBackground = true)
@Composable
private fun AdditionalFiltersPreview() {
    UIKitTheme {
        AdditionalFilters(
            items = sampleFilters(),
            onItemClick = {}
        )
    }
}
