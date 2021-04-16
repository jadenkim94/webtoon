package com.depromeet.webtoon.core.crawl.daum

import io.kotest.core.spec.style.FunSpec

class DaumCrawlerServiceTest : FunSpec({

    test("crawl") {
        val crawlService = DaumCrawlerService(daumRequestAdapter = DaumRequestAdapter())
        crawlService.getPopularWebtoons()
    }
})
