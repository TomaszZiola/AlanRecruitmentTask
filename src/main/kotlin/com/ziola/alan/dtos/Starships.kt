package com.ziola.alan.dtos

import com.ziola.alan.configurations.NoArgsConst

@NoArgsConst
data class Starships(val starships: List<StarshipWithPersonDto>)
