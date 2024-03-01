package com.ziola.alan.services

import com.ziola.alan.dtos.Starships
import com.ziola.alan.mappers.StarshipMapper
import com.ziola.alan.repositories.StarshipRepository
import org.springframework.stereotype.Service

@Service
class StarshipService(
    private val starshipMapper: StarshipMapper,
    private val starshipRepository: StarshipRepository,
) {
    fun findStarshipsByName(name: String): Starships {
        return starshipRepository.findAllByName(name)
            .let { starshipMapper.toDto(it) }
    }

    fun findStarships(): Starships {
        return starshipRepository.findAll()
            .let { starshipMapper.toDto(it) }
    }
}
