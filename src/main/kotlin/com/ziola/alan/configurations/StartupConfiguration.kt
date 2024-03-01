package com.ziola.alan.configurations

import com.ziola.alan.services.PersonService
import jakarta.annotation.PostConstruct
import org.springframework.context.annotation.Configuration

@Configuration
class StartupConfiguration(
    private val service: PersonService,
) {
    @PostConstruct
    fun executeOnStartup() {
        service.retrievePeopleWithStarshipsAndSave()
    }
}
