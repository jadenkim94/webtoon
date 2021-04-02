package com.depromeet.webtoon.domain.webtoon

import com.depromeet.webtoon.domain.author.AuthorRepository
import com.depromeet.webtoon.domain.webtoon.dto.WebtoonCreateRequestDto
import com.depromeet.webtoon.domain.webtoon.dto.WebtoonCreateResponseDto
import com.depromeet.webtoon.domain.webtoon.dto.toWebtoonCreateResponseDto
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class WebtoonService(@Autowired val webtoonRepository: WebtoonRepository, @Autowired val authorRepository: AuthorRepository) {

    fun getWebtoons(): List<WebtoonCreateResponseDto> {
        val webtoon = webtoonRepository.findAll()

        return webtoon.map { it.toWebtoonCreateResponseDto() }
    }

    fun createWebtoon(webtoonCreateRequestDto: WebtoonCreateRequestDto): WebtoonCreateResponseDto {

        val foundedAuthors = webtoonCreateRequestDto.authors.map { authorRepository.findById(it.id!!).get() }

        val newWebtoon = Webtoon(webtoonCreateRequestDto.name, foundedAuthors)
        val savedNewWebtoon = webtoonRepository.save(newWebtoon)
        return savedNewWebtoon.toWebtoonCreateResponseDto()
    }
}
