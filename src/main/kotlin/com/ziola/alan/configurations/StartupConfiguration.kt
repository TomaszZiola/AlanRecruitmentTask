package com.ziola.alan.configurations

import com.ziola.alan.services.DataFetcher
import jakarta.annotation.PostConstruct
import org.springframework.context.annotation.Configuration

@Configuration
class StartupConfiguration(
    private val dataFetcher: DataFetcher,
) {
    @PostConstruct
    fun executeOnStartup() {
        dataFetcher.retrievePeopleWithStarshipsAndSave()
    }
}
