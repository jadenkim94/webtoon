package com.depromeet.webtoon.core.domain.webtoon

import com.depromeet.webtoon.core.domain.author.authorFixture
import com.depromeet.webtoon.core.domain.webtoon.dto.WebtoonCreateRequest
import com.depromeet.webtoon.core.domain.webtoon.model.webtoonFixture
import com.depromeet.webtoon.core.domain.webtoon.repository.WebtoonRepository
import com.depromeet.webtoon.core.domain.webtoon.service.WebtoonService
import com.depromeet.webtoon.core.type.WebtoonSite
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.collections.shouldContainExactly
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify

class WebtoonServiceTest : FunSpec({

    lateinit var webtoonRepository: WebtoonRepository
    lateinit var webtoonService: WebtoonService

    beforeTest {
        webtoonRepository = mockk()
        webtoonService = WebtoonService(webtoonRepository)
    }

    test("createWebtoon") {
        // given
        val testAuthor = authorFixture(name = "김훈")
        val testCreateRequest = WebtoonCreateRequest("칼의노래", authors = listOf(testAuthor), site = WebtoonSite.NAVER)

        every { webtoonRepository.save(any()) } returns webtoonFixture(
            title = testCreateRequest.title,
            site = testCreateRequest.site,
            authors = listOf(testAuthor)
        )

        // when
        webtoonService.createWebtoon(testCreateRequest)

        // then
        verify(exactly = 1) { webtoonRepository.save(any()) }
    }

    test("getWebtoonList") {
        // given
        // 목객체 동작 정의 : every
        every { webtoonRepository.findAll() } returns listOf(
            webtoonFixture(title = "webtoon1"), webtoonFixture(title = "webtoon2")
        )

        // when
        val webtoons = webtoonService.getWebtoons()

        // then
        // 호출 여부 검증 : verify(exactly = 호출횟수)
        verify(exactly = 1) { webtoonRepository.findAll() }

        // webtoonService 의 return 값 확인
        webtoons.map { it.title }.apply {
            this shouldContainExactly listOf("webtoon1", "webtoon2")
        }
    }
})
