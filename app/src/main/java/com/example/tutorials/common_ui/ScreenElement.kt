package com.example.tutorials.common_ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tutorials.ui.theme.Cabin
import me.rerere.zoomableimage.ZoomableImage

@Composable
fun ImageSection(
    modifier: Modifier = Modifier,
    imageId: Int
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        ZoomableImage(
            painter = painterResource(id = imageId),
            contentDescription = null,
            modifier = Modifier.align(Alignment.Center)
        )
    }
}

@Composable
fun Heading(
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
fun SubHeading(
    heading: String,
    content: String
) {
    Text(
        text = buildAnnotatedString {
            withStyle(
                style = SpanStyle(
                    fontFamily = Cabin,
                    fontSize = 22.sp,
                    fontWeight = FontWeight.SemiBold,
                    textDecoration = TextDecoration.Underline,
                    fontStyle = FontStyle.Italic
                )
            ) {
                append(heading)
            }
            withStyle(
                style = SpanStyle(
                    fontFamily = Cabin,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.SemiBold
                )
            ) {
                append(content)
            }
        }
    )
}

@Composable
fun SubPoint(
    heading: String,
    content: String
) {
    Text(
        text = buildAnnotatedString {
            withStyle(
                style = SpanStyle(
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    background = MaterialTheme.colorScheme.secondary,
                    fontFamily = Cabin,
                    color = MaterialTheme.colorScheme.onSecondary
                )
            ) {
                append(heading)
            }
            withStyle(
                style = SpanStyle(
                    fontFamily = Cabin,
                    fontSize = 18.sp
                )
            ) {
                append(content)
            }
        },
        modifier = Modifier.padding(start = 16.dp)
    )
}