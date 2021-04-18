package com.depromeet.webtoon.core.application.imports

import com.depromeet.webtoon.core.application.imports.dto.WebtoonImportRequest
import com.depromeet.webtoon.core.type.WebtoonSite
import com.depromeet.webtoon.core.type.WebtoonSite.NAVER
import java.time.DayOfWeek

fun webtoonImportRequestFixture(
    title: String = "고양이 일상",
    dayOfWeeks: List<DayOfWeek> = listOf(DayOfWeek.MONDAY, DayOfWeek.THURSDAY),
    authors: List<String> = listOf("감자", "웅"),
    site: WebtoonSite = NAVER,
    genres: List<String> = listOf("고양이", "일상"),
    score: Double = 4.8,
    popular: Int = 2,
) = WebtoonImportRequest(
    title = title,
    dayOfWeeks = dayOfWeeks,
    authors = authors,
    site = site,
    genres = genres,
    score = score,
    popular = popular
)
