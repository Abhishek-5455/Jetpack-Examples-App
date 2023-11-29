package com.example.tutorials.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.tutorials.R
import com.example.tutorials.common_ui.Heading
import com.example.tutorials.common_ui.ImageSection
import com.example.tutorials.common_ui.SubPoint

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScaffoldScreen() {
    Scaffold(
        topBar = {
            Column {
                CenterAlignedTopAppBar(
                    title = {
                        Text(
                            text = "Scaffold",
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
        ScaffoldScreenContent(
            modifier = Modifier.padding(it)
        )
    }
}

@Composable
fun ScaffoldScreenContent(
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier.padding(horizontal = 16.dp)
    ) {
        item {
            Content()
        }

        item {
            ScaffoldExample()
        }
    }
}

@Composable
fun Content(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(6.dp)
    ) {
        Heading(
            heading = "What is Scaffold??",
            description = "Scaffold is a Composable function.Scaffold allows implementation of UI with the basic Material Design layout structure"
        )
        Text(
            text="We can add the following widgets with the help of Scaffold"
        )
        SubPoint(
            heading = "TopAppBar",
            content = "  : Adds Top app bar to the screen"
        )
        SubPoint(
            heading = "FloatingActionButton",
            content = "  : Adds a floating button on the screen"
        )
        SubPoint(
            heading = "DrawerMenu",
            content = "  : Adds side menu drawer to the screen"
        )
        SubPoint(
            heading = "BottomNavigation",
            content = "  : Adds bottom navigation bar to the screen"
        )
        Text(text="Scaffold function definition")
        ImageSection(imageId = R.drawable.scaffold_definition)
        Divider()
        
        Text(text="TopAppBar function definition")
        ImageSection(imageId = R.drawable.topappbar_definition)
        Divider()
        
        Text(text="FloatingActionButton function definition")
        ImageSection(imageId = R.drawable.fab_definition)
        Divider()
        
        Text(text="DrawerMenu function definition")
        ImageSection(imageId = R.drawable.drawer_definition)
        Divider()

        Text(text="BottomNavigation function definition")
        ImageSection(imageId = R.drawable.bottom_nav_definition)
        Divider()
    }
}

@Composable
fun ScaffoldExample(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
    ){
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .height(400.dp)
                .padding(vertical = 12.dp, horizontal = 6.dp)
                .clip(RoundedCornerShape(8.dp))
                .background(MaterialTheme.colorScheme.surfaceVariant)
        ) {
            item {
                Text(
                    text = stringResource(id = R.string.scaffold_code)
                )
            }

        }

        ImageSection(imageId = R.drawable.scaffold_output)
    }
}
