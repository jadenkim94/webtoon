package com.depromeet.webtoon.domain.author

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.context.request.WebRequest
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler

@ControllerAdvice
class ApiValidationExceptionHandler : ResponseEntityExceptionHandler() {

    @ExceptionHandler(value = [ApiValidationException::class])
    fun handleConflict(ex: ApiValidationException, request: WebRequest): ResponseEntity<Any> {
        return ResponseEntity.badRequest().body(ex.message.toString())
    }
}
