package com.ziola.alan.repositories

import com.ziola.alan.entities.Person
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PersonRepository : JpaRepository<Person, Long> {
    fun findAllByName(name: String): List<Person>
}
