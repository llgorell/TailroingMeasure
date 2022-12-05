package com.example.tailormeasure.presentation.detail.component

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun MainFab(
    item : MainFabItem,
    onMainFabItemClick : (MainFabItem) -> Unit,
    alpha : Float,
    textShadow : Dp,
    fabScale : Float,
    shadowLabel : Boolean = true
) {
    val buttonColor = MaterialTheme.colors.onSurface
    val shadow = Color.Black.copy(.5f)
   Row() {
       if (shadowLabel){
           Text(
               text = item.label,
               fontSize = 12.sp,
               fontWeight = FontWeight.Bold,
               modifier = Modifier
                   .alpha(
                       animateFloatAsState(
                           targetValue = alpha,
                           animationSpec = tween(durationMillis = 50)).value
                   )
                   .shadow(textShadow)
                   .background(MaterialTheme.colors.surface)
                   .padding(start = 6.dp, end = 6.dp, top = 4.dp)

           )
       }
       Spacer(modifier = Modifier.size(16.dp))
       Canvas(
           modifier = Modifier
               .size(32.dp)
               .clickable(
                   interactionSource = MutableInteractionSource(),
                   onClick = { onMainFabItemClick.invoke(item) },
                   indication = null

               ) ){
           drawCircle(
               color = shadow,
               radius = fabScale,
               center = Offset(
                   center.x + 2f,
                   center.x + 2f
               )
           )
           drawCircle(
               color = buttonColor,
               radius = fabScale
           )

           drawImage(
               image = item.icon,
               topLeft = Offset(
                   center.x - (item.icon.width / 2),
                   center.y - (item.icon.width / 2),
               )
               ,
               alpha = alpha
           )

       }
   }
}