package com.ziola.alan.dtos

import com.ziola.alan.configurations.NoArgsConst

@NoArgsConst
data class PeopleDto(val people: List<PersonWithStarshipDto>)
