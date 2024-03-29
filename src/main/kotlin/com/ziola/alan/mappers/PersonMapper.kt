package com.ziola.alan.mappers

import com.ziola.alan.dtos.PeopleDto
import com.ziola.alan.dtos.PersonWithStarshipDto
import com.ziola.alan.dtos.StarshipDto
import com.ziola.alan.dtos.swapi.PersonSwapiDto
import com.ziola.alan.entities.Person
import com.ziola.alan.entities.Starship
import com.ziola.alan.utils.DateTimeParser.toZonedDateTime
import org.springframework.stereotype.Service

@Service
class PersonMapper {
    fun toEntity(
        id: Long,
        personSwapiDto: PersonSwapiDto,
    ): Person {
        return Person(
            id = id,
            name = personSwapiDto.name,
            height = personSwapiDto.height,
            mass = personSwapiDto.mass,
            hairColor = personSwapiDto.hairColor,
            skinColor = personSwapiDto.skinColor,
            eyeColor = personSwapiDto.eyeColor,
            birthYear = personSwapiDto.birthYear,
            gender = personSwapiDto.gender,
            created = toZonedDateTime(personSwapiDto.created),
            edited = toZonedDateTime(personSwapiDto.edited),
        )
    }

    fun toDto(person: List<Person>): PeopleDto {
        return PeopleDto(
            person.map {
                PersonWithStarshipDto(
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
                    starships = toStarshipDto(it.starships),
                )
            },
        )
    }

    private fun toStarshipDto(starships: Set<Starship>): List<StarshipDto> {
        return starships.map {
            StarshipDto(
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
            )
        }
    }
}
