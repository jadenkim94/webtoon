package com.depromeet.webtoon.core.crawl.daum

import com.depromeet.webtoon.core.crawl.daum.dto.DaumWebtoonCrawlResult
import com.depromeet.webtoon.core.domain.webtoon.Webtoon
import com.depromeet.webtoon.core.domain.webtoon.WebtoonRepository
import org.springframework.http.HttpHeaders
import org.springframework.http.MediaType
import org.springframework.web.reactive.function.client.WebClient
import java.time.Instant

/*
DaumCrawlService(daumRequestAdapter:DaumRequestAdapter) {
    getPopularWebtoons() {
        val result = daumRequestAdapter.fetchPopularWebtoons()
        return result.map{ it.refine() }
    }

    savePopularWebtoons(daumWebtoons:List<Webtoon>) {
        repository.save(daumWebtoons)
    }

    getWeekdayWebtoons(){
        val result = daumRequestAdapter.fetchWeekdayWebtoons()
        return result.map{it.refine()}
    }

    saveWeekdayWebtoons(daumWebtoons:List<Webtoon>) {
        repository.save(daumWebtoons)
    }
}
 */
// API 서비스 호출 + 정제
class DaumCrawlerService(val daumRequestAdapter: DaumRequestAdapter, val webtoonRepository: WebtoonRepository) {

    fun getPopularWebtoons(): List<Webtoon> {
        val client: WebClient = WebClient.builder()
            .baseUrl("http://m.webtoon.daum.net")
            .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
            .build()

        val currentTime = Instant.now().toEpochMilli()

        val result = client.get()
            .uri("data/mobile/webtoon?sort=view&page_size=50&page_no=1&$currentTime").retrieve()
            .bodyToMono(DaumWebtoonCrawlResult::class.java).block()

        val webToonList = daumRequestAdapter.rawWebtoonListToWebtoonList(result!!)
        
        webToonList.forEach { println(it) }
        return webToonList
    }
}
