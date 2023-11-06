package com.example.tutorials

sealed class Screen(val route: String) {
    object StartScreen: Screen("main_screen")

    object ComposableScreen: Screen("composable_screen")
    object LayoutScreen: Screen("layout_screen")
    object ProgressbarScreen: Screen("progressbar_screen")
    object ScaffoldScreen: Screen("scaffold_screen")
}
