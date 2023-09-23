package com.example.tutorials.text

import androidx.compose.animation.core.MutableTransitionState
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tutorials.R
import com.example.tutorials.common_ui.ScreenElement
import com.example.tutorials.common_ui.StartingScreenAnimation

data class ScreenItem(
    val heading: String,
    val description: String,
    val code: Int
)

val textScreenItems = listOf(
    ScreenItem(
        heading = "Text Size",
        description = "Change the text size using fontSize parameter",
        code = R.string.text_with_size
    ),
    ScreenItem(
        heading = "Text Color",
        description = "Change the text color using color parameter",
        code = R.string.text_with_color
    ),
    ScreenItem(
        heading = "Bold Text",
        description = "Use fontWeight parameter to making the bold text",
        code = R.string.bold_text
    ),
    ScreenItem(
        heading = "Italic Text",
        description = "Use fontStyle parameter to making the italic text",
        code = R.string.italic_text
    ),
    ScreenItem(
        heading = "Maximum number of lines",
        description = "To limit the number of visible lines in a Text composable, set the maxLines parameter",
        code = R.string.text_with_max_lines
    ),
    ScreenItem(
        heading = "Text Overflow",
        description = "Use when the text is too long to fit, displayed text is truncated",
        code = R.string.text_with_overflow
    )
)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextScreen(
    modifier: Modifier = Modifier
) {
    val visibleState = remember {
        MutableTransitionState(false).apply {
            targetState = true
        }
    }
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(title = {
                Text(
                    text = "Text Examples",
                    style = MaterialTheme.typography.displayLarge
                )
            })
        }

    ) {
        StartingScreenAnimation(visibleState = visibleState) {
            LazyColumn(
                modifier = modifier
                    .padding(it)
                    .fillMaxSize()
                    .padding(16.dp)
            ) {
                items(textScreenItems) { item ->
                    ScreenElement(
                        item = item,
                        expandedContent = { ExpandedContent(item = item) }
                    )
                }
                item {
                    OutputImage(
                        imageId = R.drawable.text_output
                    )
                }
            }
        }
    }
}

@Composable
fun ExpandedContent(
    item: ScreenItem
) {
    Column(
        modifier = Modifier.padding(16.dp),
        horizontalAlignment = Alignment.Start
    ) {
        Text(
            text = item.description,
            style = MaterialTheme.typography.displaySmall
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "Code : ",
            style = MaterialTheme.typography.displaySmall
        )
        Text(
            text = stringResource(id = item.code),
            style = TextStyle(
                fontSize = 20.sp,
                fontWeight = FontWeight.Normal
            )
        )
    }
}
@Composable
fun OutputImage(
    modifier: Modifier = Modifier,
    imageId: Int
) {
    Box(
        modifier = modifier.fillMaxWidth()
    ){
        Text(
            text = "Output : ",
            style = MaterialTheme.typography.displayMedium,
            modifier = Modifier
                .align(Alignment.TopStart)
                .padding(top = 16.dp, start = 16.dp)
        )
        Image(
            painter = painterResource(id = imageId),
            contentDescription = null,
            contentScale = ContentScale.FillHeight,
            modifier = Modifier
                .height(400.dp)
                .padding(top = 58.dp)
                .align(Alignment.Center)
        )
    }
}