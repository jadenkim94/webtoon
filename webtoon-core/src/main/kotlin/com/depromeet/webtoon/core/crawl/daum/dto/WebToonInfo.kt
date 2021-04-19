package com.depromeet.webtoon.core.crawl.daum.dto

import com.depromeet.webtoon.core.domain.author.model.Author

data class WebToonInfo(
    val title: String,
    val authors: List<Author>
)
