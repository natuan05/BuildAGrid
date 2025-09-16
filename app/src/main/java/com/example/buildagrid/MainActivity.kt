package com.example.buildagrid

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.buildagrid.data.DataSource
import com.example.buildagrid.ui.CourseGrid
import com.example.buildagrid.ui.theme.BuildAGridTheme
import androidx.compose.runtime.Composable

@OptIn(ExperimentalMaterial3Api::class)
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BuildAGridTheme {
                Scaffold(
                    topBar = {
                        TopAppBar(
                            title = { Text("Courses") }
                        )
                    }
                ) { innerPadding ->
                    CourseGrid(
                        topics = DataSource.topics,
                        modifier = Modifier.padding(innerPadding) // ✅ tránh đè status bar
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun CourseGridPreview() {
    BuildAGridTheme {
        CourseGrid(topics = DataSource.topics)
    }
}
