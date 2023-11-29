package com.example.tutorials.data

import com.example.tutorials.R

data class ListItem(
    val iconId: Int,
    val text: String,
    val itemId: Int
)

val listItems = listOf(
    ListItem(
        text = "UI Architecture",
        itemId = 1,
        iconId = R.drawable.scaffold
    ),
    ListItem(
        text = "Layouts",
        itemId = 2,
        iconId = R.drawable.composable
    ),
    ListItem(
        text = "Composables",
        itemId = 3,
        iconId = R.drawable.text
    ),
    ListItem(
        text = "Lists and Grids",
        itemId = 4,
        iconId = R.drawable.scaffold
    ),
    ListItem(
        text = "Scaffold",
        itemId = 5,
        iconId = R.drawable.scaffold
    ),
    ListItem(
        text = "Animations",
        itemId = 6,
        iconId = R.drawable.scaffold
    )
)