package com.aecoding.recipeapptest.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
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
import com.aecoding.recipeapptest.ui.theme.RecipeAppAttemptTheme
import com.aecoding.recipeapptest.ui.theme.mainBackground
import com.aecoding.recipeapptest.ui.theme.textFieldHeader
import com.aecoding.recipeapptest.ui.theme.typeBackground
import com.aecoding.recipeapptest.ui.theme.typeBorderNormal
import com.aecoding.recipeapptest.ui.theme.typeBorderSelected


@Composable
fun AddScreen() {
    Column(modifier = Modifier
        .fillMaxSize()
        .background(mainBackground)) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    horizontal = 40.dp,
                    vertical = 60.dp
                ),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                modifier = Modifier.padding(20.dp),
                text = "New Recipe",
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.SemiBold,
                fontSize = 28.sp,
                color = Color.Black,
            )

            Text(
                modifier = Modifier
                    .align(Alignment.Start)
                    .padding(
                        start = 10.dp,
                        bottom = 10.dp
                    ),
                text = "NAME",
                fontWeight = FontWeight.Normal,
                fontSize = 14.sp,
                color = textFieldHeader
            )
            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 30.dp),
                value = "",
                onValueChange = {},
                shape = RoundedCornerShape(12.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = typeBorderSelected,
                    unfocusedBorderColor = typeBorderNormal,
                    focusedContainerColor = typeBackground,
                    unfocusedContainerColor = typeBackground
                ),
            )

            Text(
                modifier = Modifier
                    .align(Alignment.Start)
                    .padding(
                        start = 10.dp,
                        bottom = 10.dp
                    ),
                text = "CATEGORY",
                fontWeight = FontWeight.Normal,
                fontSize = 14.sp,
                color = textFieldHeader
            )
            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 30.dp),
                value = "",
                onValueChange = {},
                shape = RoundedCornerShape(12.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = typeBorderSelected,
                    unfocusedBorderColor = typeBorderNormal,
                    focusedContainerColor = typeBackground,
                    unfocusedContainerColor = typeBackground
                ),
            )

            Text(
                modifier = Modifier
                    .align(Alignment.Start)
                    .padding(
                        start = 10.dp,
                        bottom = 10.dp
                    ),
                text = "DESCRIPTION",
                fontWeight = FontWeight.Normal,
                fontSize = 14.sp,
                color = textFieldHeader
            )
            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 30.dp),
                value = "",
                onValueChange = {},
                shape = RoundedCornerShape(12.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = typeBorderSelected,
                    unfocusedBorderColor = typeBorderNormal,
                    focusedContainerColor = typeBackground,
                    unfocusedContainerColor = typeBackground
                ),
            )

            Text(
                modifier = Modifier
                    .align(Alignment.Start)
                    .padding(
                        start = 10.dp,
                        bottom = 10.dp
                    ),
                text = "INGREDIENTS",
                fontWeight = FontWeight.Normal,
                fontSize = 14.sp,
                color = textFieldHeader
            )
            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 30.dp),
                value = "",
                onValueChange = {},
                shape = RoundedCornerShape(12.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = typeBorderSelected,
                    unfocusedBorderColor = typeBorderNormal,
                    focusedContainerColor = typeBackground,
                    unfocusedContainerColor = typeBackground
                ),
            )

            Text(
                modifier = Modifier
                    .align(Alignment.Start)
                    .padding(
                        start = 10.dp,
                        bottom = 10.dp
                    ),
                text = "DESCRIPTION",
                fontWeight = FontWeight.Normal,
                fontSize = 14.sp,
                color = textFieldHeader
            )
            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 30.dp),
                value = "",
                onValueChange = {},
                shape = RoundedCornerShape(12.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = typeBorderSelected,
                    unfocusedBorderColor = typeBorderNormal,
                    focusedContainerColor = typeBackground,
                    unfocusedContainerColor = typeBackground
                ),
            )

        }
    }
}

@Preview
@Composable
private fun AddScreenPrev() {
    RecipeAppAttemptTheme {
        AddScreen()
    }
}