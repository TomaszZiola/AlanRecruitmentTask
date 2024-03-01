package com.ziola.alan.dtos

import com.ziola.alan.configurations.NoArgsConst

@NoArgsConst
data class People(val people: List<PersonWithStarshipDto>)
