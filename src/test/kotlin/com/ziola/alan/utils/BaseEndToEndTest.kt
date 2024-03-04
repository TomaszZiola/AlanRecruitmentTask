package com.ziola.alan.utils

import com.fasterxml.jackson.databind.ObjectMapper
import com.lectra.koson.ObjectType
import com.lectra.koson.arr
import com.lectra.koson.obj
import com.ziola.alan.repositories.PersonRepository
import com.ziola.alan.repositories.StarshipRepository
import io.restassured.response.ResponseBodyExtractionOptions
import org.assertj.core.api.Assertions.assertThat
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.web.server.LocalServerPort

internal abstract class BaseEndToEndTest : BaseIntegrationTest() {
    @Autowired
    lateinit var personRepository: PersonRepository

    @Autowired
    lateinit var starshipRepository: StarshipRepository

    @Autowired
    private lateinit var objectMapper: ObjectMapper

    @LocalServerPort
    var port: Int = 0

    fun assert(
        result: ResponseBodyExtractionOptions,
        expected: ObjectType,
        classType: Class<*>,
    ) {
        val resultMapped =
            if (result.asString().isBlank()) result.asString() else objectMapper.readValue(result.asString(), classType)
        val expectedMapped = objectMapper.readValue(expected.toString(), classType)

        assertThat(resultMapped).isEqualTo(expectedMapped)
    }

    @Suppress("LongParameterList")
    fun basicPeopleResponse(
        name: String = "Luke Skywalker",
        height: String = "172",
        mass: String = "77",
        hairColor: String = "blond",
        skinColor: String = "fair",
        eyeColor: String = "blue",
        birthYear: String = "19BBY",
        gender: String = "male",
        created: String = "2014-12-09T13:50:51.644000Z",
        edited: String = "2014-12-20T21:17:56.891000Z",
        url: String = "https://swapi.dev/api/people/1/",
        starships: List<ObjectType> = emptyList(),
    ): ObjectType {
        return obj {
            "name" to name
            "height" to height
            "mass" to mass
            "hairColor" to hairColor
            "skinColor" to skinColor
            "eyeColor" to eyeColor
            "birthYear" to birthYear
            "gender" to gender
            "created" to created
            "edited" to edited
            "url" to url
            "starships" to arr[starships]
        }
    }

    @Suppress("LongParameterList")
    fun basicStarshipResponse(
        name: String = "X-wing",
        model: String = "T-65 X-wing",
        manufacturer: String = "Incom Corporation",
        costInCredits: String = "149999",
        length: String = "12.5",
        maxAtmospheringSpeed: String = "1050",
        crew: String = "1",
        passengers: String = "0",
        cargoCapacity: String = "110",
        consumables: String = "1 week",
        hyperdriveRating: String = "1.0",
        mglt: String = "100",
        starshipClass: String = "Starfighter",
        created: String = "2014-12-12T11:19:05.340000Z",
        edited: String = "2014-12-20T21:23:49.886000Z",
        people: List<ObjectType> = emptyList(),
    ): ObjectType {
        return obj {
            "name" to name
            "model" to model
            "manufacturer" to manufacturer
            "costInCredits" to costInCredits
            "length" to length
            "maxAtmospheringSpeed" to maxAtmospheringSpeed
            "crew" to crew
            "passengers" to passengers
            "cargoCapacity" to cargoCapacity
            "consumables" to consumables
            "hyperdriveRating" to hyperdriveRating
            "mglt" to mglt
            "starshipClass" to starshipClass
            "created" to created
            "edited" to edited
            "person" to arr[people]
        }
    }
}
