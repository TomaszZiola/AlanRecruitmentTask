package com.ziola.alan.services

import com.ziola.alan.clients.SwapiClient
import com.ziola.alan.dtos.swapi.PersonSwapiDto
import com.ziola.alan.dtos.swapi.StarshipSwapiDto
import com.ziola.alan.entities.Person
import com.ziola.alan.entities.Starship
import com.ziola.alan.mappers.PersonMapper
import com.ziola.alan.mappers.StarshipMapper
import com.ziola.alan.repositories.PersonRepository
import com.ziola.alan.repositories.StarshipRepository
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service

@Service
class DataFetcher(
    private val client: SwapiClient,
    private val personMapper: PersonMapper,
    private val starshipMapper: StarshipMapper,
    private val personRepository: PersonRepository,
    private val starshipRepository: StarshipRepository,
) {
    private companion object {
        const val STARTING_PAGE_PERSON = 1
        const val STARTING_PAGE_STARSHIP = 1
    }

    @Transactional
    fun retrievePeopleWithStarshipsAndSave() {
        val allPeople = mutableListOf<PersonSwapiDto>()
        val allStarships = mutableListOf<StarshipSwapiDto>()
        val personStarshipConnections = mutableMapOf<Long, MutableSet<Long>>()

        retrieveAllPeople(allPeople)
        retrieveAllStarships(allStarships)

        createPersonStarshipConnections(allPeople, allStarships, personStarshipConnections)

        val starshipsEntities =
            allStarships.map {
                val id = extractIdFromUrl(it.url)
                starshipMapper.toEntity(id, it)
            }

        val peopleEntities =
            allPeople.map {
                val id = extractIdFromUrl(it.url)
                personMapper.toEntity(id, it)
            }

        addStarshipsToPeople(peopleEntities, starshipsEntities, personStarshipConnections)

        personRepository.saveAll(peopleEntities)
        starshipRepository.saveAll(starshipsEntities)
    }

    private fun retrieveAllPeople(allPeople: MutableList<PersonSwapiDto>) {
        var personPage = STARTING_PAGE_PERSON
        var hasNext = true

        while (hasNext) {
            val clientResponse = client.getPeopleFromPage(personPage)
            val currentPeople = clientResponse?.results ?: emptyList()
            allPeople.addAll(currentPeople)
            hasNext = clientResponse?.next?.isNotBlank() ?: false
            personPage++
        }
    }

    private fun retrieveAllStarships(allStarships: MutableList<StarshipSwapiDto>) {
        var starshipPage = STARTING_PAGE_STARSHIP
        var hasNext = true

        while (hasNext) {
            val clientResponse = client.getStarshipsFromPage(starshipPage)
            val currentStarships = clientResponse?.results ?: emptyList()
            allStarships.addAll(currentStarships)
            hasNext = clientResponse?.next?.isNotBlank() ?: false
            starshipPage++
        }
    }

    private fun createPersonStarshipConnections(
        allPeople: List<PersonSwapiDto>,
        allStarships: List<StarshipSwapiDto>,
        personStarshipConnections: MutableMap<Long, MutableSet<Long>>,
    ) {
        for (person in allPeople) {
            for (starship in allStarships) {
                if (starship.pilots.contains(person.url)) {
                    val personId = extractIdFromUrl(person.url)
                    val starshipId = extractIdFromUrl(starship.url)

                    val starshipIds = personStarshipConnections.getOrPut(personId) { mutableSetOf() }
                    starshipIds.add(starshipId)
                }
            }
        }
    }

    private fun addStarshipsToPeople(
        peopleEntities: List<Person>,
        starshipsEntities: List<Starship>,
        personStarshipConnections: Map<Long, Set<Long>>,
    ) {
        peopleEntities.forEach { person ->
            personStarshipConnections[person.id]?.let { connection ->
                person.starships.addAll(
                    starshipsEntities.filter { starship -> connection.contains(starship.id) },
                )
            }
        }
    }

    private fun extractIdFromUrl(url: String): Long {
        val regex = Regex("""\d+""")
        val matchResult = regex.find(url)
        return matchResult!!.value.toLong()
    }
}
