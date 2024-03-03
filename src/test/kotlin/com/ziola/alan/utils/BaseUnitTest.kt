package com.ziola.alan.utils

import com.ziola.alan.controllers.PersonController
import com.ziola.alan.controllers.StarshipController
import com.ziola.alan.dtos.PeopleDto
import com.ziola.alan.dtos.StarshipsDto
import com.ziola.alan.dtos.swapi.PersonSwapiDto
import com.ziola.alan.dtos.swapi.StarshipSwapiDto
import com.ziola.alan.entities.Person
import com.ziola.alan.entities.Starship
import com.ziola.alan.mappers.PersonMapper
import com.ziola.alan.mappers.StarshipMapper
import com.ziola.alan.models.PeopleDtoModel
import com.ziola.alan.models.StarshipsDtoModel
import com.ziola.alan.models.entity.PersonModel
import com.ziola.alan.models.entity.StarshipModel
import com.ziola.alan.models.swapi.PersonSwapiDtoModel
import com.ziola.alan.models.swapi.StarshipSwapiDtoModel
import com.ziola.alan.repositories.PersonRepository
import com.ziola.alan.repositories.StarshipRepository
import com.ziola.alan.services.PersonService
import com.ziola.alan.services.StarshipService
import io.mockk.every
import io.mockk.mockk
import org.junit.jupiter.api.BeforeEach

abstract class BaseUnitTest {
    private var personMapper = mockk<PersonMapper>()
    private var personRepository = mockk<PersonRepository>()
    private var personService = mockk<PersonService>()
    private var starshipMapper = mockk<StarshipMapper>()
    private var starshipRepository = mockk<StarshipRepository>()
    private var starshipService = mockk<StarshipService>()

    protected lateinit var peopleDto: PeopleDto
    protected lateinit var person: Person
    protected lateinit var personSwapiDto: PersonSwapiDto
    protected lateinit var starship: Starship
    protected lateinit var starshipsDto: StarshipsDto
    protected lateinit var starshipSwapiDto: StarshipSwapiDto

    protected lateinit var personControllerImpl: PersonController
    protected lateinit var personMapperImpl: PersonMapper
    protected lateinit var personServiceImpl: PersonService
    protected lateinit var starshipControllerImpl: StarshipController
    protected lateinit var starshipMapperImpl: StarshipMapper
    protected lateinit var starshipServiceImpl: StarshipService

    @BeforeEach
    fun mockResponses() {
        peopleDto = PeopleDtoModel.basic()
        person = PersonModel.basic()
        personSwapiDto = PersonSwapiDtoModel.baisc()
        starship = StarshipModel.basic(listOf(person))
        starshipsDto = StarshipsDtoModel.basic()
        starshipSwapiDto = StarshipSwapiDtoModel.basic()

        personControllerImpl = PersonController(personService)
        personMapperImpl = PersonMapper()
        personServiceImpl = PersonService(personMapper, personRepository)
        starshipControllerImpl = StarshipController(starshipService)
        starshipMapperImpl = StarshipMapper()
        starshipServiceImpl = StarshipService(starshipMapper, starshipRepository)

        every { personMapper.toDto(listOf(person)) } returns peopleDto
        every { personRepository.findAllByName("Luke Skywalker") } returns listOf(person)
        every { personRepository.findAll() } returns listOf(person)
        every { personService.findPeople() } returns peopleDto
        every { personService.findPeopleByName("Luke Skywalker") } returns peopleDto
        every { starshipMapper.toDto(listOf(starship)) } returns starshipsDto
        every { starshipRepository.findAllByName("X-wing") } returns listOf(starship)
        every { starshipRepository.findAll() } returns listOf(starship)
        every { starshipService.findStarships() } returns starshipsDto
        every { starshipService.findStarshipsByName("X-wing") } returns starshipsDto
    }
}
