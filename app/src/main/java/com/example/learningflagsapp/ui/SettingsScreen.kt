package com.example.learningflagsapp.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun SettingsScreen(
    navController: NavController,
    isDarkTheme: Boolean,
    onThemeChange: (Boolean) -> Unit,
    playerName: String,
    onPlayerNameChange: (String) -> Unit,
    paddingValues: PaddingValues
) {
    var name by remember { mutableStateOf(playerName) }
    var darkTheme by remember { mutableStateOf(isDarkTheme) }
    var isEditing by remember { mutableStateOf(false) }
    var tempName by remember { mutableStateOf(playerName) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues),
        verticalArrangement = Arrangement.Top
    ) {
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
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            if (isEditing) {
                OutlinedTextField(
                    value = tempName,
                    onValueChange = { tempName = it },
                    label = { Text("Player Name") },
                    modifier = Modifier.weight(1f)
                )
                IconButton(onClick = {
                    name = tempName
                    onPlayerNameChange(tempName)
                    isEditing = false
                }) {
                    Icon(imageVector = Icons.Filled.Check, contentDescription = "Validate")
                }
                IconButton(onClick = {
                    tempName = name
                    isEditing = false
                }) {
                    Icon(imageVector = Icons.Filled.Close, contentDescription = "Cancel")
                }
            } else {
                Text(text = name, modifier = Modifier.weight(1f))
                IconButton(onClick = { isEditing = true }) {
                    Icon(imageVector = Icons.Filled.Edit, contentDescription = "Edit")
                }
            }
        }

    }
}

@Preview(showBackground = true)
@Composable
fun PreviewSettingsScreen() {
    val navController = rememberNavController()
    SettingsScreen(
        navController = navController,
        isDarkTheme = false,
        onThemeChange = {},
        playerName = "John Doe",
        onPlayerNameChange = {},
        paddingValues = PaddingValues()
    )
}