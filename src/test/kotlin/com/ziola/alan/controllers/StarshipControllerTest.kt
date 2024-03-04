package com.ziola.alan.controllers

import com.ziola.alan.utils.BaseUnitTest
import io.mockk.verifySequence
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class StarshipControllerTest : BaseUnitTest() {
    @Test
    fun `StarshipController#getStarshipsByName should return StarshipsDto`() {
        // when
        val result = starshipControllerImpl.getStarshipsByName("X-wing")

        // then
        assertThat(result).isEqualTo(starshipsDto)

        verifySequence {
            starshipService.findStarshipsByName("X-wing")
        }
    }

    @Test
    fun `StarshipController#getStarships should return StarshipsDto`() {
        // when
        val result = starshipControllerImpl.getStarships()

        // then
        assertThat(result).isEqualTo(starshipsDto)

        verifySequence {
            starshipService.findStarships()
        }
    }
}
