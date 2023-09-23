package com.example.tutorials.textField

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
fun TextFieldScreen(
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
                        text = "Text Field Examples",
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
                items(textFieldItems) { item ->
                    ScreenElement(
                        item = item,
                        expandedContent = { ExpandedContent(item = item) }
                    )
                }
                item {
                    OutputImage(
                        imageId = R.drawable.text_field_output
                    )
                }
            }
        }
    }
}

val textFieldItems = listOf(
    ScreenItem(
        heading = "Simple TextField",
        description = "It Creates a simple text box. We use two arguments\n" +
                "value : To set the initial text field value\n" +
                "onValueChange : It returns a new value when user enter the text"
        ,
        code = R.string.simple_text_field
    ),
    ScreenItem(
        heading = "Label and Placeholder",
        description = "Label : If the text field has focus then label will be floated to the top.\n" +
                        "placeholder : Displays a text when the text field is empty.",
        code = R.string.label_placeholder
    ),
    ScreenItem(
        heading = "Keyboard Options",
        description = "To get particular input from text field we use Keyboard options.",
        code = R.string.number_format
    ),
    ScreenItem(
        heading = "Outlined TextField",
        description = "It creates a text field with border as shown in output image",
        code = R.string.outlined
    ),
    ScreenItem(
        heading = "TextField with icons",
        description = "We can add icons in text field\n" +
                "leadingIcon : Adds an icon in the beginning of text field\n" +
                "trailingIcon: Adds an icon in the ending of the text field",
        code = R.string.textfield_with_icons
    )
)

