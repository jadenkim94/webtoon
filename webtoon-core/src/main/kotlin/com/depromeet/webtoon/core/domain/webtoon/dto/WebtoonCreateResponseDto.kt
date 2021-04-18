package com.depromeet.webtoon.core.domain.webtoon.dto

import com.depromeet.webtoon.core.domain.webtoon.model.Webtoon
import java.time.LocalDateTime

data class WebtoonCreateResponseDto(
    val id: Long?,
    val title: String,
    val author: List<WebtoonAuthorVo>,
    val createdAt: LocalDateTime?,
    val lastModifiedAt: LocalDateTime?
)

fun Webtoon.toWebtoonCreateResponseDto(): WebtoonCreateResponseDto {
    return WebtoonCreateResponseDto(
        this.id,
        this.title,
        this.authors.map { author -> WebtoonAuthorVo(author.id, author.name) },
        this.createdAt,
        this.modifiedAt
    )
}
