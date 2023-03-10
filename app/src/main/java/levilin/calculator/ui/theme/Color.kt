package levilin.calculator.ui.theme

import androidx.compose.material.Colors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

val LightGray = Color(0xFFFAFAFA)
val LightMediumGray = Color(0xFFD1CFCF)
val MediumGray = Color(0xFFACA9A9)
val MediumDarkGray = Color(0xFF6F6C6C)
val DarkGray = Color(0xFF3D3C3C)

val LightOrange = Color(0xFFF1AC47)
val Orange = Color(0xFFFF9800)
val DarkOrange = Color(0xFF533201)


val Colors.screenBackgroundColor: Color
    @Composable
    get() = if (isLight) LightGray else DarkGray

val Colors.screenTextColor: Color
    @Composable
    get() = if (isLight) DarkGray else LightGray

val Colors.numberButtonBackgroundColor: Color
    @Composable
    get() = if (isLight) LightMediumGray else MediumGray

val Colors.operationButtonBackgroundColor: Color
    @Composable
    get() = if (isLight) LightOrange else Orange

val Colors.otherButtonBackgroundColor: Color
    @Composable
    get() = if (isLight) MediumGray else MediumDarkGray