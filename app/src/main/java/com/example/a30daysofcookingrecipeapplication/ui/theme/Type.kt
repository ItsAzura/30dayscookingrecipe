package com.example.a30daysofcookingrecipeapplication.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.a30daysofcookingrecipeapplication.R


val Robot = FontFamily(
    Font(R.font.roboto_regular)
)

val Typography = Typography(
    displayLarge = TextStyle(
        fontFamily = Robot,
        fontWeight = FontWeight.Normal,
        fontSize = 30.sp
    ),
    displayMedium = TextStyle(
        fontFamily = Robot,
        fontWeight = FontWeight.Bold,
        fontSize = 20.sp
    ),
    labelSmall = TextStyle(
        fontFamily = Robot,
        fontWeight = FontWeight.Bold,
        fontSize = 14.sp
    ),
    bodyLarge = TextStyle(
        fontFamily = Robot,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp
    )
)