package com.ziola.alan.configurations

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.client.RestClient
import org.springframework.web.client.RestClient.builder

@Configuration
class SwapiClientConfiguration {
    @Bean
    fun restClient(
        @Value("\${swapi.base.url}") baseUrl: String,
    ): RestClient {
        return builder()
            .baseUrl(baseUrl)
            .build()
    }
}
