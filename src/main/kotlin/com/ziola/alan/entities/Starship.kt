package com.ziola.alan.entities

import com.ziola.alan.entities.base.BaseEntity
import jakarta.persistence.Entity
import jakarta.persistence.FetchType.LAZY
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType.SEQUENCE
import jakarta.persistence.Id
import jakarta.persistence.ManyToOne
import jakarta.persistence.SequenceGenerator
import jakarta.persistence.Table
import java.time.ZonedDateTime

@Entity
@Table(name = "starship")
@Suppress("LongParameterList")
class Starship(
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
    @ManyToOne(fetch = LAZY)
    var person: Person,
) : BaseEntity<Long>() {
    @Id
    @SequenceGenerator(name = "starship_sq", sequenceName = "starship_sq", allocationSize = 1)
    @GeneratedValue(strategy = SEQUENCE, generator = "starship_sq")
    override var id: Long? = null

    override fun toString(): String {
        return "Starship(name='$name', model='$model', manufacturer='$manufacturer', costInCredits='$costInCredits', " +
            "length='$length', maxAtmospheringSpeed='$maxAtmospheringSpeed', crew='$crew', passengers='$passengers'" +
            ", cargoCapacity='$cargoCapacity', consumables='$consumables', hyperdriveRating='$hyperdriveRating', " +
            "mglt='$mglt', starshipClass='$starshipClass', created=$created, edited=$edited, id=$id)"
    }
}
