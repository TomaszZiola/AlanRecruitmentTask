package com.ziola.alan.controllers

import com.ziola.alan.utils.BaseUnitTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class StarshipControllerTest : BaseUnitTest() {
    @Test
    fun `StarshipController#getStarshipsByName should return list of StarshipWithPersonDto`() {
        // when
        val result = starshipControllerImpl.getStarshipsByName("X-wing")

        // then
        assertThat(result).isEqualTo(starships)
    }

    @Test
    fun `StarshipController#getStarships should return list of StarshipWithPersonDto`() {
        // when
        val result = starshipControllerImpl.getStarships()

        // then
        assertThat(result).isEqualTo(starships)
    }
}
