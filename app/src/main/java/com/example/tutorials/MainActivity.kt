package com.example.tutorials

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.MutableTransitionState
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
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
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.tutorials.composables.ComposableScreen
import com.example.tutorials.data.ListItem
import com.example.tutorials.data.listItems
import com.example.tutorials.image.ImageScreen
import com.example.tutorials.progressbar.ProgressBarScreen
import com.example.tutorials.scaffold.ScaffoldScreen
import com.example.tutorials.text.TextScreen
import com.example.tutorials.textField.TextFieldScreen
import com.example.tutorials.ui.theme.TutorialsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TutorialsTheme {
                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = Screen.StartScreen.route
                ) {
                    composable(Screen.StartScreen.route) {
                        TutorialApp(navController = navController)
                    }
                    composable(
                        Screen.TextScreen.route
                    ) {
                        TextScreen()
                    }
                    composable(
                        Screen.ComposableScreen.route
                    ) {
                        ComposableScreen()
                    }
                    composable(
                        Screen.ImageScreen.route
                    ) {
                        ImageScreen()
                    }
                    composable(
                        Screen.ProgressbarScreen.route
                    ) {
                        ProgressBarScreen()
                    }
                    composable(
                        Screen.ScaffoldScreen.route
                    ) {
                        ScaffoldScreen()
                    }
                    composable(
                        Screen.TextFieldScreen.route
                    ) {
                        TextFieldScreen()
                    }

                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TutorialApp(
    navController: NavController
) {
    val items = listItems
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = stringResource(id = R.string.app_name),
                        style = MaterialTheme.typography.displayLarge,
                        modifier = Modifier.padding(start = 14.dp)
                    )
                }
            )
        }
    ) {
        MainScreen(items = items , contentPadding = it, navController = navController)
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
fun MainScreen(
    modifier: Modifier = Modifier,
    items: List<ListItem>,
    contentPadding: PaddingValues = PaddingValues(0.dp),
    navController: NavController
) {
    val visibleState = remember {
        MutableTransitionState(false).apply {
            targetState = true
        }
    }
    AnimatedVisibility(
        visibleState = visibleState,
        enter = fadeIn(
            animationSpec = spring(dampingRatio = Spring.DampingRatioLowBouncy)
        ),
        exit = fadeOut(),
        modifier = modifier
    ) {
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            contentPadding = contentPadding
        ) {
            items(items) {listItem ->
                ListElement(item = listItem, onItemClick = {
                    when(it) {
                        1 -> navController.navigate(Screen.ComposableScreen.route)
                        2 -> navController.navigate(Screen.TextScreen.route)
                        3 -> navController.navigate(Screen.TextFieldScreen.route)
                        4 -> navController.navigate(Screen.ButtonScreen.route)
                        5 -> navController.navigate(Screen.ImageScreen.route)
                        6 -> navController.navigate(Screen.ProgressbarScreen.route)
                        7 -> navController.navigate(Screen.ScaffoldScreen.route)
                    }
                })
            }
        }
    }
}

@Preview(showSystemUi = false)
@Composable
fun DefaultPreview() {
    TutorialApp(rememberNavController())
}

