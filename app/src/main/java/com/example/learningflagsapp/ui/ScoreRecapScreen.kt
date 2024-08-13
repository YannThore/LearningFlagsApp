// app/src/main/java/com/example/learningflagsapp/ui/ScoreRecapScreen.kt
package com.example.learningflagsapp.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ScoreRecapScreen(score: Int, totalQuestions: Int, onRestartQuiz: () -> Unit) {
    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Your Score: $score / $totalQuestions")
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = onRestartQuiz) {
            Text(text = "Restart Quiz")
        }
    }
}