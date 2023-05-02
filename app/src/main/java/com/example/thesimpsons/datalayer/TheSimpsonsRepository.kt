package com.example.thesimpsons.datalayer

interface TheSimpsonsRepository {

    suspend fun getTheSimpsonsQuotes(): List<TheSimpsons>

}