package com.ziola.alan.entities

import com.ziola.alan.entities.base.BaseEntity
import jakarta.persistence.CascadeType.MERGE
import jakarta.persistence.CascadeType.PERSIST
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.JoinTable
import jakarta.persistence.ManyToMany
import jakarta.persistence.Table
import java.time.ZonedDateTime

@Entity
@Table(name = "person")
@Suppress("LongParameterList")
class Person(
    @Id
    override var id: Long?,
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
    @ManyToMany(cascade = [PERSIST, MERGE])
    @JoinTable(name = "person_starship", joinColumns = [JoinColumn(name = "person_id")], inverseJoinColumns = [JoinColumn(name = "starship_id")])
    val starships: MutableSet<Starship> = mutableSetOf()

    override fun toString(): String {
        return "Person(name='$name', height='$height', mass='$mass', hairColor='$hairColor', skinColor='$skinColor', " +
            "eyeColor='$eyeColor', birthYear='$birthYear', gender='$gender', " +
            "created=$created, edited=$edited, id=$id)"
    }
}
