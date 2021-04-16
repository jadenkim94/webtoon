package com.depromeet.webtoon.core.crawl.daum.dto

data class DaumWebtoonCrawlResult(

    val result: Result,
    val metaData: String?,
    val data: Data,
    val page: Page
)

data class Result(

    val status: Int,
    val message: String
)

data class Data(

    val webtoons: List<Webtoons>,
    val webtoonTotalCount: Int
)

data class Webtoons(

    val id: Int,
    val title: String,
    val finishYn: String,
    val thumbnailImage2: ThumbnailImage2,
    val restYn: String,
    val dateCreated: Long,
    val cartoon: Cartoon,
    val latestWebtoonEpisode: LatestWebtoonEpisode,
    val averageScore: Double
)
