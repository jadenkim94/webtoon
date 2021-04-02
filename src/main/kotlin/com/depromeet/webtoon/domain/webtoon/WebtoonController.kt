package com.depromeet.webtoon.domain.webtoon

import com.depromeet.webtoon.domain.webtoon.dto.WebtoonCreateRequestDto
import com.depromeet.webtoon.domain.webtoon.dto.WebtoonCreateResponseDto
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController

@RestController
class WebtoonController(@Autowired val webtoonService: WebtoonService) {

    private val log = LoggerFactory.getLogger(WebtoonController::class.java)

    @GetMapping("/api/v1/webtoons")
    fun getWebtoonList(): ResponseEntity<List<WebtoonCreateResponseDto>> {
        log.info("웹툰 리스트 요청")
        return ResponseEntity.ok(webtoonService.getWebtoons())
    }

    @PostMapping("/api/v1/webtoons")
    @ResponseBody
    fun createWebtoon(@RequestBody webtoonCreateRequestDto: WebtoonCreateRequestDto): ResponseEntity<WebtoonCreateResponseDto> {
        log.info("웹툰 생성 요청 입력 값 name -> ${webtoonCreateRequestDto.name}")
        val createdWebtoonDto = webtoonService.createWebtoon(webtoonCreateRequestDto)
        return ResponseEntity.status(HttpStatus.CREATED).body(createdWebtoonDto)
    }
}
