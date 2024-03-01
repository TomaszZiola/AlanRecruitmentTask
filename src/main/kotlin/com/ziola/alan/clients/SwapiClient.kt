package com.ziola.alan.clients

import com.ziola.alan.dtos.swapi.PeopleSwapiDto
import com.ziola.alan.dtos.swapi.StarshipSwapiDto
import com.ziola.alan.exceptions.StarshipNotFoundException
import org.springframework.stereotype.Service
import org.springframework.web.client.RestClient

@Service
class SwapiClient(
    private val client: RestClient,
) {
    fun getPeopleFromPage(page: Int): PeopleSwapiDto? {
        return client
            .get()
            .uri("people?page=$page")
            .retrieve()
            .body(PeopleSwapiDto::class.java)
    }

    fun getStarship(url: String): StarshipSwapiDto {
        return client
            .get()
            .uri(url)
            .retrieve()
            .body(StarshipSwapiDto::class.java) ?: throw StarshipNotFoundException("Starship has not been found")
    }
}
