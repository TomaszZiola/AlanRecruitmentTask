package com.ziola.alan.dtos

import com.ziola.alan.configurations.NoArgsConst

@NoArgsConst
data class StarshipsDto(val starships: List<StarshipWithPersonDto>)
