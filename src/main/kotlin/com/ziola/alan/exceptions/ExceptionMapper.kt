package com.ziola.alan.exceptions

import org.springframework.http.HttpStatus.NOT_FOUND
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

@ControllerAdvice
class ExceptionMapper {
    @ExceptionHandler(StarshipNotFoundException::class)
    fun handleStarshipNotFoundException(ex: StarshipNotFoundException): ResponseEntity<ErrorDetails> {
        val body = ErrorDetails(ex.localizedMessage)
        return ResponseEntity<ErrorDetails>(body, NOT_FOUND)
    }
}
