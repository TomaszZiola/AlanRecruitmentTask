package com.ziola.alan.services

import com.ziola.alan.clients.SwapiClient
import com.ziola.alan.dtos.People
import com.ziola.alan.dtos.swapi.PersonSwapiDto
import com.ziola.alan.entities.Person
import com.ziola.alan.mappers.PersonMapper
import com.ziola.alan.repositories.PersonRepository
import org.springframework.stereotype.Service

@Service
class PersonService(
    private val client: SwapiClient,
    private val personMapper: PersonMapper,
    private val personRepository: PersonRepository,
) {
    private companion object {
        const val STARTING_PAGE = 1
        const val URL_LAST_PART = "api/"
    }

    fun retrievePeopleWithStarshipsAndSave() {
        var page = STARTING_PAGE
        var currentPeople: List<PersonSwapiDto>
        val allPeopleWithStarships = mutableListOf<Person>()
        var hasNext = true

        while (hasNext) {
            val clientResponse = client.getPeopleFromPage(page)
            currentPeople = clientResponse?.results ?: emptyList()
            val currentPeopleWithStarships =
                currentPeople.map {
                    val starships =
                        it.starships.map {
                            client.getStarship(getStarshipUrl(it))
                        }
                    personMapper.toEntity(it, starships)
                }
            page++
            allPeopleWithStarships.addAll(currentPeopleWithStarships)
            hasNext = clientResponse?.next?.isNotBlank() ?: false
        }
        personRepository.saveAll(allPeopleWithStarships)
    }

    fun findPeopleByName(name: String): People {
        return personRepository.findAllByName(name)
            .let { personMapper.toDto(it) }
    }

    fun findPeople(): People {
        return personRepository.findAll()
            .let { personMapper.toDto(it) }
    }

    private fun getStarshipUrl(url: String): String {
        return url.substringAfterLast(URL_LAST_PART)
    }
}
