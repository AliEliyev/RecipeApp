package com.aecoding.recipeapptest.data

import com.aecoding.recipeapptest.R


sealed class Category(
    val title: String,
    val icon: Int
) {
    data object Breakfast : Category(
        title = "Breakfast",
        icon = R.drawable.waffles
    )

    data object Lunch : Category(
        title = "Lunch",
        icon = R.drawable.sandwich
    )

    data object Drinks : Category(
        title = "Drinks",
        icon = R.drawable.cocktail
    )

    data object Pastas : Category(
        title = "Pastas",
        icon = R.drawable.spaghetti
    )

    data object Salads : Category(
        title = "Salads",
        icon = R.drawable.food
    )

    data object Desserts : Category(
        title = "Desserts",
        icon = R.drawable.cake
    )

    data object Soups : Category(
        title = "Soups",
        icon = R.drawable.chicken_soup
    )


}


val screenOfCategory = listOf(
    Category.Breakfast,
    Category.Lunch,
    Category.Drinks,
    Category.Pastas,
    Category.Salads,
    Category.Desserts,
    Category.Soups
)



