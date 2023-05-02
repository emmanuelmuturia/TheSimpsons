package com.example.thesimpsons.uilayer

import androidx.compose.runtime.Composable
import androidx.compose.runtime.snapshots.SnapshotApplyResult
import com.example.thesimpsons.shared.TheSimpsonsState

@Composable
fun HomeScreen(theSimpsonsState: TheSimpsonsState) {

    when(theSimpsonsState) {

        is TheSimpsonsState.Error -> ErrorScreen()
        is TheSimpsonsState.Loading -> LoadingScreen()
        is TheSimpsonsState.Success -> SuccessScreen(listOfSimpsons = theSimpsonsState.theSimpsons)

    }

}