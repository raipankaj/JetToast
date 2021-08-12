package com.ui.toast

import android.util.Log
import androidx.compose.animation.*
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.painter.BitmapPainter
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.ui.toast.utils.ToastDelay
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun Toast(
    message: String,
    showToast: Boolean, afterToastShown: (Boolean) -> Unit,
    toastDelay: ToastDelay = ToastDelay.ShortDelay,
    shape: Shape = CircleShape,
    background: Color = Color.Gray,
    textColor: Color = Color.White,
    alignment: Alignment = Alignment.BottomCenter,
    fillMaxWidth: Boolean = false,
    leadingIconSpace: Dp = 0.dp,
    trailingIconSpace: Dp = 0.dp,
    disableAutoHide: Boolean = false,
    leadingContent: (@Composable () -> Unit)? = null,
    trailingContent: (@Composable () -> Unit)? = null,
    enter: EnterTransition = fadeIn(animationSpec = tween(500, easing = LinearEasing)),
    exit: ExitTransition = fadeOut(animationSpec = tween(500, easing = LinearEasing)),
) {

    LaunchedEffect(key1 = showToast) {
        launch {
            delay(toastDelay.duration)
            if (disableAutoHide.not())
                afterToastShown(false)
        }
    }

    AnimatedVisibility(visible = showToast, enter = enter, exit = exit) {

        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = alignment
        ) {
            val modifier =
                if (fillMaxWidth) {
                    Modifier.fillMaxWidth()
                } else {
                    Modifier.wrapContentWidth()
                }
                    .clip(shape)
                    .background(background)
                    .padding(start = 24.dp, end = 24.dp, top = 12.dp, bottom = 12.dp)

            Row(
                modifier = modifier,
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = if (disableAutoHide) Arrangement.SpaceBetween else Arrangement.Center
            ) {

                val textModifier = if (fillMaxWidth) {
                    Modifier.weight(1f)
                } else {
                    Modifier.wrapContentWidth()
                }

                if (leadingContent != null) {
                    leadingContent.invoke()
                    Spacer(modifier = Modifier.padding(leadingIconSpace))
                }

                Text(
                    text = message,
                    textAlign = TextAlign.Start,
                    color = textColor,
                    modifier = textModifier,
                    overflow = TextOverflow.Ellipsis,
                )

                if (trailingContent != null) {
                    Spacer(modifier = Modifier.padding(trailingIconSpace))
                    trailingContent.invoke()
                }
            }
        }
    }
}