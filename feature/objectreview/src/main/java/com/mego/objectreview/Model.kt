package com.mego.objectreview

data class MyReviewItem(
    var value: String,
    val onValueChange: (String) -> Unit,
    val ratingSize: Int = 5,
    var rating: Int = 0,
    var isClicked: Boolean = false,
    var isSave: Boolean = false,
    var isError: Boolean = false
)

enum class ReviewMode {
    EDIT,
    VIEW
}

data class ModeItem(
    val title: String,
    val icon: Int,
    val timeRangeFirst: String,
    val timeRangeSecond: String,
    val isOpenTime: Boolean = false,
)

data class AddressItem(
    val title: String,
    val icon: Int,
    val location: String,
    val isOpenLocation: Boolean = false,
    val seeMap: String,
)
data class ReviewBoxIem(
    val image: Int,
    val name: String,
    val location: String,
    val rating: Float,
    val review: String,
    val reviewSize: Int
)
