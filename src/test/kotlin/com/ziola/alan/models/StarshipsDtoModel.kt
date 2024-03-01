package com.ziola.alan.models

import com.ziola.alan.dtos.StarshipsDto

internal object StarshipsDtoModel {
    fun basic(): StarshipsDto {
        return StarshipsDto(
            starships = listOf(StarshipWithPersonDtoModel.basic()),
        )
    }
}
