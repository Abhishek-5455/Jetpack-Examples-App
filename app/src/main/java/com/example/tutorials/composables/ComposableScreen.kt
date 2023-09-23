package com.example.tutorials.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tutorials.ui.theme.Cabin

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ComposableScreen() {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = "Compose Layout",
                        style = MaterialTheme.typography.displayLarge
                    )
                }
            )
        }
    ) {
        ComposeLayoutContent(
            modifier = Modifier.padding(it)
        )
    }
}

@Composable
fun ComposeLayoutContent(
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier.padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp),
        horizontalAlignment = Alignment.Start
    ) {
        item {
            HeadingAndInfo(
                heading = "What's Layouts in Android?",
                description =   "It provides an invisible container to hold the views or layouts." +
                                " We can place a group of views/layouts inside the layouts." +
                                " Row and column are layouts to arrange our views in Linear manner. "
            )
        }
        item {
            HeadingAndInfo(
                heading = "What's Linear manner?",
                description = "A Linear manner means one element per line." +
                        " In this manner, arrange the elements one to another in the same order either horizontally or vertically."
            )
        }
        item {
            RowAndColumnSection()
        }
    }
}


@Preview(showSystemUi = true)
@Composable
fun DefaultPreview() {
    ComposableScreen()
}

@Composable
fun View(
    text: String,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .size(64.dp)
            .background(MaterialTheme.colorScheme.surfaceVariant)
            .border(width = 2.dp, color = MaterialTheme.colorScheme.onSurfaceVariant)
    ) {
        Text(
            text = text,
            modifier = Modifier.align(Alignment.Center),
            style = MaterialTheme.typography.displaySmall
        )
    }
}

@Composable
fun HeadingAndInfo(
    heading: String,
    description: String
) {
    Text(
        text = heading,
        style = MaterialTheme.typography.displayMedium
    )
    Text(
        text = "\t\t\t\t${description}",
        style = MaterialTheme.typography.displaySmall,
        textAlign = TextAlign.Justify

    )
}
@Composable
fun RowAndColumnSection() {
    Text(
        text = buildAnnotatedString {
            withStyle(
                style = SpanStyle(
                    fontFamily = Cabin,
                    fontSize = 22.sp,
                    fontWeight = FontWeight.SemiBold
                )
            ) {
                append("Row : ")
            }
            withStyle(
                style = SpanStyle(
                    fontFamily = Cabin,
                    fontSize = 18.sp
                )
            ) {
                append("It arranges the views horizontally")
            }
        }
    )
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .background(MaterialTheme.colorScheme.surface)
            .border(2.dp, color = MaterialTheme.colorScheme.onBackground)
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ){
        View(text = "view1")
        View(text = "view2")
        View(text = "view3")
    }
    Spacer(modifier = Modifier.height(2.dp))
    Text(
        text = buildAnnotatedString {
            withStyle(
                style = SpanStyle(
                    fontFamily = Cabin,
                    fontSize = 22.sp
                )
            ) {
                append("Column : ")
            }
            withStyle(
                style = SpanStyle(
                    fontFamily = Cabin,
                    fontSize = 18.sp
                )
            ) {
                append("It arranges the views vertically")
            }
        }
    )
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(500.dp)
    ) {
        Column(
            modifier = Modifier
                .align(Alignment.TopCenter)
                .padding(16.dp)
                .background(MaterialTheme.colorScheme.surface)
                .border(2.dp, color = MaterialTheme.colorScheme.onBackground)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            View(text = "view 1")
            View(text = "view 2")
            View(text = "view 3")
        }
    }
}