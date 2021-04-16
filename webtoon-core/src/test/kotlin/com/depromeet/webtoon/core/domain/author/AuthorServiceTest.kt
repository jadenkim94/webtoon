package com.depromeet.webtoon.core.domain.author

import com.depromeet.webtoon.core.domain.author.dto.AuthorCreateRequestDto
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify

class AuthorServiceTest : FunSpec({

    test("createAuthor") {
        /**
         *  given
         *  AuthorService 는 AuthorRepository 를 주입받아 사용한다.
         *  테스트에서는 이런 의존성을 끊고 단위테스트를 해야함으로 mock AuthorRepository 를 사용한다.
         */
        val authorRepository = mockk<AuthorRepository>()
        val authorService = AuthorService(authorRepository)

        /**
         * AuthorService 의 createAuthor() 은 AuthorRepository 의 save() 를 호출함으로
         * mock AuthorRepository 의 save() 동작 정의
         */
        every { authorRepository.save(any()) } returns Author("author", emptyList())

        val authorCreateRequestDto = AuthorCreateRequestDto("author")

        // when
        val savedAuthor = authorService.createAuthor(authorCreateRequestDto)

        // then
        verify(exactly = 1) { authorRepository.save(any()) }
        savedAuthor.name shouldBe authorCreateRequestDto.name
    }
})
