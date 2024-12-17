package com.example.jobposting.ui.component.progressIndicator

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.jobposting.R
import com.example.jobposting.ui.theme.White

@Composable
fun JobProgressIndicator(modifier: Modifier = Modifier) {
    val preloaderLottieComposition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.lottie_animation))

    val preloaderProgress by animateLottieCompositionAsState(
        preloaderLottieComposition,
        iterations = LottieConstants.IterateForever,
        isPlaying = true
    )

    Box(modifier = modifier.fillMaxSize(), contentAlignment = Alignment.Center) {

        Box(
            modifier = modifier
                .height(200.dp)
                .width(200.dp)
                .clip(RoundedCornerShape(12.dp))
                .background(color = White.copy(alpha = 0.8f)), contentAlignment = Alignment.Center,
        ) {
            LottieAnimation(
                composition = preloaderLottieComposition,
                progress = preloaderProgress,
                modifier = modifier.size(200.dp)
            )
        }

    }
}

@Preview
@Composable
private fun JobProgressIndicatorPreview() {
    JobProgressIndicator()
}