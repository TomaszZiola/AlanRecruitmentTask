package com.ziola.alan.models

import com.ziola.alan.dtos.PeopleDto

internal object PeopleDtoModel {
    fun basic(): PeopleDto {
        return PeopleDto(
            people = listOf(PersonWithStarshipDtoModel.basic()),
        )
    }
}
