package com.depromeet.webtoon.domain.webtoon

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class WebtoonController {

    @Autowired
    private lateinit var webtoonService: WebtoonService

    @GetMapping("/api/v1/webtoons")
    fun getWebtoonList(): ResponseEntity<Any> {
         return ResponseEntity.ok(webtoonService.getWebtoons());

    }


}