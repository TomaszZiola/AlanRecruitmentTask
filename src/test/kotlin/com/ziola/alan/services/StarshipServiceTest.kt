package com.ziola.alan.services

import com.ziola.alan.utils.BaseUnitTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class StarshipServiceTest : BaseUnitTest() {
    @Test
    fun `StarshipService#findStarshipsByName should return list of StarshipWithPersonDto`() {
        // when
        val result = starshipServiceImpl.findStarshipsByName("X-wing")

        // then
        assertThat(result).isEqualTo(starships)
    }

    @Test
    fun `StarshipService#findStarships should return list of StarshipWithPersonDto`() {
        // when
        val result = starshipServiceImpl.findStarships()

        // then
        assertThat(result).isEqualTo(starships)
    }
}
