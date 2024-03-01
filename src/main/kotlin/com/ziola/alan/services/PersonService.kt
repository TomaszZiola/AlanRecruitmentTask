package com.ziola.alan.services

import com.ziola.alan.dtos.PeopleDto
import com.ziola.alan.mappers.PersonMapper
import com.ziola.alan.repositories.PersonRepository
import org.springframework.stereotype.Service

@Service
class PersonService(
    private val personMapper: PersonMapper,
    private val personRepository: PersonRepository,
) {
    fun findPeopleByName(name: String): PeopleDto {
        return personRepository.findAllByName(name)
            .let { personMapper.toDto(it) }
    }

    fun findPeople(): PeopleDto {
        return personRepository.findAll()
            .let { personMapper.toDto(it) }
    }
}
