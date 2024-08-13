package com.example.learningflagsapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge

import androidx.compose.material3.MaterialTheme

import androidx.compose.material3.Surface

import androidx.compose.runtime.Composable

import androidx.compose.ui.tooling.preview.Preview
import com.example.learningflagsapp.ui.FlagListScreen
import com.example.learningflagsapp.ui.FlagQuizApp
import com.example.learningflagsapp.ui.FlagQuizScreen
import com.example.learningflagsapp.ui.theme.LearningFlagsAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LearningFlagsAppTheme {
                Surface(
                    color = MaterialTheme.colorScheme.background
                ) {
                    FlagQuizApp()
                }
            }
        }
    }
}


