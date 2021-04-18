package com.depromeet.webtoon.core.domain.author

import com.depromeet.webtoon.core.domain.author.dto.AuthorCreateRequestDto
import com.depromeet.webtoon.core.domain.author.model.Author
import com.depromeet.webtoon.core.domain.author.repository.AuthorRepository
import com.depromeet.webtoon.core.domain.author.service.AuthorService
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.collections.shouldContainExactly
import io.kotest.matchers.collections.shouldContainExactlyInAnyOrder
import io.kotest.matchers.shouldBe
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import java.lang.IllegalArgumentException

class AuthorServiceTest : FunSpec({
    lateinit var authorRepository: AuthorRepository
    lateinit var authorService: AuthorService

    beforeTest {
        authorRepository = mockk()
        authorService = AuthorService(authorRepository)
    }

    test("createAuthor") {
        // given
        val createRequest = AuthorCreateRequestDto("테스트 작가")
        every { authorRepository.save(any()) } returns authorFixture(name = createRequest.name)

        // when
        val savedAuthor = authorService.createAuthor(createRequest)

        // then
        verify(exactly = 1) { authorRepository.save(any()) }
        savedAuthor.name shouldBe createRequest.name
    }

    context("findOrCreateAuthors 테스트") {
        test("리스트가 비어있는 경우 IllegalArgumentException") {
            // given
            val emptyAuthors = emptyList<String>()

            // when, then
            shouldThrow<IllegalArgumentException> {
                authorService.findOrCreateAuthors(emptyAuthors)
            }
        }

        test("작가가 이미 존재하는 경우 저장없이 결과를 바로 반환합니다.") {
            // given
            val requestAuthorNames = listOf("김훈", "김초엽")
            val savedAuthors = requestAuthorNames.mapIndexed { idx, name -> authorFixture(idx.toLong(), name) }
            every { authorRepository.findAllByName(any()) } returns savedAuthors

            // when
            val resultAuthors = authorService.findOrCreateAuthors(requestAuthorNames)

            // then
            resultAuthors.map { it.name } shouldContainExactly requestAuthorNames
            verify {
                authorRepository.findAllByName(requestAuthorNames)
            }
        }

        test("존재하지 않는 작가 존재시 추가 후 저장 결과와 함께 반환") {
            // given
            val requestAuthorNames = listOf("김훈", "김초엽", "전민희")
            val savedAuthorName = listOf("김훈")
            val notExistAuthorNames = listOf("김초엽", "전민희")

            every { authorRepository.findAllByName(any()) } returns savedAuthorName.map { authorFixture(name = it) }
            every { authorRepository.saveAll(any<List<Author>>()) } returns notExistAuthorNames.map { authorFixture(name = it) }

            // when
            val resultAuthors = authorService.findOrCreateAuthors(requestAuthorNames)

            // then
            resultAuthors.map { it.name } shouldContainExactlyInAnyOrder requestAuthorNames
            verify {
                authorRepository.findAllByName(
                    withArg { it shouldContainExactlyInAnyOrder requestAuthorNames }
                )
            }

            verify {
                authorRepository.saveAll(
                    withArg { it: List<Author> -> it.map { it.name } shouldContainExactlyInAnyOrder notExistAuthorNames }
                )
            }
        }
    }
})
