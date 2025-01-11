package com.aecoding.recipeapptest.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.aecoding.recipeapptest.screen.AddScreen
import com.aecoding.recipeapptest.screen.CategoryScreen
import com.aecoding.recipeapptest.screen.FavoritesScreen
import com.aecoding.recipeapptest.screen.HomeScreen
import com.aecoding.recipeapptest.viewmodel.MainViewModel

@Composable
fun Navigation(
    viewModel: MainViewModel,
    navController: NavController,
    pd: PaddingValues,
) {
    val viewState by viewModel.mealState

    NavHost(
        navController = navController as NavHostController,
        startDestination = Screen.HomeScreen.route,
        modifier = Modifier.padding(pd)
    ) {
        composable(Screen.HomeScreen.route) { HomeScreen(viewState) }
        composable(Screen.LikedScreen.route) { FavoritesScreen(viewState) }
        composable(Screen.CategoryScreen.route) { CategoryScreen() }
        composable(Screen.AddScreen.route) { AddScreen() }

    }

}