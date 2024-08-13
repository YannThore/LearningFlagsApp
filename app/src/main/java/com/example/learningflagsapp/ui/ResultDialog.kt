// ResultDialog.kt
package com.example.learningflagsapp.ui

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun ResultDialog(isCorrect: Boolean, onNextQuestion: () -> Unit, onDismissRequest: () -> Unit) {
    AlertDialog(
        onDismissRequest = onDismissRequest,
        title = {
            Text(text = if (isCorrect) "Correct!" else "Incorrect!")
        },
        text = {
            Text(text = if (isCorrect) "You got it right!" else "Try again next time.")
        },
        confirmButton = {
            Button(onClick = {
                onNextQuestion()
                onDismissRequest() // Ensure the dialog closes immediately
            }) {
                Text("Next")
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun PreviewResultDialog() {
    ResultDialog(isCorrect = true, onNextQuestion = {}, onDismissRequest = {})
}