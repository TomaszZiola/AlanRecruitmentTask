package com.ziola.alan.mappers

import com.ziola.alan.dtos.PersonDto
import com.ziola.alan.dtos.StarshipWithPersonDto
import com.ziola.alan.dtos.Starships
import com.ziola.alan.dtos.swapi.StarshipSwapiDto
import com.ziola.alan.entities.Person
import com.ziola.alan.entities.Starship
import com.ziola.alan.utils.DateTimeParser
import org.springframework.stereotype.Service

@Service
class StarshipMapper {
    fun toEntity(
        id: Long,
        starshipSwapi: StarshipSwapiDto,
    ): Starship {
        return Starship(
            id = id,
            name = starshipSwapi.name,
            model = starshipSwapi.model,
            manufacturer = starshipSwapi.manufacturer,
            costInCredits = starshipSwapi.costInCredits,
            length = starshipSwapi.length,
            maxAtmospheringSpeed = starshipSwapi.maxAtmospheringSpeed,
            crew = starshipSwapi.crew,
            passengers = starshipSwapi.passengers,
            cargoCapacity = starshipSwapi.cargoCapacity,
            consumables = starshipSwapi.consumables,
            hyperdriveRating = starshipSwapi.hyperdriveRating,
            mglt = starshipSwapi.mglt,
            starshipClass = starshipSwapi.starshipClass,
            created = DateTimeParser.toZonedDateTime(starshipSwapi.created),
            edited = DateTimeParser.toZonedDateTime(starshipSwapi.edited),
        )
    }

    fun toDto(starships: List<Starship>): Starships {
        return Starships(
            starships.map {
                StarshipWithPersonDto(
                    name = it.name,
                    model = it.model,
                    manufacturer = it.manufacturer,
                    costInCredits = it.costInCredits,
                    length = it.length,
                    maxAtmospheringSpeed = it.maxAtmospheringSpeed,
                    crew = it.crew,
                    passengers = it.passengers,
                    cargoCapacity = it.cargoCapacity,
                    consumables = it.consumables,
                    hyperdriveRating = it.hyperdriveRating,
                    mglt = it.mglt,
                    starshipClass = it.starshipClass,
                    created = it.created,
                    edited = it.edited,
                    person = toPersonDto(it.people),
                )
            },
        )
    }

    private fun toPersonDto(person: Set<Person>): List<PersonDto> {
        return person.map {
            PersonDto(
                name = it.name,
                height = it.height,
                mass = it.mass,
                hairColor = it.hairColor,
                skinColor = it.skinColor,
                eyeColor = it.eyeColor,
                birthYear = it.birthYear,
                gender = it.gender,
                created = it.created,
                edited = it.edited,
            )
        }
    }
}
