package com.example.tutorials.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

private val darkColorScheme = darkColorScheme(
    primary = darkPrimaryColor,
    onPrimary = darkOnPrimaryColor,
    secondary = darkSecondaryColor,
    onSecondary = darkOnSecondaryColor,
    surface = darkSurfaceColor,
    onSurface = darkOnSurfaceColor,
    background = darkBackgroundColor,
    onBackground = darkOnBackgroundColor
)

private val lightColorScheme = lightColorScheme(
    primary = lightPrimaryColor,
    onPrimary = lightOnPrimaryColor,
    secondary = lightSecondaryColor,
    onSecondary = lightOnSecondaryColor,
    surface = lightSurfaceColor,
    onSurface = lightOnSurfaceColor,
    background = lightBackgroundColor,
    onBackground = lightOnBackgroundColor
)

@Composable
fun TutorialsTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> darkColorScheme
        else -> lightColorScheme
    }
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = colorScheme.primary.toArgb()
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = darkTheme
        }
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}