package com.aecoding.recipeapptest.data.networking

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Headers


private val retrofit = Retrofit
    .Builder()
    .baseUrl("https://spoonacular-recipe-food-nutrition-v1.p.rapidapi.com/")
    .addConverterFactory(GsonConverterFactory.create())
    .build()
val recipeService: ApiService = retrofit.create(ApiService::class.java)

interface ApiService {
    @Headers("x-rapidapi-key: 0a13671a92msh5b8fd08ac812620p1a5204jsn1c1c9d43dc47")
    @GET("recipes/random?number=25")
    suspend fun getMeals(): Meal
}