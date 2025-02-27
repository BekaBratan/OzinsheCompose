package com.example.ozinshecompose.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ozinshecompose.R
import com.example.ozinshecompose.ui.theme.Gray300
import com.example.ozinshecompose.ui.theme.Gray400
import com.example.ozinshecompose.ui.theme.Gray600
import com.example.ozinshecompose.ui.theme.Primary300


@Composable
fun DetailScreen(id: Int, name: String?) {
    val painter = painterResource(id = R.drawable.ic_launcher_background)

    LazyColumn(
        modifier = Modifier.background(MaterialTheme.colorScheme.background)
    ) {
        items(1) { index ->
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(340.dp)
            ) {
                Image(
                    painter = painter,
                    contentDescription = "image",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxSize()
                )


                Image(
                    modifier = Modifier
                        .padding(top = 68.dp, start = 33.dp)
                        .size(24.dp)
                        .clickable(onClick = { }),
                    painter = painterResource(id = R.drawable.back_btn_white),
                    contentDescription = "Back",
                    contentScale = ContentScale.Crop
                )

                PlayerPanel(
                    modifier = Modifier
                        .align(Alignment.BottomCenter)
                        .padding(bottom = 48.dp)
                )
            }

            DetailInfo(name)

            Spacer(Modifier.size(8.dp))

            MoviesList({ ScreenshotsCard() }, name = "Скриншоттар", false)

            Spacer(Modifier.size(32.dp))

            MoviesList(card = { PosterMovieCard() }, name = "Ұқсас телехикаялар", isExtend = true)
        }
    }

}

@Composable
fun DetailInfo(name: String?) {
    var isExpanded by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(
            text = name ?: "Name",
            fontFamily = fontFamily,
            fontSize = 24.sp,
            lineHeight = 28.8.sp,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            fontWeight = FontWeight(700),
            color = MaterialTheme.colorScheme.onBackground
        )
        Text(
            text = "Name",
            fontFamily = fontFamily,
            fontSize = 12.sp,
            lineHeight = 18.sp,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            fontWeight = FontWeight(600),
            color = Gray400
        )

        Spacer(
            modifier = Modifier
                .padding(vertical = 16.dp)
                .fillMaxWidth()
                .height(1.dp)
                .background(Gray300)
        )

        Box {
            Text(
                text = "Шытырман оқиғалы мультсериал Елбасының «Ұлы даланың жеті қыры» бағдарламасы аясында жүзеге асырылған. Мақалада қызғалдақтардың отаны Қазақстан екені айтылады. Ал, жоба қызғалдақтардың отаны – Алатау баурайы екенін анимация тілінде дәлелдей түседі. Шытырман оқиғалы мультсериал Елбасының «Ұлы даланың жеті қыры» бағдарламасы аясында жүзеге асырылған. Мақалада қызғалдақтардың отаны Қазақстан екені айтылады. Ал, жоба қызғалдақтардың отаны – Алатау баурайы екенін анимация тілінде дәлелдей түседі. ",
                fontFamily = fontFamily,
                fontSize = 14.sp,
                lineHeight = 22.sp,
                maxLines = if (isExpanded) Int.MAX_VALUE else 7,
                overflow = TextOverflow.Ellipsis,
                fontWeight = FontWeight(400),
                color = Gray400
            )

            if (!isExpanded)
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(154.dp)
                        .background(
                            brush = Brush.verticalGradient(
                                colors = listOf(Color.Transparent, MaterialTheme.colorScheme.background)
                            )
                        )
                )
        }


        Text(
            text = AnnotatedString(if (isExpanded) "Жасыру" else "Толығырақ"),
            fontFamily = fontFamily,
            fontSize = 14.sp,
            lineHeight = 22.sp,
            fontWeight = FontWeight(600),
            color = Primary300,
            modifier = Modifier
                .padding(top = 8.dp, bottom = 16.dp)
                .clickable(onClick = {isExpanded = !isExpanded})
        )

        Row {
            Text(
                text = "Режиссер:",
                fontFamily = fontFamily,
                fontSize = 14.sp,
                lineHeight = 22.sp,
                fontWeight = FontWeight(400),
                color = Gray600,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier.width(90.dp)
            )
            Text(
                text = "Байболат Бекарыс",
                fontFamily = fontFamily,
                fontSize = 14.sp,
                lineHeight = 22.sp,
                fontWeight = FontWeight(400),
                color = Gray400,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }

        Row {
            Text(
                text = "Продюсер:",
                fontFamily = fontFamily,
                fontSize = 14.sp,
                lineHeight = 22.sp,
                fontWeight = FontWeight(400),
                color = Gray600,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier.width(90.dp)
            )
            Text(
                text = "Байболат Бекарыс",
                fontFamily = fontFamily,
                fontSize = 14.sp,
                lineHeight = 22.sp,
                fontWeight = FontWeight(400),
                color = Gray400,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }

        Spacer(
            modifier = Modifier
                .padding(vertical = 16.dp)
                .fillMaxWidth()
                .height(1.dp)
                .background(Gray300)
        )

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(
                text = "Бөлімдер",
                fontFamily = fontFamily,
                fontSize = 16.sp,
                lineHeight = 24.sp,
                fontWeight = FontWeight(700),
                color = MaterialTheme.colorScheme.onBackground,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier.weight(1f)
            )
            Text(
                text = "Байболат Бекарыс",
                fontFamily = fontFamily,
                fontSize = 12.sp,
                lineHeight = 16.2.sp,
                fontWeight = FontWeight(600),
                color = Gray400,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            NextButton {  }
        }
    }
}

@Composable
fun ScreenshotsCard() {
    val painter = painterResource(id = R.drawable.ic_launcher_background)

    Box(
        modifier = Modifier.size(184.dp, 112.dp)
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
}

@Preview
@Composable
fun PlayerPanel(modifier: Modifier = Modifier) {
    Row (
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        Column(
            modifier = Modifier
                .padding(top = 20.dp)
                .clickable(onClick = { }),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.bookmark_outline),
                contentDescription = "Add to Favourite",
                contentScale = ContentScale.Crop,
                modifier = Modifier.size(24.dp)
            )
            Text(
                text = "Тізімге қосу",
                fontFamily = fontFamily,
                fontSize = 12.sp,
                lineHeight = 18.sp,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                fontWeight = FontWeight(600),
                color = Gray300
            )
        }

        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                modifier = Modifier
                    .size(64.dp)
                    .clickable(onClick = { }),
                painter = painterResource(id = R.drawable.ic_play_btn),
                contentDescription = "Play",
                contentScale = ContentScale.Crop
            )
        }

        Column(
            modifier = Modifier
                .padding(top = 20.dp)
                .clickable(onClick = { }),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.share_outline),
                contentDescription = "Share",
                contentScale = ContentScale.Crop,
                modifier = Modifier.size(24.dp)
            )
            Text(
                text = "Тізімге қосу",
                fontFamily = fontFamily,
                fontSize = 12.sp,
                lineHeight = 18.sp,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                fontWeight = FontWeight(600),
                color = Gray300
            )
        }
    }
}

