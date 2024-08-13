// app/src/main/java/com/example/learningflagsapp/ui/FlagQuizApp.kt
package com.example.learningflagsapp.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun FlagQuizApp() {
    var currentScreen by remember { mutableStateOf("welcome") }
    var playerName by remember { mutableStateOf("") }

    when (currentScreen) {
        "welcome" -> WelcomeScreen(
            onStartQuiz = { name ->
                playerName = name
                currentScreen = "home"
            },
            onSkip = { currentScreen = "home" }
        )
        "home" -> HomeScreen(
            playerName = playerName,
            onStartQuiz = { currentScreen = "quiz" }
        )
        "quiz" -> FlagQuizScreen(
            onRestartQuiz = { currentScreen = "home" }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewFlagQuizApp() {
    FlagQuizApp()
}