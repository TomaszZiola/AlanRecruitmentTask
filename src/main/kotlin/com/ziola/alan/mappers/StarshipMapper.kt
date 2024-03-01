package com.ziola.alan.mappers

import com.ziola.alan.dtos.PersonDto
import com.ziola.alan.dtos.StarshipWithPersonDto
import com.ziola.alan.dtos.Starships
import com.ziola.alan.entities.Person
import com.ziola.alan.entities.Starship
import org.springframework.stereotype.Service

@Service
class StarshipMapper {
    fun toDto(starships: List<Starship>): Starships {
        return Starships(
            starships =
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
                        person = toPersonDto(it.person),
                    )
                },
        )
    }

    private fun toPersonDto(person: Person): PersonDto {
        return PersonDto(
            name = person.name,
            height = person.height,
            mass = person.mass,
            hairColor = person.hairColor,
            skinColor = person.skinColor,
            eyeColor = person.eyeColor,
            birthYear = person.birthYear,
            gender = person.gender,
            created = person.created,
            edited = person.edited,
        )
    }
}
