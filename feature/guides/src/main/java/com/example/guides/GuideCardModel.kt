package com.example.guides

data class GuideCardModel(
    val id : Int,
    val name : String,
    val surname : String,
    val photo : String,
    val isOnline: Boolean,
    val isLiked : Boolean,
    val rating : Double,
    val desc : String,
    val languages : List<String>,
    val interests : List<String>,
    val price  : Int,
    val hour : Int,
    val markCount : Int
)