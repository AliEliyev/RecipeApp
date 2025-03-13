package com.aecoding.recipeapptest.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.BottomNavigation
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.BottomNavigationItem
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.contentColorFor
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.aecoding.recipeapptest.navigation.Navigation
import com.aecoding.recipeapptest.navigation.screensInBottom
import com.aecoding.recipeapptest.ui.theme.bottomSelected
import com.aecoding.recipeapptest.ui.theme.bottomSheetBg
import com.aecoding.recipeapptest.viewmodel.MainViewModel

@Composable
fun MainView() {
    val mealViewModel: MainViewModel = viewModel()
    val controller: NavController = rememberNavController()
    val navBackStackEntry by controller.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    if (mealViewModel.keepSplashScreen.value) {
        CustomSplashScreen()
    } else {

        val bottomBar: @Composable () -> Unit = {
            BottomNavigation(
                modifier = Modifier.height(100.dp),
                backgroundColor = bottomSheetBg,
                contentColor = contentColorFor(bottomSheetBg)
            ) {
                screensInBottom.forEach { item ->
                    BottomNavigationItem(
                        modifier = Modifier.padding(20.dp),
                        selected = currentRoute == item.route,
                        onClick = { controller.navigate(item.route) },
                        icon = {
                            Icon(
                                painter = painterResource(item.icon),
                                contentDescription = item.title,
                                tint = if (currentRoute == item.route) Color.Black
                                else Color.Gray,
                                modifier = Modifier
                                    .background(
                                        color = if (currentRoute == item.route) bottomSelected
                                        else bottomSheetBg,
                                        shape = RoundedCornerShape(70.dp)
                                    )
                                    .size(70.dp)
                                    .padding(16.dp)
                            )

                        },
                        selectedContentColor = bottomSelected,
                    )
                }
            }
        }

        Scaffold(bottomBar = bottomBar) {
            Navigation(mealViewModel, controller, it)
        }
    }
}
