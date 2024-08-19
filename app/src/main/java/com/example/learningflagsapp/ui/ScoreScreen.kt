package com.example.learningflagsapp.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun ScoreScreen(scores: List<Int>, paddingValues: PaddingValues) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Scores", style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(16.dp))
        LazyColumn {
            items(scores) { score ->
                Text(text = "Score: $score", style = MaterialTheme.typography.bodyLarge)
                Divider(modifier = Modifier.padding(vertical = 8.dp))
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewScoreScreen() {
    ScoreScreen(scores = listOf(100, 95, 90, 85), paddingValues = PaddingValues())
}