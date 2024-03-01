package com.ziola.alan.utils

import com.ziola.alan.controllers.PersonController
import com.ziola.alan.controllers.StarshipController
import com.ziola.alan.dtos.People
import com.ziola.alan.dtos.PersonWithStarshipDto
import com.ziola.alan.dtos.StarshipWithPersonDto
import com.ziola.alan.dtos.Starships
import com.ziola.alan.dtos.swapi.PersonSwapiDto
import com.ziola.alan.dtos.swapi.StarshipSwapiDto
import com.ziola.alan.entities.Person
import com.ziola.alan.entities.Starship
import com.ziola.alan.mappers.PersonMapper
import com.ziola.alan.mappers.StarshipMapper
import com.ziola.alan.models.PeopleModel
import com.ziola.alan.models.PersonWithStarshipDtoModel
import com.ziola.alan.models.StarshipWithPersonDtoModel
import com.ziola.alan.models.StarshipsModel
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
    internal var starshipMapper = mockk<StarshipMapper>()
    private var starshipRepository = mockk<StarshipRepository>()
    private var starshipService = mockk<StarshipService>()

    protected lateinit var people: People
    protected lateinit var person: Person
    protected lateinit var personSwapiDto: PersonSwapiDto
    protected lateinit var personWithStarshipDto: PersonWithStarshipDto
    protected lateinit var starship: Starship
    protected lateinit var starships: Starships
    protected lateinit var starshipSwapiDto: StarshipSwapiDto
    protected lateinit var starshipWithPersonDto: StarshipWithPersonDto

    protected lateinit var personControllerImpl: PersonController
    protected lateinit var personMapperImpl: PersonMapper
    protected lateinit var personServiceImpl: PersonService
    protected lateinit var starshipControllerImpl: StarshipController
    protected lateinit var starshipMapperImpl: StarshipMapper
    protected lateinit var starshipServiceImpl: StarshipService

    @BeforeEach
    fun mockResponses() {
        people = PeopleModel.basic()
        person = PersonModel.basic()
        personSwapiDto = PersonSwapiDtoModel.baisc()
        personWithStarshipDto = PersonWithStarshipDtoModel.basic()
        starship = StarshipModel.basic(listOf(person))
        starships = StarshipsModel.basic()
        starshipSwapiDto = StarshipSwapiDtoModel.basic()
        starshipWithPersonDto = StarshipWithPersonDtoModel.basic()

        personControllerImpl = PersonController(personService)
        personMapperImpl = PersonMapper()
        personServiceImpl = PersonService(personMapper, personRepository)
        starshipControllerImpl = StarshipController(starshipService)
        starshipMapperImpl = StarshipMapper()
        starshipServiceImpl = StarshipService(starshipMapper, starshipRepository)

        every { personMapper.toDto(listOf(person)) } returns people
        every { personRepository.findAllByName("Luke Skywalker") } returns listOf(person)
        every { personRepository.findAll() } returns listOf(person)
        every { personService.findPeople() } returns people
        every { personService.findPeopleByName("Luke Skywalker") } returns people
        every { starshipMapper.toDto(listOf(starship)) } returns starships
        every { starshipRepository.findAllByName("X-wing") } returns listOf(starship)
        every { starshipRepository.findAll() } returns listOf(starship)
        every { starshipService.findStarships() } returns starships
        every { starshipService.findStarshipsByName("X-wing") } returns starships
    }
}
