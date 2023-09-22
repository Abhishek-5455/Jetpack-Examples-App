package com.example.tutorials.data

import com.example.tutorials.R

data class ListItem(
    val iconId: Int,
    val text: String,
    val itemId: Int
)

val listItems = listOf(
    ListItem(
        text = "Basic Composable",
        itemId = 1,
        iconId = R.drawable.composable
    ),
    ListItem(
        text = "Text",
        itemId = 2,
        iconId = R.drawable.text
    ),
    ListItem(
        text = "TextField",
        itemId = 3,
        iconId = R.drawable.textfield
    ),
    ListItem(
        text = "Buttons",
        itemId = 4,
        iconId = R.drawable.button
    ),
    ListItem(
        text = "Images",
        itemId = 5,
        iconId = R.drawable.image
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