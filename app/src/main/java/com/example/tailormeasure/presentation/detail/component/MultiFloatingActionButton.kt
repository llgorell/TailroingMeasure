package com.example.tailormeasure.presentation.detail.component

import androidx.compose.animation.core.animateDp
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.tween
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.unit.dp

@Composable
fun MultiFloatingActionButton(
    multiFloatingState: MultiFloatingState,
    onMultiFabStateChange: (MultiFloatingState) -> Unit,
    items: List<MainFabItem>,
    onClickFab : (MainFabItem)  -> Unit
) {

    val transition = updateTransition(targetState = multiFloatingState, label = "transition")
    val rotate = transition.animateFloat(label = "rotate") {
        if (it == MultiFloatingState.EXPANDABLE) 315f else 0f
    }

    val fabScale = transition.animateFloat(label = "fabScale") {
        if (it == MultiFloatingState.EXPANDABLE) 42f else 0f
    }

    val alpha = transition.animateFloat(
        label = "alpha",
        transitionSpec = { tween(durationMillis = 50) }) {
        if (it == MultiFloatingState.EXPANDABLE) 1f else 0f
    }

    val textShadow = transition.animateDp(
        label = "textShadow",
        transitionSpec = { tween(durationMillis = 50) }) {
        if (it == MultiFloatingState.EXPANDABLE) 4.dp else 0.dp
    }
    Column(
        horizontalAlignment = Alignment.End

    ) {
        if (transition.currentState == MultiFloatingState.EXPANDABLE) {
            items.forEach {
                MainFab(
                    item = it,
                    onMainFabItemClick = {
                                        onClickFab(it)
                    },
                    alpha = alpha.value,
                    textShadow = textShadow.value,
                    fabScale = fabScale.value,
                    shadowLabel = true
                )
                Spacer(modifier = Modifier.size(16.dp))
            }
        }
        FloatingActionButton(
            onClick = {
                onMultiFabStateChange(
                    if (transition.currentState == MultiFloatingState.EXPANDABLE) {
                        MultiFloatingState.COLLAPSED
                    } else {
                        MultiFloatingState.EXPANDABLE
                    }
                )
            },

            ) {
            Icon(
                imageVector = Icons.Default.Add,
                contentDescription = null,
                modifier = Modifier.rotate(rotate.value))
        }
    }
}