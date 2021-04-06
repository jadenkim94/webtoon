package com.depromeet.webtoon.exceptions

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.context.request.WebRequest
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler

@ControllerAdvice
class ApiValidationExceptionHandler : ResponseEntityExceptionHandler() {

    @ExceptionHandler(value = [ApiValidationException::class])
    fun handleValidationExceptions(ex: ApiValidationException, request: WebRequest): ResponseEntity<String> {
        return ResponseEntity.badRequest().body(ex.message)
    }
}
