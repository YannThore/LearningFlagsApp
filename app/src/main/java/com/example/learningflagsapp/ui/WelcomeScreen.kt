package com.example.learningflagsapp.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.text.input.TextFieldValue
import com.example.compose.AppTheme

@Composable
fun WelcomeScreen(
    onStartQuiz: (String) -> Unit,
    onSkip: () -> Unit,
    darkTheme: Boolean
) {
    AppTheme(darkTheme = darkTheme) {
        WelcomeScreenContent(onStartQuiz = onStartQuiz, onSkip = onSkip)
    }

}

@Composable
fun WelcomeScreenContent(onStartQuiz: (String) -> Unit, onSkip: () -> Unit) {
    var playerName by remember { mutableStateOf(TextFieldValue("")) }

    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Welcome to the Flag Quiz!", style = MaterialTheme.typography.headlineSmall)
        Spacer(modifier = Modifier.height(16.dp))
        TextField(
            value = playerName,
            onValueChange = { playerName = it },
            label = { Text("Enter your name") }
        )
        Spacer(modifier = Modifier.height(16.dp))
        Row {
            Button(
                onClick = { onStartQuiz(playerName.text) },
                enabled = playerName.text.isNotEmpty()
            ) {
                Text(text = "Continue")
            }
            Spacer(modifier = Modifier.width(16.dp))
            Button(onClick = onSkip) {
                Text(text = "Skip")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewWelcomeScreenContent() {
    WelcomeScreen(onStartQuiz = {}, onSkip = {}, darkTheme = false)
}