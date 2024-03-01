package com.ziola.alan.integration

import com.github.tomakehurst.wiremock.junit5.WireMockTest
import com.lectra.koson.arr
import com.lectra.koson.obj
import com.ziola.alan.dtos.People
import com.ziola.alan.dtos.Starships
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
    fun `Application on startup should save to database People received from client`() {
        assertThat(personRepository.findAll().size).isEqualTo(3)
        assertThat(starshipRepository.findAll().size).isEqualTo(3)
    }

    @Test
    fun `GET#should return People`() {
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
                                        listOf(
                                            basicStarshipResponse(),
                                            basicStarshipResponse(name = "Imperial shuttle"),
                                        ),
                                ),
                                basicPeopleResponse(
                                    name = "R2-D2",
                                ),
                                basicPeopleResponse(
                                    name = "Darth Vader",
                                    starships =
                                        listOf(
                                            basicStarshipResponse(name = "TIE Advanced x1"),
                                        ),
                                ),
                            ]
                    },
                classType = People::class.java,
            )
        }
    }

    @Test
    fun `GET#should return People filtered by name`() {
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
                                        listOf(
                                            basicStarshipResponse(),
                                            basicStarshipResponse(name = "Imperial shuttle"),
                                        ),
                                ),
                            ]
                    },
                classType = People::class.java,
            )
        }
    }

    @Test
    fun `GET#should return Starships`() {
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
                                    person = basicPeopleResponse(),
                                ),
                                basicStarshipResponse(name = "Imperial shuttle", person = basicPeopleResponse()),
                                basicStarshipResponse(
                                    name = "TIE Advanced x1",
                                    person =
                                        basicPeopleResponse(
                                            name = "Darth Vader",
                                        ),
                                ),
                            ]
                    },
                classType = Starships::class.java,
            )
        }
    }

    @Test
    fun `GET#should return Starships filtered by name`() {
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
                                    person = basicPeopleResponse(),
                                ),
                            ]
                    },
                classType = Starships::class.java,
            )
        }
    }
}
