package com.aecoding.recipeapptest.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aecoding.recipeapptest.data.networking.Recipe
import com.aecoding.recipeapptest.data.networking.recipeService
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private val _mealState = mutableStateOf(MealState())
    val mealState: State<MealState> = _mealState

    init {
        fetchMeals()
    }

    private fun fetchMeals() {
        viewModelScope.launch {
            try {
                val response = recipeService.getMeals()
                _mealState.value = _mealState.value.copy(
                    list = response.recipes,
                    loading = false,
                    error = null
                )
            } catch (e: Exception) {
                _mealState.value = _mealState.value.copy(
                    loading = false,
                    error = "Error fetching categories ${e.message}"
                )
            }
        }
    }

    data class MealState(
        val loading: Boolean = true,
        val list: List<Recipe> = emptyList(),
        val error: String? = null
    )
}

