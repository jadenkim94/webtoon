package com.depromeet.webtoon.domain.author

import com.depromeet.webtoon.domain.author.dto.AuthorCreateRequestDto
import com.depromeet.webtoon.domain.author.dto.AuthorCreateResponseDto
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.validation.Errors
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class AuthorController(@Autowired val authorService: AuthorService) {

    private val log = LoggerFactory.getLogger(AuthorController::class.java)

    @PostMapping("/api/v1/author")
    fun createAuthor(@RequestBody @Validated authorCreateRequestDto: AuthorCreateRequestDto, errors: Errors): ResponseEntity<AuthorCreateResponseDto> {
        if (errors.hasErrors()) {
            val defaultMessage = errors.fieldError?.defaultMessage
            throw ApiValidationException(defaultMessage!!)
        }
        log.info("작가등록 요청 name -> ${authorCreateRequestDto.name}")
        val savedAuthor = authorService.createAuthor(authorCreateRequestDto)
        return ResponseEntity.ok(savedAuthor)
    }
}
