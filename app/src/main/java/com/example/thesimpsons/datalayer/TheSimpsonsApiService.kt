package com.example.thesimpsons.datalayer

import retrofit2.http.GET

interface TheSimpsonsApiService {

    @GET("quotes?count=7")

    suspend fun getTheSimpsons(): List<TheSimpsons>

}