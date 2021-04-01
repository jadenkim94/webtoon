package com.depromeet.webtoon.domain.webtoon

import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
class WebtoonController (@Autowired val webtoonService: WebtoonService){

    private val log = LoggerFactory.getLogger(WebtoonController::class.java)

    @GetMapping("/api/v1/webtoons")
    fun getWebtoonList(): ResponseEntity<List<WebtoonDto>> {
        log.info("웹툰 리스트 요청")
        return ResponseEntity.ok(webtoonService.getWebtoons())
    }

    @PostMapping("/api/v1/webtoons")
    @ResponseBody
    fun createWebtoon(@RequestBody webtoonCreateDto: WebtoonCreateDto): ResponseEntity<WebtoonDto> {
        val createdWebtoonDto = webtoonService.createWebtoon(webtoonCreateDto)

        log.info("웹툰 생성")
        return ResponseEntity.status(201).body(createdWebtoonDto)
    }



}