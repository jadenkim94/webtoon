package com.depromeet.webtoon.domain.webtoon

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class WebtoonService (@Autowired val webtoonRepository: WebtoonRepository){

    fun getWebtoons(): List<WebtoonDto>{
        val webtoon = webtoonRepository.findAll()
        return webtoon.map{ it.toWebtoonDto() }
    }
}