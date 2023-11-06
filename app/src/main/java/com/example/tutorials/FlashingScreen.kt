package com.example.tutorials

import android.view.animation.OvershootInterpolator
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.tutorials.ui.theme.Cabin
import kotlinx.coroutines.delay

@Composable
fun FlashingScreen(
    navController: NavController
) {
    val composition by rememberLottieComposition(
        spec = LottieCompositionSpec.RawRes(resId = R.raw.lottie_animation)
    )

    val scale = remember {
        Animatable(0f)
    }

    val visible by remember {
        mutableStateOf(false)
    }
    LaunchedEffect(key1 = true) {
        scale.animateTo(
            targetValue = 0.5f,
            animationSpec = tween(
                durationMillis = 500,
                easing = {
                    OvershootInterpolator(2f).getInterpolation(it)
                }
            )
        )
        delay(2000)
        navController.navigate(Screen.StartScreen.route)
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        LottieAnimation(
            modifier = Modifier
                .size(size = 240.dp)
                .scale(scale.value),
            composition = composition,
            iterations = LottieConstants.IterateForever
        )
        AnimatedVisibility(
            visible = visible,
            enter = fadeIn(
                animationSpec = tween(
                    delayMillis = 2000,
                    easing = LinearEasing
                )
            )
        ) {
            Box(
                modifier = Modifier.fillMaxWidth()
            ) {
                buildAnnotatedString {
                    withStyle(
                        style = SpanStyle(
                            fontFamily = Cabin,
                            fontWeight = FontWeight.Normal,
                            fontSize = 26.sp,
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
                            fontSize = 26.sp
                        )
                    ) {
                        append(" User,")
                    }
                }
                Spacer(modifier = Modifier.height(12.dp))
                Text(
                    text = stringResource(id = R.string.welcome_content),
                    fontSize = 22.sp,
                    fontFamily = Cabin,
                    color = MaterialTheme.colorScheme.onBackground

                )
            }
        }

    }
}

