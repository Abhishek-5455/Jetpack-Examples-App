package com.example.tutorials.text

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tutorials.ui.theme.TutorialsTheme

@Composable
fun TextExample(
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier
        .fillMaxSize()
        .padding(16.dp)
    ) {
        Text(
            text = "Text with large size",
            fontSize = 30.sp
        )
        Text(
            text = "Text with small size",
            fontSize = 14.sp
        )

        Text(
            text = "Text with red color",
            color = Color.Red
        )
        Text(
            text = "Text with green color",
            color = Color.Green
        )

        Text(
            text = "Bold text",
            fontWeight = FontWeight.Bold
        )

        Text(
            text = "Italic text",
            fontStyle = FontStyle.Italic
        )
        Text(
            text = "Long Text".repeat(30),
            maxLines = 2
        )
        Text(
            text = "Text Overflow".repeat(30),
            maxLines = 2,
            overflow = TextOverflow.Ellipsis
        )
    }
}


@Preview(showSystemUi = true)
@Composable
fun DefaultTextScreen() {
    TutorialsTheme {
        TextExample()
    }
}

