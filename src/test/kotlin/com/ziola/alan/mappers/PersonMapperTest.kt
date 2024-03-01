package com.ziola.alan.mappers

import com.ziola.alan.utils.BaseUnitTest
import com.ziola.alan.utils.TestUtils.setField
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class PersonMapperTest : BaseUnitTest() {
    @Test
    fun `PersonMapper#toEntity should map PersonSwapiDto and StarshipSwapiDto to Person`() {
        // when
        val result = personMapperImpl.toEntity(personSwapiDto, listOf(starshipSwapiDto))
        setField(result, "id", 1L)
        setField(person, "id", 1L)

        // then
        assertThat(result).isEqualTo(person)
    }

    @Test
    fun `PersonMapper#toDto should map Person to PersonWithStarshipDto`() {
        // when
        val result = personMapperImpl.toDto(listOf(person))

        // then
        assertThat(result).isEqualTo(people)
    }
}
