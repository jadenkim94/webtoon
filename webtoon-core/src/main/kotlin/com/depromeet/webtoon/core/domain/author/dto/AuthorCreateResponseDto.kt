package com.depromeet.webtoon.core.domain.author.dto

import com.depromeet.webtoon.core.domain.author.model.Author
import java.time.LocalDateTime

data class AuthorCreateResponseDto(
    val id: Long?,
    val name: String,
    val createdAt: LocalDateTime,
    val modifiedAt: LocalDateTime
)

fun Author.toAuthorCreateResponseDto(): AuthorCreateResponseDto = AuthorCreateResponseDto(
    id = this.id,
    name = this.name,
    createdAt = this.createdAt!!,
    modifiedAt = this.modifiedAt!!
)
