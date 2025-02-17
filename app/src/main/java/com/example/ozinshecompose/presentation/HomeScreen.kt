package com.example.ozinshecompose.presentation

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import com.example.ozinshecompose.R
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ozinshecompose.ui.theme.Gray400
import com.example.ozinshecompose.ui.theme.Gray900
import com.example.ozinshecompose.ui.theme.OzinsheComposeTheme
import com.example.ozinshecompose.ui.theme.Pink40
import com.example.ozinshecompose.ui.theme.Primary500
import com.example.ozinshecompose.ui.theme.White

@Composable
fun HomeScreen() {


    Column(
        modifier = Modifier.fillMaxSize()
    ) {


    }
}

@Preview
@Composable
fun MoviesList(){
    OzinsheComposeTheme {
        LazyRow(
            contentPadding = PaddingValues(horizontal = 24.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(10) { index ->
                MainMovieCard()
            }
        }
    }
}

@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    name = "DefaultPreviewDark"
)
@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_NO,
    name = "DefaultPreviewLight"
)
@Composable
fun MainMovieCard() {
    val painter = painterResource(id = R.drawable.ic_launcher_background)

    OzinsheComposeTheme {
        Column(
            modifier = Modifier
                .width(316.dp)
                .background(MaterialTheme.colorScheme.background)
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
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                fontWeight = FontWeight(400),
                color = MaterialTheme.colorScheme.secondary
            )
        }
    }
}

@Preview
@Composable
fun PosterMovieCard() {
    val painter = painterResource(id = R.drawable.ic_launcher_background)

    OzinsheComposeTheme {
        Column(
            modifier = Modifier
                .width(112.dp)
                .background(MaterialTheme.colorScheme.background)
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
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                fontWeight = FontWeight(400),
                color = Gray400
            )
        }
    }
}