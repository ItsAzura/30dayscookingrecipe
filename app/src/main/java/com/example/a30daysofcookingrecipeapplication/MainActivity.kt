package com.example.a30daysofcookingrecipeapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.a30daysofcookingrecipeapplication.Data.CookingRecipe
import com.example.a30daysofcookingrecipeapplication.Data.cookingRecipes
import com.example.a30daysofcookingrecipeapplication.ui.theme._30DaysOfCookingRecipeApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            _30DaysOfCookingRecipeApplicationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {
                    FoodApp()
                }
            }
        }
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FoodApp(){
    val expandedList = remember { mutableStateListOf<Boolean>() }
    for (i in cookingRecipes.indices) {
        expandedList.add(false)
    }
    Scaffold(
        topBar = {
            FoodTopBar()
        }
    ) {it ->
        LazyColumn(contentPadding = it){
            itemsIndexed(cookingRecipes){index, cookingRecipe ->
                FoodItem(
                    cookingRecipe = cookingRecipe,
                    expanded = expandedList[index],
                    onClick = { expandedList[index] = !expandedList[index] },
                    modifier = Modifier.padding(8.dp)
                )
            }
        }
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FoodTopBar(
    modifier: Modifier = Modifier
){
    CenterAlignedTopAppBar(
        title = {
            Text(
                modifier = Modifier
                    .padding(
                        top = 10.dp,
                        start = 10.dp,
                        bottom = 8.dp,
                    ),
                text = "30 Days of Cooking Recipe",
                color = if (isSystemInDarkTheme()) Color(0xFFFFFFFF)
                else Color(0xFF00390A),
                style = MaterialTheme.typography.displayLarge
            )
        }
    )
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FoodItem(
    cookingRecipe: CookingRecipe,
    expanded: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
){
    Card(
        onClick = onClick,
        modifier = modifier
    ) {
        Column(
            modifier = Modifier
                .animateContentSize(
                    animationSpec = spring(
                        dampingRatio = Spring.DampingRatioNoBouncy,
                        stiffness = Spring.StiffnessMedium
                    )
                )

                .padding(8.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        if (isSystemInDarkTheme()) Color(0xFF78DC77)
                        else Color(0xFF006E1C)
                    )
            ) {
                FoodInfo(day = cookingRecipe.day, foodName = cookingRecipe.foodName)
                Spacer(modifier = Modifier.weight(2f))
                FoodIcon(foodpic = cookingRecipe.foodPic)
            }
            if(expanded){
                FoodRecipe(
                    ingredient = cookingRecipe.ingredient,
                    recipe = cookingRecipe.recipe,
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(
                            if (isSystemInDarkTheme()) Color(0xFF78DC77)
                            else Color(0xFF006E1C)
                        )
                        .padding(
                            start = 16.dp,
                            top = 8.dp,
                            end = 16.dp,
                            bottom = 16.dp
                        )
                    )
            }

        }
    }
}
@Composable
fun FoodInfo(
    @StringRes day:Int,
    @StringRes foodName: Int,
    modifier: Modifier = Modifier,
){
    Column(modifier = modifier
        .fillMaxWidth()
        .padding(8.dp)
    )
    {
        Text(text = stringResource(id = day),
            color = if (isSystemInDarkTheme()) Color(0xFF00390A)
            else Color(0xFFFFFFFF),
            style =MaterialTheme.typography.displayMedium,
            modifier =Modifier.padding(top = 4.dp)
        )

        Text(text = stringResource(id = foodName),
            color = if (isSystemInDarkTheme()) Color(0xFF00390A)
            else Color(0xFFFFFFFF),
            style =MaterialTheme.typography.displayLarge,
            modifier =Modifier.padding(top = 8.dp)
        )
    }
}
@Composable
fun FoodIcon(
    @DrawableRes foodpic:Int,
    modifier: Modifier = Modifier
){
    Image(
        modifier = modifier
            .fillMaxWidth()
            .height(300.dp)
            .padding(8.dp)
            .clip(RoundedCornerShape(10.dp)),
        contentScale = ContentScale.Crop,
        painter = painterResource(id = foodpic),
        contentDescription =""
    )
}

@Composable
fun FoodRecipe(
    @StringRes ingredient:Int,
    @StringRes recipe:Int,
    modifier: Modifier = Modifier
){
    Column(
        modifier = modifier
    ) {
        Text(
            text = "Ingredient: ",
            color = if (isSystemInDarkTheme()) Color(0xFF00390A)
            else Color(0xFFFFFFFF),
            style = MaterialTheme.typography.displayMedium,
            )
        Text(
            text = stringResource(id = ingredient),
            color = if (isSystemInDarkTheme()) Color(0xFF00390A)
            else Color(0xFFFFFFFF),
            style = MaterialTheme.typography.bodyLarge,
        )
        Text(
            text = "Recipe: ",
            color = if (isSystemInDarkTheme()) Color(0xFF00390A)
            else Color(0xFFFFFFFF),
            style = MaterialTheme.typography.displayMedium,
        )
        Text(
            text = stringResource(id = recipe),
            color = if (isSystemInDarkTheme()) Color(0xFF00390A)
            else Color(0xFFFFFFFF),
            style = MaterialTheme.typography.bodyLarge,
        )
    }
}

