package com.example.domain.model.feedback


import java.util.UUID

data class Feedback(
    val id: String = UUID.randomUUID().toString(),
    val excursionName: String? = null,
    val description: String,
    val authorProfileImage: String,
    val authorName: String,
    val authorSurname: String,
    val authorCity: String,
    val authorCountry: String,
    val userProfileImage: String,
    val userName: String,
    val country: String,
    val city: String,
    val rating: Rating,
    val landMarkImage: String,
    val comment: String,
    val isCommentCollapsed: Boolean,
)