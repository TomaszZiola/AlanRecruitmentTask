package com.ziola.alan.models.entity

import com.ziola.alan.entities.Person
import com.ziola.alan.entities.Starship
import java.time.ZoneId.of
import java.time.ZonedDateTime.of

internal object PersonModel {
    fun basic(): Person {
        val person =
            Person(
                id = 1L,
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
        person.addStarships(listOf(StarshipModel.basic(listOf(person))))
        return person
    }

    private fun Person.addStarships(starships: List<Starship>): Person {
        starships.map {
            val starshipEntity =
                Starship(
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
            this.starships.add(starshipEntity)
        }
        return this
    }
}
