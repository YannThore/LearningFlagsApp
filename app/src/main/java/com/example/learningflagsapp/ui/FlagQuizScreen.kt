package com.example.learningflagsapp.ui

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.learningflagsapp.data.generateFlagQuizQuestions
import com.example.learningflagsapp.data.getFlags

@Composable
fun FlagQuizScreen(totalQuestions: Int = 10, onRestartQuiz: () -> Unit, paddingValues: PaddingValues) {
    val context = LocalContext.current
    val questions = remember { generateFlagQuizQuestions(context, getFlags(context)) }
    var currentQuestionIndex by remember { mutableStateOf(0) }
    var score by remember { mutableStateOf(0) }
    var showScoreRecap by remember { mutableStateOf(false) }
    var isCorrect by remember { mutableStateOf<Boolean?>(null) }
    var showResult by remember { mutableStateOf(false) }

    val progress by animateFloatAsState(
        targetValue = (currentQuestionIndex + 1) / totalQuestions.toFloat(),
        animationSpec = tween(durationMillis = 500)
    )

    if (showScoreRecap) {
        ScoreRecapScreen(score = score, totalQuestions = totalQuestions, onRestartQuiz = onRestartQuiz)
    } else {
        ElevatedCard(
            elevation = CardDefaults.cardElevation(6.dp),
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp)
        ) {
            Column {
                LinearProgressIndicator(
                    progress = progress,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                )

                FlagQuiz(
                    question = questions[currentQuestionIndex],
                    onAnswerChecked = { correct ->
                        isCorrect = correct
                        showResult = true
                    }
                )

                Spacer(modifier = Modifier.height(16.dp))

                if (showResult) {
                    ResultDialog(isCorrect = isCorrect == true, onNextQuestion = {
                        if (currentQuestionIndex < totalQuestions - 1) {
                            if (isCorrect == true) score++
                            currentQuestionIndex++
                            isCorrect = null
                            showResult = false
                        } else {
                            if (isCorrect == true) score++
                            showScoreRecap = true
                        }
                    }, onDismissRequest = { showResult = false })
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewFlagQuizScreen() {
    FlagQuizScreen(onRestartQuiz = {}, paddingValues = PaddingValues())
}