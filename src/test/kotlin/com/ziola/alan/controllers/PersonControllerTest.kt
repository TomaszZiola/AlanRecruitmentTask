package com.ziola.alan.controllers

import com.ziola.alan.utils.BaseUnitTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class PersonControllerTest : BaseUnitTest() {
    @Test
    fun `PersonController#getPeopleByName should return PeopleDto`() {
        // when
        val result = personControllerImpl.getPeopleByName("Luke Skywalker")

        // then
        assertThat(result).isEqualTo(peopleDto)
    }

    @Test
    fun `PersonController#getPeople should return PeopleDto`() {
        // when
        val result = personControllerImpl.getPeople()

        // then
        assertThat(result).isEqualTo(peopleDto)
    }
}
