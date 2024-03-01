package com.ziola.alan.models

import com.ziola.alan.dtos.StarshipWithPersonDto
import java.time.ZoneId.of
import java.time.ZonedDateTime.of

internal object StarshipWithPersonDtoModel {
    fun basic(): StarshipWithPersonDto {
        return StarshipWithPersonDto(
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
            created = of(2014, 12, 12, 11, 19, 5, 340000, of("UTC")),
            edited = of(2014, 12, 20, 21, 23, 49, 886000, of("UTC")),
            person = PersonDtoModel.basic(),
        )
    }
}
