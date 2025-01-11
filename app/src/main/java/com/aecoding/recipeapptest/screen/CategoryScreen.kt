package com.aecoding.recipeapptest.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aecoding.recipeapptest.data.Category
import com.aecoding.recipeapptest.data.screenOfCategory
import com.aecoding.recipeapptest.ui.theme.RecipeAppAttemptTheme
import com.aecoding.recipeapptest.ui.theme.cardBackground

@Composable
fun CategoryScreen() {
    Column(
        modifier = Modifier
            .background(Color.White)
            .padding(
                horizontal = 40.dp,
                vertical = 60.dp
            ),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Categories",
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.SemiBold,
            fontSize = 28.sp,
            color = Color.Black,
        )
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            items(screenOfCategory) { category ->
                Spacer(modifier = Modifier.height(20.dp))
                CategoryItem(category)

            }
        }
    }
}

@Composable
fun CategoryItem(category: Category) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
            .clickable { },
        shape = RoundedCornerShape(20.dp),
        elevation = CardDefaults.cardElevation(10.dp),
        colors = CardDefaults.elevatedCardColors(
            containerColor = cardBackground
        )
    ) {
        Row(
            modifier = Modifier.fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = category.title,
                fontSize = 23.sp,
                fontWeight = FontWeight.Medium,
                modifier = Modifier.padding(start = 15.dp)
            )
            Image(
                modifier = Modifier.padding(end = 15.dp),
                painter = painterResource(category.icon),
                contentDescription = category.title
            )
        }
    }

}


@Preview
@Composable
private fun CategoryItemPrev() {
    RecipeAppAttemptTheme {
        CategoryScreen()
    }
}