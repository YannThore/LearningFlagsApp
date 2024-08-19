package com.example.learningflagsapp.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.learningflagsapp.data.Flag

@Composable
fun FlagItem(flag: Flag) {
    val context = LocalContext.current
    val drawableId = context.resources.getIdentifier(
        flag.countryCode.lowercase(),
        "drawable",
        context.packageName
    )
    if (drawableId != 0) {
        Image(
            painter = painterResource(id = drawableId),
            contentDescription = flag.countryName,
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
        )
    } else {
        Text(text = "Image not found for ${flag.countryCode.uppercase()}", color = Color.Red)
    }
}


@Preview(showBackground = true)
@Composable
fun PreviewFlagItem() {
    FlagItem(Flag("France", "flag_fr", 0))
}