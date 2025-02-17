package com.example.ozinshecompose.ui.theme

import androidx.compose.ui.graphics.Color

val Purple80 = Color(0xFFD0BCFF)
val PurpleGrey80 = Color(0xFFCCC2DC)
val Pink80 = Color(0xFFEFB8C8)

val Purple40 = Color(0xFF6650a4)
val PurpleGrey40 = Color(0xFF625b71)
val Pink40 = Color(0xFF7D5260)

val Gray50 = Color(0xFFF9FAFB)
val Gray100 = Color(0xFFF3F4F6)
val Gray200 = Color(0xFFE5E7EB)
val Gray300 = Color(0xFFD1D5DB)
val Gray400 = Color(0xFF9CA3AF)
val Gray500 = Color(0xFF6B7280)
val Gray600 = Color(0xFF4B5563)
val Gray700 = Color(0xFF374151)
val Gray800 = Color(0xFF1F2937)
val Gray900 = Color(0xFF111827)

val Primary50 = Color(0xFFF8EEFF)
val Primary100 = Color(0xFFEAD1FD)
val Primary200 = Color(0xFFD1A4FC)
val Primary300 = Color(0xFFB376F7)
val Primary400 = Color(0xFF9753F0)
val Primary500 = Color(0xFF6D1EE7)
val Primary600 = Color(0xFF5415C6)
val Primary700 = Color(0xFF3E0FA6)
val Primary800 = Color(0xFF2B0985)
val Primary900 = Color(0xFF1E056E)

val White = Color(0xFFFFFFFF)
val Yellow = Color(0xFF00BF71)
val Green = Color(0xFFFBBC05)
val Blue = Color(0xFF2370FF)

sealed class ThemeColors(
    val background: Color,
    val surface: Color,
    val primary: Color,
    val secondary: Color,
    val tertiary: Color,
    val onBackground: Color
) {
    object Night: ThemeColors(
        background = Gray900,
        surface = Gray800,
        primary = Primary500,
        secondary = Gray400,
        tertiary = Gray700,
        onBackground = White
    )
    object Day: ThemeColors(
        background = White,
        surface = Gray300,
        primary = Primary500,
        secondary = Gray400,
        tertiary = Gray100,
        onBackground = Gray900
    )
}