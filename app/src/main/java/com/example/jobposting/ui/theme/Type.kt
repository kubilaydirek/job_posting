package com.example.jobposting.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.jobposting.R

private val rubikFontFamily =
    FontFamily(
        Font(R.font.rubik_bold, FontWeight.Bold),
        Font(R.font.rubik_bold_italic, FontWeight.Bold, style = FontStyle.Italic),
        Font(R.font.rubik_light, FontWeight.Light),
        Font(R.font.rubik_medium, FontWeight.Medium),
        Font(R.font.rubik_black, FontWeight.Black),
        Font(R.font.rubik_extra_bold, FontWeight.ExtraBold),
        Font(R.font.rubik_medium_italic, FontWeight.Medium, style = FontStyle.Italic)
    )

val customTypography =
    Typography(
        displayLarge =
        TextStyle(
            fontFamily = rubikFontFamily,
            fontWeight = FontWeight.ExtraBold,
            fontSize = 34.sp
        ),
        displayMedium =
        TextStyle(
            fontFamily = rubikFontFamily,
            fontWeight = FontWeight.Bold,
            fontSize = 28.sp
        ),
        displaySmall =
        TextStyle(
            fontFamily = rubikFontFamily,
            fontWeight = FontWeight.Medium,
            fontSize = 22.sp
        ),
        headlineLarge =
        TextStyle(
            fontFamily = rubikFontFamily,
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp
        ),
        headlineMedium =
        TextStyle(
            fontFamily = rubikFontFamily,
            fontWeight = FontWeight.Medium,
            fontSize = 20.sp
        ),
        headlineSmall =
        TextStyle(
            fontFamily = rubikFontFamily,
            fontWeight = FontWeight.Normal,
            fontSize = 18.sp
        ),
        titleLarge =
        TextStyle(
            fontFamily = rubikFontFamily,
            fontWeight = FontWeight.Medium,
            fontSize = 20.sp
        ),
        titleMedium =
        TextStyle(
            fontFamily = rubikFontFamily,
            fontWeight = FontWeight.Normal,
            fontSize = 18.sp
        ),
        titleSmall =
        TextStyle(
            fontFamily = rubikFontFamily,
            fontWeight = FontWeight.Light,
            fontSize = 16.sp
        ),
        bodyLarge =
        TextStyle(
            fontFamily = rubikFontFamily,
            fontWeight = FontWeight.Normal,
            fontSize = 16.sp
        ),
        bodyMedium =
        TextStyle(
            fontFamily = rubikFontFamily,
            fontWeight = FontWeight.Normal,
            fontSize = 14.sp
        ),
        bodySmall =
        TextStyle(
            fontFamily = rubikFontFamily,
            fontWeight = FontWeight.Light,
            fontSize = 12.sp
        ),
        labelLarge =
        TextStyle(
            fontFamily = rubikFontFamily,
            fontWeight = FontWeight.Medium,
            fontSize = 14.sp
        ),
        labelMedium =
        TextStyle(
            fontFamily = rubikFontFamily,
            fontWeight = FontWeight.Normal,
            fontSize = 12.sp
        ),
        labelSmall =
        TextStyle(
            fontFamily = rubikFontFamily,
            fontWeight = FontWeight.Light,
            fontSize = 10.sp
        )
    )
