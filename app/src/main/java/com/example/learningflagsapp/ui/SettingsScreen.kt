package com.example.learningflagsapp.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun SettingsScreen(
    isDarkTheme: Boolean,
    onThemeChange: (Boolean) -> Unit,
    playerName: String,
    onPlayerNameChange: (String) -> Unit
) {
    var name by remember { mutableStateOf(playerName) }
    var darkTheme by remember { mutableStateOf(isDarkTheme) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(text = "Settings", style = MaterialTheme.typography.headlineMedium)

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = "Dark Theme")
            Switch(
                checked = darkTheme,
                onCheckedChange = {
                    darkTheme = it
                    onThemeChange(it)
                }
            )
        }

        OutlinedTextField(
            value = name,
            onValueChange = {
                name = it
                onPlayerNameChange(it)
            },
            label = { Text("Player Name") },
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewSettingsScreen() {
    SettingsScreen(
        isDarkTheme = false,
        onThemeChange = {},
        playerName = "John Doe",
        onPlayerNameChange = {}
    )
}