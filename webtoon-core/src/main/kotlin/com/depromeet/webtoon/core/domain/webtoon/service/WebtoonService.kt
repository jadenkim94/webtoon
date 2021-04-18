package com.depromeet.webtoon.core.domain.webtoon.service

import com.depromeet.webtoon.core.domain.webtoon.dto.WebtoonCreateRequest
import com.depromeet.webtoon.core.domain.webtoon.dto.WebtoonCreateResponseDto
import com.depromeet.webtoon.core.domain.webtoon.dto.toWebtoonCreateResponseDto
import com.depromeet.webtoon.core.domain.webtoon.model.Webtoon
import com.depromeet.webtoon.core.domain.webtoon.repository.WebtoonRepository
import org.springframework.stereotype.Service

@Service
class WebtoonService(
    val webtoonRepository: WebtoonRepository
) {
    fun getWebtoons(): List<WebtoonCreateResponseDto> {
        val webtoon = webtoonRepository.findAll()

        return webtoon.map { it.toWebtoonCreateResponseDto() }
    }

    fun createWebtoon(request: WebtoonCreateRequest): WebtoonCreateResponseDto {
        val newWebtoon = Webtoon(title = request.title, authors = request.authors)
        val savedNewWebtoon = webtoonRepository.save(newWebtoon)
        return savedNewWebtoon.toWebtoonCreateResponseDto()
    }
}
