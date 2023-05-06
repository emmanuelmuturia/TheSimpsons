package com.example.thesimpsons.uilayer

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.thesimpsons.R
import com.example.thesimpsons.datalayer.TheSimpsons

@Composable
fun SuccessScreen(listOfSimpsons: List<TheSimpsons>, theSimpsonsViewModel: TheSimpsonsViewModel = hiltViewModel()) {

    LazyColumn(verticalArrangement = Arrangement.spacedBy(7.dp)) {
        items(listOfSimpsons) { simpsons ->
            SuccessCard(theSimpsons = simpsons)
        }
    }
}


@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun SuccessCard(theSimpsons: TheSimpsons) {

    Card(modifier = Modifier.fillMaxWidth(), elevation = CardDefaults.cardElevation(3.dp)) {

        Row(
            modifier = Modifier.padding(7.dp)
        ) {
            GlideImage(
                model = theSimpsons.image,
                contentDescription = "The Simpsons Image",
                contentScale = ContentScale.Fit
            )

            Spacer(modifier = Modifier.width(7.dp))

            Box(
                modifier = Modifier.fillMaxSize()
            ) {
                Column(

                ) {
                    Text(text =
                    buildAnnotatedString {
                        withStyle(SpanStyle(fontWeight = FontWeight.ExtraBold, color = Color.White)) {
                            append(text = "Name: ")
                        }
                        append(text = theSimpsons.character)
                    }
                    )
                    Spacer(modifier = Modifier.height(3.dp))
                    Text(text =
                    buildAnnotatedString {
                        withStyle(SpanStyle(fontWeight = FontWeight.ExtraBold, color = Color.White)) {
                            append(text = "Character Direction: ")
                        }
                        append(text = theSimpsons.characterDirection)
                    }
                    )
                    Spacer(modifier = Modifier.height(3.dp))
                    Text(text =
                    buildAnnotatedString {
                        withStyle(SpanStyle(fontWeight = FontWeight.ExtraBold, color = Color.White)) {
                            append(text = "Quote: ")
                        }
                        append(text = theSimpsons.quote)
                    }
                    )
                    Spacer(modifier = Modifier.height(3.dp))
                }
            }

        }

    }

}


@Composable
@Preview(showBackground = true)
fun SuccessCardPreview() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        SuccessCard(theSimpsons = TheSimpsons(character = "The Simpson", characterDirection = "North", image = "${R.drawable.simpson}", quote = "My Quote"))
    }
}
