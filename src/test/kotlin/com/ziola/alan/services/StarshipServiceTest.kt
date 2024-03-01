package com.ziola.alan.services

import com.ziola.alan.utils.BaseUnitTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class StarshipServiceTest : BaseUnitTest() {
    @Test
    fun `StarshipService#findStarshipsByName should return StarshipsDto`() {
        // when
        val result = starshipServiceImpl.findStarshipsByName("X-wing")

        // then
        assertThat(result).isEqualTo(starshipsDto)
    }

    @Test
    fun `StarshipService#findStarships should return StarshipsDto`() {
        // when
        val result = starshipServiceImpl.findStarships()

        // then
        assertThat(result).isEqualTo(starshipsDto)
    }
}
