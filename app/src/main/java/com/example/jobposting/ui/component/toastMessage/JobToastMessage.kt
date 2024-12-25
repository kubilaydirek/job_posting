package com.example.jobposting.ui.component.toastMessage

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import com.example.jobposting.data.helpers.ToastMessageType
import com.example.jobposting.ui.component.text.JobText
import kotlinx.coroutines.delay

@Composable
fun JobToastMessage(
    modifier: Modifier = Modifier,
    isVisible: Boolean = false,
    message: String? = null,
    toastType: ToastMessageType
) {
    var visible by remember { mutableStateOf(isVisible) }
    val density = LocalDensity.current

    LaunchedEffect(Unit) {
        delay(4000)
        visible = false
    }

    AnimatedVisibility(
        visible = visible,
        enter = slideInVertically {
            with(density) { -140.dp.roundToPx() }
        } + expandVertically(
            expandFrom = Alignment.Top
        ) + fadeIn(
            initialAlpha = 0.1f
        ),
        exit = slideOutVertically() + shrinkVertically() + fadeOut()

    ) {
        Box(
            modifier = modifier
                .fillMaxWidth()
                .padding(horizontal = 15.dp, vertical = 30.dp)
                .height(75.dp)
                .clip(RoundedCornerShape(16.dp))
                .background(color = toastType.color.copy(alpha = 0.8f))
                .padding(12.dp),
            contentAlignment = Alignment.Center
        ) {
            JobText(text = message ?: "")
        }
    }
}