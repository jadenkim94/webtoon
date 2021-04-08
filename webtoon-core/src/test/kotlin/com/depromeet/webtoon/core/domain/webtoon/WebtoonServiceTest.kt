package com.depromeet.webtoon.core.domain.webtoon

import com.depromeet.webtoon.core.domain.author.Author
import com.depromeet.webtoon.core.domain.author.AuthorRepository
import com.depromeet.webtoon.core.domain.webtoon.dto.WebtoonAuthorVo
import com.depromeet.webtoon.core.domain.webtoon.dto.WebtoonCreateRequestDto
import io.kotest.core.spec.style.FunSpec
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
})
