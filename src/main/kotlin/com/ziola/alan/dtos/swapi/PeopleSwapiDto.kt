package com.ziola.alan.dtos.swapi

data class PeopleSwapiDto(
    val next: String?,
    val results: List<PersonSwapiDto>,
)
