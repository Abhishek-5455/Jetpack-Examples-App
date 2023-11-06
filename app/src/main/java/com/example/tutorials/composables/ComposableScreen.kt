package com.example.tutorials.composables

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.tutorials.R
import com.example.tutorials.common_ui.Heading
import com.example.tutorials.common_ui.ImageSection
import com.example.tutorials.common_ui.SubHeading
import com.example.tutorials.common_ui.SubPoint

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ComposableScreen() {
    Scaffold(
        topBar = {
            Column {
                CenterAlignedTopAppBar(
                    title = {
                        Text(
                            text = "Composable Functions",
                            style = MaterialTheme.typography.displayLarge
                        )
                    }
                )
                Divider(
                    thickness = 1.dp,
                    color = MaterialTheme.colorScheme.onBackground
                )
            }
        }
    ) {
        ComposableScreenContent(
            modifier = Modifier.padding(it)
        )
    }
}

@Composable
fun ComposableScreenContent(
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier.padding(horizontal = 16.dp),
        horizontalAlignment = Alignment.Start
    ) {
        item {
            Examples(modifier)
        }
        items(composeItems) {
            ComposeItem(item = it)
        }
        
    }
}

@Composable
fun Examples(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(6.dp)
    ) {
        Heading(
            heading = "What are Composable Functions??",
            description = "The Jetpack compose is build up using these composable functions, " +
                    "these predefined composable functions draws data into UI on the screen."
        )
        Heading(
            heading = "Types of Composable functions",
            description = "1. In-build\n" +
                    "\t\t\t\t2. User defined"
        )
        Text(
            text="Some of the In-build composable functions are given below : "
        )
        SubPoint(
            heading = "Text",
            content = "  : Use to show any text on screen"
        )
        SubPoint(
            heading = "TextField",
            content = "  : To take input from user"
        )
        SubPoint(
            heading = "Button",
            content = "  : To show a button on the screen"
        )
        SubPoint(
            heading = "Image",
            content = "  : To show a image on the screen"
        )
        Divider()
    }
}

data class ComposeItem (
    val heading: String,
    val content: String,
    val imageId: Int,
    @StringRes val examples: List<Int>,
    @DrawableRes val outputImageId: Int
)
@Composable
fun ComposeItem(
    item: ComposeItem,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxWidth()
    ) {
        SubHeading(
            heading = item.heading,
            content = item.content
        )
        Spacer(modifier = Modifier.height(6.dp))
        ImageSection(imageId = item.imageId)
        Spacer(modifier = Modifier.height(12.dp))
        Text(
            text = "Examples :"
        )
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .height(400.dp)
                .padding(12.dp)
                .clip(RoundedCornerShape(8.dp))
                .background(MaterialTheme.colorScheme.surfaceVariant)
        ) {
            items(item.examples) {stringId ->
                Text(
                    text = stringResource(id = stringId)
                )
                Divider(
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp)
                )
            }
        }
        Text(
            text = "Output : "
        )
        ImageSection(imageId = item.outputImageId)
        Divider()
    }
}

val composeItems = listOf(
    ComposeItem(
        heading = "Text",
        content = "  : Text composable function in Jetpack Compose is used to display text on the screen.",
        imageId = R.drawable.text,
        examples = listOf(
            R.string.text_with_size,
            R.string.text_with_color,
            R.string.bold_text,
            R.string.italic_text,
            R.string.text_with_max_lines,
            R.string.text_with_overflow
        ),
        outputImageId = R.drawable.text_output
    ),
    ComposeItem(
        heading = "TextField",
        content = "  : TextField composable function is used to take input from the user.",
        imageId = R.drawable.textfield,
        examples = listOf(
            R.string.simple_text_field,
            R.string.label_placeholder,
            R.string.number_format,
            R.string.outlined,
            R.string.textfield_with_icons
        ),
        outputImageId = R.drawable.text_field_output
    ),
    ComposeItem(
        heading = "Button",
        content = "  : Buttons composable function is used to perform an action.",
        imageId = R.drawable.button,
        examples = listOf(
            R.string.simple_button,
            R.string.button_with_color,
            R.string.button_with_icon,
            R.string.button_with_shape,
            R.string.button_with_border,
            R.string.button_with_elevation
        ),
        outputImageId = R.drawable.button_output
    ),
    ComposeItem(
        heading = "Image",
        content = "  : Image composable function is used to show images on the screen",
        imageId = R.drawable.image,
        examples = listOf(
            R.string.simple_image,
            R.string.image_circular_shape,
            R.string.image_rectangular_shape,
            R.string.image_with_size
        ),
        outputImageId = R.drawable.image_output
    )
)