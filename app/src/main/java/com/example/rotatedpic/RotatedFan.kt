package com.example.rotatedpic

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun FanRotate(modifier: Modifier) {

    val iconColor = MaterialTheme.colorScheme.onBackground
    val paainter = painterResource(id =  R.drawable.pngtree_fanwithout_stand)

    var rotationCount by remember {
        mutableIntStateOf(0)
    }

    val rotationAngle by animateFloatAsState(
        targetValue = rotationCount * 360f,
        label = "",
        animationSpec = tween(1000)
    )

    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .padding(top = 80.dp)
        ) {
            Image(painter = paainter,
                contentDescription = null,
                colorFilter = ColorFilter.tint(iconColor),
                modifier = Modifier
                    .size(200.dp)
                    .graphicsLayer { rotationZ = rotationAngle }
            )
        }
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Row {
                ElevatedButton(
                    onClick = { rotationCount-- },
                    shape = (RoundedCornerShape(12.dp)),
                    elevation = ButtonDefaults.elevatedButtonElevation(25.dp),
                    colors = ButtonDefaults.elevatedButtonColors(Color(0xFFB8ED55))
                ) {
                    Text(
                        "Tap for left",
                        color = Color.Black
                    )
                }
                Spacer(modifier = Modifier.padding(35.dp))
                ElevatedButton(
                    onClick = { rotationCount++ },
                    shape = (RoundedCornerShape(12.dp)),
                    elevation = ButtonDefaults.elevatedButtonElevation(25.dp),
                    colors = ButtonDefaults.elevatedButtonColors(Color(0xFFB8ED55))
                ) {
                    Text(
                        "Tap for right",
                        color = Color.Black
                    )
                }
            }
        }
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun ShowFan() {
    FanRotate(modifier = Modifier.padding())
}
