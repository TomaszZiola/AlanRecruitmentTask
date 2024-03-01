package com.ziola.alan.dtos.swapi

data class StarshipsSwapiDto(
    val next: String?,
    val results: List<StarshipSwapiDto>,
)
