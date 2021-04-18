package com.depromeet.webtoon.core.domain.webtoon.model

import com.depromeet.webtoon.core.domain.author.model.Author
import com.depromeet.webtoon.core.domain.author.authorFixture
import com.depromeet.webtoon.core.type.WebtoonSite
import java.time.LocalDateTime

fun webtoonFixture(
    id: Long = 1L,
    site: WebtoonSite = WebtoonSite.NAVER,
    title: String = "테스트작품",
    authors: List<Author> = listOf(authorFixture(1L, "테스트 작가")),
    createdAt: LocalDateTime = LocalDateTime.now(),
    modifiedAt: LocalDateTime = LocalDateTime.now(),
) = Webtoon(
    id = id,
    site = site,
    title = title,
    authors = authors,
    createdAt = createdAt,
    modifiedAt = modifiedAt
)
