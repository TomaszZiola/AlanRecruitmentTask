package com.ziola.alan.controllers

import com.ziola.alan.dtos.Starships
import com.ziola.alan.services.StarshipService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/starships")
class StarshipController(
    private val starshipService: StarshipService,
) {
    @GetMapping("/{name}")
    fun getStarshipsByName(
        @PathVariable name: String,
    ): Starships {
        return starshipService.findPeopleByName(name)
    }

    @GetMapping
    fun getStarships(): Starships {
        return starshipService.findPeople()
    }
}
