package com.example.thesimpsons.datalayer

class TheSimpsonsRepositoryImpl(private val theSimpsonsApiService: TheSimpsonsApiService) : TheSimpsonsRepository {
    override suspend fun getTheSimpsonsQuotes(): List<TheSimpsons> {
        return theSimpsonsApiService.getTheSimpsons()
    }

}