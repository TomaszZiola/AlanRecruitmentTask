package com.ziola.alan.repositories

import com.ziola.alan.entities.Person
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param

interface PersonRepository : JpaRepository<Person, Long> {
    @Query("SELECT DISTINCT p FROM Person p LEFT JOIN FETCH p.starships WHERE p.name = :name")
    fun findAllByName(
        @Param("name") name: String,
    ): List<Person>

    @Query("SELECT DISTINCT p FROM Person p LEFT JOIN FETCH p.starships")
    override fun findAll(): List<Person>
}
