package com.example.learningflagsapp.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.learningflagsapp.data.Flag
import com.example.learningflagsapp.data.FlagQuizQuestion

@Composable
fun FlagQuiz(question: FlagQuizQuestion, onAnswerChecked: (Boolean) -> Unit) {
    var selectedOption by remember { mutableStateOf<String?>(null) }
    var isCorrect by remember { mutableStateOf<Boolean?>(null) }


    Column(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)) {
        FlagItem(Flag(question.correctAnswer.countryName, question.correctAnswer.countryCode, 0))

        Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
            Text(text = "Which country's flag is this?", style = MaterialTheme.typography.headlineSmall, modifier = Modifier.padding(16.dp))
        }

        Spacer(modifier = Modifier.height(16.dp))

        Column(modifier = Modifier.fillMaxWidth()) {
            question.options.forEach { option ->
                Button(
                    onClick = { selectedOption = option },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = if (selectedOption == option) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.secondary
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                ) {
                    Text(text = option, modifier = Modifier.padding(start = 8.dp))
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
            Button(onClick = {
                isCorrect = selectedOption == question.correctAnswer.countryName
                onAnswerChecked(isCorrect == true)
            }) {
                Text(text = "Submit")
            }
        }


    }

}

@Preview(showBackground = true)
@Composable
fun PreviewFlagQuiz() {
    FlagQuiz(
        FlagQuizQuestion(listOf("France", "Germany", "Italy", "Spain"), Flag("France", "flag_fr", 0)),
        onAnswerChecked = {}
    )
}