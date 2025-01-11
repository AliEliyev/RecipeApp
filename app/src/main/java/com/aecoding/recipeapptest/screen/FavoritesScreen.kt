package com.aecoding.recipeapptest.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aecoding.recipeapptest.data.networking.Recipe
import com.aecoding.recipeapptest.ui.theme.RecipeAppAttemptTheme
import com.aecoding.recipeapptest.ui.theme.mainBackground
import com.aecoding.recipeapptest.viewmodel.MainViewModel

@Composable
fun FavoritesScreen(
    viewState: MainViewModel.MealState
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(mainBackground)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    horizontal = 40.dp,
                    vertical = 60.dp
                ),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            if (viewState.list.isEmpty()) {
                viewState.error?.let {
                    Text(
                        modifier = Modifier.padding(20.dp),
                        text = "Empty",
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 20.sp,
                        color = Color.Black,
                    )
                }
            }
            Text(
                modifier = Modifier.padding(20.dp),
                text = "Favorites",
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.SemiBold,
                fontSize = 28.sp,
                color = Color.Black,
            )

            val likedRecipes = mutableListOf<Recipe>()
            for (meal in viewState.list) {
                if (meal.isLiked) {
                    likedRecipes.add(meal)
                } else {
                    if (meal in likedRecipes) {
                        likedRecipes.remove(meal)
                    }
                }
            }

            LazyVerticalGrid(
                modifier = Modifier
                    .fillMaxSize(),
                columns = GridCells.Fixed(2)
            ) {
                items(likedRecipes) { meal ->
                    if (meal.isLiked) {
                        GridCardItem(meal)
                    }
                }
            }

        }
    }
}


@Preview
@Composable
private fun FavoritesScreenPrev() {
    RecipeAppAttemptTheme {
        //FavoritesScreen(prevState)
    }

}