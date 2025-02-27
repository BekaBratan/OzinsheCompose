package com.example.ozinshecompose.presentation

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.ozinshecompose.R
import com.example.ozinshecompose.SecondScreen
import com.example.ozinshecompose.ui.theme.OzinsheComposeTheme
import com.example.ozinshecompose.ui.theme.Primary500
import com.example.ozinshecompose.ui.theme.White


@Composable
fun HomeScreen(navController: NavHostController) {
    var listCom = listOf<@Composable () -> Unit>(
        { MoviesList(card = { MainMovieCard(navController) } )},
        { MoviesList(card = { ContinueMovieCard() }, name = "Қарауды жалғастырыңыз", isExtend = false)},
        { MoviesList(card = { PosterMovieCard() }, name = "Қарауды жалғастырыңыз", isExtend = true)},
        { MoviesList(card = { PosterMovieCard() }, name = "Қарауды жалғастырыңыз", isExtend = true)},
        { MoviesList(card = { GenreCard() }, name = "Жанрды таңдаңыз", isExtend = true)},
        { MoviesList(card = { PosterMovieCard() }, name = "Қарауды жалғастырыңыз", isExtend = true)},
        { MoviesList(card = { PosterMovieCard() }, name = "Қарауды жалғастырыңыз", isExtend = true)},
        { MoviesList(card = { GenreCard() }, name = "Жанрды таңдаңыз", isExtend = true)},
        { MoviesList(card = { PosterMovieCard() }, name = "Қарауды жалғастырыңыз", isExtend = true)}
    )


    OzinsheComposeTheme {
        Box(
            modifier = Modifier.background(MaterialTheme.colorScheme.background)
        ) {
            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(32.dp),
                modifier = Modifier
                    .fillMaxSize()
            ) {
                items(listCom.size + 1) { index ->
                    if (index == 0)
                        Logo()
                    else
                        listCom[index - 1]()
                }
            }
        }
    }
}

@Composable
fun Logo() {
    val logo = if (isSystemInDarkTheme()) painterResource(id = R.drawable.logo_dark) else painterResource(id = R.drawable.logo)

    Image(
        painter = logo,
        contentDescription = "image",
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .padding(horizontal = 24.dp)
            .size(94.dp, 40.dp)
            .clip(shape = RoundedCornerShape(12.dp))
            .background(MaterialTheme.colorScheme.onTertiary)
    )
}

@Composable
fun MainMovieCard(navController: NavHostController) {
    val painter = painterResource(id = R.drawable.ic_launcher_background)

    Column(
        modifier = Modifier
            .width(316.dp)
            .background(Color.Transparent)
            .clickable(onClick = {navController.navigate(SecondScreen(1, "Қызғалдақтар мекені"))})
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
                    .clip(shape = RoundedCornerShape(12.dp))
            )
            Box(
                modifier = Modifier
                    .padding(8.dp)
            ) {
                Text(
                    text = "Телехикая",
                    textAlign = TextAlign.Center,
                    fontFamily = fontFamily,
                    fontSize = 12.sp,
                    maxLines = 1,
                    fontWeight = FontWeight(500),
                    color = White,
                    modifier = Modifier
                        .clip(shape = RoundedCornerShape(8.dp))
                        .background(Primary500)
                        .padding(8.dp, 4.dp)

                )
            }

        }

        Spacer(Modifier.size(16.dp))

        Text(
            text = "Қызғалдақтар мекені",
            fontFamily = fontFamily,
            fontSize = 14.sp,
            lineHeight = 21.sp,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            fontWeight = FontWeight(700),
            color = MaterialTheme.colorScheme.onBackground
        )

        Spacer(Modifier.size(8.dp))

        Text(
            text = "Шытырман оқиғалы мультсериал Елбасының «Ұлы даланың жеті қыры» бағдарламасы аясында жүздеген өнімдер шығарылған.",
            fontFamily = fontFamily,
            fontSize = 12.sp,
            lineHeight = 16.2.sp,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis,
            fontWeight = FontWeight(400),
            color = MaterialTheme.colorScheme.secondary
        )
    }
}

@Preview
@Composable
fun ContinueMovieCard() {
    val painter = painterResource(id = R.drawable.ic_launcher_background)

    Column(
        modifier = Modifier
            .width(184.dp)
            .background(Color.Transparent)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(112.dp)
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
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            fontWeight = FontWeight(600),
            color = MaterialTheme.colorScheme.onBackground
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
            color = MaterialTheme.colorScheme.secondary
        )
    }
}

@Preview
@Composable
fun GenreCard() {
    val painter = painterResource(id = R.drawable.ic_launcher_background)

    Box(
        modifier = Modifier.size(164.dp, 112.dp)
    ) {
        Image(
            painter = painter,
            contentDescription = "image",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxSize()
                .clip(shape = RoundedCornerShape(8.dp))
        )
        Text(
            text = "Multik",
            modifier = Modifier
                .fillMaxSize()
                .wrapContentSize(Alignment.Center),
            textAlign = TextAlign.Center,
            fontFamily = fontFamily,
            fontSize = 14.sp,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            fontWeight = FontWeight(600),
            color = White
        )
    }
}


