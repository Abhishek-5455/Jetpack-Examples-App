package com.example.tutorials.buttons

import androidx.compose.animation.core.MutableTransitionState
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.tutorials.R
import com.example.tutorials.common_ui.ScreenElement
import com.example.tutorials.common_ui.StartingScreenAnimation
import com.example.tutorials.text.ExpandedContent
import com.example.tutorials.text.OutputImage
import com.example.tutorials.text.ScreenItem

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ButtonScreen(
    modifier: Modifier = Modifier
) {
    val visibleState = remember {
        MutableTransitionState(false).apply {
            targetState = true
        }
    }
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = "Button Examples",
                        style = MaterialTheme.typography.displayLarge
                    )
                }
            )
        }
    ) {
        StartingScreenAnimation(visibleState = visibleState) {
            LazyColumn(
                modifier = modifier
                    .padding(it)
                    .fillMaxSize()
                    .padding(16.dp)
            ) {
                items(buttonItems) { item ->
                    ScreenElement(
                        item = item,
                        expandedContent = { ExpandedContent(item = item) }
                    )
                }
                item {
                    OutputImage(
                        imageId = R.drawable.button_img
                    )
                }
            }
        }
    }
}

val buttonItems = listOf(
    ScreenItem(
        heading = "Simple Button",
        description =  "Simple button has only a single parameter : onClick , which contains functions to perform after clicking",
        code = R.string.simple_button
    ),
    ScreenItem(
        heading = "Button with custom color",
        description = "Buttons contains another parameter : colors, to change the button colors like background color, content color, etc",
        code = R.string.button_with_color
    ),
    ScreenItem(
        heading = "Button with Icon",
        description = "To add Icon before or after the text",
        code = R.string.button_with_icon
    ),
    ScreenItem(
        heading = "Button with shape",
        description = "Button composable contains another parameter: shape, we can set the shape of the button like Rectangle shape, Round corner shape, cut corner shape, etc.",
        code = R.string.button_with_shape
    ),
    ScreenItem(
        heading = "Button with border",
        description = "We can add border to the button using shape parameter.",
        code = R.string.button_with_border
    ),
    ScreenItem(
        heading = "Button with elevation",
        description = "we can elevate the button from the surface by setting a value to elevation parameter.",
        code = R.string.button_with_elevation
)
)