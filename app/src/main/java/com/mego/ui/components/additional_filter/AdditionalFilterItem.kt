package com.mego.ui.components.additional_filter

import androidx.compose.ui.graphics.vector.ImageVector

/**
 * Модель данных для одного элемента фильтра.
 *
 * @param id Уникальный идентификатор фильтра (например, "all", "popular")
 * @param icon Иконка фильтра из MegoIcons
 * @param label Текст под иконкой (например, "Всё", "Популярное")
 * @param isSelected Выбран ли фильтр (влияет на цвет иконки и текста)
 */
data class AdditionalFilterItem(
    val id: String,
    val icon: ImageVector,
    val label: String,
    val isSelected: Boolean = false
)
