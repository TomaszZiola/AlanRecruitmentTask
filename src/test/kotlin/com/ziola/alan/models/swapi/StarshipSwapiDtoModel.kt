package com.ziola.alan.models.swapi

import com.ziola.alan.dtos.swapi.StarshipSwapiDto

internal object StarshipSwapiDtoModel {
    fun basic(): StarshipSwapiDto {
        return StarshipSwapiDto(
            name = "X-wing",
            model = "T-65 X-wing",
            manufacturer = "Incom Corporation",
            costInCredits = "149999",
            length = "12.5",
            maxAtmospheringSpeed = "1050",
            crew = "1",
            passengers = "0",
            cargoCapacity = "110",
            consumables = "1 week",
            hyperdriveRating = "1.0",
            mglt = "100",
            starshipClass = "Starfighter",
            created = "2014-12-12T11:19:05.340000Z",
            edited = "2014-12-20T21:23:49.886000Z",
            url = "https://swapi.dev/api/starships/12/",
        )
    }
}
