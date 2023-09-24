package com.example.tutorials.common_ui

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowDropDown
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
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
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tutorials.text.ScreenItem
import com.example.tutorials.ui.theme.Cabin

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenElement(
    item: ScreenItem,
    modifier: Modifier = Modifier,
    expandedContent: @Composable () -> Unit
) {
    var isExpanded by remember { mutableStateOf(false) }
    val rotate by animateFloatAsState(
        targetValue = if (isExpanded) 180f else 0f, label = ""
    )

    Card(
        shape = RoundedCornerShape(15.dp),
        modifier = modifier
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .sizeIn(minHeight = 58.dp)
            .animateContentSize(
                animationSpec = spring(
                    dampingRatio = Spring.DampingRatioMediumBouncy,
                    stiffness = Spring.StiffnessLow
                )
            ),
        onClick = { isExpanded = !isExpanded },
        elevation = CardDefaults.elevatedCardElevation(
            defaultElevation = 2.dp,
            pressedElevation = 4.dp
        )
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
            if (isExpanded) {
                expandedContent()
            }
        }
    }
}


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
        Image(
            painter = painterResource(id = imageId),
            contentDescription = null,
            contentScale = ContentScale.Fit,
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