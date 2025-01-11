package com.aecoding.recipeapptest.data.networking

data class Recipe(
    val id: Int,
    val image: String,
    val pricePerServing: Double,
    val readyInMinutes: Int,
    val sourceUrl: String,
    val summary: String,
    val title: String,
    var isLiked: Boolean = false
)
