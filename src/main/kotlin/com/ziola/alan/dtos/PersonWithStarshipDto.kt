package com.ziola.alan.dtos

import java.time.ZonedDateTime

data class PersonWithStarshipDto(
    val name: String,
    val height: String,
    val mass: String,
    val hairColor: String,
    val skinColor: String,
    val eyeColor: String,
    val birthYear: String,
    val gender: String,
    val starships: List<StarshipDto>,
    val created: ZonedDateTime,
    val edited: ZonedDateTime,
)
