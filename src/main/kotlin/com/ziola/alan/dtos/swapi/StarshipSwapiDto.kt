package com.ziola.alan.dtos.swapi

import com.fasterxml.jackson.annotation.JsonProperty

data class StarshipSwapiDto(
    val name: String,
    val model: String,
    val manufacturer: String,
    @JsonProperty("cost_in_credits")
    val costInCredits: String,
    val length: String,
    @JsonProperty("max_atmosphering_speed")
    val maxAtmospheringSpeed: String,
    val crew: String,
    val passengers: String,
    @JsonProperty("cargo_capacity")
    val cargoCapacity: String,
    val consumables: String,
    @JsonProperty("hyperdrive_rating")
    val hyperdriveRating: String,
    @JsonProperty("MGLT")
    val mglt: String,
    @JsonProperty("starship_class")
    val starshipClass: String,
    val created: String,
    val edited: String,
    val url: String,
    val pilots: List<String>,
)
