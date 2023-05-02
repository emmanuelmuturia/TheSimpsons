package com.example.thesimpsons.shared

import com.example.thesimpsons.datalayer.TheSimpsons

sealed interface TheSimpsonsState {

    data class Success(val theSimpsons: List<TheSimpsons>): TheSimpsonsState

    object Loading: TheSimpsonsState

    object Error: TheSimpsonsState

}