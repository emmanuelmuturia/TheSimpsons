package com.example.thesimpsons.datalayer

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class TheSimpsons(
    @SerialName("quote") val quote: String,
    @SerialName("character") val character: String,
    @SerialName("image") val image: String,
    @SerialName("characterDirection") val characterDirection: String
)
