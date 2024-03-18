package com.ziola.alan.entities

import com.ziola.alan.entities.base.BaseEntity
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.ManyToMany
import jakarta.persistence.Table
import java.time.ZonedDateTime

@Entity
@Table(name = "starship")
@Suppress("LongParameterList")
class Starship(
    @Id
    override var id: Long? = null,
    val name: String,
    val model: String,
    val manufacturer: String,
    val costInCredits: String,
    val length: String,
    val maxAtmospheringSpeed: String,
    val crew: String,
    val passengers: String,
    val cargoCapacity: String,
    val consumables: String,
    val hyperdriveRating: String,
    val mglt: String,
    val starshipClass: String,
    val created: ZonedDateTime,
    val edited: ZonedDateTime,
) : BaseEntity<Long>() {
    @ManyToMany(mappedBy = "starships")
    val people: MutableSet<Person> = mutableSetOf()

    override fun toString(): String {
        return "Starship(name='$name', model='$model', manufacturer='$manufacturer', costInCredits='$costInCredits', " +
            "length='$length', maxAtmospheringSpeed='$maxAtmospheringSpeed', crew='$crew', passengers='$passengers'" +
            ", cargoCapacity='$cargoCapacity', consumables='$consumables', hyperdriveRating='$hyperdriveRating', " +
            "mglt='$mglt', starshipClass='$starshipClass', created=$created, edited=$edited, id=$id)"
    }
}
