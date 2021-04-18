package com.depromeet.webtoon.core.domain.webtoon.service

import com.depromeet.webtoon.core.domain.webtoon.dto.WebtoonCreateRequest
import com.depromeet.webtoon.core.domain.webtoon.dto.WebtoonCreateResponseDto
import com.depromeet.webtoon.core.domain.webtoon.dto.WebtoonUpsertRequest
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

    fun upsertWebtoon(request: WebtoonUpsertRequest): Webtoon {
        val optionalWebtoon = webtoonRepository.findBySiteAndTitle(request.site, request.title)
        // 이미 존재하는 경우 내부 데이터를 업데이트합니다.
        return if (optionalWebtoon != null) {
            optionalWebtoon.apply {
                site = request.site
                title = request.title
                authors = request.authors.toMutableList()
            }
        }
        // 존재하지 않는 경우 새롭게 데이터를 입력한 다음 저장
        else {
            Webtoon(title = request.title, site = request.site, authors = request.authors)
                .let { webtoonRepository.save(it) }
        }
    }
}
