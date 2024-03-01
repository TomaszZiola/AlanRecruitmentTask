package com.ziola.alan.services

import com.ziola.alan.utils.BaseUnitTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class StarshipServiceTest : BaseUnitTest() {
    @Test
    fun `StarshipService#findAllByName should return list of StarshipWithPersonDto`() {
        // when
        val result = starshipServiceImpl.findPeopleByName("X-wing")

        // then
        assertThat(result).isEqualTo(starships)
    }

    @Test
    fun `StarshipService#findAll should return list of StarshipWithPersonDto`() {
        // when
        val result = starshipServiceImpl.findPeople()

        // then
        assertThat(result).isEqualTo(starships)
    }
}
