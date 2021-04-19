package com.depromeet.webtoon.core.crawl.daum

import com.depromeet.webtoon.core.crawl.daum.dto.DaumWebtoonCrawlResult
import com.depromeet.webtoon.core.domain.webtoon.model.Webtoon
import org.springframework.stereotype.Component

@Component
class DaumRequestAdapter {

    // TODO 수정 필요!
    fun rawWebtoonListToWebtoonList(daumWebtoonCrawlResult: DaumWebtoonCrawlResult): List<Webtoon> {
//        val rawWebtoonList = daumWebtoonCrawlResult.data.webtoons
//
//        val webtoonList = rawWebtoonList.map { rawWebtoon ->
//            Webtoon(
//                title = rawWebtoon.title,
//
//                // List<Author>
//                rawWebtoon.cartoon.artists.map { artist -> Author(artist.name, emptyList()) }
//                    .distinctBy { author -> author.name }
//            )
//        }
//        return webtoonList

        return emptyList()
    }
}
