package com.example.ozinshecompose.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ozinshecompose.R
import com.example.ozinshecompose.ui.theme.Gray400


@Preview
@Composable
fun PosterMovieCard() {
    val painter = painterResource(id = R.drawable.ic_launcher_background)

    Column(
        modifier = Modifier
            .width(112.dp)
            .background(Color.Transparent)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(164.dp)
        ) {
            Image(
                painter = painter,
                contentDescription = "image",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxSize()
                    .clip(shape = RoundedCornerShape(8.dp))
            )
        }

        Spacer(Modifier.size(8.dp))

        Text(
            text = "Қызғалдақтар мекені",
            fontFamily = fontFamily,
            fontSize = 12.sp,
            lineHeight = 16.2.sp,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis,
            fontWeight = FontWeight(600),
            color = MaterialTheme.colorScheme.onSurface
        )

        Spacer(Modifier.size(4.dp))

        Text(
            text = "Шытырман оқиғалы мультсериал Елбасының «Ұлы даланың жеті қыры» бағдарламасы аясында жүздеген өнімдер шығарылған.",
            fontFamily = fontFamily,
            fontSize = 12.sp,
            lineHeight = 16.2.sp,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            fontWeight = FontWeight(400),
            color = Gray400
        )
    }
}
