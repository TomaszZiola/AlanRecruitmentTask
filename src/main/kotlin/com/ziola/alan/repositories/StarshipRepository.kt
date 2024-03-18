package com.ziola.alan.repositories

import com.ziola.alan.entities.Starship
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param

interface StarshipRepository : JpaRepository<Starship, Long> {
    @Query("SELECT DISTINCT s FROM Starship s JOIN FETCH s.people WHERE s.name = :name")
    fun findAllByName(@Param("name") name: String): List<Starship>

    @Query("SELECT DISTINCT s FROM Starship s JOIN FETCH s.people")
    override fun findAll(): List<Starship>
}
