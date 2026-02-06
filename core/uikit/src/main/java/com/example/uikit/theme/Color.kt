package com.example.uikit.theme

import androidx.compose.ui.graphics.Color

val CorporateMeGoPrimary = Color(0xFF5856D6)
val ColorPurpure = Color(0xFFAF52DE)
// добавил 99 в начало, так как  66 — это прозрачность 60% в шестнадцатеричном виде.
// val OpacityLight60 = Color(0x99FFFFFF), но цвет выглядит странно, не так как в фигме
val OpacityLight60 = Color.White
// добавил 66 в начало, так как  66 — это прозрачность 40% в шестнадцатеричном виде.
val OpacityDark40 = Color(0x661C1C1E)
val ColorRed = Color(0xFFFF3B30)
val OpacityDark80 = Color.Black.copy(alpha = 0.8f)

//в фигме указан вот такой #1C1C1ECC, но это синий. На макете #OpacityDark80, но светлее
val OpacityDark80Lighter = Color.Black.copy(alpha = 0.65f)
val Green = Color(0xFF34C759)

val BGSecondary = Color(0xFFF2F2F7)