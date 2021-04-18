package com.depromeet.webtoon.core.application.imports

import com.depromeet.webtoon.core.domain.author.authorFixture
import com.depromeet.webtoon.core.domain.author.service.AuthorService
import com.depromeet.webtoon.core.domain.webtoon.model.webtoonFixture
import com.depromeet.webtoon.core.domain.webtoon.service.WebtoonService
import com.depromeet.webtoon.core.type.WebtoonSite
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.collections.shouldContainAll
import io.kotest.matchers.shouldBe
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import java.time.DayOfWeek

class WebtoonImportServiceTest : FunSpec({
    lateinit var webtoonImportService: WebtoonImportService
    lateinit var webtoonService: WebtoonService
    lateinit var authorService: AuthorService

    beforeTest {
        webtoonService = mockk()
        authorService = mockk()
        webtoonImportService = WebtoonImportService(webtoonService, authorService)
    }

    context("webtoonImportService") {
        test("각 연관 메서드가 잘 호출되는지 여부 확인") {
            // given
            val importRequest = webtoonImportRequestFixture(
                title = "드래곤볼",
                authors = listOf("토리야미 아키라"),
                dayOfWeeks = listOf(DayOfWeek.MONDAY),
                site = WebtoonSite.NAVER,
                genres = listOf("배틀"),
                score = 4.95,
                popular = 2
            )

            every { authorService.findOrCreateAuthors(any()) } returns importRequest.authors.map { authorFixture(name = it) }
            every { webtoonService.upsertWebtoon(any()) } returns webtoonFixture()

            // when
            webtoonImportService.importWebtoon(importRequest)

            // then
            verify(exactly = 1) {
                authorService.findOrCreateAuthors(
                    withArg { it shouldContainAll importRequest.authors }
                )
            }
            verify(exactly = 1) {
                webtoonService.upsertWebtoon(
                    withArg {
                        it.site shouldBe importRequest.site
                        it.title shouldBe importRequest.title
                    }
                )
            }
        }
    }
})
