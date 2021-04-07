package com.depromeet.webtoon.core.domain.webtoon.dto

import com.depromeet.webtoon.core.domain.webtoon.Webtoon
import java.time.LocalDateTime

data class WebtoonCreateResponseDto(
    val id: Long?,
    val name: String,
    val author: List<WebtoonAuthorVo>,
    val createdAt: LocalDateTime,
    val lastModifiedAt: LocalDateTime
)

fun Webtoon.toWebtoonCreateResponseDto(): WebtoonCreateResponseDto {
    return WebtoonCreateResponseDto(
        this.id,
        this.name,
        this.authors.map { author -> WebtoonAuthorVo(author.id, author.name) },
        this.createdAt,
        this.lastModifiedAt
    )
}
