package com.example.thesimpsons.uilayer

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.thesimpsons.datalayer.TheSimpsonsModule
import com.example.thesimpsons.shared.TheSimpsonsState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.io.IOException
import javax.inject.Inject

@HiltViewModel
class TheSimpsonsViewModel @Inject constructor(application: Application) : AndroidViewModel(application = application) {

    private var _theSimpsonsState = MutableStateFlow<TheSimpsonsState>(TheSimpsonsState.Loading)
    val theSimpsonsState: StateFlow<TheSimpsonsState> = _theSimpsonsState.asStateFlow()

    private val retrofit = TheSimpsonsModule.providesRetrofit()
    private val apiService = TheSimpsonsModule.providesApiService(retrofit = retrofit)
    private val repository = TheSimpsonsModule.providesTheSimpsonsRepository(theSimpsonsApiService = apiService)

    init {
        getTheSimpsonsQuotes()
    }

    private fun getTheSimpsonsQuotes() {
        viewModelScope.launch {

            _theSimpsonsState.update { TheSimpsonsState.Loading }

            try {
                _theSimpsonsState.update { TheSimpsonsState.Success(theSimpsons = repository.getTheSimpsonsQuotes()) }
            } catch (e: IOException) {
                _theSimpsonsState.update { TheSimpsonsState.Error }
            }
        }
    }

}