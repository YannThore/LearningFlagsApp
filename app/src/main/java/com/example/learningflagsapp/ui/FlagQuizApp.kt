// app/src/main/java/com/example/learningflagsapp/ui/FlagQuizApp.kt
package com.example.learningflagsapp.ui

import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview
import com.example.compose.AppTheme

@Composable
fun FlagQuizApp() {
    var currentScreen by remember { mutableStateOf("welcome") }
    var playerName by remember { mutableStateOf("") }
    var isDarkTheme by remember { mutableStateOf(false) }

    AppTheme(darkTheme = isDarkTheme) {
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
                onStartQuiz = { currentScreen = "quiz" },
                isDarkTheme = isDarkTheme,
                onThemeChange = { isDarkTheme = it }
            )
            "quiz" -> FlagQuizScreen(
                onRestartQuiz = { currentScreen = "home" }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewFlagQuizApp() {
    FlagQuizApp()
}