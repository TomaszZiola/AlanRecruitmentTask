package com.ziola.alan.services

import com.ziola.alan.utils.BaseUnitTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class PersonServiceTest : BaseUnitTest() {
    @Test
    fun `PersonService#findPeopleByName should return PeopleDto`() {
        // when
        val result = personServiceImpl.findPeopleByName("Luke Skywalker")

        // then
        assertThat(result).isEqualTo(peopleDto)
    }

    @Test
    fun `PersonService#findPeople should return PeopleDto`() {
        // when
        val result = personServiceImpl.findPeople()

        // then
        assertThat(result).isEqualTo(peopleDto)
    }
}
