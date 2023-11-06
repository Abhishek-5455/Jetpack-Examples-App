package com.example.tutorials.layout

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
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tutorials.R
import com.example.tutorials.common_ui.Heading
import com.example.tutorials.common_ui.ImageSection
import com.example.tutorials.common_ui.SubHeading
import com.example.tutorials.common_ui.SubPoint

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LayoutScreen() {
    Scaffold(
        topBar = {
            Column {
                CenterAlignedTopAppBar(
                    title = {
                        Text(
                            text = "Compose Layout",
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
        LayoutScreenContent(
            modifier = Modifier.padding(it)
        )
    }
}

@Composable
fun LayoutScreenContent(
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier.padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp),
        horizontalAlignment = Alignment.Start
    ) {
        item {
            Heading(
                heading = "What's Layouts in Android?",
                description =   "It provides an invisible container to hold the views or layouts." +
                                " We can place a group of views/layouts inside the layouts." +
                                " Row and column are layouts to arrange our views in Linear manner. "
            )
        }
        item {
            Heading(
                heading = "What's Linear manner?",
                description = "A Linear manner means one element per line." +
                        " In this manner, arrange the elements one to another in the same order either horizontally or vertically."
            )
        }
        item {
            Divider()
        }
        item {
            RowAndColumnSection()
        }

        item {
            AlignmentSection()
        }

        item {
            ArrangementSection()
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
fun RowAndColumnSection() {
    SubHeading(
        heading = "Row",
        content = ":  A Row will show each child next to the previous children. It's like a LinearLayout with a horizontal orientation."
    )
    ImageSection(imageId = R.drawable.row_code)
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 8.dp),
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        SubPoint(
            heading = "modifier",
            content = "  : The modifier to be applied to the row"
        )
        SubPoint(
            heading = "horizontalArrangement",
            content = "  : The horizontal arrangement of the layout's children."
        )
        SubPoint(
            heading = "verticalAlignment : ",
            content = "  : The vertical alignment of the layout's children."
        )
    }

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
    SubHeading(
        heading = "Column",
        content = " : A Column will show each child below the previous children. It's like a LinearLayout with vertical orientation."
    )

    ImageSection(imageId = R.drawable.column_code)
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 8.dp),
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        SubPoint(
            heading = "modifier",
            content = "  : The modifier to be applied to the column"
        )
        SubPoint(
            heading = "horizontalAlignment",
            content = "  : The horizontal arrangement of the layout's children."
        )
        SubPoint(
            heading = "verticalArrangement",
            content = "  : The vertical alignment of the layout's children."
        )
    }
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
    Divider()
}

@Composable
fun AlignmentSection(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(6.dp)
    ) {
        SubHeading(
            heading = "Alignment",
            content = "  : There are nine alignment options that can apply to child UI elements. These alignment decides where the view must be placed."
        )
        Spacer(modifier = Modifier.height(6.dp))
        SubPoint(
            heading = "TopStart",
            content = "  : Top Row and First Column "
        )
        SubPoint(
            heading = "TopCenter",
            content = "  : Top Row and Center Column"
        )
        SubPoint(
            heading = "TopEnd",
            content = "  : Top Row and Last Column"
        )
        SubPoint(
            heading = "CenterStart",
            content = "  : Middle Row and First Column "
        )
        SubPoint(
            heading = "Center",
            content = "  : Middle Row and Center Column"
        )
        SubPoint(
            heading = "CenterEnd",
            content = "  : Middle Row and Last Column"
        )
        SubPoint(
            heading = "BottomStart",
            content = "  : Bottom Row and First Column "
        )
        SubPoint(
            heading = "BottomCenter",
            content = "  : Bottom Row and Center Column"
        )
        SubPoint(
            heading = "BottomEnd",
            content = "  : Bottom Row and Last Column"
        )
        Spacer(modifier = Modifier.height(6.dp))
        ImageSection(imageId = R.drawable.alignment_img)
        Spacer(modifier = Modifier.height(12.dp))
        Divider()
    }
}

@Composable
fun ArrangementSection(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        SubHeading(
            heading = "Arrangement : ",
            content = "There are three types of arrangement that can be applied to vertical and horizontal arrangements: "
        )
        Spacer(modifier = Modifier.height(6.dp))
        SubPoint(
            heading = "SpaceEvenly : ",
            content = "  Using this arrangement we can place child elements across the main axis, including free space before the first and after the last child."
        )
        SubPoint(
            heading = "SpaceBetween : ",
            content = "  Using this arrangement we can place child elements across the main axis without free space before first and after the last child.")
        SubPoint(
            heading = "SpaceAround : ",
            content = "  Using this arrangement we can place child elements across the main axis with half of the free space before the first and after the last child."
        )
        ImageSection(imageId = R.drawable.arrangement_img)
    }
}

