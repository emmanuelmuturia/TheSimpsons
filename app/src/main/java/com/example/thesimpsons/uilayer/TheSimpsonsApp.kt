package com.example.thesimpsons.uilayer

import android.graphics.drawable.Icon
import androidx.compose.foundation.Image
import androidx.compose.ui.res.painterResource
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Refresh
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.thesimpsons.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TheSimpsonsApp(theSimpsonsViewModel: TheSimpsonsViewModel = hiltViewModel()) {

    val theSimpsonsState by theSimpsonsViewModel.theSimpsonsState.collectAsState()

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = { TheSimpsonsAppBar() },
        floatingActionButton = {
            FloatingActionButton(onClick = { theSimpsonsViewModel.getTheSimpsonsQuotes() }) {
                Icon(imageVector = Icons.Rounded.Refresh, contentDescription = "Refresh")
            }
        }
    ) {
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(it),
            color = Color.Yellow
        ) {
            HomeScreen(theSimpsonsState = theSimpsonsState)
        }
    }

}


@Composable
fun TheSimpsonsAppBar() {
    Row(
        modifier = Modifier
            .background(color = MaterialTheme.colorScheme.background)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(painter = painterResource(id = R.drawable.playstore), contentDescription = null, modifier = Modifier
            .size(width = 63.dp, height = 63.dp)
            .padding(7.dp))
        Text(text = stringResource(id = R.string.app_name), style = MaterialTheme.typography.titleLarge, fontSize = 28.sp)
    }
}