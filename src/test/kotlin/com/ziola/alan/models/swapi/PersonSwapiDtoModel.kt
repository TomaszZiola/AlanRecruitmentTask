package com.ziola.alan.models.swapi

import com.ziola.alan.dtos.swapi.PersonSwapiDto

internal object PersonSwapiDtoModel {
    fun baisc(): PersonSwapiDto {
        return PersonSwapiDto(
            name = "Luke Skywalker",
            height = "172",
            mass = "77",
            hairColor = "blond",
            skinColor = "fair",
            eyeColor = "blue",
            birthYear = "19BBY",
            gender = "male",
            created = "2014-12-09T13:50:51.644000Z",
            edited = "2014-12-20T21:17:56.891000Z",
            url = "https://swapi.dev/api/people/1/",
            starships = listOf("https://swapi.dev/api/starships/12/", "https://swapi.dev/api/starships/22/"),
        )
    }
}
