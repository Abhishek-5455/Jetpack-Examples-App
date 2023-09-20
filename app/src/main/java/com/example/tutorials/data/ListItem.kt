package com.example.tutorials.data

import com.example.tutorials.R

data class ListItem(
    val iconId: Int,
    val text: String,
    val itemId: String
)

val listItems = listOf(
    ListItem(
        text = "Basic Composable",
        itemId = "composable",
        iconId = R.drawable.composable
    ),
    ListItem(
        text = "Text",
        itemId = "text",
        iconId = R.drawable.text
    ),
    ListItem(
        text = "TextField",
        itemId = "textField",
        iconId = R.drawable.textfield
    ),
    ListItem(
        text = "Buttons",
        itemId = "button",
        iconId = R.drawable.button
    ),
    ListItem(
        text = "Images",
        itemId = "image",
        iconId = R.drawable.image
    ),
    ListItem(
        text = "Progress Bar",
        itemId = "progressBar",
        iconId = R.drawable.progress_bar
    ),
    ListItem(
        text = "Scaffold",
        itemId = "scaffold",
        iconId = R.drawable.scaffold
    )
)