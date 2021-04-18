package com.depromeet.webtoon.core.application.imports.dto

import com.depromeet.webtoon.core.type.WebtoonSite
import java.time.DayOfWeek

data class WebtoonImportRequest(
    val title: String,
    val dayOfWeeks: List<DayOfWeek>,
    val authors: List<String>,
    val site: WebtoonSite,
    val genres: List<String>,
    val score: Double,
    val popular: Int,
)
