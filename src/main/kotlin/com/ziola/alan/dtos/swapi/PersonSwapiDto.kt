package com.ziola.alan.dtos.swapi

import com.fasterxml.jackson.annotation.JsonProperty

data class PersonSwapiDto(
    val name: String,
    val height: String,
    val mass: String,
    @JsonProperty("hair_color")
    val hairColor: String,
    @JsonProperty("skin_color")
    val skinColor: String,
    @JsonProperty("eye_color")
    val eyeColor: String,
    @JsonProperty("birth_year")
    val birthYear: String,
    val gender: String,
    val starships: List<String>,
    val created: String,
    val edited: String,
    val url: String,
)
