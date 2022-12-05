package com.example.tailormeasure.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorPalette = darkColors(
    primary = Color.White,
    surface = LightBlue,
    onSurface = DarkGray,
    onError = Color.Red,
    secondary = RedOrange,
    background = DarkGray,
    onBackground = Color.White,
    primaryVariant = Violet
)

private val LightColorPalette = lightColors(
    background = Color.White,
    onBackground = DarkGray,
    primary = RedPink,
    primaryVariant = Violet,
    secondary = RedOrange

    /* Other default colors to override
    background = Color.White,
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black,
    */
)

@Composable
fun TailorMeasureTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}