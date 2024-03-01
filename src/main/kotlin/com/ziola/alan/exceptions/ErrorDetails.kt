package com.ziola.alan.exceptions

import com.fasterxml.jackson.annotation.JsonProperty

data class ErrorDetails(
    @JsonProperty("message") val message: String,
)
