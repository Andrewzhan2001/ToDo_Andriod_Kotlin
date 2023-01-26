package com.example.to_doapp.ui.theme

import androidx.compose.material.Colors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

val Purple200 = Color(0xFFBB86FC)
val Purple500 = Color(0xFF6200EE)
val Purple700 = Color(0xFF3700B3)
val Teal200 = Color(0xFF03DAC5)

val LowPriorityColor = Color(0xFF00C980)
val MediumPriorityColor = Color(0xFFFFC114)
val HighPriorityColor = Color(0XFFFF4646)
val NonePriorityColor = Color(0xFFFFFFFF)

val LightGray = Color(0xFFFCFCFC)
val MediumGray = Color(0xFF9C9C9C)
val DarkGray = Color(0xFF141414)

val MainColorLight = Color(0xFF3C488B)
val MainColor = Color(0xFF2B3467)
val SecondColor = Color(0xFF3C488B)

val Colors.fabBackgroundColor: Color
    // custom getter method
    @Composable
    get() = if (isLight) Teal200 else Purple700

val Colors.topAppBarContentColor: Color
// custom getter method
    @Composable
    get() = if (isLight) Color.White else LightGray

val Colors.topAppBarBackgroundColor: Color
    // custom getter method
    @Composable
    get() = if (isLight) Purple500 else Purple700

val Colors.taskItemTextColor: Color
    @Composable
    get() = if (isLight) DarkGray else LightGray

val Colors.taskItemBackgroundColor: Color
    @Composable
    get() = if (isLight) Color.White else DarkGray

val Colors.splashScreenBackground: Color
    @Composable
    get() = if (isLight) MainColor else Color.Black