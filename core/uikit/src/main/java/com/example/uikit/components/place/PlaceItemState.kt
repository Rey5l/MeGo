package com.example.uikit.components.place


/**
 * Data.
 *
 * ### Параметры
 * - state : PlaceItemState - выбор варианта PlaceItem из фигмы:
 *    - Стейт : Название карточки из фигмы
 *      - Default : Default, On Map
 *      - WithAddress : With address
 *      - ForPathWithButton : For Path
 *      - ForPathWithExtendedAddress : For Path2(with address)
 *      - ForPathWithOnDelete : For Path3
 */

data class PlaceItemState(
    val data: PlaceItemModel? = null,
    val variant: PlaceItemVariant = PlaceItemVariant.Default
)

data class PlaceItemModel (
    val id : Int,
    val name : String,
    val image : String,
    val address: String? = null,
    val isFavorite : Boolean,
    val rating: Float? = null,
)
sealed interface PlaceItemVariant{
    object Default : PlaceItemVariant
    object WithAddress : PlaceItemVariant
    object ForPathWithButton : PlaceItemVariant
    object ForPathWithExtendedAddress : PlaceItemVariant
    object ForPathWithOnDelete : PlaceItemVariant
}