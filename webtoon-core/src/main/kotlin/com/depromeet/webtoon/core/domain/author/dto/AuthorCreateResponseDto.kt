package com.depromeet.webtoon.core.domain.author.dto

import com.depromeet.webtoon.core.domain.author.Author
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
