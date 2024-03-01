package com.ziola.alan.repositories

import com.ziola.alan.entities.Starship
import org.springframework.data.jpa.repository.JpaRepository

interface StarshipRepository : JpaRepository<Starship, Long> {
    fun findAllByName(name: String): List<Starship>
}
