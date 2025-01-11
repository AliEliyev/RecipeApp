package com.aecoding.recipeapptest.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.aecoding.recipeapptest.R
import com.aecoding.recipeapptest.data.networking.Recipe
import com.aecoding.recipeapptest.ui.theme.RecipeAppAttemptTheme
import com.aecoding.recipeapptest.ui.theme.cardBackground
import com.aecoding.recipeapptest.ui.theme.cardSubText


@Composable
fun GridCardItem(mealsItem: Recipe) {
    var isLiked by remember { mutableStateOf(mealsItem.isLiked) }
    Card(
        modifier = Modifier
            .size(180.dp, 210.dp)
            .padding(horizontal = 10.dp, vertical = 15.dp)
            .clickable { },
        backgroundColor = cardBackground,
        elevation = 8.dp,
        shape = RoundedCornerShape(15.dp)
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(4.dp)
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Box {
                Image(
                    contentScale = ContentScale.Crop,
                    painter = rememberAsyncImagePainter(mealsItem.image),
                    contentDescription = mealsItem.title,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(100.dp)
                        .clip(RoundedCornerShape(15.dp))
                )
                Icon(
                    modifier = Modifier
                        .size(25.dp)
                        .background(
                            color = cardBackground,
                            shape = RoundedCornerShape(8.dp)
                        )
                        .padding(2.dp)
                        .clickable {
                            isLiked = !isLiked
                            mealsItem.isLiked = isLiked
                        }
                        .align(Alignment.TopEnd),
                    imageVector = if (mealsItem.isLiked) Icons.Default.Favorite else Icons.Default.FavoriteBorder,
                    contentDescription = null,
                    tint = if (isLiked) Color.Red else Color.Gray
                )
            }

            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = mealsItem.title,
                fontWeight = FontWeight.Medium,
                fontSize = 15.sp
            )
            Row(
                modifier = Modifier.fillMaxHeight()
            ) {
                Icon(
                    painter = painterResource(R.drawable.baseline_access_time_24),
                    contentDescription = null,
                    tint = cardSubText,
                    modifier = Modifier
                        .padding(start = 3.dp, end = 3.dp)
                        .size(15.dp)
                )
                Text(
                    text = "${mealsItem.readyInMinutes} minutes",
                    fontWeight = FontWeight.Medium,
                    fontSize = 11.sp,
                    color = cardSubText
                )
            }

        }

    }
}

@Preview
@Composable
private fun GridCardPreview() {
    RecipeAppAttemptTheme {
        GridCardItem(previewItem)
    }
}

var previewItem = Recipe(
    readyInMinutes = 42,
    image = "https://images.immediate.co.uk/production/volatile/sites/30/2022/11/Lentil-soup-with-feta-348cebb.jpg?quality=90&resize=504%2C458",
    title = "Soup recipe ideas",
    id = 123456,
    sourceUrl = "ad",
    summary = "",
    pricePerServing = 0.0
)