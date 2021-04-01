package com.depromeet.webtoon.domain.webtoon

import java.time.LocalDateTime

data class WebtoonDto(
    val id: Long,
    val name: String,
    val author: String,
    val createdAt: LocalDateTime,
    val lastModifiedAt: LocalDateTime
) {
}