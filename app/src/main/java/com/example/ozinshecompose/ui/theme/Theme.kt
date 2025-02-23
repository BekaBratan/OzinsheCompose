package com.example.ozinshecompose.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

private val DarkColorScheme = darkColorScheme(
    background = ThemeColors.Night.background,
    surface = ThemeColors.Night.surface,
    primary = ThemeColors.Night.primary,
    secondary = ThemeColors.Night.secondary,
    tertiary = ThemeColors.Night.tertiary,
    onBackground = ThemeColors.Night.onBackground,
    onTertiary = ThemeColors.Night.onTertiary
)

private val LightColorScheme = lightColorScheme(
    background = ThemeColors.Day.background,
    surface = ThemeColors.Day.surface,
    primary = ThemeColors.Day.primary,
    secondary = ThemeColors.Day.secondary,
    tertiary = ThemeColors.Day.tertiary,
    onBackground = ThemeColors.Day.onBackground,
    onTertiary = ThemeColors.Day.onTertiary

    /* Other default colors to override
    background = Color(0xFFFFFBFE),
    surface = Color(0xFFFFFBFE),
    onPrimary = Color.White,
    onSecondary = Color.White,
    onTertiary = Color.White,
    onBackground = Color(0xFF1C1B1F),
    onSurface = Color(0xFF1C1B1F),
    */
)

@Composable
fun OzinsheComposeTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme: ColorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    val colors = if (!darkTheme) {
        LightColorScheme
    } else {
        DarkColorScheme
    }

    MaterialTheme(
        colorScheme = colors,
        content = content
    )
}