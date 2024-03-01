package com.ziola.alan.clients

import com.ziola.alan.dtos.swapi.PeopleSwapiDto
import com.ziola.alan.dtos.swapi.StarshipsSwapiDto
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

    fun getStarshipsFromPage(page: Int): StarshipsSwapiDto? {
        return client
            .get()
            .uri("starships?page=$page")
            .retrieve()
            .body(StarshipsSwapiDto::class.java)
    }
}
