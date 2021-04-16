package com.depromeet.webtoon.core.domain.webtoon

import com.depromeet.webtoon.core.domain.author.Author
import com.depromeet.webtoon.core.domain.author.AuthorRepository
import com.depromeet.webtoon.core.domain.webtoon.dto.WebtoonAuthorVo
import com.depromeet.webtoon.core.domain.webtoon.dto.WebtoonCreateRequestDto
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import java.util.*

class WebtoonServiceTest : FunSpec({

    test("createWebtoon") {
        // given
        val webtoonRepository = mockk<WebtoonRepository>()
        val authorRepository = mockk<AuthorRepository>()
        val webtoonService = WebtoonService(webtoonRepository, authorRepository)

        // authorRepository.findById() 가 호출 될 경우  -> returns Author
        every { authorRepository.findById(any()) } returns Optional.of(Author("author", emptyList()))
        every { webtoonRepository.save(any()) } returns Webtoon("webtoon", emptyList())

        val webtoonCreateRequestDto = WebtoonCreateRequestDto("test", listOf(WebtoonAuthorVo(1, "author")))

        // when
        webtoonService.createWebtoon(webtoonCreateRequestDto)

        // then
        verify(exactly = 1) { authorRepository.findById(any()) }
        verify(exactly = 1) { webtoonRepository.save(any()) }
    }

    test("getWebtoonList") {
        // given
        val webtoonRepository = mockk<WebtoonRepository>() // 목객체 생성
        val authorRepository = mockk<AuthorRepository>()
        val webtoonService = WebtoonService(webtoonRepository, authorRepository)

        // 목객체 동작 정의 : every
        every { webtoonRepository.findAll() } returns listOf(Webtoon("webtoon1", emptyList()), Webtoon("webtoon2", emptyList()))

        val webtoons = webtoonService.getWebtoons()
        // 호출 여부 검증 : verify(exactly = 호출횟수)    
        verify(exactly = 1) { webtoonRepository.findAll() }

        // webtoonService 의 return 값 확인
        webtoons[0].name shouldBe "webtoon1"
        webtoons[1].name shouldBe "webtoon2"
    }
})
