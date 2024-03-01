package com.ziola.alan.models

import com.ziola.alan.dtos.People

internal object PeopleModel {
    fun basic(): People {
        return People(
            people = listOf(PersonWithStarshipDtoModel.basic()),
        )
    }
}
