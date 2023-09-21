package com.example.tutorials.text

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tutorials.ui.theme.TutorialsTheme

@Composable
fun TextExample(
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier
    ) {

    }

}


@Preview(showSystemUi = true)
@Composable
fun DefaultTextScreen() {
    TutorialsTheme {

    }
}

