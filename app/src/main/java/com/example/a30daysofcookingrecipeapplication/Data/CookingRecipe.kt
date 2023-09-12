package com.example.a30daysofcookingrecipeapplication.Data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.a30daysofcookingrecipeapplication.R

data class CookingRecipe(
    @StringRes val day: Int,
    @StringRes val foodName: Int,
    @DrawableRes val foodPic:Int,
    @StringRes val ingredient: Int,
    @StringRes val recipe:Int,
)

val cookingRecipes = listOf(
    CookingRecipe(R.string.day1,R.string.day1food,R.drawable.day1,R.string.day1ingredient,R.string.day1recipe)
)