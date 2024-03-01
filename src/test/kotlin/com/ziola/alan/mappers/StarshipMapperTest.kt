package com.ziola.alan.mappers

import com.ziola.alan.utils.BaseUnitTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class StarshipMapperTest : BaseUnitTest() {
    @Test
    fun `StarshipMapper#toEntity should map StarshipSwapiDto to Starship`() {
        // when
        val result = starshipMapperImpl.toEntity(1L, starshipSwapiDto)

        // then
        assertThat(result).isEqualTo(starship)
    }

    @Test
    fun `StarshipMapper#toDto should map Starship to StarshipWithPersonDto`() {
        // when
        val result = starshipMapperImpl.toDto(listOf(starship))

        // then
        assertThat(result).isEqualTo(starships)
    }
}
