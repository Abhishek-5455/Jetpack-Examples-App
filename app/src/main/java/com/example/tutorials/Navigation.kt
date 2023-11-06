package com.example.tutorials

import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.tutorials.composables.ComposableScreen
import com.example.tutorials.layout.LayoutScreen
import com.example.tutorials.progressbar.ProgressBarScreen
import com.example.tutorials.scaffold.ScaffoldScreen

@Composable
fun TutorialApp(
    navController: NavHostController,
    windowSize: WindowWidthSizeClass
) {
    NavHost(
        navController = navController,
        startDestination = Screen.StartScreen.route
    ) {
        composable(Screen.StartScreen.route) {
            MainScreen(navController = navController , windowSize = windowSize)
        }
        composable(
            Screen.LayoutScreen.route
        ) {
            LayoutScreen()
        }
        composable(
            Screen.ComposableScreen.route
        ) {
            ComposableScreen()
        }
        composable(
            Screen.ProgressbarScreen.route
        ) {
            ProgressBarScreen()
        }
        composable(
            Screen.ScaffoldScreen.route
        ) {
            ScaffoldScreen()
        }
    }
}