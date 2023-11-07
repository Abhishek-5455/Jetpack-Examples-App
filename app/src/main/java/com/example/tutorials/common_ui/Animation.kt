package com.example.tutorials.common_ui

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.MutableTransitionState
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun StartingScreenAnimation(
    visibleState: MutableTransitionState<Boolean>,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    AnimatedVisibility(
        visibleState = visibleState,
        enter = fadeIn(
            animationSpec = tween(delayMillis = 2000, easing = LinearEasing)
        ),
        exit = fadeOut(
            animationSpec = tween(delayMillis = 2000, easing = LinearEasing)
        ),
        modifier = modifier
    ) {
        content()
    }
}