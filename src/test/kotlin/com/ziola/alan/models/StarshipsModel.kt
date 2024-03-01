package com.ziola.alan.models

import com.ziola.alan.dtos.Starships

internal object StarshipsModel {
    fun basic(): Starships {
        return Starships(
            starships = listOf(StarshipWithPersonDtoModel.basic()),
        )
    }
}
