package com.aecoding.recipeapptest.navigation

import androidx.annotation.DrawableRes
import com.aecoding.recipeapptest.R

sealed class Screen(
    val title: String,
    val route: String,
    @DrawableRes val icon: Int) {
    data object HomeScreen: Screen(
        "Home",
         "homescreen",
        R.drawable.baseline_home_24)
    data object CategoryScreen: Screen(
        "Category",
        "categoryscreen",
        R.drawable.baseline_bookmark_24)
    data object LikedScreen: Screen(
        "Favorites",
        "likedscreen",
        R.drawable.baseline_favorite_24)
    data object AddScreen: Screen(
        "Add",
        "addscreen",
        R.drawable.baseline_add_24)
}

val screensInBottom = listOf(
    Screen.HomeScreen,
    Screen.CategoryScreen,
    Screen.LikedScreen,
    Screen.AddScreen
)