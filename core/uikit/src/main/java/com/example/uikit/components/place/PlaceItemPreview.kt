package com.example.uikit.components.place

import androidx.compose.foundation.background
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview


object TestPlaceItem {
    // Базовый тестовый экземпляр
    val default = PlaceItemState(
        data = PlaceItemModel(
            id = 1,
            name = "Кафе 'Уютный уголок' Lorem ipsum eget Lorem ipsum egetLorem ipsum egetLorem ipsum egetLorem ipsum eget Lorem ipsum eget",
            image = "https://www.meme-arsenal.com/memes/d9156ddbe0074b2ac2e45d39e337d6b6.jpg",
            address = "ул. Ленина, 123 Крымский Вал, 9 Крымский Вал, 9Крымский Вал, 9Крымский Вал, 9Крымский Вал, 9",
            isFavorite = true,
            rating = 4.7f
        ),
        variant = PlaceItemVariant.Default
    )


    // С адресом
    val withAddress = default.copy(
        variant = PlaceItemVariant.WithAddress
    )

    // Для маршрута с кнопкой
    val forPathWithButton = PlaceItemState(
        data = PlaceItemModel(
            id = 2,
            name = "Lorem ipsum eget Lorem ipsum eget Lorem ipsum egetLorem ipsum egetLorem ipsum egetLorem ipsum eget Lorem ipsum egetLorem ipsum eget",
            image = "https://www.meme-arsenal.com/memes/d9156ddbe0074b2ac2e45d39e337d6b6.jpg",
            address = "Точный адрес при необходимости его и указания, может быть длинным",
            isFavorite = false,
            rating = null
        ),
        variant = PlaceItemVariant.ForPathWithButton
    )

    // С полным адресом
    val forPathWithExtendedAddress = forPathWithButton.copy(
        variant = PlaceItemVariant.ForPathWithExtendedAddress
    )

    // С удалением
    val forPathWithDelete = withAddress.copy(
        variant = PlaceItemVariant.ForPathWithOnDelete
    )
}
@Preview(showBackground = true)
@Composable
fun PlaceItemPreview() {
    LazyColumn(Modifier.background(Color.Gray)) {
        item{PlaceItem(state = TestPlaceItem.withAddress)}
        item{PlaceItem(state = PlaceItemState(data = null, variant = PlaceItemVariant.Default))}
        item{PlaceItem(state = TestPlaceItem.default)}
        item{PlaceItem(state = TestPlaceItem.forPathWithExtendedAddress)}
        item{PlaceItem(state = TestPlaceItem.forPathWithButton)}
        item{PlaceItem(state = TestPlaceItem.forPathWithDelete)}
    }
}
