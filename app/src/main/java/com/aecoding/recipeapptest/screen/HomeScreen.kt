package com.aecoding.recipeapptest.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aecoding.recipeapptest.ui.theme.RecipeAppAttemptTheme
import com.aecoding.recipeapptest.ui.theme.cardSubText
import com.aecoding.recipeapptest.ui.theme.pageSubHeader
import com.aecoding.recipeapptest.ui.theme.typeBackground
import com.aecoding.recipeapptest.ui.theme.typeBorderSelected
import com.aecoding.recipeapptest.viewmodel.MainViewModel

@Composable
fun HomeScreen(
    viewState: MainViewModel.MealState
) {
    val focusManager = LocalFocusManager.current
    val text = remember { mutableStateOf("") }
    var isFocused by remember { mutableStateOf(false) }
    Column(modifier = Modifier
        .fillMaxSize()
        .background(Color.White)
        .clickable { focusManager.clearFocus() }) {
        Row(
            modifier = Modifier
                .height(130.dp)
                .fillMaxWidth()
                .padding(start = 40.dp, end = 40.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Search",
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.SemiBold,
                fontSize = 28.sp,
                color = Color.Black,
            )
        }
        Column(
            modifier = Modifier
                .padding(start = 40.dp, end = 40.dp)
                .fillMaxWidth()
                .height(160.dp)
        ) {
            Text(
                text = "What is in your kitchen?",
                textAlign = TextAlign.Start,
                fontWeight = FontWeight.SemiBold,
                fontSize = 22.sp,
                color = Color.Black,
            )


            Text(
                text = "Enter some ingredients",
                textAlign = TextAlign.Start,
                fontWeight = FontWeight.Normal,
                fontSize = 18.sp,
                color = pageSubHeader
            )

            OutlinedTextField(
                value = text.value,
                onValueChange = { text.value = it },
                textStyle = TextStyle.Default.copy(fontSize = 15.sp),
                modifier = Modifier
                    .padding(top = 30.dp, bottom = 30.dp)
                    .fillMaxWidth()
                    .onFocusChanged { isFocused = it.isFocused },
                placeholder = {
                    Text(
                        text = "Type your ingredients",
                        fontWeight = FontWeight.Normal,
                        fontSize = 15.sp,
                        color = cardSubText
                    )
                },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = "Search"
                    )
                },
                shape = RoundedCornerShape(10.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = typeBorderSelected,
                    unfocusedBorderColor = typeBorderSelected,
                    unfocusedContainerColor = typeBackground,
                    cursorColor = Color.Black
                ),
                keyboardActions = KeyboardActions(
                    onDone = { focusManager.clearFocus() }
                )
            )

        }
        LazyVerticalGrid(
            modifier = Modifier
                .padding(start = 40.dp, end = 40.dp)
                .fillMaxSize(),
            columns = GridCells.Fixed(2)
        ) {
            items(viewState.list) { meal ->
                GridCardItem(meal)
            }
        }
    }
}

@Preview
@Composable
private fun HomeScreenPreview() {
    RecipeAppAttemptTheme {
        //HomeScreen()
    }
}



