package com.mego.ui.components.additional_filter

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.uikit.theme.UIKitTheme

/**
 * Горизонтальный скролл фильтров категорий.
 *
 * ### Как использовать:
 * ```kotlin
 * val filters = listOf(
 *     AdditionalFilterItem(
 *         id = "all",
 *         icon = MegoIcons.formatListBulleted,
 *         label = "Всё",
 *         isSelected = selectedFilterId == "all"
 *     ),
 *     // ... остальные фильтры
 * )
 *
 * AdditionalFilters(
 *     items = filters,
 *     onItemClick = { filterId ->
 *         selectedFilterId = filterId  // Обновляем состояние
 *         // Здесь твоя логика фильтрации
 *     }
 * )
 * ```
 *
 * ### Подключение к кнопкам:
 * При клике на любой фильтр вызывается `onItemClick(filterId)`.
 * В обработчике обнови состояние выбранного фильтра и примени фильтрацию.
 *
 * @param items Список фильтров для отображения
 * @param onItemClick Обработчик клика по фильтру (получает id выбранного фильтра)
 */
@Composable
fun AdditionalFilters(
    items: List<AdditionalFilterItem>,
    onItemClick: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyRow (
        horizontalArrangement = Arrangement.spacedBy(20.dp),
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 12.dp),
        modifier = modifier
    ) {
        items(items){item ->
            AdditionalFilterItemView(
                item = item,
                onClick = {onItemClick(item.id)}
            )
        }
    }
}

@Composable
private fun AdditionalFilterItemView(
    item: AdditionalFilterItem,
    onClick: () -> Unit
) {
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.clickable{ onClick() }
    ) {
        Icon(
            imageVector = item.icon,
            contentDescription = item.label,
            modifier = Modifier
                .padding(1.dp)  // Figma
                .size(24.dp),  // Figma
            tint = if (item.isSelected) {
                UIKitTheme.colors.primary  // сиреневый для выбранного
            } else {
                UIKitTheme.colors.textSecondary  // серый для невыбранного
            }
        )

        Spacer(Modifier.height(4.dp))

        Text(
            text = item.label,
            style = UIKitTheme.typography.caption.copy(
                fontWeight = if (item.isSelected) {
                    FontWeight(600)
                } else {
                    FontWeight(500)
                }
            ),
            color = if (item.isSelected) {
                UIKitTheme.colors.primary
            } else UIKitTheme.colors.textSecondary
        )
    }
}