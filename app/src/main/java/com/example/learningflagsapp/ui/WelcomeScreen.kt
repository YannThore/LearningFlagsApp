package com.example.learningflagsapp.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.text.input.TextFieldValue
import com.example.learningflagsapp.data.Flag
import com.example.learningflagsapp.data.FlagQuizQuestion

@Composable
fun WelcomeScreen(onStartQuiz: (String) -> Unit, onSkip: () -> Unit) {
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
            Button(onClick = { onStartQuiz(playerName.text) }) {
                Text(text = "Continue")
            }
            Spacer(modifier = Modifier.width(16.dp))
            Button(onClick = onSkip) {
                Text(text = "Skip")
            }
        }
    }
}



