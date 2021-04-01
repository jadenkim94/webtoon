package com.depromeet.webtoon.domain.webtoon

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class WebtoonController (@Autowired val webtoonService: WebtoonService){

    private val log = LoggerFactory.getLogger(WebtoonController::class.java)

    @GetMapping("/api/v1/webtoons")
    fun getWebtoonList(): ResponseEntity<List<WebtoonDto>> {
        log.info("웹툰 리스트 요청")
         return ResponseEntity.ok(webtoonService.getWebtoons())

    }


}