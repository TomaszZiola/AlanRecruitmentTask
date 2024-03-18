package com.ziola.alan.integration

import com.github.tomakehurst.wiremock.junit5.WireMockTest
import com.lectra.koson.arr
import com.lectra.koson.obj
import com.ziola.alan.dtos.PeopleDto
import com.ziola.alan.dtos.StarshipsDto
import com.ziola.alan.utils.BaseEndToEndTest
import io.restassured.module.kotlin.extensions.Extract
import io.restassured.module.kotlin.extensions.Given
import io.restassured.module.kotlin.extensions.Then
import io.restassured.module.kotlin.extensions.When
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

@WireMockTest(httpPort = 8081)
internal class IntegrationTest : BaseEndToEndTest() {
    @Test
    fun `Application on startup should save to database People and Starships received from client`() {
        assertThat(personRepository.findAll().size).isEqualTo(3)
        assertThat(starshipRepository.findAll().size).isEqualTo(3)
    }

    @Test
    fun `GET#should return PeopleDto`() {
        Given {
            port(port)
        } When {
            get("people")
        } Then {
            statusCode(200)
        } Extract {
            assert(
                result = body(),
                expected =
                    obj {
                        "people" to
                            arr[
                                basicPeopleResponse(
                                    starships =
                                        setOf(
                                            basicStarshipResponse(),
                                            basicStarshipResponse(name = "Slave 1"),
                                        ),
                                ),
                                basicPeopleResponse(
                                    name = "R2-D2",
                                ),
                                basicPeopleResponse(
                                    name = "Darth Vader",
                                    starships =
                                        setOf(
                                            basicStarshipResponse(name = "Slave 1"),
                                        ),
                                ),
                            ]
                    },
                classType = PeopleDto::class.java,
            )
        }
    }

    @Test
    fun `GET#should return PeopleDto filtered by name`() {
        Given {
            port(port)
        } When {
            get("people/{name}", "Luke Skywalker")
        } Then {
            statusCode(200)
        } Extract {
            assert(
                result = body(),
                expected =
                    obj {
                        "people" to
                            arr[
                                basicPeopleResponse(
                                    starships =
                                        setOf(
                                            basicStarshipResponse(),
                                            basicStarshipResponse(name = "Slave 1"),
                                        ),
                                ),
                            ]
                    },
                classType = PeopleDto::class.java,
            )
        }
    }

    @Test
    fun `GET#should return StarshipsDto`() {
        Given {
            port(port)
        } When {
            get("starships")
        } Then {
            statusCode(200)
        } Extract {
            assert(
                result = body(),
                expected =
                    obj {
                        "starships" to
                            arr[
                                basicStarshipResponse(
                                    people = setOf(basicPeopleResponse()),
                                ),
                                basicStarshipResponse(name = "Star Destroyer"),
                                basicStarshipResponse(
                                    name = "Slave 1",
                                    people =
                                        setOf(
                                            basicPeopleResponse(),
                                            basicPeopleResponse(
                                                name = "Darth Vader",
                                            ),
                                        ),
                                ),
                            ]
                    },
                classType = StarshipsDto::class.java,
            )
        }
    }

    @Test
    fun `GET#should return StarshipsDto filtered by name`() {
        Given {
            port(port)
        } When {
            get("starships/{name}", "X-wing")
        } Then {
            statusCode(200)
        } Extract {
            assert(
                result = body(),
                expected =
                    obj {
                        "starships" to
                            arr[
                                basicStarshipResponse(
                                    people = setOf(basicPeopleResponse()),
                                ),
                            ]
                    },
                classType = StarshipsDto::class.java,
            )
        }
    }
}
