package com.ziola.alan.services

import com.ziola.alan.dtos.StarshipsDto
import com.ziola.alan.mappers.StarshipMapper
import com.ziola.alan.repositories.StarshipRepository
import org.springframework.stereotype.Service

@Service
class StarshipService(
    private val starshipMapper: StarshipMapper,
    private val starshipRepository: StarshipRepository,
) {
    fun findStarshipsByName(name: String): StarshipsDto {
        return starshipRepository.findAllByName(name)
            .let { starshipMapper.toDto(it) }
    }

    fun findStarships(): StarshipsDto {
        return starshipRepository.findAll()
            .let { starshipMapper.toDto(it) }
    }
}
