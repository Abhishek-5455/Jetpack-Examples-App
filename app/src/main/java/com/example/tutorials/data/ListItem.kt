package com.example.tutorials.data

import com.example.tutorials.R

data class ListItem(
    val iconId: Int,
    val text: String,
    val itemId: Int
)

val listItems = listOf(
    ListItem(
        text = "Layouts",
        itemId = 1,
        iconId = R.drawable.composable
    ),
    ListItem(
        text = "Composables",
        itemId = 2,
        iconId = R.drawable.text
    ),
    ListItem(
        text = "Progress Bar",
        itemId = 6,
        iconId = R.drawable.progress_bar
    ),
    ListItem(
        text = "Scaffold",
        itemId = 7,
        iconId = R.drawable.scaffold
    )
)