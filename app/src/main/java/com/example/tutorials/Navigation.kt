package com.example.tutorials

import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.tutorials.buttons.ButtonScreen
import com.example.tutorials.layout.LayoutScreen
import com.example.tutorials.image.ImageScreen
import com.example.tutorials.progressbar.ProgressBarScreen
import com.example.tutorials.scaffold.ScaffoldScreen
import com.example.tutorials.text.TextScreen
import com.example.tutorials.textField.TextFieldScreen

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
            Screen.TextScreen.route
        ) {
            TextScreen()
        }
        composable(
            Screen.ComposableScreen.route
        ) {
            LayoutScreen()
        }
        composable(
            Screen.ImageScreen.route
        ) {
            ImageScreen()
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
        composable(
            Screen.TextFieldScreen.route
        ) {
            TextFieldScreen()
        }
        composable(Screen.ButtonScreen.route) {
            ButtonScreen()
        }
    }
}