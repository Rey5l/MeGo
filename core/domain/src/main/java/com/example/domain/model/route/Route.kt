package com.example.domain.model.route

import java.util.UUID

data class Route(
    val id: String = UUID.randomUUID().toString(),
    val image: String,
    val title: String,
    val comment: String,
    val createdAt: String,
    val isPassed: Boolean,
    val markCount: Int,
    val isFavourite: Boolean,
)

