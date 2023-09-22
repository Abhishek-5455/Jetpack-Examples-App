package com.example.tutorials

sealed class Screen(val route: String) {
    object StartScreen: Screen("main_screen")

    object TextScreen: Screen("text_screen")
    object ComposableScreen: Screen("composable_screen")
    object ButtonScreen: Screen("button_screen")
    object ImageScreen: Screen("image_screen")
    object ProgressbarScreen: Screen("progressbar_screen")
    object ScaffoldScreen: Screen("scaffold_screen")
    object TextFieldScreen: Screen("text_field_screen")
}
