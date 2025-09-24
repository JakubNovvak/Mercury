package com.example.mercury

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.mercury.ui.theme.MercuryTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    //Called, when the Activity is created
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GreetingPreview()
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    AppNavigation()
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MercuryTheme {
        Greeting("Android")
    }
}