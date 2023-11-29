package com.example.tutorials

import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.tutorials.screen.ComposableScreen
import com.example.tutorials.screen.LayoutScreen
import com.example.tutorials.screen.FlashingScreen
import com.example.tutorials.screen.ScaffoldScreen

@Composable
fun TutorialApp(
    navController: NavHostController,
    windowSize: WindowWidthSizeClass
) {
    NavHost(
        navController = navController,
        startDestination = Screen.FlashScreen.route
    ) {
        composable(Screen.FlashScreen.route) {
            FlashingScreen(navController = navController)
        }
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
            Screen.ScaffoldScreen.route
        ) {
            ScaffoldScreen()
        }
    }
}