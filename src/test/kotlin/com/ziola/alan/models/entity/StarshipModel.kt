package com.ziola.alan.models.entity

import com.ziola.alan.entities.Person
import com.ziola.alan.entities.Starship
import java.time.ZoneId.of
import java.time.ZonedDateTime.of

internal object StarshipModel {
    fun basic(people: List<Person>): Starship {
        val starship =
            Starship(
                id = 1L,
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
            )
        starship.addPeople(people)
        return starship
    }

    fun Starship.addPeople(people: List<Person>) {
        people.map {
            val personEntity =
                Person(
                    id = it.id,
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
            this.people.add(personEntity)
        }
    }
}
