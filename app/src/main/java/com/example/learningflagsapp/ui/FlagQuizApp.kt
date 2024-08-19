// FlagQuizApp.kt
package com.example.learningflagsapp.ui

import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.compose.AppTheme
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun FlagQuizApp(navController: NavHostController) {
    var playerName by remember { mutableStateOf("") }
    var isDarkTheme by remember { mutableStateOf(false) }

    AppTheme(darkTheme = isDarkTheme) {
        NavHost(navController = navController, startDestination = "welcome") {
            composable("welcome") {
                WelcomeScreen(
                    onStartQuiz = { name ->
                        playerName = name
                        navController.navigate("home")
                    },
                    onSkip = { navController.navigate("home") }
                )
            }
            composable("home") {
                MainScaffold(
                    navController = navController,
                    playerName = playerName,
                    isDarkTheme = isDarkTheme,
                    onThemeChange = { isDarkTheme = it }
                ) { paddingValues ->
                    HomeScreen(
                        onStartQuiz = { navController.navigate("quiz") },
                        paddingValues = paddingValues
                    )
                }
            }
            composable("quiz") {
                MainScaffold(
                    navController = navController,
                    playerName = playerName,
                    isDarkTheme = isDarkTheme,
                    onThemeChange = { isDarkTheme = it }
                ) { paddingValues ->
                    FlagQuizScreen(
                        onRestartQuiz = { navController.navigate("home") },
                        paddingValues = paddingValues
                    )
                }
            }
            composable("settings") {
                MainScaffold(
                    navController = navController,
                    playerName = playerName,
                    isDarkTheme = isDarkTheme,
                    onThemeChange = { isDarkTheme = it }
                ) { paddingValues ->
                    SettingsScreen(
                        navController = navController,
                        isDarkTheme = isDarkTheme,
                        onThemeChange = { isDarkTheme = it },
                        playerName = playerName,
                        onPlayerNameChange = { playerName = it },
                        paddingValues = paddingValues
                    )
                }
            }
            composable("scores") {
                MainScaffold(
                    navController = navController,
                    playerName = playerName,
                    isDarkTheme = isDarkTheme,
                    onThemeChange = { isDarkTheme = it }
                ) { paddingValues ->
                    ScoreScreen(
                        scores = listOf(100, 95, 90, 85), // Replace with actual scores
                        paddingValues = paddingValues
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewFlagQuizApp() {
    val navController = rememberNavController()
    FlagQuizApp(navController)
}