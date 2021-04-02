package com.depromeet.webtoon.domain.webtoon

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class WebtoonService(@Autowired val webtoonRepository: WebtoonRepository) {

    fun getWebtoons(): List<WebtoonDto> {
        val webtoon = webtoonRepository.findAll()
        return webtoon.map { it.toWebtoonDto() }
    }

    fun createWebtoon(webtoonCreateDto: WebtoonCreateDto): WebtoonDto {
        val createdAt = LocalDateTime.now()
        val newWebtoon = Webtoon(webtoonCreateDto.name, webtoonCreateDto.author, createdAt, createdAt)
        val savedNewWebtoon = webtoonRepository.save(newWebtoon)
        return savedNewWebtoon.toWebtoonDto()
    }
}
