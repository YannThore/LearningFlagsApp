package com.example.learningflagsapp.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.learningflagsapp.data.Flag
import com.example.learningflagsapp.data.getFlags

@Composable
fun FlagListScreen() {
    val context = LocalContext.current
    val flags = getFlags(context)

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp)
    ) {
        items(flags) { flag ->
            FlagItem(flag)
        }
    }
}


@Preview(showBackground = true)
@Composable
fun PreviewFlagListItem() {
    FlagListScreen()
}
