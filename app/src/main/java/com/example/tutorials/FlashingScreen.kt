package com.example.tutorials

import android.view.animation.OvershootInterpolator
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.animateIntOffsetAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.tutorials.ui.theme.Cabin
import kotlin.math.roundToInt

@Composable
fun FlashingScreen(
    navController: NavController
) {
    val greetings by rememberLottieComposition(
        spec = LottieCompositionSpec.RawRes(resId = R.raw.lottie_animation)
    )
    val runningBus by rememberLottieComposition(
        spec = LottieCompositionSpec.RawRes(resId = R.raw.running_bus)
    )
    val scale = remember {
        Animatable(0f)
    }
    var moved by remember { mutableStateOf(false) }
    val pxToMove = with(LocalDensity.current) {
        300.dp.toPx().roundToInt()
    }

    val offset by animateIntOffsetAsState(
        targetValue = if (moved) {
            IntOffset(pxToMove, 0)
        } else {
            IntOffset.Zero
        },
        label = "offset"
    )

    LaunchedEffect(key1 = true) {
        scale.animateTo(
            targetValue = 1.5f,
            animationSpec = tween(
                durationMillis = 2000,
                easing = {
                    OvershootInterpolator(2f).getInterpolation(it)
                }
            )
        )
    }
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(horizontal = 32.dp).padding(top = 80.dp),
        horizontalAlignment = Alignment.Start,
    ) {
        item {
            LottieAnimation(
                modifier = Modifier
                    .size(180.dp)
                    .scale(scale.value),
                composition = greetings,
                iterations = LottieConstants.IterateForever,
                alignment = Alignment.TopStart,
                contentScale = ContentScale.Fit
            )
        }
        item {
            Text(
                text = buildAnnotatedString {
                    withStyle(
                        style = SpanStyle(
                            fontFamily = Cabin,
                            fontWeight = FontWeight.Normal,
                            fontSize = 22.sp,
                            color = MaterialTheme.colorScheme.onBackground
                        )
                    ) {
                        append("Hello ")
                    }
                    withStyle(
                        style = SpanStyle(
                            fontFamily = Cabin,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.onBackground,
                            fontSize = 22.sp
                        )
                    ) {
                        append(" User,")
                    }
                }
            )
            Text(
                text = stringResource(id = R.string.welcome_content),
                fontSize = 22.sp,
                fontFamily = Cabin,
                color = MaterialTheme.colorScheme.onBackground,
                textAlign = TextAlign.Start
            )
        }
        item {
            LottieAnimation(
                modifier = Modifier
                    .offset {
                        offset
                    }
                    .size(80.dp)
                    .padding(8.dp)
                    .scale(scale.value)
                    .clickable(
                        interactionSource = remember { MutableInteractionSource() },
                        indication = null
                    ) {
                        moved = !moved
                        navController.navigate(Screen.StartScreen.route)

                    },
                composition = runningBus,
                iterations = LottieConstants.IterateForever,
                alignment = Alignment.TopStart
            )
        }
    }
}

