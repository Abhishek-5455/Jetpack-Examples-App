package com.example.tutorials.common_ui

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.ui.unit.dp
import com.example.tutorials.text.ScreenItem

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