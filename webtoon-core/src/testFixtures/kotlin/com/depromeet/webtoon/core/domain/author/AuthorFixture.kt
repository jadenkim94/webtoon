package com.depromeet.webtoon.core.domain.author

import com.depromeet.webtoon.core.domain.author.model.Author
import java.time.LocalDateTime

fun authorFixture(
    id: Long = 1L,
    name: String = "작가",
    createAt: LocalDateTime = LocalDateTime.now(),
    modifiedAt: LocalDateTime = LocalDateTime.now()
) = Author(
    id = id,
    name = name,
    createdAt = createAt,
    modifiedAt = modifiedAt
)
