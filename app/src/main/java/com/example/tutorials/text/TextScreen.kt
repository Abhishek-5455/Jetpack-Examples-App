package com.example.tutorials.text

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.MutableTransitionState
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.spring
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowDropDown
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tutorials.R

data class TextScreenItem(
    val heading: String,
    val description: String,
    val code: Int
)

val textList = listOf(
    TextScreenItem(
        heading = "Text Size",
        description = "Change the text size using fontSize parameter",
        code = R.string.text_with_size
    ),
    TextScreenItem(
        heading = "Text Color",
        description = "Change the text color using color parameter",
        code = R.string.text_with_color
    ),
    TextScreenItem(
        heading = "Bold Text",
        description = "Use fontWeight parameter to making the bold text",
        code = R.string.bold_text
    ),
    TextScreenItem(
        heading = "Italic Text",
        description = "Use fontStyle parameter to making the italic text",
        code = R.string.italic_text
    ),
    TextScreenItem(
        heading = "Maximum number of lines",
        description = "To limit the number of visible lines in a Text composable, set the maxLines parameter",
        code = R.string.text_with_max_lines
    ),
    TextScreenItem(
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
        AnimatedVisibility(
            visibleState = visibleState,
            enter = fadeIn(
                animationSpec = spring(dampingRatio = Spring.DampingRatioLowBouncy)
            ),
            exit = fadeOut(),
            modifier = modifier
        ) {
            LazyColumn(
                modifier = modifier
                    .padding(it)
                    .fillMaxSize()
                    .padding(16.dp)
            ) {
                items(textList) {item ->
                    TextExampleElement(
                        item = item
                    )
                }
                item {
                    OutputImage()
                }
            }
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextExampleElement(
    item: TextScreenItem,
    modifier: Modifier = Modifier
) {
    var isExpanded by remember { mutableStateOf(false) }
    val rotate by animateFloatAsState(
        targetValue = if(isExpanded) 180f else 0f, label = ""
    )

    Card(
        shape = RoundedCornerShape(15),
        modifier = modifier
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .sizeIn(minHeight = 58.dp)
            .animateContentSize(
                animationSpec = spring(
                    dampingRatio = Spring.DampingRatioMediumBouncy,
                    stiffness = Spring.StiffnessLow
                )
            ),
        onClick = {isExpanded = !isExpanded}
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = item.heading,
                    style = MaterialTheme.typography.displayMedium
                )

                IconButton(
                    onClick = { isExpanded = !isExpanded },
                    modifier = Modifier
                        .rotate(rotate)
                ) {
                    Icon(
                        imageVector = Icons.Rounded.ArrowDropDown,
                        contentDescription = null,
                        modifier = Modifier.size(35.dp)
                    )
                }
            }
            if(isExpanded) {
                Column(
                    modifier = Modifier.padding(8.dp),
                    horizontalAlignment = Alignment.Start,
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Text(
                        text = item.description,
                        style = MaterialTheme.typography.displaySmall
                    )
                    Text(
                        text = stringResource(id = item.code),
                        style = TextStyle(
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Normal
                        )
                    )
                }
            }
        }
    }
}

@Composable
fun OutputImage(
    modifier: Modifier = Modifier
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
            painter = painterResource(id = R.drawable.text_output),
            contentDescription = null,
            contentScale = ContentScale.FillHeight,
            modifier = Modifier
                .height(400.dp)
                .padding(top = 58.dp)
                .align(Alignment.Center)
        )
    }
}