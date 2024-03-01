package com.ziola.alan.mappers

import com.ziola.alan.utils.BaseUnitTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class PersonMapperTest : BaseUnitTest() {
    @Test
    fun `PersonMapper#toEntity should map PersonSwapiDto to Person`() {
        // when
        val result = personMapperImpl.toEntity(1L, personSwapiDto)

        // then
        assertThat(result).isEqualTo(person)
    }

    @Test
    fun `PersonMapper#toDto should map Person to PersonWithStarshipDto`() {
        // when
        val result = personMapperImpl.toDto(listOf(person))

        // then
        assertThat(result).isEqualTo(peopleDto)
    }
}
