package com.example.tutorials.composables

import androidx.compose.foundation.Image
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tutorials.R
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
        item{
            Divider(
                thickness = 1.dp,
                color = MaterialTheme.colorScheme.onBackground
            )
        }
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

        item {
            AlignmentSection()
        }

    }
}


@Preview(showSystemUi = true)
@Composable
fun DefaultPreview() {
    AlignmentSection()
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
fun AlignmentView(
    text: String,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .height(64.dp)
            .width(160.dp)
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
                append("A Row will show each child next to the previous children. It's like a LinearLayout with a horizontal orientation.")
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
                append("A Column will show each child below the previous children. It's like a LinearLayout with vertical orientation.")
            }
        }
    )
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(250.dp)
    ) {
        Column(
            modifier = Modifier
                .align(Alignment.Center)
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

@Composable
fun AlignmentSection(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(6.dp)
    ) {
        Text(
            text = "Alignment",
            style = MaterialTheme.typography.displayMedium
        )
        Text(
            text = "There are nine alignment options that can apply to child UI elements: ",
            style = MaterialTheme.typography.displaySmall
        )
        AlignmentTypes()
    }
}
@Composable
fun AlignmentTypes(
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height((100 * 3).dp)
            .border(2.dp, color = MaterialTheme.colorScheme.onBackground)
            .padding(12.dp)
    ) {
        AlignmentView(
            text = "TopStart",
            modifier = Modifier.align(Alignment.TopStart)
        )
        AlignmentView(
            text = "TopCenter",
            modifier = Modifier.align(Alignment.TopCenter)
        )
        AlignmentView(
            text = "TopEnd",
            modifier = Modifier.align(Alignment.TopEnd)
        )
        AlignmentView(
            text = "CenterStart",
            modifier = Modifier.align(Alignment.CenterStart)
        )
        AlignmentView(
            text = "Center",
            modifier = Modifier.align(Alignment.Center)
        )
        AlignmentView(
            text = "CenterEnd",
            modifier = Modifier.align(Alignment.CenterEnd)
        )
        AlignmentView(
            text = "BottomStart",
            modifier = Modifier.align(Alignment.BottomStart)
        )
        AlignmentView(
            text = "BottomCenter",
            modifier = Modifier.align(Alignment.BottomCenter)
        )
        AlignmentView(
            text = "BottomEnd",
            modifier = Modifier.align(Alignment.BottomEnd)
        )
    }
}

