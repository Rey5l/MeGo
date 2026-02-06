package com.example.uikit.components.place

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.example.uikit.components.loader.MeGoLoader

/**
 * PlaceItem.
 *
 * ### Параметры
 * - state : PlaceItemState - выбор варианта PlaceItem из фигмы:
 *     - Стейт : Название карточки из фигмы
 *     - Default : Default, On Map
 *     - WithAddress : With address
 *     - ForPathWithButton : For Path
 *     - ForPathWithExtendedAddress : For Path2(with address)
 *     - ForPathWithOnDelete : For Path3
 *
 * - onFavoriteClick - кнопка лайка для всех вариантов
 * - onDeleteClick - кнопка корзины для варианта "For Path3"
 * - onActionClick - Кнопка к "Следующей точке" для варианта "For Path"
 * - "modifier" - Modifier
 */

@Composable
fun PlaceItem(
    state: PlaceItemState,
    onFavoriteClick : () -> Unit = {},
    onDeleteClick: () -> Unit = {},
    onActionClick: () -> Unit = {},
    modifier: Modifier = Modifier
) {
    when{
        state.data != null -> {
            PlaceItemContent(
                data = state.data,
                variant = state.variant,
                onFavoriteClick = { onFavoriteClick() },
                onDeleteClick = { onDeleteClick() },
                onActionClick = { onActionClick() },
                modifier = modifier
                )
        }
        else -> {
            Card(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    .height(148.dp)
                    .clip(RoundedCornerShape(4.dp))
            ) {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    MeGoLoader()
                }
            }
        }
    }
}