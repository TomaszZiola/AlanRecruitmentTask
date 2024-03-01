package com.ziola.alan.entities

import com.ziola.alan.entities.base.BaseEntity
import jakarta.persistence.CascadeType.PERSIST
import jakarta.persistence.CascadeType.REMOVE
import jakarta.persistence.Entity
import jakarta.persistence.FetchType.EAGER
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType.SEQUENCE
import jakarta.persistence.Id
import jakarta.persistence.OneToMany
import jakarta.persistence.SequenceGenerator
import jakarta.persistence.Table
import java.time.ZonedDateTime

@Entity
@Table(name = "person")
@Suppress("LongParameterList")
class Person(
    val name: String,
    val height: String,
    val mass: String,
    val hairColor: String,
    val skinColor: String,
    val eyeColor: String,
    val birthYear: String,
    val gender: String,
    val created: ZonedDateTime,
    val edited: ZonedDateTime,
) : BaseEntity<Long>() {
    @Id
    @SequenceGenerator(name = "person_sq", sequenceName = "person_sq", allocationSize = 1)
    @GeneratedValue(strategy = SEQUENCE, generator = "person_sq")
    override var id: Long? = null

    @OneToMany(mappedBy = "person", fetch = EAGER, cascade = [PERSIST, REMOVE], orphanRemoval = true)
    val starships: MutableList<Starship> = mutableListOf()

    fun addStarship(starship: Starship) {
        starships.add(starship)
        starship.person = this
    }

    override fun toString(): String {
        return "Person(name='$name', height='$height', mass='$mass', hairColor='$hairColor', skinColor='$skinColor', " +
            "eyeColor='$eyeColor', birthYear='$birthYear', gender='$gender', " +
            "created=$created, edited=$edited, id=$id)"
    }
}
