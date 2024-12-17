package com.example.jobposting

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.jobposting.ui.component.text.JobText
import com.example.jobposting.ui.scene.login.LoginScene
import com.example.jobposting.ui.theme.JobPostingTheme
import com.example.jobposting.ui.theme.customTypography
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MaterialTheme {
                JobPostingTheme {
                    LoginScene(modifier = Modifier)
                }
            }

        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Column(modifier = modifier.fillMaxSize(), verticalArrangement = Arrangement.Center) {
        Text("Merhaba Kubilay", style = customTypography.bodyLarge)
        JobText(text = "Merhaba Kubilay")
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    JobPostingTheme {
        Greeting("Android")
    }
}