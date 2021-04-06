package com.depromeet.webtoon.domain.author.dto

import com.depromeet.webtoon.domain.author.Author
import org.springframework.validation.Errors
import java.time.LocalDateTime

data class AuthorCreateResponseDto(
    val id: Long?,
    val name: String,
    val createdAt: LocalDateTime,
    val lastModifiedAt: LocalDateTime
)

fun Author.toAuthorCreateResponseDto(): AuthorCreateResponseDto {
    return AuthorCreateResponseDto(
        this.id,
        this.name,
        this.createdAt,
        this.lastModifiedAt
    )
}
