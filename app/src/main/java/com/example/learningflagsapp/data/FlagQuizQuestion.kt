package com.example.learningflagsapp.data
import android.content.Context

data class FlagQuizQuestion(
    val options: List<String>,
    val correctAnswer: Flag
)



// Update generateFlagQuizQuestions function
fun generateFlagQuizQuestions(context: Context, flags: List<Flag>): List<FlagQuizQuestion> {
    val questions = mutableListOf<FlagQuizQuestion>()
    val shuffledFlags = flags.shuffled()

    for (flag in shuffledFlags) {
        val correctAnswer = flag
        val incorrectOptions = flags.filter { it.countryName != correctAnswer.countryName }.shuffled().take(3).map { it.countryName }
        val options = (incorrectOptions + correctAnswer.countryName).shuffled()
        questions.add(FlagQuizQuestion(options, correctAnswer))
    }

    return questions
}