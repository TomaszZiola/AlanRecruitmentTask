package com.ziola.alan.controllers

import com.ziola.alan.dtos.PeopleDto
import com.ziola.alan.services.PersonService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/people")
class PersonController(
    private val personService: PersonService,
) {
    @GetMapping("/{name}")
    fun getPeopleByName(
        @PathVariable name: String,
    ): PeopleDto {
        return personService.findPeopleByName(name)
    }

    @GetMapping
    fun getPeople(): PeopleDto {
        return personService.findPeople()
    }
}
