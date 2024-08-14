package com.example.learningflagsapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.compose.AppTheme
import com.example.learningflagsapp.ui.FlagListScreen
import com.example.learningflagsapp.ui.FlagQuizApp
import com.example.learningflagsapp.ui.FlagQuizScreen


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MainContent()
        }
    }
}

@Composable
fun MainContent() {
    AppTheme {
        Surface(
            color = MaterialTheme.colorScheme.background
        ) {
            FlagQuizApp()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewMainContent() {
    MainContent()
}