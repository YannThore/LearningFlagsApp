package com.example.learningflagsapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.compose.AppTheme
import com.example.learningflagsapp.ui.FlagQuizApp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            MainContent(navController)
        }
    }
}

@Composable
fun MainContent(navController: NavHostController) {
    AppTheme {
        Surface(
            color = MaterialTheme.colorScheme.background
        ) {
            FlagQuizApp(navController)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewMainContent() {
    val navController = rememberNavController()
    MainContent(navController)
}