package com.depromeet.webtoon.core.crawl.daum

import com.depromeet.webtoon.core.crawl.daum.dto.DaumWebtoonCrawlResult
import com.depromeet.webtoon.core.domain.author.Author
import com.depromeet.webtoon.core.domain.webtoon.Webtoon
import org.springframework.stereotype.Component

@Component
class DaumRequestAdapter {

    fun rawWebtoonListToWebtoonList(daumWebtoonCrawlResult: DaumWebtoonCrawlResult): List<Webtoon> {
        val rawWebtoonList = daumWebtoonCrawlResult.data.webtoons

        return rawWebtoonList.map { rawWebtoon ->
            Webtoon(
                rawWebtoon.title,
                // List<Author>
                rawWebtoon.cartoon.artists.map { artist -> Author(artist.name, emptyList()) }
                    .distinctBy { author -> author.name }
            )
        }
    }
}
