package com.siarheikrupenich.testrepo.presentation.ui

import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.EaseInOutQuad
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.tooling.preview.Preview
import com.siarheikrupenich.testrepo.style.Colors
import com.siarheikrupenich.testrepo.style.Size
import com.siarheikrupenich.testrepo.style.UiConstants.Companion.ANIMATION_DRAW_WIDTH
import com.siarheikrupenich.testrepo.style.UiConstants.Companion.ANIMATION_DURATION
import com.siarheikrupenich.testrepo.style.UiConstants.Companion.ANIMATION_RADIUS_K
import com.siarheikrupenich.testrepo.style.UiConstants.Companion.INDICATOR_ANIMATION_INITIAL
import com.siarheikrupenich.testrepo.style.UiConstants.Companion.INDICATOR_TARGET

@Composable
internal fun LoadingState(modifier: Modifier = Modifier) {
    val infiniteTransition = rememberInfiniteTransition(label = "")
    val pulse by infiniteTransition.animateFloat(
        initialValue = INDICATOR_ANIMATION_INITIAL,
        targetValue = INDICATOR_TARGET,
        animationSpec = infiniteRepeatable(
            animation = tween(ANIMATION_DURATION, easing = EaseInOutQuad),
            repeatMode = RepeatMode.Reverse
        ), label = ""
    )

    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.surface)
    ) {
        Canvas(modifier = Modifier.size(Size.loadingCanvas)) {
            drawCircle(
                color = Colors.loaderCanvasColor,
                radius = size.minDimension / ANIMATION_RADIUS_K * pulse,
                style = Stroke(width = ANIMATION_DRAW_WIDTH)
            )
        }
        CircularProgressIndicator(
            color = MaterialTheme.colors.primary,
            strokeWidth = Size.circularProgressWidth,
            modifier = Modifier.size(Size.circularProgressIndicatorSize)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewLoadingState() {
    LoadingState()
}
