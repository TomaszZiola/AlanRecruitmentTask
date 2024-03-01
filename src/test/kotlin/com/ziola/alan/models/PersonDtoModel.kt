package com.ziola.alan.models

import com.ziola.alan.dtos.PersonDto
import java.time.ZoneId.of
import java.time.ZonedDateTime.of

internal object PersonDtoModel {
    fun basic(): PersonDto {
        return PersonDto(
            name = "Luke Skywalker",
            height = "172",
            mass = "77",
            hairColor = "blond",
            skinColor = "fair",
            eyeColor = "blue",
            birthYear = "19BBY",
            gender = "male",
            created = of(2014, 12, 9, 13, 50, 51, 644000, of("UTC")),
            edited = of(2014, 12, 20, 21, 17, 56, 891000, of("UTC")),
        )
    }
}
