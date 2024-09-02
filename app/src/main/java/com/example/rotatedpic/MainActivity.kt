package com.example.rotatedpic

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.example.rotatedpic.ui.theme.RotatedPicTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RotatedPicTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    FanRotate(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}
