package com.example.ozinshecompose.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import com.example.ozinshecompose.R
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun NextButton(
    onClick: () -> Unit
) {
    val painter = painterResource(id = R.drawable.next_btn_violet)

    Image(
        painter = painter,
        contentDescription = "image",
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .size(16.dp)
            .clickable(onClick = onClick)
    )
}

@Composable
fun BackButton(
    onClick: () -> Unit
) {
    val painter = if (isSystemInDarkTheme()) painterResource(id = R.drawable.back_btn_white) else painterResource(id = R.drawable.back_btn_black)

    Image(
        painter = painter,
        contentDescription = "image",
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .fillMaxSize()
            .clickable(onClick = onClick)
    )
}

@Composable
fun BackWhiteButton(
    onClick: () -> Unit
) {
    val painter = painterResource(id = R.drawable.back_btn_white)

    Image(
        painter = painter,
        contentDescription = "image",
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .fillMaxSize()
            .clickable(onClick = onClick)
    )
}