package com.example.tutorials

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.MutableTransitionState
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.tutorials.common_ui.StartingScreenAnimation
import com.example.tutorials.data.ListItem
import com.example.tutorials.data.listItems
import com.example.tutorials.ui.theme.TutorialsTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TutorialsTheme {
                val navController = rememberNavController()

                val windowSize = calculateWindowSizeClass(activity = this)

                TutorialApp(navController = navController, windowSize = windowSize.widthSizeClass)
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(
    navController: NavController,
    windowSize: WindowWidthSizeClass
) {
    val gridCells = if(windowSize == WindowWidthSizeClass.Compact) 2 else 3
    val items = listItems
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            Column {
                CenterAlignedTopAppBar(
                    title = {
                        Text(
                            text = "Jet Tutorials",
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
        MainScreenContent(
            items = items,
            contentPadding = it,
            navController = navController,
            gridCells = gridCells
        )
    }
}

@Composable
fun ListElement(
    item: ListItem,
    onItemClick: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        shape = RoundedCornerShape(15),
        elevation = CardDefaults.cardElevation(defaultElevation = 32.dp),
        modifier = modifier
            .padding(16.dp)
            .sizeIn(minHeight = 160.dp)
            .clickable {
                onItemClick(item.itemId)
            }
    ) {
        Box (
            modifier = Modifier.fillMaxSize()
        ){
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .padding(top = 28.dp)
                    .align(Alignment.Center)
            ) {
                Icon(painter = painterResource(
                    id = item.iconId),
                    contentDescription = item.text,
                    tint = MaterialTheme.colorScheme.onSurface,
                    modifier = Modifier
                        .size(36.dp)
                )
                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = item.text,
                    style = MaterialTheme.typography.displaySmall,
                    color = MaterialTheme.colorScheme.onSurface
                )
            }
        }
    }
}

@Composable
fun MainScreenContent(
    modifier: Modifier = Modifier,
    items: List<ListItem>,
    contentPadding: PaddingValues = PaddingValues(0.dp),
    navController: NavController,
    gridCells: Int
) {
    val visibleState = remember {
        MutableTransitionState(false).apply {
            targetState = true
        }
    }
    StartingScreenAnimation(visibleState = visibleState) {
        LazyVerticalGrid(
            columns = GridCells.Fixed(gridCells),
            contentPadding = contentPadding,
            modifier = modifier
        ) {
            items(items) {listItem ->
                ListElement(item = listItem, onItemClick = {
                    when(it) {
                        1 -> navController.navigate(Screen.LayoutScreen.route)
                        2 -> navController.navigate(Screen.ComposableScreen.route)
                        6 -> navController.navigate(Screen.ProgressbarScreen.route)
                        7 -> navController.navigate(Screen.ScaffoldScreen.route)
                    }
                })
            }
        }
    }
}

