package com.example.thesimpsons.datalayer

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object TheSimpsonsModule {

    @OptIn(ExperimentalSerializationApi::class)
    @Provides
    @Singleton
    fun providesRetrofit(): Retrofit {

        val json = Json {
            ignoreUnknownKeys = true
            coerceInputValues = true
        }

        return Retrofit.Builder()
            .baseUrl("https://thesimpsonsquoteapi.glitch.me/")
            .addConverterFactory(json.asConverterFactory("application/json".toMediaType()))
            .build()

    }

    @Provides
    @Singleton
    fun providesApiService(retrofit: Retrofit): TheSimpsonsApiService {
        return retrofit.create(TheSimpsonsApiService::class.java)
    }

    @Provides
    @Singleton
    fun providesTheSimpsonsRepository(theSimpsonsApiService: TheSimpsonsApiService): TheSimpsonsRepositoryImpl {
        return TheSimpsonsRepositoryImpl(theSimpsonsApiService = theSimpsonsApiService)
    }

}