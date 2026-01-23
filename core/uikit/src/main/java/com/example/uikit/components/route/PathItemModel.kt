package com.example.uikit.components.route

data class PathItemModel(
    val id : Int,
    val title : String,
    val createdAt : String,
    val description : String,
    val image : String,
    val stage : Boolean,
    val isFavorite : Boolean,
    val duration : Int,
    val markCount : Int,
)